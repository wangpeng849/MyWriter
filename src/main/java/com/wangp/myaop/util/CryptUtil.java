package com.wangp.myaop.util;

import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import lombok.extern.slf4j.Slf4j;

/**
 * 加解密工具
 *
 * @author jamesteng
 */
@Slf4j
public class CryptUtil {

    /**
     * 十六进制下数字到字符的映射数组
     */
    private final static String[] HEX_DIGITS = {"0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    private final static String[] PADDING_SYMBOL = {"", "=", "==", "==="};

    public enum AESCipherMode {
        //加密模式
        CFB("CFB"), CTR("CTR"), CBC("CBC");
        private final String id;

        AESCipherMode(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }
    }

    /*** rsa加密算法*/
    private static final String RSA = "RSA";

    /**
     * RSA私钥加密
     *
     * @param str              明文
     * @param base64PrivateKey base64编码私钥
     * @return base64编码密文
     */
    public static String encryptByRsa(String str, String base64PrivateKey) {
        try {
            byte[] keyBytes = base64Decode(base64PrivateKey.replace("\n", ""));
            RSAPrivateCrtKey privateKey = (RSAPrivateCrtKey) KeyFactory.getInstance(RSA)
                    .generatePrivate(new PKCS8EncodedKeySpec(keyBytes));
            //Cipher cipher = Cipher.getInstance("RSA/None/OAEPWITHSHA-256ANDMGF1PADDING");
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.ENCRYPT_MODE, privateKey);
            return base64Encode(cipher.doFinal(str.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception e) {
            log.error("Encrypt By Rsa error!", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * RSA公钥解密
     *
     * @param str             密文
     * @param base64PublicKey base64编码公钥
     * @return 明文
     */
    public static String decryptByRsa(String str, String base64PublicKey) {
        try {
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(base64Decode(base64PublicKey));
            KeyFactory keyFactory = KeyFactory.getInstance(RSA);
            PublicKey publicKey = keyFactory.generatePublic(keySpec);
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.DECRYPT_MODE, publicKey);
            return new String(cipher.doFinal(base64Decode(str)));
        } catch (Exception e) {
            log.error("Decrypt By Rsa error!", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * aes-256加密
     *
     * @param clearText    明文
     * @param secretKey    密钥
     * @param cipherMode   加密方式
     * @param iv           iv
     * @param cipherWithIv 密文是否携带iv
     * @return 密文
     */
    public static byte[] encryptByAES256(String clearText, String secretKey,
            AESCipherMode cipherMode, byte[] iv, boolean cipherWithIv) {
        //参数校验
        if (clearText == null || secretKey == null || cipherMode == null) {
            throw new IllegalArgumentException("clear text and secret key and cipher mode must be not null");
        }

        try {
            //设置秘钥和加密方式
            SecretKeySpec keySpec = new SecretKeySpec(secretKey.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/" + cipherMode.getId() + "/NoPadding");

            //如果输入iv为空，创建随机IV
            int ivSize = 16;
            if (iv == null) {
                iv = new byte[ivSize];
                SecureRandom random = new SecureRandom();
                random.nextBytes(iv);
            }
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);

            //加密
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivParameterSpec);
            byte[] encrypted = cipher.doFinal(clearText.getBytes());

            //拼接iv和密文
            if (cipherWithIv) {
                byte[] encryptedIVAndText = new byte[ivSize + encrypted.length];
                System.arraycopy(iv, 0, encryptedIVAndText, 0, ivSize);
                System.arraycopy(encrypted, 0, encryptedIVAndText, ivSize, encrypted.length);
                return encryptedIVAndText;
            }

            //直接返回密文
            return encrypted;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * aes-256解密
     *
     * @param cipherText 密文
     * @param secretKey  密钥
     * @param cipherMode 加密方式
     * @param iv         iv，iv为空时，从密文中获取iv
     * @return 明文
     */
    public static String decryptByAES256(String cipherText, String secretKey, AESCipherMode cipherMode, byte[] iv) {
        //参数校验
        if (cipherText == null || secretKey == null || cipherMode == null) {
            throw new IllegalArgumentException("clear text and secret key and cipher mode must be not null");
        }
        try {
            //获取iv和密文
            byte[] asBytes = Base64.getDecoder().decode(cipherText);
            byte[] encryptBytes;
            if (iv == null) {
                iv = new byte[16];
                encryptBytes = new byte[asBytes.length - iv.length];
                System.arraycopy(asBytes, 0, iv, 0, iv.length);
                System.arraycopy(asBytes, iv.length, encryptBytes, 0, encryptBytes.length);
            } else {
                encryptBytes = asBytes;
            }

            //设置秘钥和解密方式
            SecretKeySpec key = new SecretKeySpec(secretKey.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/" + cipherMode.getId() + "/NoPadding");
            IvParameterSpec ivspec = new IvParameterSpec(iv);

            //解密
            cipher.init(Cipher.DECRYPT_MODE, key, ivspec);
            byte[] result = cipher.doFinal(encryptBytes);
            return new String(result, StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Sha-256加密
     */
    public static String encryptBySHA256(String str) throws NoSuchAlgorithmException {
        if (str == null) {
            return null;
        }
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(str.getBytes(StandardCharsets.UTF_8));
        return getFormattedText(messageDigest.digest());
    }

    private static String getFormattedText(byte[] bytes) {
        StringBuilder buf = new StringBuilder(bytes.length * 2);
        // 把密文转换成十六进制的字符串形式
        for (byte b : bytes) {
            buf.append(HEX_DIGITS[(b >> 4) & 0x0f]);
            buf.append(HEX_DIGITS[b & 0x0f]);
        }
        return buf.toString();
    }

    /**
     * sha1加密
     *
     * @param clearText 明文
     * @return sha1
     */
    public static String encryptBySHA1(String clearText) {
        if (clearText == null) {
            return null;
        }
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.update(clearText.getBytes());
            byte[] messageDigest = digest.digest();
            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                String shaHex = Integer.toHexString(b & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * md5加密
     *
     * @param clearText 明文
     * @return md5
     */
    public static String encryptByMD5(String clearText) {
        return encryptByMD5(clearText, true);
    }

    /**
     * md5加密
     *
     * @param clearText 明文
     * @param isCapital 是否大写，1-大写，2-小写
     * @return md5
     */
    public static String encryptByMD5(String clearText, boolean isCapital) {
        if (clearText != null) {
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                byte[] results = md.digest(clearText.getBytes());
                String resultString = byteArrayToHexString(results);

                if (isCapital) {
                    return resultString.toUpperCase();
                }

                return resultString;
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    /**
     * 异或加密 异或加密为对称性加密，使用该方法同样可以进行异或解密，即输入密文得到明文
     *
     * @param srcBytes  明文或密文字节数组
     * @param secretKey 密钥
     * @return 密文
     */
    public static byte[] encryptByXor(byte[] srcBytes, String secretKey) {
        //原文或秘钥为空，直接返回原文
        if (srcBytes == null || srcBytes.length == 0 || secretKey == null || secretKey.length() == 0) {
            return srcBytes;
        }

        //使用原文字节和密钥字节循环异或
        byte[] cipherText = new byte[srcBytes.length];
        byte[] secretKeyBytes = secretKey.getBytes();
        for (int i = 0; i < srcBytes.length; i++) {
            cipherText[i] = (byte) (srcBytes[i] ^ secretKeyBytes[i % secretKeyBytes.length]);
        }

        return cipherText;
    }

    /**
     * base64编码
     *
     * @param bytes 字节数组
     * @return base64编码后的字符串
     */
    public static String base64Encode(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }

    /**
     * base64解码
     *
     * @param text base64编码字符串
     * @return 字节数组
     */
    public static byte[] base64Decode(String text) {
        int paddingNum = 0;
        if (text.length() % 4 != 0) {
            paddingNum = 4 - text.length() % 4;
        }
        text = text + PADDING_SYMBOL[paddingNum];
        return Base64.getDecoder().decode(text);
    }

    /**
     * 转换字节数组为16进制字串
     *
     * @param bytes 字节数组
     * @return 十六进制字串
     */
    public static String byteArrayToHexString(byte[] bytes) {
        StringBuilder resultSb = new StringBuilder();
        for (byte b : bytes) {
            resultSb.append(byteToHexString(b));
        }
        return resultSb.toString();
    }

    /**
     * 将一个字节转化成16进制形式的字符串
     *
     * @param b 请求字节字符
     * @return 16进制字符串
     */
    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n = 256 + n;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return HEX_DIGITS[d1] + HEX_DIGITS[d2];
    }
}
