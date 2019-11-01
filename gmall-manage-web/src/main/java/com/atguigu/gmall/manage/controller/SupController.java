/**
 * FileName: SupContoller
 * Author:   lin
 * Date:     2019/10/23 0023 下午 9:16
 * Description: SPU
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.atguigu.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.PmsBaseSaleAttr;
import com.atguigu.gmall.bean.PmsProductImage;
import com.atguigu.gmall.bean.PmsProductInfo;
import com.atguigu.gmall.bean.PmsProductSaleAttr;
import com.atguigu.gmall.manage.Util.PmsUploadUtil;
import com.atguigu.gmall.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈SPU控制器〉
 *
 * @author Administrator
 * @create 2019/10/23 0023
 * @since 1.0.0
 */
@CrossOrigin
@Controller
public class SupController {

    @Reference
    SpuService spuService;

    /**
    * @Description: 图片文件上传
    * @Param:  MultipartFile multipartFile
    * @return:  String
    * @Author: lin
    * @Date: 2019/10/26 0026
    */
    @RequestMapping("fileUpload")
    @ResponseBody
    public String fileUpload(@RequestParam("file") MultipartFile multipartFile){
        // 将图片或者音视频上传到分布式的文件存储系统

        // 将图片的存储路径返回给页面
        String imgUrl = PmsUploadUtil.uploadImage(multipartFile);

        return imgUrl;
    }

    /**
    * @Description: 保存sup信息
    * @Param:   PmsProductInfo pmsProductInfo
    * @return:  String
     * @Author: lin
    * @Date: 2019/10/26 0026
    */
    @RequestMapping("saveSpuInfo")
    @ResponseBody
    public String saveSpuInfo(@RequestBody PmsProductInfo pmsProductInfo){

        String success=spuService.saveSpuIfo(pmsProductInfo);
        return success;
    }


    /**
    * @Description: 获取spu列表通过catalog3Id
    * @Param:  String catalog3Id
    * @return:  List<PmsProductInfo>
    * @Author: lin
    * @Date: 2019/10/24 0024
    */
    @RequestMapping("spuList")
    @ResponseBody
    public List<PmsProductInfo> spuList (String catalog3Id){
        
        List<PmsProductInfo> pmsProductInfos = spuService.spuList(catalog3Id);
        return pmsProductInfos;
    }

    /**
     * @Description: 获取sup售卖列表通过spuId
     * @Param:  String catalog3Id
     * @return:  List<PmsProductInfo>
     * @Author: lin
     * @Date: 2019/10/24 0024
     */
    @RequestMapping("spuSaleAttrList")
    @ResponseBody
    public List<PmsProductSaleAttr> spuSaleAttrList (String spuId){

        List<PmsProductSaleAttr>  pmsProductSaleAttr = spuService.spuSaleAttrList(spuId);
        return pmsProductSaleAttr;
    }


    /**
     * @Description: 获取sup售卖图片列表通过spuId
     * @Param:  String catalog3Id
     * @return:  List<PmsProductInfo>
     * @Author: lin
     * @Date: 2019/10/24 0024
     */
    @RequestMapping("spuImageList")
    @ResponseBody
    public List<PmsProductImage> spuImageList (String spuId){

        List<PmsProductImage>  pmsProductImages = spuService.spuImageList(spuId);
        return pmsProductImages;
    }
}
