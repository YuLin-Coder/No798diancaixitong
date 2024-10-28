package com.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
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

import com.entity.KuchuenEntity;

import com.service.KuchuenService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 库存表
 * 后端接口
 * @author
 * @email
 * @date 2021-03-08
*/
@RestController
@Controller
@RequestMapping("/kuchuen")
public class KuchuenController {
    private static final Logger logger = LoggerFactory.getLogger(KuchuenController.class);

    @Autowired
    private KuchuenService kuchuenService;

    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params){
        logger.debug("Controller:"+this.getClass().getName()+",page方法");
        PageUtils page = kuchuenService.queryPage(params);
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        KuchuenEntity kuchuen = kuchuenService.selectById(id);
        if(kuchuen!=null){
            return R.ok().put("data", kuchuen);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody KuchuenEntity kuchuen, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<KuchuenEntity> queryWrapper = new EntityWrapper<KuchuenEntity>()
            .eq("name", kuchuen.getName())
            .eq("number", kuchuen.getNumber())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KuchuenEntity kuchuenEntity = kuchuenService.selectOne(queryWrapper);
        if(kuchuenEntity==null){
            kuchuenService.insert(kuchuen);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody KuchuenEntity kuchuen, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<KuchuenEntity> queryWrapper = new EntityWrapper<KuchuenEntity>()
            .notIn("id",kuchuen.getId())
            .eq("name", kuchuen.getName())
            .eq("number", kuchuen.getNumber())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KuchuenEntity kuchuenEntity = kuchuenService.selectOne(queryWrapper);
        if(kuchuenEntity==null){
            kuchuenService.updateById(kuchuen);//根据id更新
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
        kuchuenService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}

