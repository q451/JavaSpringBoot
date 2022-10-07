package com.example.demo.util;

import com.example.demo.model.user.UserAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TokenUtil {
    private static Map<String, UserAccount> tokenMap=new HashMap<>();

    /**
     * 生成token，存储token-user对应关系
     * 返回token令牌
     * @param userAccount
     * @return
     */
    public static String generateToken(UserAccount userAccount){
        //生成唯一不重复的字符串
        String token = UUID.randomUUID().toString();
        tokenMap.put(token,userAccount);
        return token;
    }

    /**
     * 验证token是否合法
     * @param token
     * @return
     */
    public static boolean verify(String token){
        return tokenMap.containsKey(token);
    }

    /**
     * 根据token获取用户信息
     * @param token
     * @return
     */
    public static UserAccount getUser(String token){
        return tokenMap.get(token);
    }

}
