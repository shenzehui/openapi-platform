package com.szh.openapiinterface.controller;

import com.szh.openapiclientsdk.model.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * 名称 API
 * Created by szh on 2023-04-21
 */

@RestController
@RequestMapping("/name")
public class NameController {

    @GetMapping("/get")
    public String getNameByGet(String name, HttpServletRequest request) {
        System.out.println(request.getHeader("yupi"));
        return "GET 你的名字是" + name;
    }

    @PostMapping("/post")
    public String getNameByPost(@RequestParam String name) {
        return "POST 你的名字是" + name;
    }

    @PostMapping("/user")
    public String getUserNameByPost(@RequestBody User user, HttpServletRequest request) throws UnsupportedEncodingException {
//        String accessKey = request.getHeader("accessKey");
//        String nonce = request.getHeader("nonce");
//        String timestamp = request.getHeader("timestamp");
//        String sign = request.getHeader("sign");
//        String body = URLDecoder.decode(request.getHeader("body"), StandardCharsets.UTF_8.name());
//        if (!"yupi".equals(accessKey)) {
//            throw new RuntimeException("无权限");
//        }
//        if (Long.parseLong(nonce) < 10000) {
//            throw new RuntimeException("无权限");
//        }
//        // 时间和当前时间不能超过5分钟
//        if (System.currentTimeMillis() / 1000 - Long.parseLong(timestamp) > 5 * 60) {
//            throw new RuntimeException("无权限");
//        }
//        String sign1 = SignUtils.getSign(body, "abcdefgh");
//        if (!sign1.equals(sign)) {
//            throw new RuntimeException("无权限");
//        }
//
        return "POST 用户名是" + user.getUsername();
    }
}
