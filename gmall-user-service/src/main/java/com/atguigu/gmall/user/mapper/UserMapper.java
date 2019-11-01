package com.atguigu.gmall.user.mapper;

import com.atguigu.gmall.bean.UmsMember;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
/**
 * @Description: 用户映射
 * @Author: lin
 * @Date: 2019/10/22 0022
 */

public interface UserMapper extends Mapper<UmsMember> {
    List<UmsMember> selectAllUser();
}
