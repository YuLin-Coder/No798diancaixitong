package com.entity.vo;

import com.entity.LiushuiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 流水表
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @email
 * @date 2021-03-08
 */
@TableName("liushui")
public class LiushuiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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
     * 是否支付 Search
     */

    @TableField(value = "sf_types")
    private Integer sfTypes;


    /**
     * 总价
     */

    @TableField(value = "maxMoney")
    private Double maxMoney;


    /**
     * 支付时间 Search
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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
	 * 设置：是否支付 Search
	 */
    public Integer getSfTypes() {
        return sfTypes;
    }


    /**
	 * 获取：是否支付 Search
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
	 * 设置：支付时间 Search
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：支付时间 Search
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
