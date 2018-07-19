package com.cxd.xiaonuan.util;

import java.io.*;

/**
 * 文件工具类
 * 
 * @author cxd
 * 
 */
public class FileUtil {

	private final static int BUFFER = 1024;

	/**
	 * 复制文件(只能复制文件)
	 * 
	 * @param strSourceFileName
	 *            指定的文件全路径名
	 * @param strDestDir
	 *            移动到指定的文件夹
	 * @return 如果成功true;否则false
	 */
	public static boolean copyFile(String strSourceFileName, String strDestDir) {
		File fileSource = new File(strSourceFileName);
		File fileDest = new File(strDestDir);

		// 如果源文件不存或源文件是文件夹
		if (!fileSource.exists() || !fileSource.isFile()) {
			return false;
		}
		// 如果目标文件夹不存在
		if (!fileDest.isDirectory() || !fileDest.exists()) {
			if (!fileDest.mkdirs()) {
				return false;
			}
		}
		try {
			String strAbsFilename = strDestDir + File.separator + fileSource.getName();
			FileInputStream fileInput = new FileInputStream(strSourceFileName);
			FileOutputStream fileOutput = new FileOutputStream(strAbsFilename);
			int count = -1;
			long nWriteSize = 0;
			long nFileSize = fileSource.length();
			byte[] data = new byte[BUFFER];
			while (-1 != (count = fileInput.read(data, 0, BUFFER))) {
				fileOutput.write(data, 0, count);
				nWriteSize += count;
				long size = (nWriteSize * 100) / nFileSize;
				long t = nWriteSize;
				String msg = null;
				if (size <= 100 && size >= 0) {
					msg = "\r拷贝文件进度:   " + size + "%   \t" + "\t   已拷贝:   " + t;
				} else if (size > 100) {
					msg = "\r拷贝文件进度:   " + 100 + "%   \t" + "\t   已拷贝:   " + t;
				}
			}
			fileInput.close();
			fileOutput.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 复制文件夹(只能复制文件夹)
	 * 
	 * @param strSourceDir
	 *            指定的文件夹
	 * @param strDestDir
	 *            移动到指定的文件夹
	 * @return 如果成功true;否则false
	 */
	public static boolean copyDirectory(String strSourceDir, String strDestDir) {
		boolean flag = false;
		File fileSource = new File(strSourceDir);
		File fileDest = new File(strDestDir + File.separator + fileSource.getName());
		// 如果源文件不存或源文件是文件夹
		if (!fileSource.exists() || !fileSource.isDirectory()) {
			return false;
		}
		// 如果目标文件夹不存在
		if (!fileDest.isDirectory() || !fileDest.exists()) {
			if (!fileDest.mkdirs()) {
				return false;
			}
		}
		try {
			File files[] = fileSource.listFiles();
			for (int i = 0; i < files.length; i++) {
				if (files[i].isFile()) {
					// 如果是文件，则调用文件复制
					flag = copyFile(files[i].getAbsolutePath(), fileDest.getAbsolutePath());
				}
				if (files[i].isDirectory()) {
					// 如果是文件夹，则调用文件夹复制
					flag = copyDirectory(files[i].getAbsolutePath(), fileDest.getAbsolutePath());
				}
			}
			return flag;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 文件复制(无论是文件夹还是文件)
	 * 
	 * @param strSourceFloder
	 *            指定的文件或文件夹
	 * @param strDestDir
	 *            移动到指定的文件夹
	 * @return 如果成功true;否则false
	 */
	public static boolean copyFolder(String strSourceFloder, String strDestDir) {
		boolean flag = false;
		File fileSource = new File(strSourceFloder);
		File fileDest = new File(strDestDir);
		// 如果源文件不存或源文件是文件夹
		if (!fileSource.exists()) {
			return false;
		}
		// 如果目标文件夹不存在
		if (!fileDest.isDirectory() || !fileDest.exists()) {
			if (!fileDest.mkdirs()) {
				return false;
			}
		}
		try {
			if (fileSource.isFile()) {
				// 如果是文件，则调用文件复制
				flag = copyFile(fileSource.getAbsolutePath(), fileDest.getAbsolutePath());
			}
			if (fileSource.isDirectory()) {
				// 如果是文件夹，则调用文件夹复制
				flag = copyDirectory(fileSource.getAbsolutePath(), fileDest.getAbsolutePath());
			}
			return flag;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 移动文件夹(只能移动文件夹)
	 * 
	 * @param strSourceFileName
	 *            指定的文件全路径名
	 * @param strDestDir
	 *            指定的文件夹中
	 * @return 如果成功true; 否则false
	 */
	public static boolean moveDirectory(String strSourceDir, String strDestDir) {
		if (copyDirectory(strSourceDir, strDestDir))
			return deleteDirectory(strSourceDir);
		else
			return false;
	}

	/**
	 * 移动文件(只能移动文件)
	 * 
	 * @param strSourceDir
	 *            指定的文件夹
	 * @param strDestDir
	 *            指定的文件夹中
	 * @return 如果成功true; 否则false
	 */
	public static boolean moveFile(String strSourceFileName, String strDestDir) {
		if (copyFile(strSourceFileName, strDestDir))
			return deleteFile(strSourceFileName);
		else
			return false;
	}

	/**
	 * 移动文件或文件夹
	 * 
	 * @param strSourceFolder
	 *            指定的文件或文件夹
	 * @param strDestDir
	 *            指定的文件夹中
	 * @return 如果成功true; 否则false
	 */
	public static boolean moveFolder(String strSourceFolder, String strDestDir) {
		if (copyFolder(strSourceFolder, strDestDir))
			return DeleteFolder(strSourceFolder);
		else
			return false;
	}

	/**
	 * 功 能: 创建文件夹
	 * 
	 * @param strDir
	 *            要创建的文件夹名称
	 * @return 如果成功true;否则false
	 */
	public static boolean makeDirectory(String strDir) {
		File fileNew = new File(strDir);

		if (!fileNew.exists()) {
			return fileNew.mkdirs();
		} else {
			return true;
		}
	}

	/**
	 * 从文件流中保存文件，返回文件大小(最大2G的文件,单位byte)
	 * 
	 * @param stream
	 *            输入文件流
	 * @param savePath
	 *            文件保存路径
	 * @return bytesum 返回文件字节大小
	 */
	public static Integer saveFileFromInputStream(InputStream stream, String savePath) {
		FileOutputStream fs = null;
		int bytesum = 0;
		int byteread = 0;
		try {
			fs = new FileOutputStream(savePath);
			byte[] buffer = new byte[1024 * 1024];

			while ((byteread = stream.read(buffer)) != -1) {
				bytesum += byteread;
				fs.write(buffer, 0, byteread);
				fs.flush();
			}
		} catch (IOException e) {
		} finally {
			try {
				if (fs != null) {
					fs.close();
				}
				if (fs != null) {
					stream.close();
				}
			} catch (IOException e) {
			}
		}

		return bytesum;

	}

	/**
	 * 根据路径删除指定的目录或文件，无论存在与否
	 * 
	 * @param strSourceFolder
	 *            要删除的目录或文件
	 * @return 删除成功返回 true，否则返回 false。
	 */
	public static boolean DeleteFolder(String strSourceFolder) {
		boolean flag = false;
		File file = new File(strSourceFolder);
		// 判断目录或文件是否存在
		if (!file.exists()) { // 不存在返回 false
			return flag;
		} else {
			// 判断是否为文件
			if (file.isFile()) { // 为文件时调用删除文件方法
				return deleteFile(strSourceFolder);
			} else { // 为目录时调用删除目录方法
				return deleteDirectory(strSourceFolder);
			}
		}
	}

	/**
	 * 删除单个文件
	 * 
	 * @param strSourceFileName
	 *            被删除文件的文件名
	 * @return 单个文件删除成功返回true，否则返回false
	 */
	public static boolean deleteFile(String strSourceFileName) {
		boolean flag = false;
		File file = new File(strSourceFileName);
		// 路径为文件且不为空则进行删除
		if (file.isFile() && file.exists()) {
			file.delete();
			flag = true;
		}
		return flag;
	}

	/**
	 * 删除目录（文件夹）以及目录下的文件
	 * 
	 * @param strSourceDir
	 *            被删除目录的文件路径
	 * @return 目录删除成功返回true，否则返回false
	 */
	public static boolean deleteDirectory(String strSourceDir) {
		// 如果sPath不以文件分隔符结尾，自动添加文件分隔符
		if (!strSourceDir.endsWith(File.separator)) {
			strSourceDir = strSourceDir + File.separator;
		}
		File dirFile = new File(strSourceDir);
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
	 * 得到文件的类型。 实际上就是得到文件名中最后一个“.”后面的部分。
	 * 
	 * @param fileName
	 *            文件名
	 * @return 文件名中的类型部分
	 * @since 1.0
	 */
	public static String getTypePart(String fileName) {
		int point = fileName.lastIndexOf('.');
		int length = fileName.length();
		if (point == -1 || point == length - 1) {
			return "";
		} else {
			return fileName.substring(point + 1, length);
		}
	}

	/**
	 * 得到文件的类型。 实际上就是得到文件名中最后一个“.”后面的部分。
	 * 
	 * @param file
	 *            文件
	 * @return 文件名中的类型部分
	 * @since 1.0
	 */
	public static String getFileType(File file) {
		return getTypePart(file.getName());
	}



	public static void main(String[] args) throws Exception {
		File file = new File("D:\\Java\\ojdbc6.jar");
		if (file.isFile()) {
			System.out.println(file.getParent());
		} else if (file.isDirectory()) {
			System.out.println(file.getAbsolutePath());
		}

	}

}
