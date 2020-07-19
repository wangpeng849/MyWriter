package com.wangp.myaop.util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImgToTxt {

    /**
     * 定义把灰度值转化成的txt字符集
     */
    public static String toChar = "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/|()1{}[]?-_+~<>i!lI;:,\"^`'. ";

    /**
     * 生成的图片的长宽
     */
    public static int width = 100, height = 190;

    /**
     * 函数主体
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        /**
         * 需要转换的图片的文件地址
         */
        String inputFileName = "G:\\ThisIsMyZone\\System64\\花老师\\mmexport1563085948760.jpg";
        BufferedImage image = ImageIO.read(new File(inputFileName));

        //绘图方法实现绘图
        BufferedImage scaled = getScaledImg(image);
        //图片转成txt字符集的方法
        char[][] array = getImageMatrix(scaled);
        //输出字符
        for (char[] cs : array) {
            for (char c : cs) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    private static char[][] getImageMatrix(BufferedImage img) {
        int w = img.getWidth(), h = img.getHeight();
        char[][] rst = new char[w][h];
        for (int i = 0; i < w; i++)
            for (int j = 0; j < h; j++) {
                int rgb = img.getRGB(i, j);
                /**
                 * 值大小控制，防止溢出。
                 * Integer valueOf(String s, int radix): 返回一个 Integer 对象，该对象中保存了用第二个参数提供的基数（即 几进制）进行解析时从指定的 String 中提取的值。
                 */
                int r = Integer.valueOf(Integer.toBinaryString(rgb).substring(0, 8), 2);
                int g = (rgb & 0xff00) >> 8;
                int b = rgb & 0xff;
                /** 根据rgb值计算出灰度图像的公式，可以自己调整数值但是注意数据溢出*/
                int gray = (int) (0.299 * r + 0.587 * g + 0.114 * b);
                /** 把int gray转换成char */
                int len = toChar.length();
                int base = 256 / len + 1;
                int charIdx = gray / base;
                rst[i][j] = toChar.charAt(charIdx);
            }
        return rst;
    }


    private static BufferedImage getScaledImg(BufferedImage image) {

        BufferedImage rst = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
        rst.getGraphics().drawImage(image, 0, 0, width, height, null);
        return rst;

    }

}