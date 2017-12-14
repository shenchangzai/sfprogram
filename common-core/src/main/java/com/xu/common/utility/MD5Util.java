package com.xu.common.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.LoggerFactory;
import org.springframework.util.Base64Utils;

public class MD5Util {

    public static String encryptMD5(String content) {
        try {
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(content.getBytes());
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            StringBuffer hexString = new StringBuffer();
            // 字节数组转换为 十六进制 数
            for (int i = 0; i < md.length; i++) {
                String shaHex = Integer.toHexString(md[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
        	LoggerFactory.getLogger("MD5Util.encryptMD5").error(e.getMessage());//日志
        }
        return null;
    }

    /**
	 * 获取文件MD5值
	 * @param file
	 * @return
	 */
	public static String getMd5ByFile(File file) {  
        String value = null;  
        FileInputStream in = null;  
        try {  
        	in = new FileInputStream(file);
        	MappedByteBuffer byteBuffer = in.getChannel()
        			.map(FileChannel.MapMode.READ_ONLY, 0, file.length());  
        	MessageDigest md5 = MessageDigest.getInstance("MD5");  
        	md5.update(byteBuffer);  
        	BigInteger bi = new BigInteger(1, md5.digest());  
        	value = bi.toString(16);
        	
        	// value有问题，会自动去掉最前面的0，这里将0补上至32位
			if (value.length() < 32) {
				int diff = 32 - value.length();
				for (int i=0; i<diff; i++) {
					value = "0" + value;
				}
			}
        } catch (Exception e) {  
        	LoggerFactory.getLogger("MD5Util.getMd5ByFile").error(e.getMessage());// 日志
        } finally {  
            if(null != in) {  
                try {  
                	in.close();  
                } catch (IOException e) {  
                	e.printStackTrace();  
                }  
            }  
        }  
        return value;  
    }
	
	public static String getBase64Md5ByFile(File file) {  
        String value = null;  
        FileInputStream in = null;  
        try {  
        	in = new FileInputStream(file);
        	MappedByteBuffer byteBuffer = in.getChannel()
        			.map(FileChannel.MapMode.READ_ONLY, 0, file.length());  
        	MessageDigest md5 = MessageDigest.getInstance("MD5");  
        	md5.update(byteBuffer);  
        	value = Base64Utils.encodeToString(md5.digest());
        } catch (Exception e) {  
        	LoggerFactory.getLogger("MD5Util.getBase64Md5ByFile").error(e.getMessage());//日志
        } finally {  
            if(null != in) {  
                try {  
                	in.close();  
                } catch (IOException e) {  
                	e.printStackTrace();  
                }  
            }  
        }  
        return value;  
    }
	
	public static String getMd5ByBytes(byte[] strBytes) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			LoggerFactory.getLogger("MD5Util.getMd5ByBytes").error(e.getMessage());//日志
		}
		md.update(strBytes);		
		StringBuffer buf = new StringBuffer();
		byte[] bits = md.digest();
		for (int i=0; i<bits.length; i++) {
			int a = bits[i];
			if (a<0) 
				a += 256;
			if (a<16) 
				buf.append("0");
			buf.append(Integer.toHexString(a));
		}
		return buf.toString();
	}

    public static void main(String[] args) {
        String timestamp = Long.toString(System.currentTimeMillis() / 1000);
        String salt = "7e2de1edd32e46dd971d682a41f98bad";
        String systemId = "Fmaster";

        System.out.println(timestamp);
        System.out.println(encryptMD5(systemId + timestamp + salt));
    }

}
