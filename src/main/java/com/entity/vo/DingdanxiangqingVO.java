package com.entity.vo;

import com.entity.DingdanxiangqingEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 订单详情
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @email
 * @date 2021-03-09
 */
@TableName("dingdanxiangqing")
public class DingdanxiangqingVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 订单号 Search
     */

    @TableField(value = "odd")
    private String odd;


    /**
     * 菜品名称
     */

    @TableField(value = "hx_types")
    private Integer hxTypes;


    /**
     * 数量 Search
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
