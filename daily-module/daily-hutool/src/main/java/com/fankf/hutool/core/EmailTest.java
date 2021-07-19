package com.fankf.hutool.core;

import cn.hutool.extra.mail.MailAccount;
import lombok.var;

/**
 * @author fankf
 * @date 2021/7/9 9:36
 * @description
 */
public class EmailTest {
    public static void main(String[] args) {
        var account = new MailAccount();
        account.setHost("smtp.163.com");
        account.setPort(25);
        account.setAuth(true);
        account.setFrom("fankunfeng_email@163.com");
        account.setUser("fankunfeng_email");
        account.setPass("HGCKFIBFYWRIPGCC");
//        MailUtil.send(account,"1990432344@qq.com","测试","hutool email send test",false);
    }
}
