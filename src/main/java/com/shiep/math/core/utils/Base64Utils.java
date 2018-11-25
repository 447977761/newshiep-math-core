package com.shiep.math.core.utils;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.util.Assert;
import sun.misc.BASE64Decoder;

import java.io.*;

/**
 * @program: shiep-math-core
 * @description:
 * @author: Mr.Wang
 * @create: 2018-10-02 21:19
 **/
public class Base64Utils {

    /**
     * 将图片转换成Base64编码
     * @param imgFile 待处理图片
     * @return
     */
     public static String getImgStr(String imgFile){
     //将图片文件转化为字节数组字符串，并对其进行Base64编码处理
    InputStream in = null;
    byte[] data = null;
    //读取图片字节数组
    try{
        in = new FileInputStream(imgFile);
        data = new byte[in.available()];
        in.read(data);
        in.close();
    }catch (IOException e){
         e.printStackTrace();
    }

     Assert.notNull(Base64.encodeBase64(data),"Base64.encodeBase64(data) is null");
     return new String(Base64.encodeBase64(data));

    }

    /**
     * 将Base64位编码的图片进行解码，并保存到指定目录
     *
     * @param base64
     *            base64编码的图片信息
     * @return
     */ public static void decodeBase64ToImage(String base64, String path, String imgName) {
         BASE64Decoder decoder = new BASE64Decoder();
         try {
             FileOutputStream write = new FileOutputStream(new File(path + imgName));
             byte[] decoderBytes = decoder.decodeBuffer(base64);
             write.write(decoderBytes);
             write.close();
         } catch (IOException e) {
             e.printStackTrace();
         }
     }
}
