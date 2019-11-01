/**
 * FileName: SkuController
 * Author:   lin
 * Date:     2019/10/27 0027 下午 3:58
 * Description: Sku控制器
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.atguigu.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.PmsSkuInfo;
import com.atguigu.gmall.service.SkuService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 〈一句话功能简述〉<br> 
 * 〈Sku控制器〉
 *
 * @author Administrator
 * @create 2019/10/27 0027
 * @since 1.0.0
 */
@CrossOrigin
@Controller
public class SkuController {

    @Reference
    SkuService skuService;


    /**
    * @Description: 存储Sku信息
    * @Param:  PmsSkuInfo pmsSkuInfo
    * @return:  String
    * @Author: lin
    * @Date: 2019/10/28 0028
    */
    @RequestMapping("saveSkuInfo")
    @ResponseBody
    public  String saveSkuInfo(@RequestBody PmsSkuInfo pmsSkuInfo){

        // 将spuId封装给productId
        pmsSkuInfo.setProductId(pmsSkuInfo.getSpuId());

        // 处理默认图片
        String skuDefaultImg = pmsSkuInfo.getSkuDefaultImg();
        if(StringUtils.isBlank(skuDefaultImg)){
            pmsSkuInfo.setSkuDefaultImg(pmsSkuInfo.getSkuImageList().get(0).getImgUrl());
        }

      /*  //将spuid转换为ProductId
        pmsSkuInfo.setProductId(pmsSkuInfo.getSpuId());
        //处理默认图片
        String skuDefaultImg = pmsSkuInfo.getSkuDefaultImg();
        if(StringUtils.isBlank(skuDefaultImg)){
            pmsSkuInfo.setSkuDefaultImg(pmsSkuInfo.getSkuImageList().get(0).getImgUrl());
        }*/
        //存储Sku信息
        String success = skuService.saveSkuInfo(pmsSkuInfo);
        return success;
    }
}
