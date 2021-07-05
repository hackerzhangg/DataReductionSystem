package com.datareductionsystem.controller;

import com.datareductionsystem.model.Tiktok;
import com.datareductionsystem.model.Users;
import com.datareductionsystem.service.UserService;
import com.sun.deploy.net.HttpResponse;
import org.apache.commons.collections4.ListUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author zgp
 * @Since 2021 -06 -30 10 :47
 * @Description 系统用户管理员Controller
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 到系统登录页面
     * @return
     */
    @RequestMapping("userLoginPage")
    public ModelAndView userLoginPage(){
        ModelAndView modelAndView=new ModelAndView("userLogin");
        return modelAndView;
    }

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/userLogin")
    @ResponseBody
    public ModelAndView userLogin(String username, String password){
        ModelAndView modelAndView =new ModelAndView("userLogin");
        List<Users> usersList=userService.userLogin(username,password);
        //判断用户密码和用户名是否为空
        if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
            modelAndView.addObject("status","-9999");
            modelAndView.addObject("msg","亲 用户名或者密码为空！");
            return modelAndView;
        }
        //判断是否存在该用户,如果不存在，继续回到登录页面
        if (usersList.size() == 0 || usersList == null){
            modelAndView.addObject("status","-9999");
            modelAndView.addObject("msg","亲 该用户不存在!");
            return modelAndView;
        }
        //用户存在，到后台首页系统
        //return new ModelAndView("loginSuccess");
        return new ModelAndView("dataExcel");
    }

    /**
     * 提交抖音用户数据
     * @param TikTokUserName1
     * @param TikTokUserName2
     * @return
     */
    @RequestMapping("/submitData")
    public ModelAndView subTikTokData(String TikTokUserName1,String TikTokUserName2){
        ModelAndView modelAndView1=new ModelAndView("loginSuccess");
        if (StringUtils.isEmpty(TikTokUserName1) || StringUtils.isEmpty(TikTokUserName2)){
            modelAndView1.addObject("status","-9999");
            modelAndView1.addObject("msg","亲 用户名或者密码为空！");
            return modelAndView1;
        }
        //用回车键来分隔几个元素
        String[] TikTokUserName1Data = TikTokUserName1.split("\n");
        //先插入抖音姓名
        for (int i = 0; i < TikTokUserName1Data.length; i++) {
            userService.subTikTokData1(TikTokUserName1Data[i]);
        }
        //插入抖音号码
        String[] TikTokUserName2Data = TikTokUserName2.split("\n");
        for (int i = 0; i < TikTokUserName2Data.length; i++) {
            userService.subTikTokData2(TikTokUserName2Data[i]);
        }
        ModelAndView modelAndView2=new ModelAndView("success");
        modelAndView2.addObject("status","0000");
        modelAndView2.addObject("msg","抖音数据提交成功！");
        //到提交成功页面
        return modelAndView2;
    }

    /**
     * 提交抖音数据
     * @param TikTokUserName1 抖音姓名，抖音号码
     * @param TikTokUserName1 抖音群
     * @param TikTokUserName1 抖音代号
     * @return
     */
    @RequestMapping("/submitDatas")
    public ModelAndView subTikTokDatas(String TikTokUserName1,String TikTokUserName2,String TikTokUserName3){
        ModelAndView modelAndView1=new ModelAndView("dataExcel");
        if (StringUtils.isEmpty(TikTokUserName1) || StringUtils.isEmpty(TikTokUserName2) || StringUtils.isEmpty(TikTokUserName3)){
            modelAndView1.addObject("status","-9999");
            modelAndView1.addObject("msg","亲 用户名或者密码为空！");
            return modelAndView1;
        }
        //用回车键来分隔几个元素
        String[] TikTokUserName1Data = TikTokUserName1.split("\n");
        //先插入抖音姓名
        for (int i = 0; i < TikTokUserName1Data.length; i++) {
            String data1=TikTokUserName1Data[i].trim();
            //截取字符串中空格之前得数据
            String str1=data1.substring(0, data1.indexOf(" "));
            System.out.println(str1);
            //截取字符串中空格之后得数据
            String str2=data1.substring(data1.lastIndexOf(" "));
            System.out.println(str2);
            userService.subTikTokData4(str1,str2,TikTokUserName2,TikTokUserName3);
        }
        ModelAndView modelAndView2=new ModelAndView("success");
        modelAndView2.addObject("status","0000");
        modelAndView2.addObject("msg","抖音数据提交成功！");
        //到提交成功页面
        return modelAndView2;
    }

    /**
     * 通过excel导出抖音数据
     * @return
     */
    @ResponseBody
    @RequestMapping("excel")
    public ModelAndView  dataExcel(){
        ModelAndView modelAndView=new ModelAndView("dataExcelSuccess");
        Boolean dataExcel = userService.dataExcel();
        if(dataExcel){
            modelAndView.addObject("Value","true");
        }else{
            modelAndView.addObject("Value","false");
        }
        return modelAndView;
    }

    /**
     * 查询所有提交得Excel数据信息
     * @return
     */
    @ResponseBody
    @RequestMapping("queryDataExcel")
    public ModelAndView queryDataExcel(){
        ModelAndView modelAndView=new ModelAndView("queryDataExcel");
        List<Tiktok> tiktokList=userService.queryDataExcel();
        modelAndView.addObject("tiktokList",tiktokList);
        return modelAndView;
    }

    /**
     * 对导出的Excel文件 进行下载
     * @param request
     * @param response
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping("FileDownload")
    public void FileDownload(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 设置请求编码
        request.setCharacterEncoding("UTF-8");
        // 接受参数，得到需要被下载的文件的名称
        /*String fileName = request.getParameter("fileName");
        // 判断名字名是否为空
        if(fileName == null || "".equals(fileName)){
            // 提示
            System.out.println("文件名不能为空");
            return;
        }*/
        // 获取文件存放的真实路径
        //String path = request.getServletContext().getRealPath("/" + fileName);
        //本机
        //String path="F:\\upload\\datareductionsystem\\douyin.xls";
        //线上
        String path="/upload/datareductionsystem/douyin.xls";
        // 通过文件路径和文件名得到file对象
        File file = new File(path);
        // 判断是否存在，并且是一个标准文件
        if (file.exists() && file.isFile()){
            // 设置相应类型 application/octet-stream
            response.setContentType("application/x-msdownload");
            // 设置头信息
            response.setHeader("Content-Disposition", "attachment;filename=" + "douyin.xls");
            // 通过file对象得到输入流
            FileInputStream in = new FileInputStream(file);
            // 得到输出流
            ServletOutputStream out = response.getOutputStream();
            byte[] car = new byte[1024];
            int len = 0;
            while((len = in.read(car)) != -1){
                out.write(car,0,len);
            }
            // 关闭流
            in.close();
            out.close();
        } else {
            System.out.println("文件路径不正确！");
        }
    }

    /**
     * 清空Excel表信息
     * @return
     */
    @ResponseBody
    @RequestMapping("deleteDataExcel")
    public ModelAndView deleteDataExcel(){
        ModelAndView modelAndView=new ModelAndView("dataExcel");
        userService.deleteDataExcel();
        return modelAndView;
    }

    /**
     * 到添加抖音数据页面
     * @return
     */
    @ResponseBody
    @RequestMapping("toAddDataPage")
    public ModelAndView toAddDataPage(){
        ModelAndView modelAndView=new ModelAndView("dataExcel");
        return  modelAndView;
    }
}
