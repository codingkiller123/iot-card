package com.xdm.business.util;

import com.xdm.common.core.constant.Constants;
import com.xdm.common.core.utils.DateUtils;
import com.xdm.common.core.utils.HttpClientUtils;
import com.xdm.common.core.utils.SignUtil;

import java.util.HashMap;
import java.util.Map;

public class JskHttpUtils {

    private final static Map headerMap = new HashMap() {{
        put ("Content-type", "application/json");
    }};

    public static Map<String,Object> invoke(String url,Map<String, Object> paramMap,String methodName){
        Map result = new HashMap<>();
        paramMap.put("traderId", Constants.JSK_TRACE_ID);
        paramMap.put("method", methodName);
        paramMap.put("timestamp", DateUtils.dateTimeNow());
        // 加签
        String sign = SignUtil.signByRSA(paramMap, Constants.JSK_PRIVATE_KEY);
        paramMap.put("sign", sign);
        result = HttpClientUtils.post(url, headerMap, paramMap);
        return result;
    }

}
