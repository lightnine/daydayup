package com.leon.httpClientDemo;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author leon
 * @since 2019/6/27 16:42
 * 采用httpClient包进行Get请求演示代码
 */
public class GetDemo {
    /**
     * 采用httpClient进行GET 请求，此请求不带参数
     */
    public static void getWithoutParams() {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://www.baidu.com");
        CloseableHttpResponse httpResponse = null;
        try {
            httpResponse = httpClient.execute(httpGet);
            if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String content = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
                System.out.println("结果: " + content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            httpClientUtil.closeIgnoringIOException(httpResponse);
            httpClientUtil.closeIgnoringIOException(httpClient);
        }
    }

    /**
     * 相比较于{@link com.leon.httpClientDemo.GetDemo#getWithoutParams}
     * 采用了try-with-resources方式，只要资源继承了{@link AutoCloseable}接口，不必显示关闭资源
     * JVM会自动帮助关闭资源
     */
    public static void getWithoutParamsSimple() {
        HttpGet httpGet = new HttpGet("http://www.baidu.com");
        try (CloseableHttpClient httpClient = HttpClients.createDefault(); CloseableHttpResponse httpResponse = httpClient.execute(httpGet)) {
            if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String content = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
                System.out.println("结果: " + content);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 带参数的Get 请求
     * 有两种方式
     *  1.直接将参数拼接到url后面 如：?wd=java
     *  2.使用URI的方法设置参数 setParameter("wd", "java")
     * 有可以使用try-with-resources方式简化代码
     */
    public static void getWithParams() {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        URI uri = null;
        try {
            uri = new URIBuilder("http://www.baidu.com").setParameter("wd", "java").build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        HttpGet httpGet = new HttpGet(uri);
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                System.out.println("getWithParams 结果: " + content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            httpClientUtil.closeIgnoringIOException(response);
            httpClientUtil.closeIgnoringIOException(httpClient);
        }
    }
    public static void main(String[] args) {
        GetDemo.getWithoutParams();
        GetDemo.getWithoutParamsSimple();
        GetDemo.getWithParams();
    }
}
