/*
 * Copyright (c) 2018. Toxic
 */

package com.toxic.generate.tool.util;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;
import org.apache.tools.zip.ZipOutputStream;

import java.io.*;
import java.util.Enumeration;

/**
 * Title:
 * Description:
 *
 * @author py
 * @date 2018/7/9 下午4:11.
 */
public class ZipFileUtils {
    private static ZipFileUtils instance = new ZipFileUtils();

    public static ZipFileUtils getInstance() {
        return instance;
    }

    public ZipFileUtils() {
    }

    /*
     * inputFileName 输入一个文件夹
     * zipFileName 输出一个压缩文件夹
     */
//    public void zip(String inputFileName,String outFileName) throws Exception {
//        String zipFileName = "c:\\test.zip"; //打包后文件名字
//        //System.out.println(zipFileName);
//        zip(zipFileName, new File(inputFileName));
//    }

    private void zip(String zipFileName, File inputFile) throws Exception {
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFileName));
        zip(out, inputFile, "");
        System.out.println("zip done");
        out.close();
    }

    private void zip(ZipOutputStream out, File f, String base) throws Exception {
        if (f.isDirectory()) {
            File[] fl = f.listFiles();
            out.putNextEntry(new ZipEntry(base + "/"));
            base = base.length() == 0 ? "" : base + "/";
            for (int i = 0; i < fl.length; i++) {
                zip(out, fl[i], base + fl[i].getName());
            }
        } else {
            out.putNextEntry(new ZipEntry(base));
            FileInputStream in = new FileInputStream(f);
            int b;
            System.out.println(base);
            while ((b = in.read()) != -1) {
                out.write(b);
            }
            in.close();
        }
    }


    public synchronized void zip(String inputFilename, String zipFilename) throws IOException {
        zip(new File(inputFilename), zipFilename);
    }

    public synchronized void zip(File inputFile, String zipFilename) throws IOException {

        try (ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFilename))) {
            zip(inputFile, out, "");
        }
    }

    public synchronized void zip(File inputFile, ZipOutputStream out, String base)
            throws IOException {
        if (inputFile.isDirectory()) {
            File[] inputFiles = inputFile.listFiles();
            out.putNextEntry(new ZipEntry(base + "/"));
            base = base.length() == 0 ? "" : base + "/";
            for (File inputFile1 : inputFiles) {
                zip(inputFile1, out, base + inputFile1.getName());
            }

        } else {
            if (base.length() > 0) {
                out.putNextEntry(new ZipEntry(base));
            } else {
                out.putNextEntry(new ZipEntry(inputFile.getName()));
            }

            try (FileInputStream in = new FileInputStream(inputFile)) {
                int c;
                byte[] by = new byte[BUFFEREDSIZE];
                while ((c = in.read(by)) != -1) {
                    out.write(by, 0, c);
                }
            }
        }
    }

    private synchronized void unzip(String zipFilename, String outputDirectory)
            throws IOException {
        File outFile = new File(outputDirectory);
        if (!outFile.exists()) {
            outFile.mkdirs();
        }

        ZipFile zipFile = new ZipFile(zipFilename);
        Enumeration en = zipFile.getEntries();
        ZipEntry zipEntry = null;
        while (en.hasMoreElements()) {
            zipEntry = (ZipEntry) en.nextElement();
            if (zipEntry.isDirectory()) {
                // mkdir directory
                String dirName = zipEntry.getName();
                dirName = dirName.substring(0, dirName.length() - 1);

                File f = new File(outFile.getPath() + File.separator + dirName);
                f.mkdirs();

            } else {
                // unzip file
                File f = new File(outFile.getPath() + File.separator
                        + zipEntry.getName());
                f.createNewFile();
                try (InputStream in = zipFile.getInputStream(zipEntry); FileOutputStream out = new FileOutputStream(f)) {
                    int c;
                    byte[] by = new byte[BUFFEREDSIZE];
                    while ((c = in.read(by)) != -1) {
                        out.write(by, 0, c);
                    }
                    // out.flush();
                }
            }
        }
    }

    private static final int BUFFEREDSIZE = 1024;

    public static void main(String[] args) {
        ZipFileUtils bean = new ZipFileUtils();
        try {
            bean.zip("d:/temp", "d:/test.zip");

            bean.unzip("d:/test.zip", "d:/out/temp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
