/*
 * Copyright (c) 2018. Toxic
 */

package com.toxic.generate.tool.util;

import java.io.*;
import java.nio.channels.FileChannel;

/**
 * Title:
 * Description:
 *
 * @author py
 * @date 2018/7/9 下午4:15.
 */
public class FileUtils {
    private FileUtils() {
        // Not instantiable.
    }

    /**
     * 复制文件
     *
     * @param srcFile     源文件File
     * @param destDir     目标目录File
     * @param newFileName 新文件名
     * @return 实际复制的字节数，如果文件、目录不存在、文件为null或者发生IO异常，返回-1
     */
    public static long copyFile(File srcFile, File destDir, String newFileName) {
        long copySizes = 0;
        if (!srcFile.exists()) {
            System.out.println("源文件不存在");
            copySizes = -1;
        } else if (!destDir.exists()) {
            System.out.println("目标目录不存在");
            copySizes = -1;
        } else if (newFileName == null) {
            System.out.println("文件名为null");
            copySizes = -1;
        } else {
            try {
                BufferedInputStream bin = new BufferedInputStream(
                        new FileInputStream(srcFile));
                BufferedOutputStream bout = new BufferedOutputStream(
                        new FileOutputStream(new File(destDir, newFileName)));
                int b = 0, i = 0;
                while ((b = bin.read()) != -1) {
                    bout.write(b);
                    i++;
                }
                bout.flush();
                bin.close();
                bout.close();
                copySizes = i;

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return copySizes;
    }

    /**
     * 复制文件(以超快的速度复制文件)
     *
     * @param srcFile     源文件File
     * @param destDir     目标目录File
     * @param newFileName 新文件名
     * @return 实际复制的字节数，如果文件、目录不存在、文件为null或者发生IO异常，返回-1
     */
    public static long copyFile2(File srcFile, File destDir, String newFileName) {
        long copySizes = 0;
        if (!srcFile.exists()) {
            System.out.println("源文件不存在");
            copySizes = -1;
        } else if (!destDir.exists()) {
            System.out.println("目标目录不存在");
            copySizes = -1;
        } else if (newFileName == null) {
            System.out.println("文件名为null");
            copySizes = -1;
        } else {
            try {
                FileChannel fcin = new FileInputStream(srcFile).getChannel();
                FileChannel fcout = new FileOutputStream(new File(destDir,
                        newFileName)).getChannel();
                long size = fcin.size();
                fcin.transferTo(0, fcin.size(), fcout);
                fcin.close();
                fcout.close();
                copySizes = size;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return copySizes;
    }

    /**
     * 根据路径删除指定的目录或文件，无论存在与否
     *
     * @param sPath 要删除的目录或文件
     * @return 删除成功返回 true，否则返回 false。
     */
    public static boolean DeleteFolder(String sPath) {
        File file = new File(sPath);
        // 判断目录或文件是否存在
        // 不存在返回 false
        if (!file.exists()) {
            return false;
        } else {
            // 判断是否为文件
            // 为文件时调用删除文件方法
            if (file.isFile()) {
                return deleteFile(sPath);
            } else {
                // 为目录时调用删除目录方法
                return deleteDirectory(sPath);
            }
        }
    }


    /**
     * 根据路径删除包含指定字符的文件
     */
    public static boolean DeleteFileByKey(String sPath, String sKey) {
        File file = new File(sPath);
        // 判断目录或文件是否存在
        // 不存在返回 false
        if (!file.exists()) {
            return false;
        } else {
            File temp = null;
            File[] filelist = file.listFiles();
            //遍历目录下所有文件
            for (File aFilelist : filelist) {
                temp = aFilelist;
                //输入文件所包含的字符
                //删除文件
                if (temp.getName().contains(sKey)) {
                    temp.delete();
                }
            }

            return true;
        }
    }

    /**
     * 删除单个文件
     *
     * @param sPath 被删除文件的文件名
     * @return 单个文件删除成功返回true，否则返回false
     */
    public static boolean deleteFile(String sPath) {
        boolean flag = false;
        File file = new File(sPath);
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
     * @param sPath 被删除目录的文件路径
     * @return 目录删除成功返回true，否则返回false
     */
    public static boolean deleteDirectory(String sPath) {
        //如果sPath不以文件分隔符结尾，自动添加文件分隔符
        if (!sPath.endsWith(File.separator)) {
            sPath = sPath + File.separator;
        }
        File dirFile = new File(sPath);
        //如果dir对应的文件不存在，或者不是一个目录，则退出
        if (!dirFile.exists() || !dirFile.isDirectory()) {
            return false;
        }
        boolean flag = true;
        //删除文件夹下的所有文件(包括子目录)
        File[] files = dirFile.listFiles();
        for (File file : files) {
            //删除子文件
            if (file.isFile()) {
                flag = deleteFile(file.getAbsolutePath());
                if (!flag) {
                    break;
                }
            } //删除子目录
            else {
                flag = deleteDirectory(file.getAbsolutePath());
                if (!flag) {
                    break;
                }
            }
        }
        if (!flag) {
            return false;
        }
        //删除当前目录
        return dirFile.delete();
    }
}
