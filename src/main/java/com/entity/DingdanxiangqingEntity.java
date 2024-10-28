package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 订单详情
 *
 * @email
 * @date 2021-03-09
 */
@TableName("dingdanxiangqing")
public class DingdanxiangqingEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


    public DingdanxiangqingEntity() {

    }

    public DingdanxiangqingEntity(T t) {
    try {
    BeanUtils.copyProperties(this, t);
    } catch (IllegalAccessException | InvocationTargetException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
    }
    }


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 订单号
     */
    @TableField(value = "odd")

    private String odd;


    /**
     * 菜品名称
     */
    @TableField(value = "hx_types")

    private Integer hxTypes;


    /**
     * 数量
     */
    @TableField(value = "number")

    private Integer number;


    /**
     * 单价
     */
    @TableField(value = "money")

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
	 * 设置：订单号
	 */
    public String getOdd() {
        return odd;
    }


    /**
	 * 获取：订单号
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
	 * 设置：数量
	 */
    public Integer getNumber() {
        return number;
    }


    /**
	 * 获取：数量
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

    @Override
    public String toString() {
    return "Dingdanxiangqing{" +
            "id=" + id +
            ", odd=" + odd +
            ", hxTypes=" + hxTypes +
            ", number=" + number +
            ", money=" + money +
    "}";
    }
    }
