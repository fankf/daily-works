package com.fans.util;

import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.impl.nio.reactor.IOReactorConfig;
import org.apache.http.message.BasicHeader;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.*;

import java.io.IOException;

/**
 * @author fankunfeng
 * @date 2022-03-02 18:31:49
 */
public class EsRestUtil {
    private RestHighLevelClient restClient;

    public EsRestUtil() {
        String indexServer = "127.0.0.1:9200";
        String[] indexServers = indexServer.split(",");
        HttpHost[] httpHosts = new HttpHost[indexServers.length];
        for (int i = 0; i < indexServers.length; i++) {
            String[] array = indexServers[i].split(":");
            httpHosts[i] = new HttpHost(array[0], Integer.parseInt(array[1]), "http");
        }

        RestClientBuilder clientBuilder = RestClient.builder(httpHosts);

        // 设置监听器，每次节点失败都可以监听到，可以作额外处理
        clientBuilder.setFailureListener(new RestClient.FailureListener() {
        });
        clientBuilder.setRequestConfigCallback(requestConfigBuilder -> {
            // 连接5秒超时，套接字连接60s超时
            return requestConfigBuilder.setConnectTimeout(90000).setSocketTimeout(90000);
        });
        clientBuilder.setHttpClientConfigCallback(httpAsyncClientBuilder -> httpAsyncClientBuilder.setDefaultIOReactorConfig(
                IOReactorConfig.custom().setIoThreadCount(6).build()
        ));

        restClient = new RestHighLevelClient(clientBuilder);
    }

    public static void main(String[] args) throws IOException {
        RestHighLevelClient restClient = new EsRestUtil().restClient;
        IndicesClient indices = restClient.indices();
        System.out.println(indices);
    }
}
