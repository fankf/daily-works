package com.fankf.springmvc.sf.util;

/**
 * @author fankunfeng
 * @datetime 2020-08-06 16:28
 */

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpClientUtil
{
    private static Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

    public String post(String url, StringEntity entity) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost post = postForm(url, entity);
        String body = "";
        body = invoke(httpClient, post);
        try {
            httpClient.close();
        } catch (IOException e) {
            logger.error("HttpClientService post error", e);
        }
        return body;
    }

    public String post(String url, String name, String value)
    {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        List parameters = new ArrayList();
        parameters.add(new BasicNameValuePair("content", value));

        HttpPost post = postForm(url, new UrlEncodedFormEntity(parameters, Charset.forName("UTF-8")));
        String body = "";
        body = invoke(httpClient, post);
        try {
            httpClient.close();
        } catch (IOException e) {
            logger.error("HttpClientService post error", e);
        }
        return body;
    }

    public String postSFAPI(String url, String xml, String verifyCode)
    {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        List parameters = new ArrayList();
        parameters.add(new BasicNameValuePair("xml", xml));
        parameters.add(new BasicNameValuePair("verifyCode", verifyCode));

        HttpPost post = postForm(url, new UrlEncodedFormEntity(parameters, Charset.forName("UTF-8")));
        String body = "";
        body = invoke(httpClient, post);
        try {
            httpClient.close();
        } catch (IOException e) {
            logger.error("HttpClientService post error", e);
        }
        return body;
    }

    public String get(String url)
    {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet get = new HttpGet(url);
        String body = "";
        body = invoke(httpClient, get);
        try {
            httpClient.close();
        } catch (IOException e) {
            logger.error("HttpClientService get error", e);
        }
        return body;
    }

    public String delete(String url) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpDelete delete = new HttpDelete(url);
        String body = "";
        body = invoke(httpClient, delete);
        try {
            httpClient.close();
        } catch (IOException e) {
            logger.error("HttpClientService get error", e);
        }
        return body;
    }

    public static String invoke(CloseableHttpClient httpclient, HttpUriRequest httpost) {
        HttpResponse response = sendRequest(httpclient, httpost);
        String body = "";
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode == 200) {
            body = parseResponse(response);
        }
        return body;
    }

    private static String parseResponse(HttpResponse response) {
        HttpEntity entity = response.getEntity();
        String body = "";
        try {
            if (entity != null)
                body = EntityUtils.toString(entity);
        }
        catch (ParseException e) {
            logger.error("HttpClientService paseResponse error", e);
        } catch (IOException e) {
            logger.error("HttpClientService paseResponse error", e);
        }
        return body;
    }

    private static HttpResponse sendRequest(CloseableHttpClient httpclient, HttpUriRequest httpost) {
        HttpResponse response = null;
        try {
            response = httpclient.execute(httpost);
        } catch (ClientProtocolException e) {
            logger.error("HttpClientService sendRequest error", e);
        } catch (IOException e) {
            logger.error("HttpClientService sendRequest error", e);
        }
        return response;
    }

    public HttpPost postForm(String url, StringEntity entity) {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(entity);
        return httpPost;
    }

    public static String post(String url, Map<String, String> params) throws UnsupportedEncodingException
    {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(5000).setConnectTimeout(5000)
                .setSocketTimeout(60000).build();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(requestConfig);
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
        List paramsList = new ArrayList();
        for (Map.Entry entry : params.entrySet()) {
            paramsList.add(new BasicNameValuePair((String)entry.getKey(), (String)entry.getValue()));
        }
        UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(paramsList, "UTF-8");
        httpPost.setEntity(urlEncodedFormEntity);
        String body = invoke(httpClient, httpPost);
        try {
            httpClient.close();
        } catch (IOException e) {
            logger.error("HttpClientService post error", e);
        }
        return body;
    }
}