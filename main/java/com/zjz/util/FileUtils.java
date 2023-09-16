package com.zjz.util;

import java.io.*;
import java.nio.charset.StandardCharsets;


public class FileUtils {


    public static String readTxt(String txtPath) {

        if (!txtPath.endsWith("txt")){
            throw new RuntimeException("文件类型应为txt文件");
        }

        StringBuilder str = new StringBuilder();
        String strLine;

        //将txt文件按行读入 str中
        File file = new File(txtPath);

        if (!file.exists()){
            throw new RuntimeException("文件不存在或路径错误");
        }


        try (FileInputStream fileInputStream = new FileInputStream(file);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

            //字符串拼接
            while ((strLine = bufferedReader.readLine()) != null) {
                str.append(strLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return str.toString();
    }



    public static void writeTxt(String txtElem, String txtPath) {

        if (!txtPath.endsWith("txt")){
            throw new RuntimeException("文件类型应为txt文件");
        }

        File file = new File(txtPath);

        if (!file.exists()){
            throw new RuntimeException("文件不存在或路径错误");
        }

        try (FileWriter fileWriter = new FileWriter(file, true)) {
            fileWriter.write(txtElem);
            fileWriter.write("\r\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
