package com.mxc.web.vo.req;

import lombok.Data;

/**
 * @author robot
 */
@Data
public class WorldQueryReq {


    /**
     * 应用名（中文）
     */
    private String appNameCn;
    /**
     * group
     */
    private String group;
    /**
     * artifact
     */
    private String artifact;
}
