package com.zjz;

import com.zjz.util.FileUtils;
import com.zjz.util.HammingUtils;
import com.zjz.util.SimHashUtils;
import org.junit.Test;

public class HammingUtilsTest {


    //获取海明距离
    @Test
    public void getHammingDistanceTest() {
        String str0 = FileUtils.readTxt("D:\\3121005063\\src\\main\\resources\\file\\orig.txt");
        String str1 = FileUtils.readTxt("D:\\3121005063\\src\\main\\resources\\file\\orig_0.8_add.txt");
        int distance = HammingUtils.getHammingDistance(SimHashUtils.generateSimHash(str0), SimHashUtils.generateSimHash(str1));
        System.out.println("海明距离：" + distance);
        System.out.println("相似度: " + (100 - distance * 100 / 128) + "%");
    }

    //获取海明距离失败测试
    @Test
    public void getHammingDistanceFailTest() {
        // 测试str0.length()!=str1.length()的情况
        String str0 = "10101010";
        String str1 = "1010101";
        System.out.println(HammingUtils.getHammingDistance(str0, str1));
    }

    //获取相似度测试
    @Test
    public void getSimilarityTest() {
        String str0 = FileUtils.readTxt("D:\\3121005063\\src\\main\\resources\\file\\orig.txt");
        String str1 = FileUtils.readTxt("D:\\3121005063\\src\\main\\resources\\file\\orig_0.8_add.txt");
        int distance = HammingUtils.getHammingDistance(SimHashUtils.generateSimHash(str0), SimHashUtils.generateSimHash(str1));
        double similarity = HammingUtils.getSimilarity(SimHashUtils.generateSimHash(str0), SimHashUtils.generateSimHash(str1));
        System.out.println("str0和str1的汉明距离: " + distance);
        System.out.println("str0和str1的相似度:" + similarity);
    }

}
