package util;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * 项目名称：**** 
 * 类名称：ThreeDES 
 * 类描述： 3des 加密工具类
 * 
 * @version 1.0
 *
 */
public class ThreeDES {

	// key 根据实际情况对应的修改
	private final byte[] keybyte = "F7A0B971B199FD2A1017CEC5".getBytes(); // keybyte为加密密钥，长度为24字节
	private static final String Algorithm = "DESede"; // 定义 加密算法,可用
														// DES,DESede,Blowfish
	private SecretKey deskey;

	/// 生成密钥
	public ThreeDES() {
		deskey = new SecretKeySpec(keybyte, Algorithm);
	}

	// 加密
	public byte[] encrypt(byte[] data) {
		try {
			Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
			IvParameterSpec iv = new IvParameterSpec("20160120".getBytes());
			cipher.init(Cipher.ENCRYPT_MODE, deskey, iv);
			return cipher.doFinal(data);
		} catch (Exception ex) {
			// 加密失败，打日志
			ex.printStackTrace();
		}
		return null;
	}

	// 解密
	public byte[] decrypt(byte[] data) {
		try {
			Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, deskey);
			return cipher.doFinal(data);
		} catch (Exception ex) {
			// 解密失败，打日志
			ex.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) throws Exception {
		ThreeDES des = new ThreeDES();
		String req = "{\"plateNo\":\"A12345\"}";

		String toreq = toHexString(req);
		System.err.println("十六进制报文====" + toreq);
		byte[] srcData = req.toString().getBytes("GB2312");
		byte[] encryptData = des.encrypt(srcData);
//		System.out.println(Base64.encodeBase64String(encryptData));
		System.out.println("密文：");
		if (encryptData != null) {
			for (int i = 0; i < encryptData.length; i++) {
				String hex = Integer.toHexString(encryptData[i]);
				if (hex.length() > 1)
					System.out.print(hex.substring(hex.length() - 2) + " ");
				else
					System.out.print("0" + hex + " ");
			}
		}
		System.out.println("");
		System.out.println("明文：");
	}

	// 转化字符串为十六进制编码
	public static String toHexString(String s) {
		String str = "";
		for (int i = 0; i < s.length(); i++) {
			int ch = (int) s.charAt(i);
			String s4 = Integer.toHexString(ch);
			str = str + s4;
		}
		return str;
	}
}