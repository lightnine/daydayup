package com.leon.httpClientDemo;

import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author leon
 * @since 2019/6/27 17:21
 * 采用HttpClient包进行POST请求
 */
public class PostDemo {
    public static void postWithoutParams() {
        // 如果网址是http://www.oschina.net 返回的状态码是301，即永久重定向到https://www.oschina.net/
        HttpPost httpPost = new HttpPost("https://www.oschina.net/");
        // 伪装浏览器请求
        httpPost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36");
        try (CloseableHttpClient httpClient = HttpClients.createDefault(); CloseableHttpResponse httpResponse = httpClient.execute(httpPost)){
            System.out.println(httpResponse);
            if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String content = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
                System.out.println(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 带参数的POST提交方式
     * Content-Type: application/x-www-form-urlencoded
     */
    public static void postWithParams() {
        HttpPost httpPost = new HttpPost("https://www.oschina.net/");
        // 伪装成浏览器，不然有些网址获取不到内容
        httpPost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36");
        // 准备post的参数
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("scope", "project"));
        params.add(new BasicNameValuePair("q", "java"));
        UrlEncodedFormEntity formEntity = null;
        try {
            formEntity = new UrlEncodedFormEntity(params, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return;
        }
        httpPost.setEntity(formEntity);
        try (CloseableHttpClient httpClient = HttpClients.createDefault(); CloseableHttpResponse httpResponse = httpClient.execute(httpPost)) {
            if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String content = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
                System.out.println("postWithParams 结果: " + content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void postWithParamJson() {
        String url = "https://www.iteblog.com";
        HttpPost httpPost = new HttpPost(url);
        // 如果访问Restful接口，可以不添加User-Agent
        httpPost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36");
        httpPost.setHeader("Content-Type", ContentType.APPLICATION_JSON.toString());
        // post params
        String content = "{'Author':'iteblog'}";
        StringEntity se = new StringEntity(content, "UTF-8");
        httpPost.setEntity(se);
        try (CloseableHttpClient httpClient = HttpClients.createDefault(); CloseableHttpResponse httpResponse = httpClient.execute(httpPost)) {
            System.out.println("postWithParamJson response: " + httpResponse.toString());
            if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String respContent = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
                System.out.println("postWithParamJson 结果: " + respContent);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
//        PostDemo.postWithoutParams();
//        PostDemo.postWithParams();
        PostDemo.postWithParamJson();
    }
}
