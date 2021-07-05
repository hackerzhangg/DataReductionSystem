package com.datareductionsystem.common;

/**
 * @Author zgp
 * @Since 2021 -06 -30 14 :44
 * @Description 获取String字符串中的每一行
 */
public class ReadString {
    /*public static void main(String[] args) {
        String str ="1001"+"\n"+"1002"+"\n"+"1003"+"\n"+"1004";
        //用回车键来分隔几个元素
        String[] ss = str.split("\n");
        for (int i = 0; i < ss.length; i++) {
            System.out.println(ss[i]);
        }
    }*/

    public static void main(String[] args) {
        String a=" 1 2 ";
        String trim = a.trim();
        System.out.println(trim);
    }
}
