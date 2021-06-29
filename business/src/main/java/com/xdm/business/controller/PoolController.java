package com.xdm.business.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xdm.business.domain.Card;
import com.xdm.business.domain.Pool;
import com.xdm.common.core.utils.DateUtils;
import com.xdm.common.core.utils.HttpClientUtils;
import com.xdm.common.core.utils.SecurityUtils;
import com.xdm.common.core.utils.SignUtil;
import com.xdm.common.core.web.controller.BaseController;
import com.xdm.common.core.web.domain.AjaxResult;
import com.xdm.common.core.web.page.PageDomain;
import com.xdm.common.core.web.page.TableDataInfo;
import com.xdm.common.core.web.page.TableSupport;
import com.xdm.common.log.annotation.Log;
import com.xdm.common.log.enums.BusinessType;
import com.xdm.common.security.annotation.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 流量池处理
 *
 * @author xdm
 */
@RestController
@RequestMapping("/pool")
public class PoolController extends BaseController {

    private final String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAI27Q4X1bqiESnkNIb2ppjG/ckfGBGRh03Y1rLFGbKK2onJHtu3w0b3uKBj3HTwj+j9RMaU0Ne3msVKrmKpaj6xbdhwK4qM+uEPyVhbrjOhi1GZpW5YztmmtvyQi7J9PHHA+LEbGsREZYjKeWhljtRoMRKql6W2++RmDIgjx8G1tAgMBAAECgYBs7T839SjW2tVhs3X7DidslHaAMu+tNoIOl7HhjP5xD2xJ6FPvCuYn0qF+jm0pi30IrJ47GaVY8bPWlYr/YhqIdm2fxcJuKIxuC/wMv3/L69Fb431XkI9Adw7UBAVfVi0XoBPahDvedYeieaV7ez3vp0em4tZARwui5U7UThSNAQJBANMM4JaKYV1kUIgbZ0bgKmb0xpuVpH9C/jh4G/CtKQkE0Uhl+a7aO7Egwu1Vm9GgWKjH4j3VMpuD29pcNIWIj+sCQQCr6uiSGONULm2ZLoZaxWfjAMOkVWudzxBYkxe21ePBT/zmlymDuGfcMGZAbZz1AF6jSaQVeJDddgDoRqzqu/oHAkEApftcrkiKpn58b27N3In0DyC3Cim4Q3YWpaagorosqbEmPwAkTAXKKFYRt8I6V7T5xVPedK61rGUZhTQ7AkISnQJAMQkm3w0UQl2fyzJ3BgsKb7g3FXd74549FlaWTANEHE55Xzg8kiKWFTsE31mkjElXtRF7KNij0VcoORh3l9iYHwJAK98VYOjq4xEnMY5ZP1cK/QtvriY+InwycTmmm+zQLIkWfcuzUt5KEXxITeMzWgHI/Brzj77349Uon/yVUWepIA==";
    private final Map headerMap = new HashMap() {{
        put ("Content-type", "application/json");
    }};
    private final String tradeId = "13JSK3C0-DJD2-4SKC5F-C1AA7-Y0BBBB15G";

    /**
     * 获取流量卡列表
     */
    @PreAuthorize(hasPermi = "commanage:iotcard:list")
    @GetMapping("/list")
    public TableDataInfo list(Pool pool) {
        //startPage();
        PageDomain pageDomain = TableSupport.buildPageRequest();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();

        String requestURL = "http://yfzx.whty.com.cn/prod-api/outter2/queryPoolInfo";

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("traderId", tradeId);
        paramMap.put("method", "queryPoolInfo");
        paramMap.put("timestamp", DateUtils.dateTimeNow());
        paramMap.put("poolId", pool.getId());
        paramMap.put("pageNum", pageNum);
        paramMap.put("pageSize", pageSize);
        paramMap.put("version", "2.0");
        // 加签
        String sign = SignUtil.signByRSA(paramMap, privateKey);
        paramMap.put("sign", sign);

        Map result = new HashMap<>();
        result = HttpClientUtils.post(requestURL, headerMap, paramMap);

        JSONObject jsonResult = JSONObject.parseObject(JSONObject.toJSONString(result));
        if (jsonResult.getInteger("code") != 200) {
            System.out.println("获取错误，结束了");
            return getDataTable(null);
        }
        JSONObject dataJson = jsonResult.getJSONObject("data");
        if (dataJson.getInteger("code") != 200) {
            System.out.println("没有数据，结束了：" + dataJson.getInteger("msg"));
            return getDataTable(null);
        }
        JSONArray rowsJson = dataJson.getJSONArray("rows");
        Long totalNum = dataJson.getLong("total");
        System.out.println("此次获取到：" + rowsJson.size() + "条数据，数据总量："+ dataJson.getInteger("total"));
        List<Card> rowsList = JSONArray.parseArray(rowsJson.toJSONString(), Card.class);

        return getHttpDataTable(rowsList, totalNum);
    }


}
