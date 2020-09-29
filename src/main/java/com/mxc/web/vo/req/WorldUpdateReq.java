package com.mxc.web.vo.req;

import lombok.Data;

/**
 * @author robot
 */
@Data
public class WorldUpdateReq {


    /**
     * 应用名
     */
    private String appName;
    /**
     * 应用名（中文）
     */
    private String appNameCn;
    /**
     * 应用名描述
     */
    private String appDesc;
    /**
     * group
     */
    private String group;
    /**
     * artifact
     */
    private String artifact;
    /**
     * 更新人名字
     */
    private String updateUserName;
}
