package com.zjz.util;


import com.hankcs.hanlp.HanLP;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.List;


public class SimHashUtils {


    public static String getHash(String str) {
        try {
            //使用MD5获得hash值
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            return new BigInteger(1, messageDigest.digest(str.getBytes(StandardCharsets.UTF_8))).toString(2);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }



    public static String generateSimHash(String str) {
        if (str.length() < 300) {
            throw new RuntimeException("文本长度小于300");
        }

        //用数组表示特征向量,取128位,从 0 1 2 位开始表示从高位到低位
        int[] v = new int[128];
        //1. 分词（使用了外部依赖hankcs包提供的接口）
        //取出所有关键词
        List<String> keywordList = HanLP.extractKeyword(str, str.length());
        //hash
        int size = keywordList.size();
        //以i做外层循环
        int i = 0;
        for (String keyword : keywordList) {
        //2. 获取hash值
            StringBuilder keywordHash = new StringBuilder(getHash(keyword));
            if (keywordHash.length() < 128) {
                //hash值可能少于128位，在低位以0补齐
                int dif = 128 - keywordHash.length();
                for (int j = 0; j < dif; j++) {
                    keywordHash.append("0");
                }
            }
        //3. 加权、合并
            for (int j = 0; j < v.length; j++) {
                // 对keywordHash的每一位与'1'进行比较
                if (keywordHash.charAt(j) == '1') {
                    //权重分10级，由词频从高到低，取权重10~0
                    v[j] += (10 - (i / (size / 10)));
                } else {
                    v[j] -= (10 - (i / (size / 10)));
                }
            }
            i++;
        }
        //4. 降维
        //储存返回的simHash值
        StringBuilder simHash = new StringBuilder();
        for (int k : v) {
            // 从高位遍历到低位
            if (k <= 0) {
                simHash.append("0");
            } else {
                simHash.append("1");
            }
        }
        return simHash.toString();
    }

}