package com.xdm.business.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.nacos.shaded.org.checkerframework.checker.units.qual.C;
import com.xdm.business.domain.*;
import com.xdm.business.util.JskHttpUtils;
import com.xdm.common.core.constant.Constants;
import com.xdm.common.core.utils.DateUtils;
import com.xdm.common.core.utils.HttpClientUtils;
import com.xdm.common.core.utils.SignUtil;
import com.xdm.common.core.web.controller.BaseController;
import com.xdm.common.core.web.domain.AjaxResult;
import com.xdm.common.core.web.page.PageDomain;
import com.xdm.common.core.web.page.TableDataInfo;
import com.xdm.common.core.web.page.TableSupport;
import com.xdm.common.security.annotation.PreAuthorize;
import jdk.nashorn.internal.scripts.JS;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 流量池处理
 *
 * @author xdm
 */
@SuppressWarnings("all")
@RestController
@RequestMapping("/iotcard")
public class CardController extends BaseController {


    @PreAuthorize(hasPermi = "commanage:iotcard:detail")
    @GetMapping("/detail")
    public AjaxResult detail(String iccId){
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("iccid", iccId);
        paramMap.put("version", "2.0");
        paramMap.put("type", "0");
        Map result = new HashMap<>();
        result = JskHttpUtils.invoke(Constants.JSK_URL + Constants.JSK_QUERY_CARD_DETAIL, paramMap, Constants.JSK_QUERY_CARD_DETAIL);
        JSONObject jsonResult = JSONObject.parseObject(JSONObject.toJSONString(result));
        if (jsonResult.getInteger("code") != 200) {
            System.out.println("获取错误，结束了");
            return AjaxResult.error();
        }
        JSONObject dataJson = jsonResult.getJSONObject("data");
        CardInfo cardInfo = new CardInfo();
        if(dataJson != null){
            cardInfo = JSONObject.parseObject(dataJson.toJSONString(), CardInfo.class);
            if(cardInfo != null){
                String onlineStateInfoStr = cardInfo.getOnlineStateInfo();
                String stateChangeHistoryStr = cardInfo.getStateChangeHistory();
                String apnInfoStr = cardInfo.getApnInfo();
                String imeiInfo = cardInfo.getImeiInfo();
                if(onlineStateInfoStr != null){
                    JSONObject jsonOnlineStateInfo = JSONObject.parseObject(onlineStateInfoStr);
                    JSONArray arrayResult = jsonOnlineStateInfo.getJSONArray("result");
                    List<OnlineStateInfo> onlineStateInfos = JSONArray.parseArray(((JSONObject) arrayResult.get(0)).get("simSessionList").toString(), OnlineStateInfo.class);
                    cardInfo.setOnlineStateInfoList(onlineStateInfos);
                }
                if(stateChangeHistoryStr != null){
                    JSONObject jsonStateChange = JSONObject.parseObject(stateChangeHistoryStr);
                    JSONArray arrayResult = jsonStateChange.getJSONArray("result");
                    List<StateChangeHistory> StateChangeHistoryList = JSONObject.parseArray(((JSONObject) arrayResult.get(0)).get("changeHistoryList").toString(), StateChangeHistory.class);
                    cardInfo.setStateChangeHistoryList(StateChangeHistoryList);
                }
                if(apnInfoStr != null){
                    JSONObject jsonapnInfo = JSONObject.parseObject(apnInfoStr);
                    JSONArray arrayResult = jsonapnInfo.getJSONArray("result");
                    List<ApnList> ApnListInfo = JSONObject.parseArray(((JSONObject) arrayResult.get(0)).get("apnList").toString(), ApnList.class);
                    cardInfo.setApnListList(ApnListInfo);
                }
                if(imeiInfo != null){
                    JSONObject jsonimeiInfo = JSONObject.parseObject(imeiInfo);
                    JSONArray arrayResult = jsonimeiInfo.getJSONArray("result");
                    List<Imei> imeiList = JSONObject.parseArray(arrayResult.toJSONString(), Imei.class);
                    cardInfo.setImeiList(imeiList);
                }
            }
        }
        return AjaxResult.success(cardInfo);
    }

    public static void main(String[] args) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("traderId", "13JSK3C0-DJD2-4SKC5F-C1AA7-Y0BBBB15G");
        paramMap.put("method", "queryCardDetail");
        paramMap.put("timestamp", "20210725143828");
        paramMap.put("iccid", "898604A2192171150000");
        paramMap.put("version", "2.0");
        paramMap.put("type", "0");
        // 加签
        String sign = SignUtil.signByRSA(paramMap, "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAI27Q4X1bqiESnkNIb2ppjG/ckfGBGRh03Y1rLFGbKK2onJHtu3w0b3uKBj3HTwj+j9RMaU0Ne3msVKrmKpaj6xbdhwK4qM+uEPyVhbrjOhi1GZpW5YztmmtvyQi7J9PHHA+LEbGsREZYjKeWhljtRoMRKql6W2++RmDIgjx8G1tAgMBAAECgYBs7T839SjW2tVhs3X7DidslHaAMu+tNoIOl7HhjP5xD2xJ6FPvCuYn0qF+jm0pi30IrJ47GaVY8bPWlYr/YhqIdm2fxcJuKIxuC/wMv3/L69Fb431XkI9Adw7UBAVfVi0XoBPahDvedYeieaV7ez3vp0em4tZARwui5U7UThSNAQJBANMM4JaKYV1kUIgbZ0bgKmb0xpuVpH9C/jh4G/CtKQkE0Uhl+a7aO7Egwu1Vm9GgWKjH4j3VMpuD29pcNIWIj+sCQQCr6uiSGONULm2ZLoZaxWfjAMOkVWudzxBYkxe21ePBT/zmlymDuGfcMGZAbZz1AF6jSaQVeJDddgDoRqzqu/oHAkEApftcrkiKpn58b27N3In0DyC3Cim4Q3YWpaagorosqbEmPwAkTAXKKFYRt8I6V7T5xVPedK61rGUZhTQ7AkISnQJAMQkm3w0UQl2fyzJ3BgsKb7g3FXd74549FlaWTANEHE55Xzg8kiKWFTsE31mkjElXtRF7KNij0VcoORh3l9iYHwJAK98VYOjq4xEnMY5ZP1cK/QtvriY+InwycTmmm+zQLIkWfcuzUt5KEXxITeMzWgHI/Brzj77349Uon/yVUWepIA==");
        System.out.println(sign);
    }
}
