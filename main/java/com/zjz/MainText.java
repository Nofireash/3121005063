package com.zjz;


import com.zjz.util.HammingUtils;
import com.zjz.util.SimHashUtils;
import com.zjz.util.FileUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class MainText {

    public static void main(String[] args) {
        // 从命令行输入的路径名读取对应的文件，将文件的内容转化为对应的字符串
        String str0 = FileUtils.readTxt(args[0]);
        String str1 = FileUtils.readTxt(args[1]);
        String resultFileName = args[2];

        //由字符串得出对应的simHash值
        String simHash0 = SimHashUtils.getSimHash(str0);
        String simHash1 = SimHashUtils.getSimHash(str1);

        //由simHash值求出相似度
        Double similarity = HammingUtils.getSimilarity(simHash0, simHash1);

        //保留小数点后两位
        String resultSimilarity = String.format("%.2f", similarity);

        String result = "查重时间：" + DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss").format(LocalDateTime.now()) + "===" + args[0] + "与" + args[1] + "的相似度为：" + resultSimilarity + "\r\n";

        //把相似度写入最后的结果文件中
        FileUtils.writeTxt(result, resultFileName);

        System.out.println("相似度为：" + resultSimilarity + "。 结果已经写入" + resultFileName + "中。");

    }

}
