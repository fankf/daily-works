package com.fankf.springmvc.util;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Http请求工具类
 *
 * @author SONGDAN
 * @modified liuyong 添加decodeParm函数
 */
public final class HttpUtils {


    public static final int TIMEOUT = 10;

    /**
     * post 请求
     *
     * @param url
     * @return
     */
    public static String post(String url) {
        return post(url, "");
    }

    /**
     * post请求
     *
     * @param url
     * @param data
     * @return
     */
    public static String post(String url, String data) {
        return httpPost(url, data);
    }

    /**
     * post请求
     *
     * @param url
     * @param data
     * @return
     */
    public static String postWithForm(String url, String data) {
        return httpPost(url, data, ContentType.create("application/x-www-form-urlencoded", Consts.UTF_8));
    }

    public static String postWithJson2(String url, String data) {
        return httpPost(url, data, ContentType.create("application/json", Consts.UTF_8));
    }

    /**
     * @param @param  url
     * @param @param  data
     * @param @return
     * @return String
     * @throws
     */
    public static String putWithJson(String url, String data) {
        return httpPut(url, data, ContentType.create("application/x-www-form-urlencoded", Consts.UTF_8));
    }


    /**
     * @param @param  url
     * @param @param  data
     * @param @param  create
     * @param @return
     * @return String
     * @throws
     */

    private static String httpPut(String url, String data, ContentType contentType) {
        try {
            HttpEntity entity = Request.Put(url).bodyString(data, contentType)
                    .execute().returnResponse().getEntity();
            return entity != null ? EntityUtils.toString(entity) : null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 发送http post请求
     *
     * @param url      url
     * @param instream post数据的字节流
     * @return
     */
    public static String post(String url, InputStream instream) {
        try {
            HttpEntity entity = Request.Post(url).bodyStream(instream, ContentType.create("text/html", Consts.UTF_8))
                    .execute().returnResponse().getEntity();
            return entity != null ? EntityUtils.toString(entity) : null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param @param  url
     * @param @param  instream
     * @param @return
     * @return String
     */

    public static String put(String url, InputStream instream) {
        try {
            HttpEntity entity = Request.Put(url).bodyStream(instream, ContentType.create("text/html", Consts.UTF_8))
                    .execute().returnResponse().getEntity();
            return entity != null ? EntityUtils.toString(entity) : null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * get请求
     *
     * @param url
     * @return
     */
    public static String get(String url) {
        return httpGet(url);
    }

    /**
     * post 请求
     *
     * @param url
     * @param data
     * @return
     */
    public static String httpPost(String url, String data) {
        try {
            HttpEntity entity = Request.Post(url).bodyString(data, ContentType.create("text/html", Consts.UTF_8))
                    .execute().returnResponse().getEntity();
            return entity != null ? EntityUtils.toString(entity) : null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * post 请求
     *
     * @param url
     * @param data
     * @return
     */
    public static String httpPostWithHeader(String url, String data, String token) {
        try {
            Request post = Request.Post(url);
            post.setHeader("token", token);
            HttpEntity entity = post.bodyString(data, ContentType.create("application/json", Consts.UTF_8))
                    .execute().returnResponse().getEntity();
            return entity != null ? EntityUtils.toString(entity) : null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * post 请求
     *
     * @param url
     * @param data
     * @param contentType
     * @return
     */
    public static String httpPost(String url, String data, ContentType contentType) {
        try {
            HttpEntity entity = Request.Post(url).bodyString(data, contentType)
                    .execute().returnResponse().getEntity();
            return entity != null ? EntityUtils.toString(entity) : null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 上传文件
     *
     * @param url  URL
     * @param file 需要上传的文件
     * @return
     */
    public static String postFile(String url, File file) {
        return postFile(url, null, file);
    }

    /**
     * 上传文件
     *
     * @param url  URL
     * @param name 文件的post参数名称
     * @param file 上传的文件
     * @return
     */
    public static String postFile(String url, String name, File file) {
        try {
            HttpEntity reqEntity = MultipartEntityBuilder.create().addBinaryBody(name, file).build();
            Request request = Request.Post(url);
            request.body(reqEntity);
            HttpEntity resEntity = request.execute().returnResponse().getEntity();
            return resEntity != null ? EntityUtils.toString(resEntity) : null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 下载文件
     *
     * @param url URL
     * @return 文件的二进制流，客户端使用outputStream输出为文件
     */
    public static byte[] getFile(String url) {
        try {
            Request request = Request.Get(url);
            HttpEntity resEntity = request.execute().returnResponse().getEntity();
            return EntityUtils.toByteArray(resEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 发送get请求
     *
     * @param url
     * @return
     */
    private static String httpGet(String url) {
        try {
            HttpEntity entity = Request.Get(url).execute().returnResponse().getEntity();
            return entity != null ? EntityUtils.toString(entity, "UTF-8") : null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    public static String requestPost(String url, Map<String, String> map) throws ClientProtocolException, IOException {
        return requestPost(url, toNameValuePairs(map));
    }
    public static List<NameValuePair> toNameValuePairs(Map<String, String> map) {
        List<NameValuePair> params = new ArrayList<NameValuePair>();

        for (Entry<String, String> entry : map.entrySet()) {
            params.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        return params;
    }
    public static String requestPost(String url, List<NameValuePair> params) throws ClientProtocolException, IOException {

        String result = null;
        CloseableHttpClient httpclient = HttpClients.createDefault();

        HttpPost post = new HttpPost(url);
        post.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
        CloseableHttpResponse response = httpclient.execute(post);
        StatusLine statusLine = response.getStatusLine();
        if (statusLine.getStatusCode() == 200) {
            HttpEntity httpEntity = response.getEntity();
            result = EntityUtils.toString(httpEntity);
        } else {
            throw new IOException("post请求异常");
        }

        return result;
    }
    public static String requestPost(String url, String json) throws IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		// 参入发送路径
		HttpPost post = new HttpPost(url);
		StringEntity se = new StringEntity(json, "UTF-8");
		// 用post请求
		se.setContentType("application/json;charset=UTF-8");
		post.setEntity(se);
		// 接收请求返回的数据
		CloseableHttpResponse response = httpclient.execute(post);
		return dealResponse(url, response);
	}
    /**
     * 处理响应结果
     * @param url
     * @param response
     * @return
     * @throws IOException
     */
    public static String dealResponse(String url, CloseableHttpResponse response) throws IOException {
        String result;// 取出请求返回状态
        StatusLine statusLine = response.getStatusLine();
        if (statusLine.getStatusCode() == 200) {
            // 获取http返回的报文实体
            HttpEntity httpEntity = response.getEntity();
            result = EntityUtils.toString(httpEntity);

        } else {
            throw new IOException("请求失败！请求链接为："+url+"，返回的请求代码为："+ statusLine.getStatusCode() +
                    "，错误原因为:"+statusLine.getReasonPhrase());
        }
        return result;
    }
    
    /**
     * head中添加对应的key-value 请求数据
     */
    public static String httpPostWithHeader(String url, String data, Map<String, String> header) {
        try {
            Request post = Request.Post(url);
            
            for (Entry<String, String> entry : header.entrySet()) {
                post.setHeader(entry.getKey(), entry.getValue());
            }
            HttpEntity entity = post.bodyString(data, ContentType.create("application/json", Consts.UTF_8))
                    .execute().returnResponse().getEntity();
            return entity != null ? EntityUtils.toString(entity) : null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
