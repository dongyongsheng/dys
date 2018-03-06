package util;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.Map;
import java.util.Properties;

/**
 * 文件处理工具类
 * 
 * @author ssc
 * 
 */
public class FileUtil {

	/**
	 * 根据路径删除指定的目录或文件，无论存在与否
	 * 
	 * @param sPath
	 *            要删除的目录或文件
	 * @return 删除成功返回 true，否则返回 false。
	 */
	public static boolean DeleteFolder(String sPath) {
		boolean flag = false;
		File file = new File(sPath);
		// 判断目录或文件是否存在
		if (!file.exists()) { // 不存在返回 false
			return flag;
		} else {
			// 判断是否为文件
			if (file.isFile()) { // 为文件时调用删除文件方法
				return deleteFile(sPath);
			} else { // 为目录时调用删除目录方法
				return deleteDirectory(sPath);
			}
		}
	}

	/**
	 * 删除单个文件
	 * 
	 * @param sPath
	 *            被删除文件的文件名
	 * @return 单个文件删除成功返回true，否则返回false
	 */
	public static boolean deleteFile(String sPath) {
		File file = new File(sPath);
		// 路径为文件且不为空则进行删除
		if (file.isFile() && file.exists()) {
			return file.delete();
		}
		return false;
	}

	/**
	 * 删除目录（文件夹）以及目录下的文件
	 * 
	 * @param sPath
	 *            被删除目录的文件路径
	 * @return 目录删除成功返回true，否则返回false
	 */
	public static boolean deleteDirectory(String sPath) {
		// 如果sPath不以文件分隔符结尾，自动添加文件分隔符
		if (!sPath.endsWith(File.separator)) {
			sPath = sPath + File.separator;
		}
		File dirFile = new File(sPath);
		// 如果dir对应的文件不存在，或者不是一个目录，则退出
		if (!dirFile.exists() || !dirFile.isDirectory()) {
			return false;
		}
		boolean flag = true;
		// 删除文件夹下的所有文件(包括子目录)
		File[] files = dirFile.listFiles();
		for (int i = 0; i < files.length; i++) {
			// 删除子文件
			if (files[i].isFile()) {
				flag = deleteFile(files[i].getAbsolutePath());
				if (!flag)
					break;
			} // 删除子目录
			else {
				flag = deleteDirectory(files[i].getAbsolutePath());
				if (!flag)
					break;
			}
		}
		if (!flag)
			return false;
		// 删除当前目录
		if (dirFile.delete()) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 移动文件
	 * @param srcFile
	 * @param destPath
	 * @return
	 */
	public static boolean Move(File srcFile, String destPath) {
		// Destination directory
		File dir = new File(destPath);

		// Move file to new directory
		boolean success = srcFile.renameTo(new File(dir, srcFile.getName()));

		return success;
	}

	/**
	 * 移动文件
	 * @param srcFile
	 * @param destPath
	 * @return
	 */
	public static boolean Move(String srcFile, String destPath) {
		// File (or directory) to be moved
		File file = new File(srcFile);

		// Destination directory
		File dir = new File(destPath);

		// Move file to new directory
		boolean success = file.renameTo(new File(dir, file.getName()));

		return success;
	}
	
	/**
	 * 复制文件
	 * @param oldPath
	 * @param newPath
	 */
	public static void Copy(String oldPath, String newPath) {
		try {
			int bytesum = 0;
			int byteread = 0;
			File oldfile = new File(oldPath);
			if (oldfile.exists()) {
				InputStream inStream = new FileInputStream(oldPath);
				FileOutputStream fs = new FileOutputStream(newPath);
				byte[] buffer = new byte[1444];
				int length;
				while ((byteread = inStream.read(buffer)) != -1) {
					bytesum += byteread;
					System.out.println(bytesum);
					fs.write(buffer, 0, byteread);
				}
				inStream.close();
			}
		} catch (Exception e) {
			System.out.println("error  ");
			e.printStackTrace();
		}
	}
	/**
	 * 文件复制
	 * @param s
	 * 		原文件
	 * @param t
	 * 		新文件
	 */
	public static void fileChannelCopy(File s, File t) {
		FileInputStream fi = null;
		FileOutputStream fo = null;
		FileChannel in = null;
		FileChannel out = null;
		try {
			fi = new FileInputStream(s);
			fo = new FileOutputStream(t);
			in = fi.getChannel();// 得到对应的文件通道
			out = fo.getChannel();// 得到对应的文件通道
			in.transferTo(0, in.size(), out);// 连接两个通道，并且从in通道读取，然后写入out通道
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fi.close();
				in.close();
				fo.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}
	
	/**
	 * 文件复制
	 * @param s
	 * 		原文件 地址
	 * @param t
	 * 		新文件地址
	 */
	public static void fileChannelCopy(String s, String t) {
		FileInputStream fi = null;
		FileOutputStream fo = null;
		FileChannel in = null;
		FileChannel out = null;
		try {

			fi = new FileInputStream(s);
			fo = new FileOutputStream(t);
			in = fi.getChannel();// 得到对应的文件通道
			out = fo.getChannel();// 得到对应的文件通道
			in.transferTo(0, in.size(), out);// 连接两个通道，并且从in通道读取，然后写入out通道
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fi.close();
				in.close();
				fo.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 复制一个文件夹下所有的文件到另一个目录
	 * @param str1
	 * 			目标文件夹
	 * @param str2
	 * 			原文件夹
	 * 
	 */
	public static void copyAllFile(String str1,String str2){
		File copyfiles=new File(str1);   
		File[] files=copyfiles.listFiles();   
		for(int i=0;i<files.length;i++){   
		    if(!files[i].isDirectory()){   
		        int bytesum = 0;   
		        int byteread = 0;   
		        try {   
		            InputStream inStream = new FileInputStream(files[i]); //读入原文件   
		            FileOutputStream fs = new FileOutputStream(new File(str2,files[i].getName()));   
		            byte[] buffer = new byte[5120];   
		            while ( (byteread = inStream.read(buffer)) != -1) {   
		                bytesum += byteread; //字节数 文件大小   
//		                System.out.println(bytesum);   
		                fs.write(buffer, 0, byteread);   
		            }   
		            inStream.close();   
		        } catch (Exception e) {   
		            System.out.println("复制单个文件操作出错,文件名称："+files[1].getName());   
		            e.printStackTrace();   
		        }   
		    }   
		}    
	}
	
	
	public static void main(String args[]){
		 Properties properties = System.getProperties()  ;  //获得JAVA配置信息
		 Map<String , String> map = System.getenv() ;//获得系统配置信息
		 
		 System.out.println( properties.getProperty("user.dir"));
		 System.out.println( map.get("JAVA_HOME"));
		 System.out.println( map.get("SystemRoot"));
		 
		 FileUtil.copyAllFile(properties.getProperty("user.dir")+"\\dll", map.get("JAVA_HOME")+"\\bin");
		 
	}
}
