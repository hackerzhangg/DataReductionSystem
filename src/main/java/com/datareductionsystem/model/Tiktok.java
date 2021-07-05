package com.datareductionsystem.model;

/**
 * @Author zgp
 * @Since 2021 -07 -03 18 :52
 * @Description
 */
public class Tiktok {

    private String TikTokUserName1;
    private String TikTokUserName2;
    private String TikTokUserName3;
    private String TikTokUserName4;

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

    public String getTikTokUserName3() {
        return TikTokUserName3;
    }

    public void setTikTokUserName3(String tikTokUserName3) {
        TikTokUserName3 = tikTokUserName3;
    }

    public String getTikTokUserName4() {
        return TikTokUserName4;
    }

    public void setTikTokUserName4(String tikTokUserName4) {
        TikTokUserName4 = tikTokUserName4;
    }

    @Override
    public String toString() {
        return "Tiktok{" +
                "TikTokUserName1='" + TikTokUserName1 + '\'' +
                ", TikTokUserName2='" + TikTokUserName2 + '\'' +
                ", TikTokUserName3='" + TikTokUserName3 + '\'' +
                ", TikTokUserName4='" + TikTokUserName4 + '\'' +
                '}';
    }
}
