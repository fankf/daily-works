package com.fankf.springmvc.sf.util;

/**
 * @author fankunfeng
 * @datetime 2020-08-06 16:29
 */
public enum EspServiceCode {
    EXP_RECE_CREATE_ORDER(
            "EXP_RECE_CREATE_ORDER", "01.order.json"),
    EXP_RECE_SEARCH_ORDER_RESP(
            "EXP_RECE_SEARCH_ORDER_RESP", "02.order.query.json"),
    EXP_RECE_UPDATE_ORDER(
            "EXP_RECE_UPDATE_ORDER", "03.order.confirm.json"),
    EXP_RECE_FILTER_ORDER_BSP(
            "EXP_RECE_FILTER_ORDER_BSP", "04.order.filter.json"),
    EXP_RECE_SEARCH_ROUTES(
            "EXP_RECE_SEARCH_ROUTES", "05.route_query_by_MailNo.json"),
    EXP_RECE_GET_SUB_MAILNO(
            "EXP_RECE_GET_SUB_MAILNO", "07.sub.mailno.json"),
    EXP_RECE_QUERY_SFWAYBILL(
            "EXP_RECE_QUERY_SFWAYBILL", "09.waybills_fee.json");

    private String code;
    private String path;

    private EspServiceCode(String code, String path) {
        this.code = code;
        this.path = path;
    }

    public String getCode() {
        return this.code;
    }

    public String getPath() {
        return this.path;
    }
}
