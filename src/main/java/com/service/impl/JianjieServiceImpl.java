package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.JianjieDao;
import com.entity.JianjieEntity;
import com.service.JianjieService;
import com.entity.view.JianjieView;

/**
 * 简介 服务实现类
 * @since 2021-04-01
 */
@Service("jianjieService")
@Transactional
public class JianjieServiceImpl extends ServiceImpl<JianjieDao, JianjieEntity> implements JianjieService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<JianjieView> page =new Query<JianjieView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

}
