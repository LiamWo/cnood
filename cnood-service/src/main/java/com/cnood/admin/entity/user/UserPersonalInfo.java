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
 * 用户信息
 * </p>
 *
 * @author Leah
 * @since 2023-07-03
 */
@Getter
@Setter
@TableName("user_personal_info")
public class UserPersonalInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 国籍
     */
    private Byte nationality;

    /**
     * 性别
     */
    private Boolean gender;

    /**
     * 证件类型
     */
    private Byte identityType;

    /**
     * 证件号
     */
    private String identityNum;

    /**
     * 证件正
     */
    private String identityCardFrontal;

    /**
     * 证件背
     */
    private String identityCardBack;

    /**
     * 出生日期
     */
    private Date dataOfBirth;

    /**
     * 民族
     */
    private String nation;

    /**
     * 血型
     */
    private Byte bloodType;

    /**
     * 政治面貌
     */
    private Byte politicalLandscape;

    /**
     * 居住地址
     */
    private String residentialAddress;

    /**
     * 婚姻状况
     */
    private Boolean maritalStatus;

    /**
     * 小孩
     */
    private Boolean child;

    /**
     * 联系人
     */
    private String linkman;

    /**
     * 联系人电话
     */
    private String linkmanTel;

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
