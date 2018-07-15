package com.joseph.osys.mail;
import org.apache.commons.mail.*;
public class MailUtilSend {
    // 这里是SMTP发送服务器的协议
    public static final String HOST_NAME = "smtp.exmail.qq.com";
    // 登陆邮件服务器的用户名、密码、昵称
    public static final String USERNAME = "osys_admin@gaofeng1314.cn"; 
    public static final String PASSWORD = "Admin123";
    public static final String NICKNAME = "OSYS";
    
    /**
     * 发送邮件（成功true、失败false）
     * @param receiveEmail  收件人邮箱
     * @param receiveNick   收件人昵称（随便取）
     * @param subject       邮件主题
     * @param contents      邮件内容
     * @return
     */
    public static final boolean sendMail(String receiveEmail,String receiveNick,String subject,String contents){
    	SimpleEmail email = new SimpleEmail();
        try {
            //smtp host 
            email.setHostName(HOST_NAME);
            //登陆邮件服务器的用户名和密码
            email.setAuthentication(USERNAME,PASSWORD);
            //接收人
            email.addTo(receiveEmail, receiveNick);
            //发送人
            email.setFrom(USERNAME, NICKNAME);
            //标题
            email.setSubject(subject);
            //邮件内容
            email.setCharset("utf-8");
            
            email.setMsg(contents);
            //发送
            email.send();
            return true;
        } catch (EmailException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
    }
}
