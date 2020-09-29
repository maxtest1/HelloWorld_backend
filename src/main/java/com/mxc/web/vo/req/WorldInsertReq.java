package com.mxc.web.vo.req;

import lombok.Data;

/**
 * @author robot
 */
@Data
public class WorldInsertReq {


    /**
     * 主键id
     */
    private Integer id;
    /**
     * 应用名（中文）
     */
    private String appNameCn;
    /**
     * 应用名描述
     */
    private String appDesc;
    /**
     * 创建人名字
     */
    private String createUserName;
}
