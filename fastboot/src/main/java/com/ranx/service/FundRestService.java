package com.ranx.service;

import com.ranx.consts.API;
import com.ranx.consts.RedisConsts;
import com.ranx.model.dto.OperateLogDto;
import com.ranx.model.req.OperateLogReq;
import com.ranx.utils.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@Slf4j
@AllArgsConstructor
public class FundRestService {

    @Autowired
    private RestTemplateReqService req;

    @Autowired
    RedisTemplate<Object, Object> redisTemplate;

    /**
     * Get请求参数在url后
     * @param bean
     * @return
     */
    public OperateLogDto fundGet(OperateLogReq bean){
        OperateLogDto resp =  req.sendParam(API.ACCESS_TOKEN, HttpMethod.GET, BeanUtil.parseObj2MapByJson(bean), OperateLogDto.class);
        return resp;
    }


    /**
     * Get请求参数body
     * @param bean
     * @return
     */
    public OperateLogDto fundDailyStat(OperateLogReq bean){
        String token = "";
        OperateLogDto resp = req.send(API.ACCESS_TOKEN, HttpMethod.GET, token, bean, OperateLogDto.class);
        return resp;
    }

    /**
     * Redis操作相关
     * @param busId
     */
    public void saveToken(Long busId){
        String token = "";
        String key = String.format(RedisConsts.ACCESS_TOKEN_QQ, "business_id");
        redisTemplate.opsForValue().set(key, token, 24,TimeUnit.HOURS);
    }



}
