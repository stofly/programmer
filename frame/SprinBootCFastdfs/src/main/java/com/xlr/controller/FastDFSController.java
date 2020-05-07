package com.xlr.controller;

/**
 * @author user
 */
/**
 * @author lr
 * @date 2019年1月28日 下午1:50:47
 * @version V1.0.0
 */

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.xlr.client.FastDFSClient;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/operationFastDfs")
public class FastDFSController {

    @Autowired
    private FastDFSClient fdfsClient;

    /**
     * 文件上传
     * @param file
     * @return
     * @throws Exception
     */
    @RequestMapping("/uploadFile")
    public Map<String,Object> uploadFile(MultipartFile file) throws Exception{

        String url = fdfsClient.uploadFile(file);

        Map<String,Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("msg", "上传成功");
        result.put("url", url);
        return result;
    }

    /**
     * 文件下载
     * @param fileUrl  url 开头从组名开始
     * @param response
     * @throws Exception
     */
    @RequestMapping("/downFile")
    public void  downFile(String fileUrl,String fileName,HttpServletResponse response) throws Exception{
        byte[] data = fdfsClient.download(fileUrl);
        response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(fileName+"zip", "UTF-8"));
        response.setCharacterEncoding("UTF-8");
        ServletOutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            outputStream.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.flush();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 文件删除
     * @param fileUrl
     * @throws Exception
     */
    @RequestMapping("/deleteFile")
    public void  deleteFile(String fileUrl) throws Exception{
        fdfsClient.deleteFile(fileUrl);
    }
}