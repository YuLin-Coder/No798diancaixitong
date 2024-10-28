package com.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

import com.entity.CanzhuoEntity;
import com.service.CanzhuoService;
import com.service.YudingcanzhuoService;
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

import com.entity.LiushuiEntity;

import com.service.LiushuiService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 流水表
 * 后端接口
 * @author
 * @email
 * @date 2021-03-08
*/
@RestController
@Controller
@RequestMapping("/liushui")
public class LiushuiController {
    private static final Logger logger = LoggerFactory.getLogger(LiushuiController.class);

    @Autowired
    private LiushuiService liushuiService;

    @Autowired
    private CanzhuoService canzhuoService;

    @Autowired
    private YudingcanzhuoService yudingcanzhuoService;

    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",page方法");
        PageUtils page = null;
        if(!request.getSession().getAttribute("role").equals("管理员")){
            params.put("yh",request.getSession().getAttribute("userId"));
            page = liushuiService.queryPage(params);
        }else{
            page = liushuiService.queryPage(params);
        }
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        LiushuiEntity liushui = liushuiService.selectById(id);
        if(liushui!=null){
            return R.ok().put("data", liushui);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody LiushuiEntity liushui, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<LiushuiEntity> queryWrapper = new EntityWrapper<LiushuiEntity>()
            .eq("odd", liushui.getOdd())
            .eq("cz_types", liushui.getCzTypes())
            .eq("yh_types", liushui.getYhTypes())
            .eq("sf_types", liushui.getSfTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        LiushuiEntity liushuiEntity = liushuiService.selectOne(queryWrapper);
        if(liushuiEntity==null){
            liushuiService.insert(liushui);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody LiushuiEntity liushui, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<LiushuiEntity> queryWrapper = new EntityWrapper<LiushuiEntity>()
            .notIn("id",liushui.getId())
            .eq("odd", liushui.getOdd())
            .eq("cz_types", liushui.getCzTypes())
            .eq("yh_types", liushui.getYhTypes())
            .eq("sf_types", liushui.getSfTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        LiushuiEntity liushuiEntity = liushuiService.selectOne(queryWrapper);
        if(liushuiEntity==null){
            liushuiService.updateById(liushui);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 删除
    */
    @RequestMapping("/gaiwei")
    public R gaiwei(Integer ids){
        LiushuiEntity liushuiEntity = liushuiService.selectById(ids);
        if(liushuiEntity.getSfTypes() == 1){
            return R.error("这个订单已经支付过了，请不要重复支付");
        }
        if(liushuiEntity== null){
            return  R.error();
        }
        CanzhuoEntity canzhuoEntity = canzhuoService.selectById(liushuiEntity.getCzTypes());
        if(canzhuoEntity ==null){
            return R.error();
        }
        liushuiEntity.setSfTypes(1);
        canzhuoEntity.setSfTypes(2);
        yudingcanzhuoService.delete(new EntityWrapper().eq("cz_types",canzhuoEntity.getId()));
        canzhuoService.updateById(canzhuoEntity);
        liushuiService.updateById(liushuiEntity);
        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        logger.debug("Controller:"+this.getClass().getName()+",delete");
        liushuiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}

