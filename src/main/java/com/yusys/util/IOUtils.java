package com.yusys.util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.Blob;

public class IOUtils {

    /**
     * 把文件转换成字节数组形式
     * @param file
     * @return
     */
    public static byte[] turnFileIntoBytes(File file) {
        byte[] bytes = new byte[(int) file.length()];
        InputStream is = null;
        try {
            is = new FileInputStream(file);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] flush = new byte[2048];  // 缓冲区
            int len;
            len = is.read(flush);
            while (len != -1) {
                baos.write(flush, 0, len);
                len = is.read(flush);
            }
            bytes = baos.toByteArray();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bytes;
    }

    /**
     * 把字节数组转化为图片
     * @param bytes
     * @param filePath  文件存储路径
     * @return
     */
    public static void turnBytesToFile(byte[] bytes,String filePath){
        ByteArrayInputStream bais = null;
        File file = null;
        try {
            bais = new ByteArrayInputStream(bytes);
            BufferedImage image = ImageIO.read(bais);
            file = new File(filePath);
            ImageIO.write(image,"jpg",file);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bais.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 把Blob对象数据转化为字节数组
     * @param blob
     * @return
     */
    public static byte[] blobToBytes(Blob blob) {
        BufferedInputStream bufferedInputStream = null;
        try {
            //利用Blob自带的一个函数去将blob转换成InputStream
            bufferedInputStream = new BufferedInputStream(blob.getBinaryStream());
            //申请一个字节流，长度和blob相同
            byte[] bytes = new byte[(int) blob.length()];
            int len = bytes.length;
            int offset = 0;
            int read = 0;
            while (offset < len//确保不会读过头
                    && (read = bufferedInputStream.read(bytes, offset, len - offset)) >= 0) {
                //BufferedInputStream内部有一个缓冲区，默认大小为8M，每次调用read方法的时候，它首先尝试从缓冲区里读取数据，
                //若读取失败（缓冲区无可读数据），则选择从物理数据源（譬如文件）读取新数据（这里会尝试尽可能读取多的字节）放入到缓冲区中，
                //最后再将缓冲区中的内容部分或全部返回给用户
                //也就是说read函数一次性可能读不完，所以可能会分多次读，于是就有了上面的逻辑
                offset += read;
            }
            return bytes;
        } catch (Exception e) {
            return null;
        } finally {
            try {
                bufferedInputStream.close();
            } catch (IOException e) {

                return null;
            }
        }
    }



}
