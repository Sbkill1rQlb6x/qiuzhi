package com.gs.qiuzhi.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.exceptions.ClientException;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.gs.qiuzhi.pojo.User;
import com.gs.qiuzhi.service.KlService;
import com.gs.qiuzhi.service.UserService;
import com.gs.qiuzhi.util.JsonResult;
import com.gs.qiuzhi.util.SmsCode;
import com.gs.qiuzhi.util.UnixTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 控制器
 */
@Controller

public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    DefaultKaptcha defaultKaptcha;

    @Autowired
    private KlService klService;

    @RequestMapping("/testMybatis")
    public String listUser(Model m) {
        List<User> users = userService.findAll();
        m.addAttribute("users", users);
        return "user2";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "home";
    }

    @RequestMapping("/testGit")
    public String git() {
        return "home";
    }


    @RequestMapping("/registerView.do")
    public String registerView() {
        return "register";
    }

    @RequestMapping("/personView.do")
    public String personView(){
        return "person";
    }

    @RequestMapping("/checkPass.do")
    public String checkPass(){
        return "updatePass";
    }

    @RequestMapping("/updatePass.do")
    public String updatePass(){
        return "updatePass2";
    }

    @RequestMapping("/loginView.do")
    public String loginView() {
        return "login";
    }

    @RequestMapping("plaseLogin.do")
    public String plaseLogin(){
        return "noLogin";
    }




    /**
     * 获取验证码
     * @param httpServletRequest
     * @param httpServletResponse
     * @throws Exception
     */
    @RequestMapping("/defaultKaptcha")
    public void defaultKaptcha(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        byte[] captchaChallengeAsJpeg = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try {
            //生产验证码字符串并保存到session中
            String createText = defaultKaptcha.createText();
            httpServletRequest.getSession().setAttribute("vrifyCode", createText);
            //使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
            BufferedImage challenge = defaultKaptcha.createImage(createText);
            ImageIO.write(challenge, "jpg", jpegOutputStream);
        } catch (IllegalArgumentException e) {
            httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        //定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
        httpServletResponse.setHeader("Cache-Control", "no-store");
        httpServletResponse.setHeader("Pragma", "no-cache");
        httpServletResponse.setDateHeader("Expires", 0);
        httpServletResponse.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream =
                httpServletResponse.getOutputStream();
        responseOutputStream.write(captchaChallengeAsJpeg);
        responseOutputStream.flush();
        responseOutputStream.close();
    }

    /**
     * 验证登录验证码是否正确
     * @param verifyCode
     * @param request
     * @return
     */

    @RequestMapping(value = "checkVerificationCode")
    @ResponseBody
    public boolean checkVerificationCode(String verifyCode,
                                         HttpServletRequest request){
        String kaptchaExpected = (String)request.getSession().getAttribute("vrifyCode");
        String kaptchaReceived = verifyCode;
        if  (kaptchaReceived.equals("")  || !kaptchaReceived.equalsIgnoreCase(kaptchaExpected))
        {
            return false;
        }else {
            return true;
        }

    }

    /**
     * 用户登录
     * @param userName
     * @param password
     * @param session
     * @param red
     * @return
     */
    @RequestMapping("/userLogin.do")
    public String userLogin(String userName, String password, HttpSession session,RedirectAttributes red){
        User user = userService.checkUserLogin(userName,password);
        if (user!=null)
        {
            session.setAttribute("user",user);
            return "redirect:index.do";
        }
        else {
            red.addFlashAttribute("loginErr","用户名或密码错误");
            return "redirect:loginView.do";
        }

    }

    /**
     * 用户注销
     * @param session
     * @return
     */
    @RequestMapping("/outUserLogin.do")
    public String outUserLogin(HttpSession session){

        session.removeAttribute("user");
        session.invalidate();
        return "redirect:index.do";
    }

    /**
     * 发送短信验证码
     * @param jsonObject
     * @param session
     * @return
     * @throws ClientException
     */
    @RequestMapping("/sendMsg.do")
    @ResponseBody
    public JSONObject sendMsg(@RequestBody JSONObject jsonObject,HttpSession session) throws ClientException {
        JSONObject resJson;
        System.out.println(jsonObject.toJSONString());
        String phoneNum = jsonObject.getString("phoneNumber");
        System.out.println(phoneNum);
        if (phoneNum==null||phoneNum.equals(""))
        {
            resJson = JSON.parseObject(JsonResult.SMS_CODE_RES_FALSE);
            return resJson;
        }
        else {
            SmsCode sms = new SmsCode(phoneNum);
            sms.sendSms();
            session.setAttribute("smsCode",sms.getVerifyCode());
            resJson = JSON.parseObject(JsonResult.SMS_CODE_RES_TRUE);
            return resJson;
        }

    }

    /**
     * 用户注册
     * @param sms
     * @param email
     * @param phoneNum
     * @param password
     * @param session
     * @param red 用于装入重定向参数（不会在url拼接值，刷新之后会被清空）
     * @return
     */
    @RequestMapping("/userRegister.do")
    public String userRegister(String sms,String email,String phoneNum,String password,HttpSession session,RedirectAttributes red){
        if (sms==null||sms.equals("")) {
            red.addFlashAttribute("smsErr", "请填写验证码");
            return "redirect:registerView.do";

        }else if(!sms.equals(session.getAttribute("smsCode"))){

                red.addFlashAttribute("smsErr","验证码错误");
                return "redirect:registerView.do";

        }else {
            if (userService.checkRegister(phoneNum)!=null){
                red.addFlashAttribute("smsErr","该手机号已被注册！");
                return "redirect:registerView.do";
            }
            User user = new User();
            UnixTime ux = new UnixTime();
            String uxTime = ux.getNowTimeStamp();
            user.setEmail(email);
            user.setUser_phone(phoneNum);
            user.setUser_pass(password);
            user.setNickName("用户_"+uxTime);
            user.setUser_onlyId(uxTime);
            userService.userRegister(user);
            return "redirect:loginView.do";

        }

    }

    /**
     * 用户上传头像
     * @param file
     * @param red
     * @param session
     * @param request
     * @return
     */
    @RequestMapping("/userUploadedFace.do")
    public String userUploadedFace(@RequestParam("userFace") MultipartFile file, RedirectAttributes red,HttpSession session,HttpServletRequest request){

        String fileName = file.getOriginalFilename();
        String fileSuffix = fileName.substring(fileName.lastIndexOf(".")+1);//获取后缀名称
        if (fileSuffix.equals("png")|| fileSuffix.equals("jpeg") || fileSuffix.equals("jpg"))
        {
            User user = (User) session.getAttribute("user");
            String path = request.getServletContext().getRealPath("user_face/");
            String newFileName = "user_face_"+user.getUser_onlyId()+"."+fileSuffix;
            File dest = new File(path+newFileName);
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            try {
                file.transferTo(dest);
                red.addFlashAttribute("faceErr","上传成功！");
                userService.updateUserFace("user_face/"+newFileName,user.getUser_onlyId());//更新数据库，传递相对路径
                klService.updateCollUserFace("user_face/"+newFileName,user.getUser_onlyId());
                return "redirect:personView.do";
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "redirect:personView.do";
        }else {

            red.addFlashAttribute("faceErr","图片格式错误！");
            return "redirect:personView.do";

        }

    }

    /**
     * 修改用户名
     * @param nickName
     * @param session
     * @return
     */
    @RequestMapping("/updateUserNickName.do")
    public String updateUserNickName(String nickName,HttpSession session){
        User user =(User)session.getAttribute("user");
        user.setNickName(nickName);
        userService.updateUserNickName(nickName,user.getUser_onlyId());
        session.setAttribute("user",user);
        return "redirect:personView.do";
    }


    /**
     * 检查原始密码
     * @param originalPass
     * @param session
     * @return
     */
    @RequestMapping("checkOriginalPass.do")
    public String checkOriginalPass(String originalPass,HttpSession session){
        User user =(User)session.getAttribute("user");
        if(userService.checkOriginalPass(originalPass,user.getUser_onlyId()))
        {
            return "redirect:updatePass.do";
        }else {
            return "redirect:checkPass.do";
        }


    }


    /**
     * 用户修改密码
     * @param newPassword
     * @param session
     * @return
     */
    @RequestMapping("updateNewPass.do")
    public String updatePassRequest(String newPassword,HttpSession session){
        User user = (User)session.getAttribute("user");
        userService.updatePass(newPassword,user.getUser_onlyId());
        session.invalidate();
        return "redirect:index.do";
    }


    }
