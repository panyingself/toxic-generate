/*
 * Copyright (c) 2018. Toxic
 */

package com.toxic.generate.tool.controller.generate;

import com.toxic.generate.tool.business.GenerateBusiness;
import com.toxic.generate.tool.controller.BaseController;
import com.toxic.generate.tool.model.CodeConfig;
import com.toxic.generate.tool.model.DbconfigInfo;
import com.toxic.generate.tool.model.TableInfo;
import com.toxic.generate.tool.util.FileUtils;
import com.toxic.generate.tool.util.ZipFileUtils;
import org.apache.tools.zip.ZipOutputStream;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Title:
 * Description:
 *
 * @author py
 * @date 2018/7/9 下午3:54.
 */
@Controller
@RequestMapping("/generate")
public class GenerateController extends BaseController {
    @Resource
    private GenerateBusiness generateBusiness;

    /**
     * 生成代码
     */
    @RequestMapping(value = "/code", method = RequestMethod.POST)
    public String generate(DbconfigInfo dbconfigInfo, TableInfo tableInfo, CodeConfig codeConfig, HttpServletResponse response) {
        String model = tableInfo.getComments().substring(tableInfo.getComments().indexOf("#") + 1);
        codeConfig.setBasepackage("com." + model);
        codeConfig.setPath_model("" + model.replaceAll("\\.", "/"));
        codeConfig.setPath_mybatis("mybatis." + model);
        codeConfig.setPath_admin("admin." + model);
        codeConfig.setPath_front("front." + model);
        codeConfig.setPath_html5("html5." + model);

        try {
            codeConfig.setOutRoot(ResourceUtils.getURL("classpath:templates/upload").getPath() + request.getSession().getId());
            codeConfig.setTemplateName(ResourceUtils.getURL("classpath:templates/shangri-la").getPath());
//            codeConfig.setTemplateName(ResourceUtils.getURL("classpath:templates/base").getPath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //生成数据
        generateBusiness.generator(dbconfigInfo, tableInfo, codeConfig);

        //打包下载
        response.setContentType("APPLICATION/OCTET-STREAM");
        response.setHeader("Content-Disposition", "attachment; filename=src.zip");
        System.out.println("in BatchDownload................");
        try {
            ZipFileUtils zip = new ZipFileUtils();
            ZipOutputStream zos = new ZipOutputStream(response.getOutputStream());
            zip.zip(new File(ResourceUtils.getURL("classpath:templates/upload").getPath() + request.getSession().getId() + "/src"), zos, "");
            zos.flush();
            zos.close();

            //删除目录
            FileUtils.DeleteFolder(ResourceUtils.getURL("classpath:templates/upload").getPath() + request.getSession().getId());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
