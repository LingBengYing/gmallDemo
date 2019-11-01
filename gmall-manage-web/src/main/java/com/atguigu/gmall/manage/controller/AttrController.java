/**
 * FileName: AttrController
 * Author:   lin
 * Date:     2019/10/22 0022 下午 2:36
 * Description: 商品平台属性
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.atguigu.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.PmsBaseAttrInfo;
import com.atguigu.gmall.bean.PmsBaseAttrValue;
import com.atguigu.gmall.bean.PmsBaseSaleAttr;
import com.atguigu.gmall.service.AttrService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈商品平台属性〉
 *
 * @author Administrator
 * @create 2019/10/22 0022
 * @since 1.0.0
 */
@CrossOrigin
@Controller
public class AttrController {

    @Reference
    AttrService attrService;

    /**
     * @Description: 获取基本属性列表
     * @Param:
     * @return:  List<PmsProductInfo>
     * @Author: lin
     * @Date: 2019/10/24 0024
     */
    @RequestMapping("baseSaleAttrList")
    @ResponseBody
    public List<PmsBaseSaleAttr> baseSaleAttrList (){

        List<PmsBaseSaleAttr> pmsBaseSaleAttrs = attrService.baseSaleAttrList();
        return pmsBaseSaleAttrs;
    }
    /**
    * @Description: 存储\修改属性
    * @Param:  PmsBaseAttrInfo pmsBaseAttrInfo
    * @return:   String
     * @Author: lin
    * @Date: 2019/10/23 0023
    */
    @RequestMapping("saveAttrInfo")
    @ResponseBody
    public String saveAttrInfo(@RequestBody  PmsBaseAttrInfo pmsBaseAttrInfo){
        String succes = attrService.saveAttrInfo(pmsBaseAttrInfo);
        return succes;
    }


    /**
    * @Description: 获取列表属性值列表通过三级分类ID
    * @Param:  catalog3Id
    * @return:  List<PmsBaseAttrInfo>
     * @Author: lin
    * @Date: 2019/10/23 0023
    */
    @RequestMapping("attrInfoList")
    @ResponseBody
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id){
        List<PmsBaseAttrInfo>  pmsBaseAttrInfos = attrService.attrInfoList(catalog3Id);
        return pmsBaseAttrInfos;
    }

    /**
    * @Description: 获取平台属性值通过平台属性id
    * @Param:  String attrId
    * @return:  List<PmsBaseAttrValue>
     * @Author: lin
    * @Date: 2019/10/23 0023
    */
    @RequestMapping("getAttrValueList")
    @ResponseBody
    public  List<PmsBaseAttrValue> getAttrValueList(String attrId){
        List<PmsBaseAttrValue> pmsBaseAttrValues = attrService.getAttrValueList(attrId);
        return pmsBaseAttrValues;
    }
}
