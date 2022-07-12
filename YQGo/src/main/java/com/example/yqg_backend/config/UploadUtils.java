package com.example.yqg_backend.config;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class UploadUtils {

    //实际图片存储路径，个人需要根据后端文件夹所在地址进行更改
    private static final String BASE_PATH = "C:\\Users\\YUXU\\Desktop\\YQG_backend\\YQGo\\src\\main\\resources\\static\\image\\";
    //映射访问路径
    //在浏览器上可以看到图片，ip和端口号需要自行设置
    private static final String ACCESS_PATH = "http://localhost:8080/image/";

    /**
     * 图片上传
     * @param file
     * @return 访问图片的网址
     */
    public static String upload(MultipartFile file){
        //图片原始名称
        String fileName = file.getOriginalFilename();
        //生成新名字(用UUID生成一个特有的文件名防止重名文件覆盖)
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        String newFileName = UUID.randomUUID()+suffixName;

        File dest = new File(BASE_PATH+newFileName);
        if(!dest.getParentFile().exists()){
            dest.getParentFile().mkdir();
        }
        try {
            file.transferTo(dest);
        }catch (IOException e){
            e.printStackTrace();
        }
        String fileUrl = ACCESS_PATH + newFileName;
        return fileUrl;
    }

    /**
     * 图片删除
     * @param url
     * @return 是否删除成功
     */
    public boolean delete(String url){
        String fileName = url.substring(url.lastIndexOf('/'));
        String route = BASE_PATH + fileName;

        File file = new File(route);
        if(file.exists()){
            if(file.delete()) return true;
            else return false;
        }
        else return false;
    }
}
