package com.xdm.common.core.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpClientUtils {

    public static Map<String, Object> post(String url, Map<String, String> headerMap, Map<String, Object> paramMap) {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        Map<String, Object> resultMap = new HashMap<>();
        HttpPost httpPost = new HttpPost(url);
        for (Map.Entry<String, String> m : headerMap.entrySet()) {
            httpPost.setHeader(m.getKey(), m.getValue());
        }
        /*for (Map.Entry<String, Object> m : paramMap.entrySet()) {
            HttpEntity entity = new StringEntity(m.getKey(), m.getValue().toString());
            httpPost.setEntity(entity);
        }*/

        httpPost.setEntity(new StringEntity(JSONObject.toJSONString(paramMap), "UTF-8"));

        CloseableHttpResponse response = null;
        try {
            //请求超时
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(6000).setConnectTimeout(6000).build();
            httpPost.setConfig(requestConfig);
            // 由客户端执行(发送)Post请求
            response = httpClient.execute(httpPost);
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();
            if (responseEntity != null) {
                String resultStr = EntityUtils.toString(responseEntity);
                resultMap = JSON.parseObject(resultStr, Map.class);
                // resultMap = JsonUtils.toObject(resultStr, Map.class);
            }
            int statusCode = response.getStatusLine().getStatusCode();
            resultMap.put("code", statusCode);
            return resultMap;
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 释放资源
                if (httpClient != null) {
                    httpClient.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resultMap;
    }

    public static Map<String, Object> get(String url, Map<String, String> headerMap) {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        Map<String, Object> resultMap = new HashMap<>();
        HttpGet httpGet = new HttpGet(url);
        for (Map.Entry<String, String> m : headerMap.entrySet()) {
            httpGet.setHeader(m.getKey(), m.getValue());
        }
        CloseableHttpResponse response = null;
        try {
            //请求超时
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(6000).setConnectTimeout(6000).build();
            httpGet.setConfig(requestConfig);
            // 由客户端执行(发送)Post请求
            response = httpClient.execute(httpGet);
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();
            if (responseEntity != null) {
                String resultStr = EntityUtils.toString(responseEntity);
                resultMap = JSON.parseObject(resultStr, Map.class);
                // resultMap = JsonUtils.toObject(resultStr, Map.class);
            }
            int statusCode = response.getStatusLine().getStatusCode();
            resultMap.put("code", statusCode);
            return resultMap;
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 释放资源
                if (httpClient != null) {
                    httpClient.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resultMap;
    }


    public static Map<String, Object> postURL(String url, List<NameValuePair> params) {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        Map<String, Object> resultMap = new HashMap<>();
        HttpPost httpPost = new HttpPost(url);
        /*for (Map.Entry<String,String> m : headerMap.entrySet()) {
            httpPost.setHeader(m.getKey(),m.getValue());
        }*/

        /*for (Map.Entry<String,Object> m : paramMap.entrySet()) {
            HttpEntity entity = new StringEntity(m.getKey(),m.getValue().toString());
            httpPost.setEntity(entity);
        }*/
        CloseableHttpResponse response = null;
        try {
            if (null != params) {
                httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
            }
            httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
            //请求超时
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(6000).setConnectTimeout(6000).build();
            httpPost.setConfig(requestConfig);
            // 由客户端执行(发送)Post请求
            response = httpClient.execute(httpPost);
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();
            if (responseEntity != null) {
                String resultStr = EntityUtils.toString(responseEntity);
                resultMap = JSON.parseObject(resultStr, Map.class);
                // resultMap = JsonUtils.toObject(resultStr, Map.class);
            }
            int statusCode = response.getStatusLine().getStatusCode();
            resultMap.put("code", statusCode);
            return resultMap;
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 释放资源
                if (httpClient != null) {
                    httpClient.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resultMap;
    }

    public static void main(String[] args) {
        Map<String, String> headerMap = new HashMap<>();
        Map<String, Object> paramMap = new HashMap<>();
        headerMap.put("Content-Type", "x-www-form-urlencoded;charset=utf8");
        // headerMap.put("Authorization","Bearer 97ef9f01-c0ab-4afa-9d26-948a23c99a142");
        Map<String, Object> post = post("https://paytest.cosmoplat.com/api/paymentBill/paymentBill", headerMap, paramMap);
        System.out.println(post);
    }


}
