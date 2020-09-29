package com.mxc.domain;

import java.sql.Timestamp;
import com.isyscore.isc.neo.annotation.Column;
import com.isyscore.isc.neo.annotation.Table;
import lombok.experimental.Accessors;
import lombok.Data;

/**
 * 应用表
 * @author robot
 */
@Data
@Table("hello_world")
@Accessors(chain = true)
public class WorldDO {


    /**
     * 主键id
     */
    @Column("id")
    private Integer id;

    /**
     * 应用名
     */
    @Column("app_name")
    private String appName;

    /**
     * 应用名（中文）
     */
    @Column("app_name_cn")
    private String appNameCn;

    /**
     * 应用名描述
     */
    @Column("app_desc")
    private String appDesc;

    /**
     * group
     */
    @Column("group")
    private String group;

    /**
     * artifact
     */
    @Column("artifact")
    private String artifact;

    /**
     * 展示状态：0，不展示;1，展示
     */
    @Column("show_status")
    private Integer showStatus;

    /**
     * 系统标示：0，非系统应用;1，系统应用
     */
    @Column("system_flag")
    private Integer systemFlag;

    /**
     * 创建时间
     */
    @Column("create_time")
    private Timestamp createTime;

    /**
     * 更新时间
     */
    @Column("update_time")
    private Timestamp updateTime;
}
