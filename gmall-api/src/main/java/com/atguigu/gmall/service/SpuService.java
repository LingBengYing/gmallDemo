/**
 * FileName: SpuService
 * Author:   lin
 * Date:     2019/10/23 0023 下午 9:31
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.atguigu.gmall.service;

import com.atguigu.gmall.bean.PmsProductImage;
import com.atguigu.gmall.bean.PmsProductInfo;
import com.atguigu.gmall.bean.PmsProductSaleAttr;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈Spu接口〉
 *
 * @author Administrator
 * @create 2019/10/23 0023
 * @since 1.0.0
 */
public interface SpuService {

    List<PmsProductInfo> spuList(String catalog3Id);

    String saveSpuIfo(PmsProductInfo pmsProductInfo);

    List<PmsProductSaleAttr> spuSaleAttrList(String spuId);

    List<PmsProductImage> spuImageList(String spuId);

    List<PmsProductSaleAttr> spuSaleAttrListCheckBySku(String productId,String skuId);
}
