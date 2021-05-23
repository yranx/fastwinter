package com.ranx.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

@Component
public class RequestUtils {

    @Autowired
    private HttpServletRequest request;

    public String getIp() {
        String ipAddr = null;
        String Referer = request.getHeader("Referer");
        String origin = (StringUtils.isEmpty(request.getHeader("Origin")) ? Referer : request.getHeader("Origin"));
        if (!StringUtils.isEmpty(origin)) {
            boolean flag = origin.contains("http://");
            if (flag) {
                String substring = origin.substring(7);
                int i1 = substring.indexOf(":");
                if (i1 > 0) {
                    //带有ip和端口的
                    ipAddr = substring.substring(0, i1);
                } else {
                    //域名  ip 80端口
                    int i2 = substring.indexOf("/");
                    if (i2 > 0) {
                        ipAddr = substring.substring(0, i2);
                    } else {
                        ipAddr = substring;
                    }
                }
            } else {
                boolean contains = origin.contains("https://");
                if (contains) {
                    String substring = origin.substring(8);
                    int i1 = substring.indexOf(":");
                    if (i1 > 0) {
                        //带有ip和端口的
                        ipAddr = substring.substring(0, i1);
                    } else {
                        //域名  ip 80端口
                        int i2 = substring.indexOf("/");
                        if (i2 > 0) {
                            ipAddr = substring.substring(0, i2);
                        } else {
                            ipAddr = substring;
                        }
                    }
                }
            }
        }
        return ipAddr;
    }

    public String getLoginName() {
        return (String) request.getAttribute("username");
    }
}
