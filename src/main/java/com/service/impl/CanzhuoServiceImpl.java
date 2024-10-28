package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.CanzhuoDao;
import com.entity.CanzhuoEntity;
import com.service.CanzhuoService;
import com.entity.view.CanzhuoView;

/**
 * 餐桌表 服务实现类
 * @since 2021-03-08
 */
@Service("canzhuoService")
@Transactional
public class CanzhuoServiceImpl extends ServiceImpl<CanzhuoDao, CanzhuoEntity> implements CanzhuoService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<CanzhuoView> page =new Query<CanzhuoView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

}
