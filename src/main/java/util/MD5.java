package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public  class MD5 {
	/**
	 * 根据原始数据 生成MD5加密后的数据
	 * @param plainText
	 * 		原始文档
	 * @return
	 */
	public static String md5(String plainText) {
		 String str = null;
		try {
			
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();

			int i;

			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			str = buf.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();

		}
		return str;
	}
	public static void main(String[] args){
		
		System.out.println(MD5.md5("dahai"));
		// 5411a124b0dee3b08bde02ae3142d289
		
	}
	
}
