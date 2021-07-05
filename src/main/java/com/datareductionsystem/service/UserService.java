package com.datareductionsystem.service;

import com.datareductionsystem.mapper.UserMapper;
import com.datareductionsystem.model.Tiktok;
import com.datareductionsystem.model.Tiktokdatas;
import com.datareductionsystem.model.Users;
import jxl.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author zgp
 * @Since 2021 -06 -30 10 :48
 * @Description 系统用户Service
 */
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    public List<Users> userLogin(String username, String password) {
        List<Users> usersList=userMapper.userLogin(username,password);
        return usersList;
    }

    /**
     * 添加抖音数据
     * @param tikTokUserName1
     * @param tikTokUserName2
     */
    public void subTikTokData1(String tikTokUserName1) {

        userMapper.subTikTokData1(tikTokUserName1);
    }

    /**
     * 添加抖音数据
     * @param tikTokUserName1
     * @param tikTokUserName2
     */
    public void subTikTokData2(String tikTokUserName2) {

        userMapper.subTikTokData2(tikTokUserName2);
    }

    //定义导出excel的文件路径
    //private final static String File_Path="C:\\upload";
    private final static String File_Path="/upload/datareductionsystem";

    /**
     * 测试导入Excel文件
     */
    public Boolean dataExcel(){
        Boolean b=true;
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            WritableWorkbook wwb = null;
            //创建文件夹
            String filePath = File_Path;
            File file = new File(filePath);
            //如果文件夹不存在 则创建文件夹
            if (!file.exists()) {
                file.mkdirs();
            }
            // 创建可写入的Excel工作簿
            //String fileName = File_Path + "\\"+ "douyin.xls";
            String fileName = File_Path + "/"+ "douyin.xls";
            File file1 = new File(fileName);
            //如果文件不存在，则创建文件夹
            if (!file1.exists()) {
                file1.createNewFile();
            }
            // 以fileName为文件名来创建一个Workbook
            wwb = Workbook.createWorkbook(file1);

            // 创建工作表
            WritableSheet ws = wwb.createSheet("Test Shee 1", 0);

            // 查询数据库中所有的数据
            List<Tiktok> list = userMapper.findAllDataExcel();
            // 要插入到的Excel表格的行号，默认从0开始
            Label label1 = new Label(0, 0, "抖音姓名");
            Label label2 = new Label(1, 0, "抖音号码");
            Label label3 = new Label(2, 0, "抖音群号");
            Label label4 = new Label(3, 0, "抖音代号");
            /*Label label3 = new Label(2, 0, "用户密码");
            Label label4 = new Label(3, 0, "用户的age");
            Label label5 = new Label(4, 0, "用户地址");*/

            ws.addCell(label1);
            ws.addCell(label2);
            ws.addCell(label3);
            ws.addCell(label4);
            /*ws.addCell(label3);
            ws.addCell(label4);
            ws.addCell(label5);*/
            for (int i = 0; i < list.size(); i++) {
                Label getId = new Label(0, i + 1, list.get(i).getTikTokUserName1().trim()+"");
                Label getUsername = new Label(1, i + 1, list.get(i).getTikTokUserName2().trim()+"");
                Label datas1 = new Label(2, i + 1, list.get(i).getTikTokUserName3().trim()+"");
                Label datas2 = new Label(3, i + 1, list.get(i).getTikTokUserName4().trim()+"");
                /*Label getPassword = new Label(2, i + 1, list.get(i).getPassword());
                Label getAge = new Label(3, i + 1, list.get(i).getAge() + "");
                Label getAddress = new Label(4, i + 1, list.get(i).getAddress());*/

                ws.addCell(getId);
                ws.addCell(getUsername);
                ws.addCell(datas1);
                ws.addCell(datas2);
                /*ws.addCell(getPassword);
                ws.addCell(getAge);
                ws.addCell(getAddress);*/
            }

            //写进文档
            wwb.write();
            System.out.println("-------------success-------------");
            //关闭Excel工作簿对象
            //数据导出成功!
            /*String fileUrl = fileName.substring(0, fileName.indexOf("dataToExcl"));
            fileUrl = fileName.substring(fileUrl.length(), fileName.length());
            fileUrl = "http://ganfutong.jiangxi.gov.cn/gftjkzzptcs/webapp/" + fileUrl;
            result.put("fileUrl", fileUrl);
            result.put("code", "0000");*/
            wwb.close();
            //抖音数据导出成功，清空表中数据
            userMapper.deleteDataExcel();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            b=false;
            result.put("code", "-9999");
        }
        return b;
    }

    public void subTikTokData3(String str1, String str2) {
        userMapper.subTikTokData3(str1,str2);
    }

    public void subTikTokData4(String str1, String str2, String tikTokUserName2, String tikTokUserName3) {
        userMapper.subTikTokData4(str1,str2,tikTokUserName2,tikTokUserName3);
    }

    public List<Tiktok> queryDataExcel() {
        return userMapper.queryDataExcel();
    }

    public void deleteDataExcel() {
        userMapper.deleteDataExcel();
    }
}
