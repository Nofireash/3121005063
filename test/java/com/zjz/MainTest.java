package com.zjz;

import com.zjz.util.FileUtils;
import com.zjz.util.HammingUtils;
import com.zjz.util.SimHashUtils;
import org.junit.Test;

public class MainTest {

    @Test
    public void origAndAllTest(){
        String[] str = new String[6];
        str[0] = FileUtils.readTxt("D:\\3121005063\\src\\main\\resources\\file\\orig.txt");
        str[1] = FileUtils.readTxt("D:\\3121005063\\src\\main\\resources\\file\\orig_0.8_add.txt");
        str[2] = FileUtils.readTxt("D:\\3121005063\\src\\main\\resources\\file\\orig_0.8_del.txt");
        str[3] = FileUtils.readTxt("D:\\3121005063\\src\\main\\resources\\file\\orig_0.8_dis_1.txt");
        str[4] = FileUtils.readTxt("D:\\3121005063\\src\\main\\resources\\file\\orig_0.8_dis_10.txt");
        str[5] = FileUtils.readTxt("D:\\3121005063\\src\\main\\resources\\file\\orig_0.8_dis_15.txt");
        String ansFileName = "D:\\3121005063\\src\\main\\resources\\file\\result.txt";
        for(int i = 0; i <= 5; i++){
            double ans = HammingUtils.getSimilarity(SimHashUtils.generateSimHash(str[0]), SimHashUtils.generateSimHash(str[i]));
            FileUtils.writeTxt(String.valueOf(ans), ansFileName);
        }
    }
}
