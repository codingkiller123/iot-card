package com.xdm.common.core.utils;

import org.apache.commons.codec.binary.Base64;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * <p> </p>
 *
 * @author ZhiXy
 * @since 2017-11-15 16:10
 */
public class SignUtil {
    private static final String SIGN_ALGORITHMS = "SHA1WithRSA";
    private static final String CHARSET = "utf-8";

    public static String signByRSA(Map<String, Object> params, String privateKey) {
        try {
            String content = createLinkString(paramsFilter(params));
            //System.out.println("content=" + content);
            PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64.decodeBase64(privateKey));
            KeyFactory keyf = KeyFactory.getInstance("RSA");
            PrivateKey priKey = keyf.generatePrivate(priPKCS8);
            Signature signature = Signature
                    .getInstance(SIGN_ALGORITHMS);
            signature.initSign(priKey);
            signature.update(content.getBytes(CHARSET));
            byte[] signed = signature.sign();
            return Base64.encodeBase64String(signed);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean verifyByRSA(Map<String, Object> params, String sign, String publicKey) {
        try {
            String content = createLinkString(paramsFilter(params));
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            byte[] encodedKey = Base64.decodeBase64(publicKey);
            PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));
            Signature signature = Signature
                    .getInstance(SIGN_ALGORITHMS);
            signature.initVerify(pubKey);
            signature.update(content.getBytes(CHARSET));
            return signature.verify(Base64.decodeBase64(sign));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private static Map<String, String> paramsFilter(Map<String, Object> params) {
        Map<String, String> result = new HashMap<>();
        if (params == null || params.size() == 0) {
            return result;
        }

        for (Map.Entry<String, Object> entry : params.entrySet()) {
            if (entry.getValue() == null || "sign".equals(entry.getKey())) {
                continue;
            }
            result.put(entry.getKey(), String.valueOf(entry.getValue()));
        }
        return result;
    }

    private static String createLinkString(Map<String, String> params) {
        if (params == null) {
            return "";
        }
        ArrayList<String> keys = new ArrayList(params.keySet());
        Collections.sort(keys);
        StringBuffer sb = new StringBuffer();
        int keyLastNum = keys.size() - 1;
        for (int i = 0; i < keys.size(); ++i) {
            String key = keys.get(i);
            String value = String.valueOf(params.get(key));
            sb.append(key).append("=").append(value);
            if (i != keyLastNum) {
                sb.append("&");
            }
        }
        return sb.toString();
    }

}
