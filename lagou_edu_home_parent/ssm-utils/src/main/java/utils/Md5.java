package utils;

import org.apache.commons.codec.digest.DigestUtils;

public class Md5 {

    public final static String md5key = "heying";

    public static String md5(String text, String key) throws Exception {
        String encodeStr = DigestUtils.md5Hex(text+key);
        System.out.println("MD5加密后的字符串为:encodeStr="+encodeStr);
        return encodeStr;
    }

    public static boolean verify(String text, String key, String md5) throws Exception {

        String md5Text = md5(text, key);
        if(md5Text.equalsIgnoreCase(md5)){
            System.out.println("验证通过");
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        String s = Md5.md5("9870", "heying");
    }
}
