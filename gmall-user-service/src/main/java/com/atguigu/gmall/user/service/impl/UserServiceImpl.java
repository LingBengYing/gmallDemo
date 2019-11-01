package com.atguigu.gmall.user.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.bean.UmsMember;
import com.atguigu.gmall.bean.UmsMemberReceiveAddress;
import com.atguigu.gmall.service.UserService;
import com.atguigu.gmall.user.mapper.UmsMemberReceiveAddressMapper;
import com.atguigu.gmall.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
/**
 * @Description: 用户接口实现
 * @Author: lin
 * @Date: 2019/10/22 0022
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    UmsMemberReceiveAddressMapper umsMemberReceiveAddressMapper;
    /**
    * @Description: 获取用户列表
    * @Param:
    * @return:  List<UmsMember>
     * @Author: lin
    * @Date: 2019/10/22 0022
    */
    @Override
    public List<UmsMember> getAllUser() {
        List<UmsMember> umsMembersList=userMapper.selectAll();
        return umsMembersList;
    }
    /**
     * @Description: 通过用户ID获取用户收货地址
     * @Param: memberId
     * @return:  List<UmsMemberReceiveAddress>
     * @Author: lin
     * @Date: 2019/10/22 0022
     */

    @Override
    public List<UmsMemberReceiveAddress> etReceiveAddressByMemberId(String memberId) {
      /*  //外键查询方式
        Example e =new Example(UmsMemberReceiveAddress.class);
        e.createCriteria().andEqualTo("memberId", memberId);
        umsMemberReceiveAddressMapper.deleteByExample(e);
       //外键查询方式
        UmsMemberReceiveAddress umsMemberReceiveAddress=new UmsMemberReceiveAddress();
        umsMemberReceiveAddress.setMemberId(memberId);
        List<UmsMemberReceiveAddress> umsMemberReceiveAddresses = umsMemberReceiveAddressMapper.selectByExample(umsMemberReceiveAddress);*/
        UmsMemberReceiveAddress umsMemberReceiveAddress=new UmsMemberReceiveAddress();
        umsMemberReceiveAddress.setMemberId(memberId);
        List<UmsMemberReceiveAddress> umsMemberReceiveAddresses = umsMemberReceiveAddressMapper.select(umsMemberReceiveAddress);
        return umsMemberReceiveAddresses;
    }
}
