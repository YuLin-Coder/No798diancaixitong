package com.entity.model;

import com.entity.LiushuiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 流水表
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @email
 * @date 2021-03-08
 */
public class LiushuiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 订单号
     */
    private String odd;


    /**
     * 餐桌名称
     */
    private Integer czTypes;


    /**
     * 预定用户
     */
    private Integer yhTypes;


    /**
     * 是否支付 Search
     */
    private Integer sfTypes;


    /**
     * 总价
     */
    private Double maxMoney;


    /**
     * 支付时间 Search
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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
