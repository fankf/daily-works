package com.fankf.hutool.entity;

import lombok.Data;

/**
 * @author fankf
 * @date 2021/7/5 16:09
 * @description
 */
@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String salt;
    private String address;
    private String phone;
    private String email;
}
