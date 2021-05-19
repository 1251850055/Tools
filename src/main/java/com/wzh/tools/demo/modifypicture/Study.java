//package com.wzh.tools.demo.modifypicture;
//
//import com.sun.image.codec.jpeg.JPEGCodec;
//import com.sun.image.codec.jpeg.JPEGImageEncoder;
//
//import java.awt.*;
//import java.awt.image.BufferedImage;
//import java.io.DataInputStream;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.net.URL;
//
//public class Study {
//
//    public static void main(String[] args) throws IOException {
////		Study.downLoad();
////		Study.modifyPoster();
////		Study.modifyStills();
//    }
//
//    //下载图片
//    public static void downLoad() throws IOException {
//        String imageUrl = "http://newimg.vcfilm.cn/vcimg/M00/01/C8/wKgBb1oC4r2ACcvwAAP8XnsDXWg410.jpg";
//        URL url = new URL(imageUrl);
//        //打开网络输入流
//        DataInputStream dis = new DataInputStream(url.openStream());
//        String posterPicture = "D:\\我的图片\\哈票影片图片2\\测试\\1.jpg";
//        //建立一个新的文件
//        FileOutputStream fos = new FileOutputStream(new File(posterPicture));
//        byte[] buffer = new byte[1024];
//        int length;
//        //开始填充数据
//        while ((length = dis.read(buffer)) > 0) {
//            fos.write(buffer, 0, length);
//        }
//        dis.close();
//        fos.close();
//    }
//
//
//    public static void modifyPoster() throws IOException {
//        File file = new File("D:\\我的图片\\哈票影片图片2\\测试\\1.jpg");
//        Image src;
//        src = javax.imageio.ImageIO.read(file);
//
//        int wideth1 = 531;
//        int height1 = 760;
//        BufferedImage tag1 = new BufferedImage(wideth1, height1, BufferedImage.TYPE_INT_RGB);
//        tag1.getGraphics().drawImage(src, 0, 0, wideth1, height1, null);
//
//        int wideth2 = 171;
//        int height2 = 245;
//        BufferedImage tag2 = new BufferedImage(wideth2, height2, BufferedImage.TYPE_INT_RGB);
//        tag2.getGraphics().drawImage(src, 0, 0, wideth2, height2, null);
//
//        int wideth3 = 156;
//        int height3 = 216;
//        BufferedImage tag3 = new BufferedImage(wideth3, height3, BufferedImage.TYPE_INT_RGB);
//        tag3.getGraphics().drawImage(src, 0, 0, wideth3, height3, null);
//
//        FileOutputStream out1 = new FileOutputStream("D:\\我的图片\\哈票影片图片2\\测试\\da.jpg");
//        JPEGImageEncoder encoder1 = JPEGCodec.createJPEGEncoder(out1);
//        encoder1.encode(tag1);
//
//        FileOutputStream out2 = new FileOutputStream("D:\\我的图片\\哈票影片图片2\\测试\\zhong.jpg");
//        JPEGImageEncoder encoder2 = JPEGCodec.createJPEGEncoder(out2);
//        encoder2.encode(tag2);
//
//        FileOutputStream out3 = new FileOutputStream("D:\\我的图片\\哈票影片图片2\\测试\\xiao.jpg");
//        JPEGImageEncoder encoder3 = JPEGCodec.createJPEGEncoder(out3);
//        encoder3.encode(tag3);
//
//        out1.close();
//        out2.close();
//        out3.close();
//    }
//
//
//    //修改剧照
//    public static void modifyStills() throws IOException {
//        File file1 = new File("D:\\我的图片\\哈票影片图片2\\测试\\2.jpg");
//        Image src1;
//        src1 = javax.imageio.ImageIO.read(file1);
//
//        File file2 = new File("D:\\我的图片\\哈票影片图片2\\测试\\3.jpg");
//        Image src2;
//        src2 = javax.imageio.ImageIO.read(file2);
//
//        File file3 = new File("D:\\我的图片\\哈票影片图片2\\测试\\4.jpg");
//        Image src3;
//        src3 = javax.imageio.ImageIO.read(file3);
//
//        File file4 = new File("D:\\我的图片\\哈票影片图片2\\测试\\5.jpg");
//        Image src4;
//        src4 = javax.imageio.ImageIO.read(file4);
//
//
//        int wideth = 600;
//        int height = 400;
//
//
//        BufferedImage tag1 = new BufferedImage(wideth, height, BufferedImage.TYPE_INT_RGB);
//        tag1.getGraphics().drawImage(src1, 0, 0, wideth, height, null);
//
//        BufferedImage tag2 = new BufferedImage(wideth, height, BufferedImage.TYPE_INT_RGB);
//        tag2.getGraphics().drawImage(src2, 0, 0, wideth, height, null);
//
//        BufferedImage tag3 = new BufferedImage(wideth, height, BufferedImage.TYPE_INT_RGB);
//        tag3.getGraphics().drawImage(src3, 0, 0, wideth, height, null);
//
//        BufferedImage tag4 = new BufferedImage(wideth, height, BufferedImage.TYPE_INT_RGB);
//        tag4.getGraphics().drawImage(src4, 0, 0, wideth, height, null);
//
//
//        FileOutputStream out1 = new FileOutputStream(file1);
//        JPEGImageEncoder encoder1 = JPEGCodec.createJPEGEncoder(out1);
//        encoder1.encode(tag1);
//
//        FileOutputStream out2 = new FileOutputStream(file2);
//        JPEGImageEncoder encoder2 = JPEGCodec.createJPEGEncoder(out2);
//        encoder2.encode(tag2);
//
//        FileOutputStream out3 = new FileOutputStream(file3);
//        JPEGImageEncoder encoder3 = JPEGCodec.createJPEGEncoder(out3);
//        encoder3.encode(tag3);
//
//        FileOutputStream out4 = new FileOutputStream(file4);
//        JPEGImageEncoder encoder4 = JPEGCodec.createJPEGEncoder(out4);
//        encoder4.encode(tag4);
//
//        out1.close();
//        out2.close();
//        out3.close();
//        out4.close();
//    }
//
//
//}
//
//
//
//
//
//
//
//
//
//
