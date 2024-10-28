package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;

import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 菜品表
 *
 * @email
 * @date 2021-03-08
 */
@TableName("caipin")
public class CaipinEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


    public CaipinEntity() {

    }

    public CaipinEntity(T t) {
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
     * 菜品名称
     */
    @TableField(value = "hx_types")

    private Integer hxTypes;
    /**
     * 菜品名称
     */
    @TableField(value = "clicknum")

    private Integer clicknum;

    public Integer getClicknum() {
        return clicknum;
    }

    public void setClicknum(Integer clicknum) {
        this.clicknum = clicknum;
    }

    /**
     * 菜品单价
     */
    @TableField(value = "money")

    private Double money;


    /**
     * 菜品图片
     */
    @TableField(value = "img_photo")

    private String imgPhoto;


    /**
     * 菜品描述
     */
    @TableField(value = "caipin_content")

    private String caipinContent;


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
	 * 设置：菜品单价
	 */
    public Double getMoney() {
        return money;
    }


    /**
	 * 获取：菜品单价
	 */

    public void setMoney(Double money) {
        this.money = money;
    }
    /**
	 * 设置：菜品图片
	 */
    public String getImgPhoto() {
        return imgPhoto;
    }


    /**
	 * 获取：菜品图片
	 */

    public void setImgPhoto(String imgPhoto) {
        this.imgPhoto = imgPhoto;
    }
    /**
	 * 设置：菜品描述
	 */
    public String getCaipinContent() {
        return caipinContent;
    }


    /**
	 * 获取：菜品描述
	 */

    public void setCaipinContent(String caipinContent) {
        this.caipinContent = caipinContent;
    }

    @Override
    public String toString() {
    return "Caipin{" +
            "id=" + id +
            ", hxTypes=" + hxTypes +
            ", money=" + money +
            ", imgPhoto=" + imgPhoto +
            ", caipinContent=" + caipinContent +
    "}";
    }
    }
