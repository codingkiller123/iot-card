package com.xdm.system.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.xdm.common.core.constant.ServiceNameConstants;
import com.xdm.common.core.domain.R;
import com.xdm.system.api.factory.RemoteUserFallbackFactory;
import com.xdm.system.api.model.LoginUser;

/**
 * 用户服务
 *
 * @author xdm
 */
@FeignClient(contextId = "remoteUserService", value = ServiceNameConstants.SYSTEM_SERVICE, fallbackFactory = RemoteUserFallbackFactory.class)
public interface RemoteUserService {
    /**
     * 通过用户名查询用户信息
     *
     * @param username 用户名
     * @return 结果
     */
    @GetMapping(value = "/user/info/{username}")
    public R<LoginUser> getUserInfo(@PathVariable("username") String username);
}
