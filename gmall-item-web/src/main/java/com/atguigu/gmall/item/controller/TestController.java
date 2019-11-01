/**
 * FileName: TestController
 * Author:   lin
 * Date:     2019/10/28 0028 下午 4:20
 * Description: 测试控制器
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.atguigu.gmall.item.controller;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈测试控制器〉
 *
 * @author Administrator
 * @create 2019/10/28 0028
 * @since 1.0.0
 */
@Controller
public class TestController {

    @RequestMapping("test")
    public  String getIndex(@RequestBody HashMap<String,String> map){
        System.out.println(map.get("ok"));
        return "index";
    }
}
