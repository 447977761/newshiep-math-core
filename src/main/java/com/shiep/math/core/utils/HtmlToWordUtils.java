package com.shiep.math.core.utils;

import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.DocumentEntry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @program: shiep-math-core
 * @description:
 * @author: Mr.Wang
 * @create: 2018-10-27 14:14
 **/
public class HtmlToWordUtils {
    public static boolean writeWordFile(String content) {
        boolean w = false;
        String path = "d:/";
        try {
            if (!"".equals(path)) {
                // 检查目录是否存在
                File fileDir = new File(path);
                if (fileDir.exists()) {
                    // 生成临时文件名称
                    String fileName = "test.doc";
                    byte b[] = content.getBytes();
                    ByteArrayInputStream bais = new ByteArrayInputStream(b);
                    POIFSFileSystem poifs = new POIFSFileSystem();
                    DirectoryEntry directory = poifs.getRoot();
                    DocumentEntry documentEntry = directory.createDocument("WordDocument", bais);
                    FileOutputStream ostream = new FileOutputStream(path+ fileName);
                    poifs.writeFilesystem(ostream);
                    bais.close();
                    ostream.close();
                    w = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return w;
    }
}
