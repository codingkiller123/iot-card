package com.xdm.business.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xdm.business.domain.Card;
import com.xdm.common.core.utils.HttpClientUtils;
import com.xdm.common.core.utils.SignUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ZhiXy
 * @since 2018-05-28 17:29
 */
public class Demo {
    /**
     * 3.1	验证商户唯一标识接口
     * 该请求由表单方式发起
     * 请求成功后会重定向到指定地址
     *
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        String url = "http://yfzx.whty.com.cn/prod-api/outter2/queryPoolInfo";

        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("Content-Type", "application/json");


        String pulicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCNu0OF9W6ohEp5DSG9qaYxv3JHxgRkYdN2NayxRmyitqJyR7bt8NG97igY9x08I/o/UTGlNDXt5rFSq5iqWo+sW3YcCuKjPrhD8lYW64zoYtRmaVuWM7Zprb8kIuyfTxxwPixGxrERGWIynloZY7UaDESqpeltvvkZgyII8fBtbQIDAQAB";
        String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAI27Q4X1bqiESnkNIb2ppjG/ckfGBGRh03Y1rLFGbKK2onJHtu3w0b3uKBj3HTwj+j9RMaU0Ne3msVKrmKpaj6xbdhwK4qM+uEPyVhbrjOhi1GZpW5YztmmtvyQi7J9PHHA+LEbGsREZYjKeWhljtRoMRKql6W2++RmDIgjx8G1tAgMBAAECgYBs7T839SjW2tVhs3X7DidslHaAMu+tNoIOl7HhjP5xD2xJ6FPvCuYn0qF+jm0pi30IrJ47GaVY8bPWlYr/YhqIdm2fxcJuKIxuC/wMv3/L69Fb431XkI9Adw7UBAVfVi0XoBPahDvedYeieaV7ez3vp0em4tZARwui5U7UThSNAQJBANMM4JaKYV1kUIgbZ0bgKmb0xpuVpH9C/jh4G/CtKQkE0Uhl+a7aO7Egwu1Vm9GgWKjH4j3VMpuD29pcNIWIj+sCQQCr6uiSGONULm2ZLoZaxWfjAMOkVWudzxBYkxe21ePBT/zmlymDuGfcMGZAbZz1AF6jSaQVeJDddgDoRqzqu/oHAkEApftcrkiKpn58b27N3In0DyC3Cim4Q3YWpaagorosqbEmPwAkTAXKKFYRt8I6V7T5xVPedK61rGUZhTQ7AkISnQJAMQkm3w0UQl2fyzJ3BgsKb7g3FXd74549FlaWTANEHE55Xzg8kiKWFTsE31mkjElXtRF7KNij0VcoORh3l9iYHwJAK98VYOjq4xEnMY5ZP1cK/QtvriY+InwycTmmm+zQLIkWfcuzUt5KEXxITeMzWgHI/Brzj77349Uon/yVUWepIA==";

        Map<String, Object> param = new HashMap<>();
        param.put("traderId", "13JSK3C0-DJD2-4SKC5F-C1AA7-Y0BBBB15G");
        param.put("method", "queryPoolInfo");
        param.put("timestamp", "20210621144355");
        param.put("poolId", 317);
        param.put("pageNum", 1);
        param.put("pageSize", 100);
        //param.put("msisdn","1440736992851");
        //param.put("backAddress","http://dxyy.ssinube.com/api/RecSms/recvupsms");
        //param.put("content","777788888");
        param.put("version", "2.0");
        // 加签
        String sign = SignUtil.signByRSA(param, privateKey);
        System.out.println(sign);
        // 验签
        System.out.println(SignUtil.verifyByRSA(param, sign, pulicKey));

        param.put("sign", sign);

        Map result = new HashMap<>();

        String paramJson = JSONObject.toJSONString(param);
        System.out.println(paramJson);

        result = HttpClientUtils.post(url, headerMap, param);
        System.out.println("\n\n");

        JSONObject jsonResult = JSONObject.parseObject(JSONObject.toJSONString(result));
        if (jsonResult.getInteger("code") != 200) {
            System.out.println("获取错误，结束了");
            return;
        }
        JSONObject dataJson = jsonResult.getJSONObject("data");
        if (dataJson.getInteger("code") != 200) {
            System.out.println("没有数据，结束了：" + dataJson.getInteger("msg"));
            return;
        }
        JSONArray rowsJson = dataJson.getJSONArray("rows");
        System.out.println("此次获取到：" + rowsJson.size() + "条数据，数据总量："+ dataJson.getInteger("total"));
        List<Card> rowsList = JSONArray.parseArray(rowsJson.toJSONString(), Card.class);
        System.out.println(rowsList);


    }

}
