package com.datareductionsystem.model;

/**
 * @Author zgp
 * @Since 2021 -07 -01 11 :09
 * @Description 抖音数据实体类
 */
public class Tiktokdatas {

    /*CREATE TABLE `tiktokdatas` (
            `TikTokUserName1` varchar(255) DEFAULT NULL,
            `TikTokUserName2` varchar(255) DEFAULT NULL
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;*/

    private String TikTokUserName1;
    private String TikTokUserName2;

    public String getTikTokUserName1() {
        return TikTokUserName1;
    }

    public void setTikTokUserName1(String tikTokUserName1) {
        TikTokUserName1 = tikTokUserName1;
    }

    public String getTikTokUserName2() {
        return TikTokUserName2;
    }

    public void setTikTokUserName2(String tikTokUserName2) {
        TikTokUserName2 = tikTokUserName2;
    }

    @Override
    public String toString() {
        return "Tiktokdatas{" +
                "TikTokUserName1='" + TikTokUserName1 + '\'' +
                ", TikTokUserName2='" + TikTokUserName2 + '\'' +
                '}';
    }
}
