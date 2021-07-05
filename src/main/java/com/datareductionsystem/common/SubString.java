package com.datareductionsystem.common;

/**
 * @Author zgp
 * @Since 2021 -07 -03 17 :36
 * @Description
 */
public class SubString {
    /*public static void main(String[] args) {
        String str="111111111 888888888";
        //截取字符串中空格之前得数据
        String str1=str.substring(0, str.indexOf(" "));
        System.out.println(str1);
        //截取字符串中空格之后得数据
        String str2=str.substring(str.lastIndexOf(" "));
        System.out.println(str2);
    }*/

    public static void main(String[] args) {
        String str="11 18942131698";
        //截取字符串中空格之前得数据
        String str1=str.substring(0, str.indexOf(" "));
        System.out.println(str1);
        //截取字符串中空格之后得数据
        String str2=str.substring(str.lastIndexOf(" "));
        System.out.println(str2);
    }
}
