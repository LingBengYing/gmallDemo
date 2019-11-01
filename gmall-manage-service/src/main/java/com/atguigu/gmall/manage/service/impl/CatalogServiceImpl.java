package com.atguigu.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.bean.PmsBaseCatalog1;
import com.atguigu.gmall.bean.PmsBaseCatalog2;
import com.atguigu.gmall.bean.PmsBaseCatalog3;
import com.atguigu.gmall.manage.mapper.PmsBaseCatalog1Mapper;
import com.atguigu.gmall.manage.mapper.PmsBaseCatalog2Mapper;
import com.atguigu.gmall.manage.mapper.PmsBaseCatalog3Mapper;
import com.atguigu.gmall.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
/**
 * @Description: 后台管理商品分类实现
 * @Author: lin
 * @Date: 2019/10/22 0022
 */
@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    PmsBaseCatalog1Mapper pmsBaseCatalog1Mapper;

    @Autowired
    PmsBaseCatalog2Mapper pmsBaseCatalog2Mapper;

    @Autowired
    PmsBaseCatalog3Mapper pmsBaseCatalog3Mapper;

    /**
    * @Description: 获取一级分类
    * @Param:
    * @return:  List<PmsBaseCatalog1>
    * @Author: lin
    * @Date: 2019/10/22 0022
    */
    @Override
    public List<PmsBaseCatalog1> getCatalog1() {
        return pmsBaseCatalog1Mapper.selectAll();
    }

    /**
    * @Description: 获取二级分类通过一级分类ID
    * @Param:  catalog1Id
    * @return: List<PmsBaseCatalog2>
     * @Author: lin
    * @Date: 2019/10/22 0022
    */
    @Override
    public List<PmsBaseCatalog2> getCatalog2(String catalog1Id) {
        PmsBaseCatalog2 pmsBaseCatalog2=new PmsBaseCatalog2();
        pmsBaseCatalog2.setCatalog1Id(catalog1Id);
        List<PmsBaseCatalog2> pmsBaseCatalog2s=pmsBaseCatalog2Mapper.select(pmsBaseCatalog2);
        return pmsBaseCatalog2s;
    }

    /**
    * @Description: 获取三级分类列表通过二级分类ID
    * @Param:  catalog2Id
    * @return:  List<PmsBaseCatalog3>
    * @Author: lin
    * @Date: 2019/10/22 0022
    */
    @Override
    public List<PmsBaseCatalog3> getCatalog3(String catalog2Id) {
        PmsBaseCatalog3 pmsBaseCatalog3=new PmsBaseCatalog3();
        pmsBaseCatalog3.setCatalog2Id(catalog2Id);
        List<PmsBaseCatalog3> pmsBaseCatalog3s=pmsBaseCatalog3Mapper.select(pmsBaseCatalog3);
        return pmsBaseCatalog3s;
    }
}
