package com.wzh.tools.demo.modifythepicturesize;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;


public class DownLoadStillsAndModify {
    //剧照 地址
    static String stillsUrl1 = "/vcimg/M00/02/E6/wKgBb1ovdGKAKXgrAAE96lTivk0672.jpg";
    static String stillsUrl2 = "/vcimg/M00/02/E6/wKgBb1ovdGKAOnAnAAG4n7qqLIo368.jpg";
    static String stillsUrl3 = "/vcimg/M00/02/E6/wKgBb1ovdGKAD6fnAAGNpwtjEm4982.jpg";
    static String stillsUrl4 = "/vcimg/M00/02/E6/wKgBb1ovdGKAf6xFAAHOReLbNro919.jpg";
    //文件名字
    static String fileName = "妖铃铃";
    static String hipiaoFileName = "哈票影片图片3";


    public static void main(String[] args) throws IOException {

        if ('v' == stillsUrl1.charAt(1)) {
            String imageUrl1 = "http://newimg.vcfilm.cn" + stillsUrl1;
            String imageUrl2 = "http://newimg.vcfilm.cn" + stillsUrl2;
            String imageUrl3 = "http://newimg.vcfilm.cn" + stillsUrl3;
            String imageUrl4 = "http://newimg.vcfilm.cn" + stillsUrl4;
            modify(imageUrl1, imageUrl2, imageUrl3, imageUrl4);
        } else if ('W' == stillsUrl1.charAt(0)) {
            String imageUrl1 = "http://img.vcfilm.cn:8080/resource/" + stillsUrl1;
            String imageUrl2 = "http://img.vcfilm.cn:8080/resource/" + stillsUrl2;
            String imageUrl3 = "http://img.vcfilm.cn:8080/resource/" + stillsUrl3;
            String imageUrl4 = "http://img.vcfilm.cn:8080/resource/" + stillsUrl4;
            modify(imageUrl1, imageUrl2, imageUrl3, imageUrl4);
        } else {

        }

    }


    private static void modify(String imageUrl1, String imageUrl2, String imageUrl3, String imageUrl4)
            throws IOException {
        //加载地址
        URL url1 = new URL(imageUrl1);
        URL url2 = new URL(imageUrl2);
        URL url3 = new URL(imageUrl3);
        URL url4 = new URL(imageUrl4);
        //打开网络输入流
        DataInputStream dis1 = new DataInputStream(url1.openStream());
        DataInputStream dis2 = new DataInputStream(url2.openStream());
        DataInputStream dis3 = new DataInputStream(url3.openStream());
        DataInputStream dis4 = new DataInputStream(url4.openStream());
        //图片存储本地地址
        String posterPicture1 = "D:\\我的图片\\" + hipiaoFileName + "\\" + fileName + "\\2.jpg";
        String posterPicture2 = "D:\\我的图片\\" + hipiaoFileName + "\\" + fileName + "\\3.jpg";
        String posterPicture3 = "D:\\我的图片\\" + hipiaoFileName + "\\" + fileName + "\\4.jpg";
        String posterPicture4 = "D:\\我的图片\\" + hipiaoFileName + "\\" + fileName + "\\5.jpg";
        //建立一个新的文件
        FileOutputStream fos1 = new FileOutputStream(new File(posterPicture1));
        FileOutputStream fos2 = new FileOutputStream(new File(posterPicture2));
        FileOutputStream fos3 = new FileOutputStream(new File(posterPicture3));
        FileOutputStream fos4 = new FileOutputStream(new File(posterPicture4));

        byte[] buffer = new byte[1024];
        int length;

        //开始填充数据
        while ((length = dis1.read(buffer)) > 0) {
            fos1.write(buffer, 0, length);
        }
        dis1.close();
        fos1.close();

        while ((length = dis2.read(buffer)) > 0) {
            fos2.write(buffer, 0, length);
        }
        dis2.close();
        fos2.close();

        while ((length = dis3.read(buffer)) > 0) {
            fos3.write(buffer, 0, length);
        }
        dis3.close();
        fos3.close();

        while ((length = dis4.read(buffer)) > 0) {
            fos4.write(buffer, 0, length);
        }
        dis4.close();
        fos4.close();


        Image src1;
        Image src2;
        Image src3;
        Image src4;

        File file1 = new File(posterPicture1);
        File file2 = new File(posterPicture2);
        File file3 = new File(posterPicture3);
        File file4 = new File(posterPicture4);

        src1 = ImageIO.read(file1);
        src2 = ImageIO.read(file2);
        src3 = ImageIO.read(file3);
        src4 = ImageIO.read(file4);
        //定义图片宽和高 px
        int wideth = 600;
        int height = 400;

        BufferedImage tag1 = new BufferedImage(wideth, height, BufferedImage.TYPE_INT_RGB);
        tag1.getGraphics().drawImage(src1, 0, 0, wideth, height, null);

        BufferedImage tag2 = new BufferedImage(wideth, height, BufferedImage.TYPE_INT_RGB);
        tag2.getGraphics().drawImage(src2, 0, 0, wideth, height, null);

        BufferedImage tag3 = new BufferedImage(wideth, height, BufferedImage.TYPE_INT_RGB);
        tag3.getGraphics().drawImage(src3, 0, 0, wideth, height, null);

        BufferedImage tag4 = new BufferedImage(wideth, height, BufferedImage.TYPE_INT_RGB);
        tag4.getGraphics().drawImage(src4, 0, 0, wideth, height, null);


        String formatName1 = posterPicture1.substring(posterPicture1.lastIndexOf(".") + 1);
        ImageIO.write(tag1, /*"GIF"*/ formatName1 /* format desired */, new File(posterPicture1) /* target */);

        String formatName2 = posterPicture2.substring(posterPicture2.lastIndexOf(".") + 1);
        ImageIO.write(tag2, /*"GIF"*/ formatName2 /* format desired */, new File(posterPicture2) /* target */);

        String formatName3 = posterPicture1.substring(posterPicture3.lastIndexOf(".") + 1);
        ImageIO.write(tag3, /*"GIF"*/ formatName3 /* format desired */, new File(posterPicture3) /* target */);

        String formatName4 = posterPicture1.substring(posterPicture4.lastIndexOf(".") + 1);
        ImageIO.write(tag4, /*"GIF"*/ formatName4 /* format desired */, new File(posterPicture4) /* target */);
    }


}
