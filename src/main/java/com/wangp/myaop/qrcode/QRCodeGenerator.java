package com.wangp.myaop.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Hashtable;

public class QRCodeGenerator {

    private static final String QR_CODE_IMAGES_PATH = "D://qrCode.png";
//注释内也可以 解决乱码
//    private static final String CHARSET = "utf-8";
    private static void generateQRCodeImage(String text,int width,int height,String filePath) throws WriterException, IOException {
//        Hashtable hints = new Hashtable();
//        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
//        hints.put(EncodeHintType.CHARACTER_SET, CHARSET);
//        hints.put(EncodeHintType.MARGIN, 1);
        text = new String(text.getBytes("UTF-8"), "ISO-8859-1");
        QRCodeWriter writer = new QRCodeWriter();
//        BitMatrix bitMatrix = writer.encode(text, BarcodeFormat.QR_CODE,width,height,hints);
        BitMatrix bitMatrix = writer.encode(text, BarcodeFormat.QR_CODE,width,height);
        Path path = FileSystems.getDefault().getPath(filePath);
        MatrixToImageWriter.writeToPath(bitMatrix,"PNG",path);
    }

    public static void main(String[] args) throws IOException, WriterException {
        generateQRCodeImage(".",350,350,QR_CODE_IMAGES_PATH);
    }
}
