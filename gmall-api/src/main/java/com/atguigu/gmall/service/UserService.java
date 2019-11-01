package com.atguigu.gmall.service;





import com.atguigu.gmall.bean.UmsMember;
import com.atguigu.gmall.bean.UmsMemberReceiveAddress;

import java.util.List;

/**
 * @Description: 用户接口
 * @Author: lin
 * @Date: 2019/10/22 0022
 */
public interface UserService {

    List<UmsMember> getAllUser();

    List<UmsMemberReceiveAddress> etReceiveAddressByMemberId(String memberId);
}
