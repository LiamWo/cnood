package com.cnood.admin.service.system;

import com.cnood.admin.entity.system.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author Leah
 * @since 2023-07-03
 */
public interface SysUserService extends IService<SysUser> {

    List<String> getPermissions(Long loginId);

    List<String> getRoles(Long loginId);
}
