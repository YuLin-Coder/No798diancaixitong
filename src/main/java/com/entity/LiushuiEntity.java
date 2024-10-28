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
 * 流水表
 *
 * @email
 * @date 2021-03-08
 */
@TableName("liushui")
public class LiushuiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


    public LiushuiEntity() {

    }

    public LiushuiEntity(T t) {
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
     * 餐桌名称
     */
    @TableField(value = "cz_types")

    private Integer czTypes;


    /**
     * 预定用户
     */
    @TableField(value = "yh_types")

    private Integer yhTypes;


    /**
     * 是否支付
     */
    @TableField(value = "sf_types")

    private Integer sfTypes;


    /**
     * 总价
     */
    @TableField(value = "maxMoney")

    private Double maxMoney;


    /**
     * 支付时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


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
	 * 设置：餐桌名称
	 */
    public Integer getCzTypes() {
        return czTypes;
    }


    /**
	 * 获取：餐桌名称
	 */

    public void setCzTypes(Integer czTypes) {
        this.czTypes = czTypes;
    }
    /**
	 * 设置：预定用户
	 */
    public Integer getYhTypes() {
        return yhTypes;
    }


    /**
	 * 获取：预定用户
	 */

    public void setYhTypes(Integer yhTypes) {
        this.yhTypes = yhTypes;
    }
    /**
	 * 设置：是否支付
	 */
    public Integer getSfTypes() {
        return sfTypes;
    }


    /**
	 * 获取：是否支付
	 */

    public void setSfTypes(Integer sfTypes) {
        this.sfTypes = sfTypes;
    }
    /**
	 * 设置：总价
	 */
    public Double getMaxMoney() {
        return maxMoney;
    }


    /**
	 * 获取：总价
	 */

    public void setMaxMoney(Double maxMoney) {
        this.maxMoney = maxMoney;
    }
    /**
	 * 设置：支付时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：支付时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
    return "Liushui{" +
            "id=" + id +
            ", odd=" + odd +
            ", czTypes=" + czTypes +
            ", yhTypes=" + yhTypes +
            ", sfTypes=" + sfTypes +
            ", maxMoney=" + maxMoney +
            ", createTime=" + createTime +
    "}";
    }

}
