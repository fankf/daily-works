package com.dxhy.ofdfile.controller;

import com.dxhy.ofdfile.protocol.DataInfo;
import com.dxhy.ofdfile.protocol.RESPONSE;
import com.dxhy.ofdfile.protocol.WRITE_OFD_FILE;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author fan
 * @create 2020-06-27 9:02
 * @description
 * @see
 */
@RestController
@RequestMapping("/ofd")
public class MNController {

    @RequestMapping("/write")
    public RESPONSE writeInfo(HttpServletRequest request,@RequestBody WRITE_OFD_FILE WRITE_OFD_FILE){
        String invoice_code = WRITE_OFD_FILE.getInvoice_code();
        String invoice_no = WRITE_OFD_FILE.getInvoice_no();
        String ofd_content_base64 = WRITE_OFD_FILE.getOfd_content_base64();
        DataInfo.map.put(invoice_code+invoice_no,ofd_content_base64);
        return new RESPONSE();
    }

    @RequestMapping("/read")
    public RESPONSE getInfo(HttpServletRequest request){
        String invoice_code = request.getParameter("invoice_code");
        String invoice_no = request.getParameter("invoice_no");
        String message = DataInfo.map.get(invoice_code + invoice_no);
        RESPONSE response = new RESPONSE();
        response.setOfd_content_base64(message);
        return response;
    }
}
