package com.mxc.web.vo.rsp;

import lombok.Data;
import java.util.Date;
import java.io.Serializable;

/**
 * @author robot
 */
@Data
public class WorldQueryRsp implements Serializable {


    /**
     * 主键id
     */
    private Integer id;
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
     * 展示状态：0，不展示;1，展示
     */
    private Integer showStatus;
    /**
     * 系统标示：0，非系统应用;1，系统应用
     */
    private Integer systemFlag;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
}
