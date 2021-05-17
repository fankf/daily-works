package com.fankf.springmvc.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Map;


/**
 * @Author fankunfeng
 * @Date 2018-12-27 18:57:21
 * @Describe rest方式请求第三方资源
 */
@Slf4j
public class RestWebServiceUtil {
    private static final String CLASSNAME = "RestWebServiceUtil";
    /**
     * 此处所有配置都是用默认，如果像修改需要使用配置文件
     */
    private static RestTemplate template = new RestTemplate();

    /**
     * URL示例  http://localhost:8082/order/post
     *
     * @param url
     * @param string
     * @return
     */
    public static String doPost(String url, String string,MediaType mediaType) {
        log.info("{}请求传输的参数URL:{},String：{}", CLASSNAME, url, string);
        ResponseEntity<String> forEntity = template.postForEntity(url, string, String.class);
        HttpHeaders headers = forEntity.getHeaders();
        HttpStatus statusCode = forEntity.getStatusCode();
        int statusCodeValue = forEntity.getStatusCodeValue();
        String body = forEntity.getBody();
        log.info("响应头:headers:{},状态码:{},状态信息:{}", headers, statusCode, statusCodeValue);
        log.info("返回的body:{}", body);
        return body;
    }
    //----------------------------------------------以下为测试示例------------------------------------------------------------

    /**
     * URI示例   http://localhost:8082/order/post
     *
     * @param url
     * @param string
     * @return
     */
    public static String doPostUriForObject(String url, String string) {
        log.info("{}请求传输的参数String：{}", CLASSNAME, string);
        UriComponents encode = UriComponentsBuilder.fromUriString(url).build().encode();
        URI uri = encode.toUri();
        String body = template.postForObject(uri, string, String.class);
        log.info("返回的body:{}", body);
        return body;
    }

    /**
     * URL示例  http://localhost:8082/order/post
     *
     * @param url
     * @param string
     * @return
     */
    public static String doPostForObject(String url, String string) {
        log.info("{}请求传输的参数String：{}", CLASSNAME, string);
        String body = template.postForObject(url, string, String.class);
        log.info("返回的body:{}", body);
        return body;
    }

    /**
     * URL示例：http://localhost:8082/order/post
     *
     * @param url
     * @param map 示例map{A=Avalue,B=Bvalue},请求的时候拿到的是Value值
     * @return
     */
    public static <T> String doPostForObject(String url, Map<String, T> map) {
        log.info("{}请求传输的参数map：{}", CLASSNAME, map);
        String body = template.postForObject(url, map, String.class);
        log.info("返回的body:{}", body);
        return body;
    }

    /**
     * URI示例   http://localhost:8082/order/post
     *
     * @param url
     * @param string
     * @return
     */
    public static String doPostUriForEntity(String url, String string) {
        log.info("{}请求传输的参数String：{}", CLASSNAME, string);
        UriComponents encode = UriComponentsBuilder.fromUriString(url).build().encode();
        URI uri = encode.toUri();
        ResponseEntity<String> forEntity = template.postForEntity(uri, string, String.class);
        HttpHeaders headers = forEntity.getHeaders();
        HttpStatus statusCode = forEntity.getStatusCode();
        int statusCodeValue = forEntity.getStatusCodeValue();
        String body = forEntity.getBody();
        log.info("响应头:headers:{},状态码:{},状态信息:{}", headers, statusCode, statusCodeValue);
        log.info("返回的body:{}", body);
        return body;
    }

    /**
     * URL示例  http://localhost:8082/order/post
     *
     * @param url
     * @param string
     * @return
     */
    public static String doPostForEntity(String url, String string) {
        log.info("{}请求传输的参数String：{}", CLASSNAME, string);
        ResponseEntity<String> forEntity = template.postForEntity(url, string, String.class);
        HttpHeaders headers = forEntity.getHeaders();
        HttpStatus statusCode = forEntity.getStatusCode();
        int statusCodeValue = forEntity.getStatusCodeValue();
        String body = forEntity.getBody();
        log.info("响应头:headers:{},状态码:{},状态信息:{}", headers, statusCode, statusCodeValue);
        log.info("返回的body:{}", body);
        return body;
    }

