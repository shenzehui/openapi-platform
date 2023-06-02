package com.szh.openapiclientsdk.client;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.szh.openapiclientsdk.model.User;
import com.szh.openapiclientsdk.utils.SignUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 调用第三方接口的客户端
 * Created by szh on 2023-04-21
 */

public class OpenApiClient {

    private String accessKey;

    private String secretKey;

    private final String GATEWAY_HOST = "http://127.0.0.1:8090";

    public OpenApiClient(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    public String getNameByGet(String name) {
        HashMap<String, Object> paramMap = new HashMap();
        paramMap.put("name", name);
        String result = HttpUtil.get(GATEWAY_HOST + "/api/name/get", paramMap);
        System.out.println(result);
        return result;
    }

    public String getNameByPost(String name) {
        HashMap<String, Object> paramMap = new HashMap();
        paramMap.put("name", name);
        String result = HttpUtil.post(GATEWAY_HOST + "/api/name/post", paramMap);
        System.out.println(result);
        return result;
    }

    public String getUserNameByPost(User user) {
        String json = JSONUtil.toJsonStr(user);
        HttpResponse response = HttpRequest.post(GATEWAY_HOST + "/api/name/user").body(json).addHeaders(getHeaderMap(json)).execute();
        System.out.println(response.getStatus());
        String result = response.body();
        System.out.println(result);
        return result;
    }

    private Map<String, String> getHeaderMap(String body) {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("accessKey", accessKey);
        // 一定不能发送给后端
//        hashMap.put("secretKey", secretKey);
        // 随机数 防重放
        hashMap.put("nonce", RandomUtil.randomNumbers(5));
        hashMap.put("body", body);
        // 加timestamp 时间戳，校验随机数的有效期
        hashMap.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        hashMap.put("sign", SignUtils.getSign(body, secretKey));
        return hashMap;
    }
}
