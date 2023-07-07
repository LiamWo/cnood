package com.cnood.admin.entity.system;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author Leah
 * @since 2023-07-04
 */
@Getter
@Setter
@TableName("sys_icon")
public class SysIcon implements Serializable {

    private static final long serialVersionUID = 1L;
    private String icon;
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
}
