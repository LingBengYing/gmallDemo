/**
 * FileName: PmsUploadUtil
 * Author:   lin
 * Date:     2019/10/25 0025 下午 1:27
 * Description: 上传工具类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.atguigu.gmall.manage.Util;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 〈一句话功能简述〉<br> 
 * 〈上传工具类〉
 *
 * @author Administrator
 * @create 2019/10/25 0025
 * @since 1.0.0
 */
public class PmsUploadUtil {

    /**
    * @Description: 上传图片
    * @Param:  MultipartFile multipartFile
    * @return:  String（图片地址）
    * @Author: lin
    * @Date: 2019/10/25 0025
    */
    public static String uploadImage(MultipartFile multipartFile) {
            String imgUrl =  "http://47.94.216.50";

            // 上传图片到服务器
            // 配置fdfs的全局链接地址
            String tracker = PmsUploadUtil.class.getResource("/tracker.conf").getPath();// 获得配置文件的路径

            try {
                ClientGlobal.init(tracker);
            } catch (Exception e) {
                e.printStackTrace();
            }

            TrackerClient trackerClient = new TrackerClient();

            // 获得一个trackerServer的实例
            TrackerServer trackerServer = null;
            try {
                trackerServer = trackerClient.getConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // 通过tracker获得一个Storage链接客户端
            StorageClient storageClient = new StorageClient(trackerServer,null);

            try {

                byte[] bytes = multipartFile.getBytes();// 获得上传的二进制对象

                // 获得文件后缀名
                String originalFilename = multipartFile.getOriginalFilename();// a.jpg
                System.out.println(originalFilename);
                int i = originalFilename.lastIndexOf(".");
                String extName = originalFilename.substring(i+1);

                String[] uploadInfos = storageClient.upload_file(bytes, extName, null);

                for (String uploadInfo : uploadInfos) {
                    imgUrl += "/"+uploadInfo;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return imgUrl;
        }
}
