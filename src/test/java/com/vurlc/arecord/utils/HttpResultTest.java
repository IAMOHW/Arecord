package com.vurlc.arecord.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class HttpResultTest {

    @Test
    void main() {
        //1.生成httpclent,相当于打开浏览器
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse httpResponse = null;

        //2.创建Get请求，相当于输入地址.
        HttpGet httpGet = new HttpGet("https://www.amazon.cn/");

        httpGet.setHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36");
        try{
            //3.执行get请求，相当于在输入地址栏后敲回车键
            httpResponse = httpClient.execute(httpGet);
            //4.判断响应状态为200，进行处理
            if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                //5.获取相应内容
                HttpEntity httpEntity = httpResponse.getEntity();
                String html = EntityUtils.toString(httpResponse.getEntity(),"utf-8");
                Document document = Jsoup.parse(html);
                System.out.println(document.getElementsByTag("title").first());

            }else {
                System.out.println("Return is not 200");
                System.out.println(EntityUtils.toString(httpResponse.getEntity(),"utf-8"));
            }

        } catch (IOException e){
            e.printStackTrace();
        } finally {
            //6.关闭
            HttpClientUtils.closeQuietly(httpResponse);
            HttpClientUtils.closeQuietly(httpClient);
        }
    }
}