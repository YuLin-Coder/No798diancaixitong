package com.entity.model;

import com.entity.DingdanxiangqingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 订单详情
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @email
 * @date 2021-03-09
 */
public class DingdanxiangqingModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 订单号 Search
     */
    private String odd;


    /**
     * 菜品名称
     */
    private Integer hxTypes;


    /**
     * 数量 Search
     */
    private Integer number;


    /**
     * 单价
     */
    private Double money;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：订单号 Search
	 */
    public String getOdd() {
        return odd;
    }


    /**
	 * 获取：订单号 Search
	 */

    public void setOdd(String odd) {
        this.odd = odd;
    }
    /**
	 * 设置：菜品名称
	 */
    public Integer getHxTypes() {
        return hxTypes;
    }


    /**
	 * 获取：菜品名称
	 */

    public void setHxTypes(Integer hxTypes) {
        this.hxTypes = hxTypes;
    }
    /**
	 * 设置：数量 Search
	 */
    public Integer getNumber() {
        return number;
    }


    /**
	 * 获取：数量 Search
	 */

    public void setNumber(Integer number) {
        this.number = number;
    }
    /**
	 * 设置：单价
	 */
    public Double getMoney() {
        return money;
    }


    /**
	 * 获取：单价
	 */

    public void setMoney(Double money) {
        this.money = money;
    }

    }
