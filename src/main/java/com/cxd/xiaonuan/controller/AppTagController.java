package com.cxd.xiaonuan.controller;


import com.cxd.xiaonuan.bean.AppTag;
import com.cxd.xiaonuan.mapper.AppTagMapper;
import com.cxd.xiaonuan.service.AppTagService;
import com.cxd.xiaonuan.util.DateUtil;
import com.gitee.sunchenbin.mybatis.actable.command.PageResultCommand;
import com.gitee.sunchenbin.mybatis.actable.manager.common.BaseMysqlCRUDManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
public class AppTagController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppTagController.class);

    @Autowired
    private AppTagService appTagService;
    @Autowired
    private AppTagMapper appTagMapper;

    @Autowired
    private BaseMysqlCRUDManager baseMysqlCRUDManager;

    @RequestMapping("/index.html")
    public String index() {
        return "/index";
    }

    @RequestMapping("/testApp.json")
    @ResponseBody
    public Object testapp() {

        AppTag appTag = new AppTag();
        appTag.setAppSecret("1");
        appTag.setPushBizId(DateUtil.format(new Date()));
        appTag.setPushKey(1);

        Integer save = baseMysqlCRUDManager.save(appTag);
        PageResultCommand<AppTag> query = baseMysqlCRUDManager.query(appTag);

        List<AppTag> all = appTagMapper.findAll(appTag);
        List<AppTag> all1 = appTagService.findAll(appTag);

        return "/index";
    }


}
