package com.zjz;

import com.zjz.util.FileUtils;
import com.zjz.util.SimHashUtils;
import org.junit.Test;

public class SimHashUtilsTest {


    //获取字符串Hash测试
    @Test
    public void getHashTest() {
        String[] strings = {"余华", "是", "一位", "值得尊重", "的", "作家"};
        for (String string : strings) {
            String stringHash = SimHashUtils.getHash(string);
            System.out.println(stringHash.length());
            System.out.println(stringHash);
            System.out.println("=====================");
        }
    }

    //获取字符串SimHash测试
    @Test
    public void getSimHashTest() {
        String orig = FileUtils.readTxt("F:\\DeskTop\\查重测试文件\\orig.txt");
        String orig_add = FileUtils.readTxt("F:\\DeskTop\\查重测试文件\\orig_0.8_add.txt");
        System.out.println(orig + ": \n" + SimHashUtils.generateSimHash(orig));
        System.out.println("=====================");
        System.out.println(orig_add + ": \n" + SimHashUtils.generateSimHash(orig_add));
        System.out.println("=====================");
    }

}
