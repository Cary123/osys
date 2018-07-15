package com.joseph.osys.mail;

public class SendEmail {
	public static void main(String[] args) {
		String receiveEmail = "2191936379@qq.com";
//        String receiveNick="";
        String subject="OSYS系统-邮箱身份验证";
        String contents="亲爱的用户：您好！" +
        		"感谢您使用OSYS系统。您正在进行邮箱验证，请在验证码输入框中输入此次验证码：334025 以完成验证。" +
        		"如非本人操作，请忽略此邮件，由此给您带来的不便请谅解！" +
        		"Joseph&joseph" +
        		"2017年01月01日";
        boolean b = MailUtilSend.sendMail(receiveEmail, receiveEmail, subject, contents);
        System.out.println(b);
	}  
}
