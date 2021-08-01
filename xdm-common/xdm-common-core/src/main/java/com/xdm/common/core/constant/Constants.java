package com.xdm.common.core.constant;

/**
 * 通用常量信息
 *
 * @author xdm
 */
public class Constants {
    /**
     * UTF-8 字符集
     */
    public static final String UTF8 = "UTF-8";

    /**
     * GBK 字符集
     */
    public static final String GBK = "GBK";

    /**
     * http请求
     */
    public static final String HTTP = "http://";

    /**
     * https请求
     */
    public static final String HTTPS = "https://";

    /**
     * 成功标记
     */
    public static final Integer SUCCESS = 200;

    /**
     * 失败标记
     */
    public static final Integer FAIL = 500;

    /**
     * 登录成功
     */
    public static final String LOGIN_SUCCESS = "Success";

    /**
     * 注销
     */
    public static final String LOGOUT = "Logout";

    /**
     * 注册
     */
    public static final String REGISTER = "Register";

    /**
     * 登录失败
     */
    public static final String LOGIN_FAIL = "Error";

    /**
     * 当前记录起始索引
     */
    public static final String PAGE_NUM = "pageNum";

    /**
     * 每页显示记录数
     */
    public static final String PAGE_SIZE = "pageSize";

    /**
     * 排序列
     */
    public static final String ORDER_BY_COLUMN = "orderByColumn";

    /**
     * 排序的方向 "desc" 或者 "asc".
     */
    public static final String IS_ASC = "isAsc";

    /**
     * 验证码 redis key
     */
    public static final String CAPTCHA_CODE_KEY = "captcha_codes:";

    /**
     * 验证码有效期（分钟）
     */
    public static final long CAPTCHA_EXPIRATION = 2;

    /**
     * 令牌有效期（分钟）
     */
    public final static long TOKEN_EXPIRE = 720;

    /**
     * 参数管理 cache key
     */
    public static final String SYS_CONFIG_KEY = "sys_config:";

    /**
     * 字典管理 cache key
     */
    public static final String SYS_DICT_KEY = "sys_dict:";

    /**
     * 资源映射路径 前缀
     */
    public static final String RESOURCE_PREFIX = "/profile";

    public static final String JSK_URL = "http://yfzx.whty.com.cn/prod-api/outter2/";

    public static final String JSK_TRACE_ID = "13JSK3C0-DJD2-4SKC5F-C1AA7-Y0BBBB15G";

    public static final String JSK_PRIVATE_KEY = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAI27Q4X1bqiESnkNIb2ppjG/ckfGBGRh03Y1rLFGbKK2onJHtu3w0b3uKBj3HTwj+j9RMaU0Ne3msVKrmKpaj6xbdhwK4qM+uEPyVhbrjOhi1GZpW5YztmmtvyQi7J9PHHA+LEbGsREZYjKeWhljtRoMRKql6W2++RmDIgjx8G1tAgMBAAECgYBs7T839SjW2tVhs3X7DidslHaAMu+tNoIOl7HhjP5xD2xJ6FPvCuYn0qF+jm0pi30IrJ47GaVY8bPWlYr/YhqIdm2fxcJuKIxuC/wMv3/L69Fb431XkI9Adw7UBAVfVi0XoBPahDvedYeieaV7ez3vp0em4tZARwui5U7UThSNAQJBANMM4JaKYV1kUIgbZ0bgKmb0xpuVpH9C/jh4G/CtKQkE0Uhl+a7aO7Egwu1Vm9GgWKjH4j3VMpuD29pcNIWIj+sCQQCr6uiSGONULm2ZLoZaxWfjAMOkVWudzxBYkxe21ePBT/zmlymDuGfcMGZAbZz1AF6jSaQVeJDddgDoRqzqu/oHAkEApftcrkiKpn58b27N3In0DyC3Cim4Q3YWpaagorosqbEmPwAkTAXKKFYRt8I6V7T5xVPedK61rGUZhTQ7AkISnQJAMQkm3w0UQl2fyzJ3BgsKb7g3FXd74549FlaWTANEHE55Xzg8kiKWFTsE31mkjElXtRF7KNij0VcoORh3l9iYHwJAK98VYOjq4xEnMY5ZP1cK/QtvriY+InwycTmmm+zQLIkWfcuzUt5KEXxITeMzWgHI/Brzj77349Uon/yVUWepIA==";

    public static final String JSK_QUERY_CARD_DETAIL = "queryCardDetail";

}
