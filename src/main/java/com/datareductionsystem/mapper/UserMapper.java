package com.datareductionsystem.mapper;

import com.datareductionsystem.model.Tiktok;
import com.datareductionsystem.model.Tiktokdatas;
import com.datareductionsystem.model.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author zgp
 * @Since 2021 -06 -30 10 :48
 * @Description 系统用户数据库访问层
 */
public interface UserMapper {

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    List<Users> userLogin(@Param("username") String username, @Param("password") String password);

    void subTikTokData1(@Param("tikTokUserName1") String tikTokUserName1);

    void subTikTokData2(@Param("tikTokUserName2")String tikTokUserName2);

    List<Tiktok> findAllDataExcel();

    void subTikTokData3(@Param("str1")String str1, @Param("str2")String str2);

    void subTikTokData4(@Param("str1")String str1, @Param("str2")String str2, @Param("tikTokUserName2")String tikTokUserName2, @Param("tikTokUserName3")String tikTokUserName3);

    List<Tiktok> queryDataExcel();

    void deleteDataExcel();
}
