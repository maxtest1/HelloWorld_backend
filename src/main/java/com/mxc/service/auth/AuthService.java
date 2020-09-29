package com.mxc.service.auth;

import com.alibaba.fastjson.JSON;
import com.isyscore.common.exception.BusinessException;
import com.isyscore.os.dev.api.permission.model.builder.QueryUserAclRequestBuilder;
import com.isyscore.os.dev.api.permission.model.domain.*;
import com.isyscore.os.dev.api.permission.model.result.QueryUserAclResult;
import com.isyscore.os.dev.api.permission.service.PermissionService;
import com.isyscore.os.dev.util.IsyscoreHashMap;
import com.isyscore.os.sso.session.RequestUserHolder;
import com.isyscore.os.sso.session.UserForm;
import com.mxc.constant.AppConstant;
import com.mxc.web.vo.rsp.UserAuthRsp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户权限给前端的处理
 *
 * @author robot
 */
@Slf4j
@Service
public class AuthService {

    private static final String SID_STR = "X-Isyscore-Permission-Sid";
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private List<MenuAuthHandler> menuAuthHandlerList;

    /**
    * 获取前端菜单和资源的权限配置
    * <p>
    * 由于操作系统的权限部分暂时不支持菜单权限方面的配置，因此这里需要用户自己进行配置下
    */
    public List<MenuDomain> getAuthConfigOfMenu() {
    List<MenuDomain> authList = new ArrayList<>();
        MenuDomain auth = new MenuDomain();
        auth.setAppCode(AppConstant.APP_CODE);
        auth.setAppName(AppConstant.APP_NAME);

        doAddAuth(auth);

        authList.add(auth);
        return authList;
    }

    public UserAuthRsp getAuthOfUser() {
        UserForm currentUser = RequestUserHolder.getCurrentUser();
        if (null == currentUser) {
            return new UserAuthRsp();
        }
        IsyscoreHashMap coreMap = new IsyscoreHashMap();
        coreMap.put(SID_STR, currentUser.getToken());

        QueryUserAclRequestBuilder builder = new QueryUserAclRequestBuilder().setAppCode("HelloWorld-08c666").setHeaders(coreMap);
        QueryUserAclResult result = permissionService.queryUserAcl(builder);
        if (result.isSuccess()) {
            DataAuthAclDomain dataAuthAclDomain = JSON.parseObject(result.getResponse().getBody(), DataAuthAclDomain.class);
            if (null != dataAuthAclDomain) {
                UserAuthRsp rsp = new UserAuthRsp();
                rsp.setAuthCodeList(getCodeList(dataAuthAclDomain));
                return rsp;
            } else {
                log.error("数据解析异常：" + JSON.toJSONString(result.getResponse()));
                throw new BusinessException("数据解析异常");
            }
        } else {
            log.error("获取用户权限异常：" + result.getResponse());
            throw new BusinessException("获取数据异常");
        }
    }

    /**
    * 获取对应的code集合
    */
    private List<String> getCodeList(DataAuthAclDomain dataAuthAclDomain) {
        List<String> menuCodeList = new ArrayList<>();
            if (null == dataAuthAclDomain) {
            return menuCodeList;
        }

        menuCodeList.addAll(doGetCodeList(dataAuthAclDomain.getAclsList()));
        return menuCodeList;
    }

    private List<String> doGetCodeList(List<AclModuleLevelDomain> aclList) {
        if (CollectionUtils.isEmpty(aclList)) {
        return Collections.emptyList();
    }

    return aclList.stream().filter(AclModuleLevelDomain::getHasAcl).flatMap(e -> {
        List<String> dataList = new ArrayList<>();
            dataList.add(e.getCode());
            dataList.addAll(doGetCodeList(e.getAclModuleList()));
            dataList.addAll(e.getAclList().stream().filter(AclDomain::getHasAcl).map(AclDomain::getCode).collect(Collectors.toList()));
            return dataList.stream();
        }).collect(Collectors.toList());
    }

    private void doAddAuth(MenuDomain dataAuthAclDomain) {
        List<MenuAuthorityDomain> aclList = new ArrayList<>();

        if (!CollectionUtils.isEmpty(menuAuthHandlerList)) {
            menuAuthHandlerList.forEach(m -> {
                aclList.add(m.getMenuAuth());
            });
        }
        dataAuthAclDomain.setAcls(aclList);
    }
}