    /**
     * URL示例：Http://localhost:8082/order?key1={A}&key2={B}
     *
     * @param url
     * @param map 示例map{A=Avalue,B=Bvalue},请求的时候拿到的是Value值
     * @return
     */
    public static <T> String doPostForEntity(String url, Map<String, T> map) {
        log.info("{}请求传输的参数map：{}", CLASSNAME, map);
        ResponseEntity<String> forEntity = template.postForEntity(url, map, String.class);
        HttpHeaders headers = forEntity.getHeaders();
        HttpStatus statusCode = forEntity.getStatusCode();
        int statusCodeValue = forEntity.getStatusCodeValue();
        String body = forEntity.getBody();
        log.info("响应头:headers:{},状态码:{},状态信息:{}", headers, statusCode, statusCodeValue);
        log.info("返回的body:{}", String.valueOf(body));
        return body;
    }

    /**
     * URI示例   http://localhost:8082/order?name={string}
     *
     * @param url
     * @param string
     * @return
     */
    public static String doUriGetForEntity(String url, String string) {
        log.info("{}请求传输的参数String：{}", CLASSNAME, string);
        UriComponents encode = UriComponentsBuilder.fromUriString(url).build().expand(string).encode();
        URI uri = encode.toUri();
        ResponseEntity<String> forEntity = template.getForEntity(uri, String.class);
        HttpHeaders headers = forEntity.getHeaders();
        HttpStatus statusCode = forEntity.getStatusCode();
        int statusCodeValue = forEntity.getStatusCodeValue();
        String body = forEntity.getBody();
        log.info("响应头:headers:{},状态码:{},状态信息:{}", headers, statusCode, statusCodeValue);
        log.info("返回的body:{}", body);
        return body;
    }

    /**
     * URL示例 1   http://localhost:8082/order/{string}
     * URL示例 2   http://localhost:8082/order?name={string}
     *
     * @param url
     * @param string
     * @return
     */
    public static String doGetForEntity(String url, String string) {
        log.info("{}请求传输的参数String：{}", CLASSNAME, string);
        ResponseEntity<String> forEntity = template.getForEntity(url, String.class, string);
        HttpHeaders headers = forEntity.getHeaders();
        HttpStatus statusCode = forEntity.getStatusCode();
        int statusCodeValue = forEntity.getStatusCodeValue();
        String body = forEntity.getBody();
        log.info("响应头:headers:{},状态码:{},状态信息:{}", headers, statusCode, statusCodeValue);
        log.info("返回的body:{}", body);
        return body;
    }

    /**
     * URL示例：Http://localhost:8082/order?key1={A}&key2={B}
     *
     * @param url
     * @param map 示例map{A=Avalue,B=Bvalue},请求的时候拿到的是Value值
     * @return
     */
    public static <T> String doGetForEntity(String url, Map<String, T> map) {
        log.info("{}请求传输的参数map：{}", CLASSNAME, map);
        ResponseEntity<String> forEntity = template.getForEntity(url, String.class, map);
        HttpHeaders headers = forEntity.getHeaders();
        HttpStatus statusCode = forEntity.getStatusCode();
        int statusCodeValue = forEntity.getStatusCodeValue();
        String body = forEntity.getBody();
        log.info("响应头:headers:{},状态码:{},状态信息:{}", headers, statusCode, statusCodeValue);
        log.info("返回的body:{}", String.valueOf(body));
        return body;
    }

    /**
     * URI示例   http://localhost:8082/order?name={string}
     *
     * @param url
     * @param string
     * @return
     */
    public static String doUriGetForObject(String url, String string) {
        log.info("{}请求传输的参数String：{}", CLASSNAME, string);
        UriComponents encode = UriComponentsBuilder.fromUriString(url).build().expand(string).encode();
        URI uri = encode.toUri();
        String body = template.getForObject(uri, String.class);
        log.info("返回的body:{}", body);
        return body;
    }

    /**
     * URL示例 1   http://localhost:8082/order/{string}
     * URL示例 2   http://localhost:8082/order?name={string}
     *
     * @param url
     * @param string
     * @return
     */
    public static String doGetForObject(String url, String string) {
        log.info("{}请求传输的参数String：{}", CLASSNAME, string);
        String body = template.getForObject(url, String.class, string);
        log.info("返回的body:{}", body);
        return body;
    }

    /**
     * URL示例：Http://localhost:8082/order?key1={A}&key2={B}
     *
     * @param url
     * @param map 示例map{A=Avalue,B=Bvalue},请求的时候拿到的是Value值
     * @return
     */
    public static String doGetForObject(String url, Map<String, Object> map) {
        log.info("{}请求传输的参数map：{}", CLASSNAME, map);
        String forEntity = template.getForObject(url, String.class, map);
        log.info("返回的body:{}", forEntity);
        return forEntity;
    }
}
