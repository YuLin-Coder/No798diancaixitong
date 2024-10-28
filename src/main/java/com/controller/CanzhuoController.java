package com.controller;

import java.util.*;
import javax.servlet.http.HttpServletRequest;

import com.entity.YudingcanzhuoEntity;
import com.service.YudingcanzhuoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.CanzhuoEntity;

import com.service.CanzhuoService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 餐桌表
 * 后端接口
 * @author
 * @email
 * @date 2021-03-08
*/
@RestController
@Controller
@RequestMapping("/canzhuo")
public class CanzhuoController {
    private static final Logger logger = LoggerFactory.getLogger(CanzhuoController.class);

    @Autowired
    private CanzhuoService canzhuoService;

    @Autowired
    private YudingcanzhuoService yudingcanzhuoService;

    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params){
        logger.debug("Controller:"+this.getClass().getName()+",page方法");
        PageUtils page = canzhuoService.queryPage(params);
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        CanzhuoEntity canzhuo = canzhuoService.selectById(id);
        if(canzhuo!=null){
            return R.ok().put("data", canzhuo);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody CanzhuoEntity canzhuo, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<CanzhuoEntity> queryWrapper = new EntityWrapper<CanzhuoEntity>()
            .eq("name", canzhuo.getName())
            .eq("tableLocation", canzhuo.getTableLocation())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        CanzhuoEntity canzhuoEntity = canzhuoService.selectOne(queryWrapper);
        if(canzhuoEntity==null){
            canzhuo.setSfTypes(2);
            canzhuoService.insert(canzhuo);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody CanzhuoEntity canzhuo, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<CanzhuoEntity> queryWrapper = new EntityWrapper<CanzhuoEntity>()
            .notIn("id",canzhuo.getId())
            .eq("name", canzhuo.getName())
            .eq("tableLocation", canzhuo.getTableLocation())
            .eq("sf_types", canzhuo.getSfTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        CanzhuoEntity canzhuoEntity = canzhuoService.selectOne(queryWrapper);
        if(canzhuoEntity==null){
            canzhuoService.updateById(canzhuo);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        logger.debug("Controller:"+this.getClass().getName()+",delete");
        canzhuoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
    * 预定
    */
    @RequestMapping("/subscribe")
    public R subscribe(Integer ids, HttpServletRequest request){
        CanzhuoEntity canzhuoEntity = canzhuoService.selectById(ids);
        if(canzhuoEntity == null){
           return R.error();
        }
        canzhuoEntity.setSfTypes(1);
        canzhuoService.updateById(canzhuoEntity);
        YudingcanzhuoEntity yudingcanzhuoEntity = new YudingcanzhuoEntity();
        yudingcanzhuoEntity.setCreateTime(new Date());
        yudingcanzhuoEntity.setCzTypes(canzhuoEntity.getId());
        yudingcanzhuoEntity.setYhTypes((Integer) request.getSession().getAttribute("userId"));
        yudingcanzhuoService.insert(yudingcanzhuoEntity);
        return R.ok();
    }
}

