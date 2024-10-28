package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.CaipinDao;
import com.entity.CaipinEntity;
import com.service.CaipinService;
import com.entity.view.CaipinView;

/**
 * 菜品表 服务实现类
 * @since 2021-03-08
 */
@Service("caipinService")
@Transactional
public class CaipinServiceImpl extends ServiceImpl<CaipinDao, CaipinEntity> implements CaipinService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<CaipinView> page =new Query<CaipinView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

}
