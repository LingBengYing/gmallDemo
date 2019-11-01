package com.atguigu.gmall.user.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.UmsMember;
import com.atguigu.gmall.bean.UmsMemberReceiveAddress;
import com.atguigu.gmall.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description: 用户web接口
 * @Author: lin
 * @Date: 2019/10/22 0022
 */

@Controller
public class UserController {

    @Reference
    UserService userService;

    /**
    * @Description: 获取收货地址通过用户ID
    * @Param:  memberId
    * @return:  List<UmsMemberReceiveAddress>
     * @Author: lin
    * @Date: 2019/10/22 0022
    */
    @RequestMapping("getReceiveAddressByMemberId")
    @ResponseBody
    public List<UmsMemberReceiveAddress> getReceiveAddressByMemberId( String memberId){
        List< UmsMemberReceiveAddress> umsMemberReceiveAddresses=userService.etReceiveAddressByMemberId(memberId);
        return umsMemberReceiveAddresses;
    }

    /**
    * @Description: 获取所有用户
    * @Param:
    * @return:  List<UmsMember>
    * @Author: lin
    * @Date: 2019/10/22 0022
    */

    @RequestMapping("getAllUser")
    @ResponseBody
    public List<UmsMember> getAllUser(){
        List<UmsMember> umsMembers=userService.getAllUser();
        return umsMembers;
    }

    @RequestMapping("index")
    @ResponseBody
    public String index(){
        return "hello user";
    }
}
