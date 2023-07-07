package com.cnood.admin.entity.system;

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
 * 
 * </p>
 *
 * @author Leah
 * @since 2023-07-03
 */
@Getter
@Setter
@TableName("sys_menu")
public class SysMenu implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private Long parentId;
    private String title;
    private String icon;
    private String name;
    private String path;

    /**
     * 排序
     */
    private Byte sort;
    private String url;
    private String component;
    private String redirect;

    /**
     * 菜单权限
     */
    private String permission;

    /**
     * 是否隐藏当前菜单
     */
    private Boolean hideInMenu;

    /**
     * 是否存在面包屑
     */
    private Boolean hideInBreadcrumb;

    /**
     * 是否需要显示所有的子菜单
     */
    private Boolean hideChildrenInMenu;

    /**
     * 是否保活,1；保活，0：不包活
     */
    private Boolean keepAlive;

    /**
     * 全连接跳转模式，1：blank，2：self，3：parent
     */
    private Byte target;

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
