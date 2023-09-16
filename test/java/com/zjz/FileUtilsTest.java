package com.zjz;

import com.zjz.util.FileUtils;
import org.junit.Test;

public class FileUtilsTest {

    //文件类型不是txt类型
    @Test
    public void readNotTxtTest(){
        String str = FileUtils.readTxt("D:\\3121005063\\src\\main\\java\\com\\zjz\\util\\FileUtils.java");
        System.out.println(str);
    }

    //路径存在，正常读取
    @Test
    public void readTxtTest() {
        String str = FileUtils.readTxt("D:\\3121005063\\src\\main\\resources\\file\\orig.txt");
        String[] strings = str.split(" ");
        for (String string : strings) {
            System.out.println(string);
        }
    }

    //路径存在，正常写入
    @Test
    public void writeTxtTest() {
        FileUtils.writeTxt("原神，启动！",
                "D:\\3121005063\\src\\main\\resources\\file\\orig.txt");
    }

    //路径不存在，读取失败
    @Test
    public void readTxtFailTest() {
        FileUtils.readTxt("D:\\3121005063\\src\\main\\resources\\file\\fake.txt");
    }

    //路径错误，写入失败
    @Test
    public void writeTxtFailTest() {
        FileUtils.writeTxt("原神，启动！",
                "D:\\3121005063\\src\\main\\resources\\file\\fake.txt");
    }

}
