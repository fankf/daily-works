package com.dxhy.ofdfile.protocol;

import lombok.Data;

/**
 * @author fan
 * @create 2020-06-26 21:23
 * @description
 * @see
 */
@Data
public class WRITE_OFD_FILE {
    public String invoice_code;
    public String invoice_no;
    public String ofd_content_base64;
}
