package com.cnood.admin.entity.user;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 工资信息
 * </p>
 *
 * @author Leah
 * @since 2023-07-03
 */
@Getter
@Setter
@TableName("user_salary")
public class UserSalary implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 薪酬帐套
     */
    private Byte salaryType;

    /**
     * 基本工资
     */
    private BigDecimal baseSalary;

    /**
     * 销售提成
     */
    private BigDecimal commission;

    /**
     * 奖金
     */
    private BigDecimal bonus;

    /**
     * 目标达成奖励
     */
    private BigDecimal target;

    /**
     * 补贴
     */
    private BigDecimal allowance;

    /**
     * 加班
     */
    private BigDecimal overtimePay;

    /**
     * 销售竞赛奖励
     */
    private Long salesContestRewards;

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
