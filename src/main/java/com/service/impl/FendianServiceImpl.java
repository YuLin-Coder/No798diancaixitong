package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.FendianDao;
import com.entity.FendianEntity;
import com.service.FendianService;
import com.entity.view.FendianView;

/**
 * 分店 服务实现类
 * @since 2021-04-01
 */
@Service("fendianService")
@Transactional
public class FendianServiceImpl extends ServiceImpl<FendianDao, FendianEntity> implements FendianService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<FendianView> page =new Query<FendianView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

}
