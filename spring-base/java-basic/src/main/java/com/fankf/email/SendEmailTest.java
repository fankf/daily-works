package com.fankf.email;


import org.springframework.util.ResourceUtils;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

public class SendEmailTest {
    // 发件人
    public static final String SendAddress = "fankunfeng_email@163.com";
    //账号
    public static final String SendAccount = "fankunfeng_email@163.com";
    // 密码
    public static final String SendPassword = "XXXX";
    //收件人
    public static final String RecipientAddress = "zhangnan,xyd@autoroad.com";

    // 设置消息主体信息
    public static MimeMessage getMessage(Session session) throws MessagingException, UnsupportedEncodingException, FileNotFoundException {
        MimeMessage message = new MimeMessage(session);

        // 发件人
        message.addFrom(new InternetAddress[]{new InternetAddress(SendAddress)});
        // 收件人
        /**
         * MimeMessage.RecipientType.T0 发送
         * MimeMessage.RecipientType.CC 抄送
         * MimeMessage.RecipientType.BCC 密送
         */
        message.addRecipients(MimeMessage.RecipientType.TO, RecipientAddress);

        //设置邮件主题
        message.setSubject("邮件主题", "UTF-8");
        //设置邮件正文
        //（文本+图片）设置 文本 和 图片"节点"的关系（将 文本 和 图片"节点"合成一个混合"节点"）
        // 1. 创建图片节点
        MimeBodyPart image = new MimeBodyPart();
        DataHandler handler = new DataHandler(new FileDataSource(ResourceUtils.getFile("classpath:pic.png")));
        image.setDataHandler(handler);
        // 设置附件的文件名（需要编码）
        image.setFileName(MimeUtility.encodeText(handler.getName()));
        // 为"节点"设置一个唯一编号（在文本"节点"将引用该ID）
        image.setContentID("Pic");

        // 2. 创建文本"节点"
        MimeBodyPart text = new MimeBodyPart();
        // 这里添加图片的方式是将整个图片包含到邮件内容中, 实际上也可以以 http 链接的形式添加网络图片
        text.setContent("这是一张图片<br/><a href='https://image.baidu.com/search/detail?ct=503316480&z=0&ipn=d&word=%E6%A1%83%E5%AD%90&step_word=&hs=0&pn=0&spn=0&di=151140&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&istype=2&ie=utf-8&oe=utf-8&in=&cl=2&lm=-1&st=-1&cs=2119762476%2C291001022&os=556392980%2C3519954025&simid=0%2C0&adpicid=0&lpn=0&ln=1774&fr=&fmq=1609081947357_R&fm=result&ic=&s=undefined&hd=&latest=&copyright=&se=&sme=&tab=0&width=&height=&face=undefined&ist=&jit=&cg=&bdtype=0&oriquery=&objurl=https%3A%2F%2Fgimg2.baidu.com%2Fimage_search%2Fsrc%3Dhttp%3A%2F%2F5b0988e595225.cdn.sohucs.com%2Fimages%2F20190601%2F299563eee3104b48b858558115e77a75.jpeg%26refer%3Dhttp%3A%2F%2F5b0988e595225.cdn.sohucs.com%26app%3D2002%26size%3Df9999%2C10000%26q%3Da80%26n%3D0%26g%3D0n%26fmt%3Djpeg%3Fsec%3D1611673949%26t%3D338f9c8557f59e336732dafe08ec7da4&fromurl=ippr_z2C%24qAzdH3FAzdH3Fooo_z%26e3Bf5i7_z%26e3Bv54AzdH3FwAzdH3Fn80bl0b9m_m989bb&gsm=1&rpstart=0&rpnum=0&islist=&querylist=&force=undefined'><img src='cid:mailTestPic'/></a>", "text/html;charset=UTF-8");
        // 3. 混合节点
        MimeMultipart mm_text_image = new MimeMultipart();
        mm_text_image.addBodyPart(text);
        mm_text_image.addBodyPart(image);
        mm_text_image.setSubType("related");    // 关联关系

        // 4. 将text + image 封装成一个节点
        MimeBodyPart text_image = new MimeBodyPart();
        text_image.setContent(mm_text_image);

        //  --> 附件节点
        // 5. 创建附件"节点"
        MimeBodyPart attachment = new MimeBodyPart();
        // 读取本地文件
        DataHandler dh2 = new DataHandler(new FileDataSource( ResourceUtils.getFile("classpath:pic.png")));
        // 将附件数据添加到"节点"
        attachment.setDataHandler(dh2);
        // 设置附件的文件名（需要编码）
        attachment.setFileName(MimeUtility.encodeText(dh2.getName()));

        // 6. 设置（文本+图片）和 附件 的关系（合成一个大的混合"节点" / Multipart ）
        MimeMultipart mm = new MimeMultipart();
        mm.addBodyPart(text_image);
        mm.addBodyPart(attachment);     // 如果有多个附件，可以创建多个多次添加
        mm.setSubType("mixed");         // 混合关系

        // 7. 设置整个邮件的关系（将最终的混合"节点"作为邮件的内容添加到邮件对象）
        // 读取本地文件
        message.setContent(mm);

//        message.setContent("楠楠好！", "text/html;charset=UTF-8");
        //设置邮件的发送时间,默认立即发送
        message.setSentDate(new Date());

        return message;
    }

    public static void main(String[] args) throws MessagingException, UnsupportedEncodingException, FileNotFoundException {
        //1、连接邮件服务器的参数配置
        Properties props = new Properties();
        //设置用户的认证方式
        props.setProperty("mail.smtp.auth", "true");
        //设置传输协议
        props.setProperty("mail.transport.protocol", "smtp");
        //设置发件人的SMTP服务器地址
        props.setProperty("mail.smtp.host", "smtp.163.com");
        //2、创建定义整个应用程序所需的环境信息的 Session 对象
        Session session = Session.getInstance(props);
        //设置调试信息在控制台打印出来
        session.setDebug(true);
        //3、创建邮件的实例对象
        Message msg = getMessage(session);
        //4、根据session对象获取邮件传输对象Transport
        Transport transport = session.getTransport();
        //设置发件人的账户名和密码
        transport.connect(SendAccount, SendPassword);
        //发送邮件，并发送到所有收件人地址，message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
        transport.sendMessage(msg,msg.getAllRecipients());

        //如果只想发送给指定的人，可以如下写法
        //transport.sendMessage(msg, new Address[]{new InternetAddress("xxx@qq.com")});

        //5、关闭邮件连接
        transport.close();
    }
}
