package com.cxd.xiaonuan.service.impl;

import com.cxd.xiaonuan.bean.AppTag;
import com.cxd.xiaonuan.mapper.AppTagMapper;
import com.cxd.xiaonuan.service.AppTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("appTagService")
public class AppTagServiceImpl implements AppTagService {

    @Autowired
    private AppTagMapper appTagMapper;

    @Override
    public List<AppTag> findAll(AppTag appTag) {
        return appTagMapper.findAll(appTag);
    }
}
