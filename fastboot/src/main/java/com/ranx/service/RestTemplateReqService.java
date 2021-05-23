package com.ranx.service;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Map;

/**
 * @author
 */
@Component
public class RestTemplateReqService {

    private final static Logger logger = LoggerFactory.getLogger(RestTemplateReqService.class);


//    @Autowired
    private RestTemplate restTemplate = simpeClient();

    private static RestTemplate simpeClient() {
        HttpComponentsClientHttpRequestWithBodyFactory requestFactory = new HttpComponentsClientHttpRequestWithBodyFactory();
        requestFactory.setConnectTimeout(5000);
        requestFactory.setReadTimeout(30000);

        RestTemplate restTemplate = new RestTemplate(requestFactory);
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8)); // 设置编码集
//        restTemplate.setErrorHandler(new DefaultResponseErrorHandler()); //error处理
//        if (url.contains("https")){
//            restTemplate.setRequestFactory(new HttpsClientRequestFactory()); // 绕过https
//        }
        return restTemplate;
    }

    public static final class HttpComponentsClientHttpRequestWithBodyFactory extends HttpComponentsClientHttpRequestFactory {
        @Override
        protected HttpUriRequest createHttpUriRequest(HttpMethod httpMethod, URI uri) {
            if (httpMethod == HttpMethod.GET) {
                return new HttpGetRequestWithEntity(uri);
            }
            return super.createHttpUriRequest(httpMethod, uri);
        }
    }

    private static final class HttpGetRequestWithEntity extends HttpEntityEnclosingRequestBase {
        public HttpGetRequestWithEntity(final URI uri) {
            super.setURI(uri);
        }

        @Override
        public String getMethod() {
            return HttpMethod.GET.name();
        }
    }


    /**
     * 封装的get请求，暂时只支持map传参，并且value只支持基本类型和String
     *
     * @param url
     * @param object
     * @return
     */
    private String getForURl(String url, Object object){
        StringBuffer stringBuffer = new StringBuffer(url);
        if (object instanceof Map) {
            Iterator iterator = ((Map) object).entrySet().iterator();
            if (iterator.hasNext()) {
                stringBuffer.append("?");
                Object element;
                while (iterator.hasNext()) {
                    element = iterator.next();
                    Map.Entry<String, Object> entry = (Map.Entry) element;
                    //过滤value为null，value为null时进行拼接字符串会变成 "null"字符串
                    if (entry.getValue() != null) {
                        stringBuffer.append(element).append("&");
                    }
                    url = stringBuffer.substring(0, stringBuffer.length() - 1);
                }
            }
        } else {
            throw new RuntimeException("url请求:" + url + "请求参数有误不是map类型");
        }

        return url;
    }



    /**
     * 发送请求返回字符串
     *
     * @param obj 提交的参数
     * @return 字符串结果
     */
    public String send(String url, HttpMethod httpMethod, String token, Object obj) {
        ResponseEntity<String> result = restTemplate.exchange(url, httpMethod, getEntity(obj, token), String.class);
        return result.getBody();
    }

    public String sendParam(String url, HttpMethod httpMethod, String token, Object obj) {
        url = getForURl(url, obj);
        ResponseEntity<String> result = restTemplate.exchange(url, httpMethod, getEntity(obj, token), String.class);
        return result.getBody();
    }

    /**
     * 发送请求返回特定类型
     *
     * @param obj 提交的参数
     * @param t   返回类型
     * @return 指定类型的结果返回
     */
    public <T> T send(String url,  HttpMethod httpMethod, String token, Object obj, Class<T> t) {
        logger.info("REQUEST===> url:"+url+", token:" + token+ ", httpMethod:" + httpMethod + ", data:" + JSONObject.toJSONString(obj));
        HttpEntity<String> entity = getEntity(obj, token);
//        logger.info(JSONObject.toJSONString(entity));
        ResponseEntity<T> result = restTemplate.exchange(url, httpMethod, entity, t);
        logger.info("RESPONSE===> url:" +url + ", body:"+ JSONObject.toJSONString(result));
        return result.getBody();
    }

    public <T> T sendParam(String url,  HttpMethod httpMethod, String token, Object obj, Class<T> t) {
        url = getForURl(url, obj);
        logger.info("REQUEST===> url:"+url+", token:" + token+ ", httpMethod:" + httpMethod + ", data:" + JSONObject.toJSONString(obj));
        HttpEntity<String> entity = getEntity(obj, token);
//        logger.info(JSONObject.toJSONString(entity));
        ResponseEntity<T> result = restTemplate.exchange(url, httpMethod, entity, t);
        logger.info("RESPONSE===> url:" +url + ", body:"+ JSONObject.toJSONString(result));
        return result.getBody();
    }

    /**
     * headers不含token
     * @return
     */
    public <T> T send(String url,  HttpMethod httpMethod, Object obj, Class<T> t) {
        return send( url,   httpMethod, null,  obj, t);
    }
    public <T> T sendParam(String url,  HttpMethod httpMethod, Object obj, Class<T> t) {
        return sendParam( url,   httpMethod, null,  obj, t);
    }

    /**
     * 发送请求返回特定类型（上传文件用）
     *
     * @param multiValueMap 提交的参数
     * @param t   返回类型
     * @return 指定类型的结果返回
     */
    public <T> T sendFile(String url,  HttpMethod httpMethod, String token, MultiValueMap<String, Object> multiValueMap, Class<T> t) {
        ResponseEntity<T> result = restTemplate.exchange(url, httpMethod, getEntity(token, multiValueMap), t);
        return result.getBody();
    }


    private HttpEntity<MultiValueMap<String, Object>> getEntity(String token, MultiValueMap<String, Object> multiValueMap) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Token", token);
        headers.add("Content-Type", "multipart/form-data");
        HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<MultiValueMap<String,Object>>(multiValueMap,headers);
        return httpEntity;
    }

    private HttpEntity<String> getEntity(Object obj, String token) {
        HttpHeaders headers = new HttpHeaders();
//        headers.add("Content-Type", "application/json; charset=UTF-8");
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        headers.add("X-Debug-Mode", "1");
        if(!StringUtils.isEmpty(token)){
            headers.add("Access-Token", token);
        }
        String json;
        if (obj instanceof String) {
            json = (String) obj;
        } else {
            json = JSONObject.toJSONString(obj);
        }
        HttpEntity<String> entity = new HttpEntity<>(json, headers);
        return entity;
    }

}
