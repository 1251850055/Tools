package com.wzh.tools;


/**
 * @Description:
 * @Author: wangzehui
 * @Date: 2019/9/29 8:59
 */

public class Test {
    public static void main(String[] args) {
        long kaishi = System.currentTimeMillis();

        String str = "<style>body{line-height:200%;font-size:14px;font-family:\"Times New Roman\",\"Microsoft YaHei\"; }td{font-size:14px;line-height:200%;font-family:\"Times New Roman\",\"Microsoft YaHei\";}img{vertical-align:middle}</style>\n" +
                "<div>\n" +
                "<p style=\"margin:0cm;margin-bottom:.0001pt;text-align:justify;text-justify:inter-ideograph;font-size:10.5pt;font-family:'Calibri','sans-serif';line-height:200%;\"><span style=\"line-height:200%;font-family:'微软雅黑','sans-serif';\n" +
                "color:black;\">对水循环重要意义的叙述，正确的是</span><span style=\"line-height:200%;font-family:'微软雅黑','sans-serif';\n" +
                "color:black;\">（</span><span style=\"line-height:200%;font-family:'Times New Roman','serif';\n" +
                "color:black;\"><span>&nbsp;&nbsp;&nbsp; </span></span><span style=\"line-height:200%;font-family:'微软雅黑','sans-serif';color:black;\">）</span></p>\n" +
                "<p style=\"margin:0cm;margin-bottom:.0001pt;text-align:justify;text-justify:inter-ideograph;font-size:10.5pt;font-family:'Calibri','sans-serif';line-height:200%;\"><span style=\"line-height:200%;font-family:'Times New Roman','serif';\n" +
                "color:black;\">A</span><span style=\"line-height:200%;font-family:'微软雅黑','sans-serif';\n" +
                "color:black;background:white\">．</span><span style=\"line-height:200%;font-family:'微软雅黑','sans-serif';\n" +
                "color:black;\">使地表各个圈层之间，进行能量交换</span><span style=\"line-height:200%;font-family:'Times New Roman','serif';\n" +
                "color:black;\"> &nbsp;</span></p>&nbsp;&nbsp;&nbsp;\n" +
                "<p style=\"margin:0cm;margin-bottom:.0001pt;text-align:justify;text-justify:inter-ideograph;font-size:10.5pt;font-family:'Calibri','sans-serif';line-height:200%;\"><span style=\"line-height:200%;font-family:'Times New Roman','serif';\n" +
                "color:black;\">B</span><span style=\"line-height:200%;font-family:'微软雅黑','sans-serif';\n" +
                "color:black;background:white\">．</span><span style=\"line-height:200%;font-family:'微软雅黑','sans-serif';\n" +
                "color:black;\">使全球各地的降水保持不变</span></p>\n" +
                "<p style=\"margin:0cm;margin-bottom:.0001pt;text-align:justify;text-justify:inter-ideograph;font-size:10.5pt;font-family:'Calibri','sans-serif';line-height:200%;\"><span style=\"line-height:200%;font-family:'Times New Roman','serif';\n" +
                "color:black;\">C</span><span style=\"line-height:200%;font-family:'微软雅黑','sans-serif';\n" +
                "color:black;background:white\">．</span><span style=\"line-height:200%;font-family:'微软雅黑','sans-serif';\n" +
                "color:black;\">使地表径流增多，海洋蒸发减少</span><span style=\"line-height:200%;font-family:'Times New Roman','serif';\n" +
                "color:black;\"> &nbsp; &nbsp;\n" +
                "&nbsp;</span></p>\n" +
                "<p style=\"margin:0cm;margin-bottom:.0001pt;text-align:justify;text-justify:inter-ideograph;font-size:10.5pt;font-family:'Calibri','sans-serif';line-height:200%;\"><span style=\"line-height:200%;font-family:'Times New Roman','serif';\n" +
                "color:black;\">D</span><span style=\"line-height:200%;font-family:'微软雅黑','sans-serif';\n" +
                "color:black;background:white\">．</span><span style=\"line-height:200%;font-family:'微软雅黑','sans-serif';\n" +
                "color:black;\">使水资源不断得到更新，但不能持续利用</span></p>\n" +
                "<br>\n" +
                "</div>";
        String s = delHtmlTags(str);
        System.out.println(s);
        long jieshu = System.currentTimeMillis();
        System.out.println((jieshu - kaishi) / 1000);
    }

    private static String delHtmlTags(String htmlStr) {
        //定义script的正则表达式，去除js可以防止注入
        String scriptRegex = "<script[^>]*?>[\\s\\S]*?</script>";
        //定义style的正则表达式，去除style样式，防止css代码过多时只截取到css样式代码
        String styleRegex = "<style[^>]*?>[\\s\\S]*?</style>";
        //定义HTML标签的正则表达式，去除标签，只提取文字内容
        String htmlRegex = "<[^>]+>";
        //定义空格,回车,换行符,制表符
        String spaceRegex = "\\s*|\t|\r|\n";

        // 过滤script标签
        htmlStr = htmlStr.replaceAll(scriptRegex, "");
        // 过滤style标签
        htmlStr = htmlStr.replaceAll(styleRegex, "");
        // 过滤html标签
        htmlStr = htmlStr.replaceAll(htmlRegex, "");
        // 过滤空格等
        htmlStr = htmlStr.replaceAll(spaceRegex, "");
        //过滤&nbsp
        htmlStr = htmlStr.replaceAll("&nbsp;", "");
        return htmlStr.trim(); // 返回文本字符串
    }

}
