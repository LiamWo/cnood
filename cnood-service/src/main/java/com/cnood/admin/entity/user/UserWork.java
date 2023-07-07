package com.cnood.admin.entity.user;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 工作信息
 * </p>
 *
 * @author Leah
 * @since 2023-07-03
 */
@Getter
@Setter
@TableName("user_work")
public class UserWork implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String name;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 工号
     */
    private String jobNum;

    /**
     * 部门ID
     */
    private Long deptId;

    /**
     * 职位ID
     */
    private Long postId;

    /**
     * 工作地点
     */
    private String workAddress;

    /**
     * 工作类型
     */
    private Byte workType;

    /**
     * 入职时间
     */
    private Date dateOfEntry;

    /**
     * 工龄
     */
    private Integer seniority;

    /**
     * 工作状态
     */
    private Byte workStatus;

    /**
     * 合同
     */
    private Long contractId;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date createTime;

    /**
     * 更新人
     */
    private String updater;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;

    /**
     * 租户
     */
    private Long tenantId;
}