package com.controller;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

import com.entity.*;
import com.entity.view.CaipinView;
import com.service.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.utils.PageUtils;
import com.utils.R;

/**
 * 菜品表
 * 后端接口
 * @author
 * @email
 * @date 2021-03-08
*/
@RestController
@Controller
@RequestMapping("/caipin")
public class CaipinController {
    private static final Logger logger = LoggerFactory.getLogger(CaipinController.class);

    @Autowired
    private CaipinService caipinService;

    @Autowired
    private KuchuenService kuchuenService;

    @Autowired
    private LiushuiService liushuiService;


    @Autowired
    private YudingcanzhuoService yudingcanzhuoService;

    @Autowired
    private DingdanxiangqingService dingdanxiangqingService;

    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params){
        logger.debug("Controller:"+this.getClass().getName()+",page方法");
        PageUtils page = caipinService.queryPage(params);
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        CaipinEntity caipin = caipinService.selectById(id);
        if(caipin!=null){
            CaipinView caipinView = new CaipinView();
            BeanUtils.copyProperties(caipin, caipinView);
            KuchuenEntity kuchuenEntity = kuchuenService.selectById(caipin.getHxTypes());
            BeanUtils.copyProperties(kuchuenEntity, caipinView ,new String[]{ "id", "createDate"});
            return R.ok().put("data", caipinView);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody CaipinEntity caipin, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<CaipinEntity> queryWrapper = new EntityWrapper<CaipinEntity>()
            .eq("hx_types", caipin.getHxTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        CaipinEntity caipinEntity = caipinService.selectOne(queryWrapper);
        if("".equals(caipin.getImgPhoto()) || "null".equals(caipin.getImgPhoto())){
            caipin.setImgPhoto(null);
        }
        if(caipinEntity==null){
            caipinService.insert(caipin);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody CaipinEntity caipin, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<CaipinEntity> queryWrapper = new EntityWrapper<CaipinEntity>()
            .notIn("id",caipin.getId())
            .eq("hx_types", caipin.getHxTypes())
            .eq("money", caipin.getMoney())
            .eq("caipin_content", caipin.getCaipinContent())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        CaipinEntity caipinEntity = caipinService.selectOne(queryWrapper);
        if("".equals(caipin.getImgPhoto()) || "null".equals(caipin.getImgPhoto())){
                caipin.setImgPhoto(null);
        }
        if(caipinEntity==null){
            caipinService.updateById(caipin);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 删除
    */
    @RequestMapping("/diancai")
    public R diancai(@RequestParam Map<String, Object> params, HttpServletRequest request){
        if(params.size() == 0){
            return R.error("请选择要购买的菜品");
        }
        //获取系统当前时间的时间戳作为订单号
        long danhao = new Date().getTime();
        //new 一个订单详情表
        DingdanxiangqingEntity dingdanxiangqing = new DingdanxiangqingEntity();
        //new 一个流水表
        LiushuiEntity liushui = new LiushuiEntity();
        //循环前端传过来的key
            for (String id: params.keySet()) {
                //根据前端传来的key（id）查询数据
                CaipinEntity caipin = caipinService.selectOne(new EntityWrapper<CaipinEntity>().eq("hx_types",id));
                //判断查出来的数据是否为空
                if(caipin == null){
                    //为空返回前台
                    return R.error();
                }
                //判断前端传来的菜品数量是否为空或者小于0
                if(StringUtils.isBlank((String)params.get(id)) || Integer.parseInt(String.valueOf(params.get(id))) <= 0){
                    return R.error("您选择的菜品数量不能小于0哦");
                }

                //根据前台传来的key（id）去库存表中查询数据
                KuchuenEntity kuchuenEntity = kuchuenService.selectById(id);
                //如果为空返回前台
                if(kuchuenEntity == null){
                    return R.error("这件菜品菜品不存在于库存");
                }
                //把map中的值转为Integger
                Integer zhi = Integer.parseInt(String.valueOf(kuchuenEntity.getId()));
                //根据当前登录人的id去已预约的餐桌信息表中查询数据
                YudingcanzhuoEntity yudingcanzhuo = yudingcanzhuoService.selectOne(new EntityWrapper().eq("yh_types", request.getSession().getAttribute("userId")));
                //如果为空就返回前端
                if(yudingcanzhuo == null){
                    return R.error("请先预定餐桌后再预定菜品，以免餐桌不足");
                }
                //如果为空就返回前端
                if(yudingcanzhuo.getCzTypes() == null){
                    return R.error("请先预定餐桌后再预定菜品，以免餐桌不足");
                }

                //判断库存中的菜品数量是否大于用户购买的数量
                if(kuchuenEntity.getNumber() < Integer.parseInt(String.valueOf(params.get(String.valueOf(zhi))))){
                    //库存小于是返回并提示
                    return R.error(kuchuenEntity.getName()+" 库存只剩："+kuchuenEntity.getNumber()+" 个，不足："+ params.get(id)+" 个！！！");
                }

                //订单详情中添加进用户购买数量
                dingdanxiangqing.setNumber(zhi);
                //在订单详情表中存入生成的订单号
                dingdanxiangqing.setOdd(String.valueOf(danhao));
                //在订单详情表中存入菜品信息
                dingdanxiangqing.setHxTypes(caipin.getHxTypes());
                //订单详情表中存入菜品价格
                dingdanxiangqing.setMoney(caipin.getMoney());
                //新增订单详情信息
                dingdanxiangqingService.insert(dingdanxiangqing);


                //给流水表中的总价赋值为0
                liushui.setMaxMoney(0.0);
                //获取系统当前时间
                liushui.setCreateTime(new Date());
                //设置上面生成的订单号
                liushui.setOdd(String.valueOf(danhao));
                //在流水表存入中查出来的餐桌信息
                liushui.setCzTypes(yudingcanzhuo.getCzTypes());
                //在流水表存入当前登录用户的信息
                liushui.setYhTypes((Integer) request.getSession().getAttribute("userId"));
                //设置为未支付
                liushui.setSfTypes(2);
                //计算总价
                liushui.setMaxMoney(liushui.getMaxMoney()+(dingdanxiangqing.getMoney()*dingdanxiangqing.getNumber()));

                //库存数量减去用户购买数量
                int i = kuchuenEntity.getNumber() - zhi;
                //将库存数量更新
                kuchuenEntity.setNumber(i);
                //修改库存数量
                kuchuenService.updateById(kuchuenEntity);
            }
        //新增流水信息
        liushuiService.insert(liushui);
        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        logger.debug("Controller:"+this.getClass().getName()+",delete");
        caipinService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}

