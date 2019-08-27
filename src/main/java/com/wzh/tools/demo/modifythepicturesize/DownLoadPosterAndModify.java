package com.wzh.tools.demo.modifythepicturesize;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class DownLoadPosterAndModify {
    //海报地址
    static String posterUrl = "/vcimg/M00/02/E6/wKgBb1ovdFOAMtE5AAU7wfAoCeo327.jpg";
    //文件名字
    static String fileName = "测试";
    static String hipiaoFileName = "哈票影片图片3";


    public static void main(String[] args) throws IOException {
        //图片网络地址
        String imageUrl = "http://newimg.vcfilm.cn" + posterUrl;
//		String imageUrl = "http://ww2.sinaimg.cn/large/71dcf4c8gw1ez1si79zvaj22up230ak4.jpg";
        //加载地址
        URL url = new URL(imageUrl);
        //打开网络输入流
        DataInputStream dis = new DataInputStream(url.openStream());
        //图片存储本地地址
        String posterPicture = "D:\\我的图片\\" + hipiaoFileName + "\\" + fileName + "\\1.jpg";
        //建立一个新的文件
        FileOutputStream fos = new FileOutputStream(new File(posterPicture));
        byte[] buffer = new byte[1024];
        int length;
        //开始填充数据
        while ((length = dis.read(buffer)) > 0) {
            fos.write(buffer, 0, length);
        }
        dis.close();
        fos.close();


        File file = new File(posterPicture);
        Image src;
        src = ImageIO.read(file);

        int wideth1 = 531;
        int height1 = 760;
        BufferedImage tag1 = new BufferedImage(wideth1, height1, BufferedImage.TYPE_INT_RGB);
        tag1.getGraphics().drawImage(src, 0, 0, wideth1, height1, null);

        int wideth2 = 171;
        int height2 = 245;
        BufferedImage tag2 = new BufferedImage(wideth2, height2, BufferedImage.TYPE_INT_RGB);
        tag2.getGraphics().drawImage(src, 0, 0, wideth2, height2, null);

        int wideth3 = 156;
        int height3 = 216;
        BufferedImage tag3 = new BufferedImage(wideth3, height3, BufferedImage.TYPE_INT_RGB);
        tag3.getGraphics().drawImage(src, 0, 0, wideth3, height3, null);


        //修改三种图片的本地地址
        String da = "D:\\我的图片\\" + hipiaoFileName + "\\" + fileName + "\\da.jpg";
        String zhong = "D:\\我的图片\\" + hipiaoFileName + "\\" + fileName + "\\zhong.jpg";
        String xiao = "D:\\我的图片\\" + hipiaoFileName + "\\" + fileName + "\\xiao.jpg";

        String formatName1 = da.substring(da.lastIndexOf(".") + 1);
        ImageIO.write(tag1, /*"GIF"*/ formatName1 /* format desired */, new File(da) /* target */);

        String formatName2 = zhong.substring(zhong.lastIndexOf(".") + 1);
        ImageIO.write(tag2, /*"GIF"*/ formatName2 /* format desired */, new File(zhong) /* target */);

        String formatName3 = xiao.substring(xiao.lastIndexOf(".") + 1);
        ImageIO.write(tag3, /*"GIF"*/ formatName3 /* format desired */, new File(xiao) /* target */);

    }
}
