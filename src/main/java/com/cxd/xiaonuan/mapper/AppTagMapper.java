package com.cxd.xiaonuan.mapper;


import com.cxd.xiaonuan.bean.AppTag;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppTagMapper {

    List<AppTag> findAll(AppTag appTag);

}
