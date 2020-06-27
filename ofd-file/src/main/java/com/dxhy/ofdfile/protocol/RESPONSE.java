package com.dxhy.ofdfile.protocol;

import lombok.Data;

/**
 * @author fan
 * @create 2020-06-27 8:50
 * @description
 * @see
 */
@Data
public class RESPONSE {
    private String return_code;
    private String return_msg;
    private String ofd_content_base64;
    public RESPONSE(){
        return_code = "0";
        return_msg = "OK";
    }
}
