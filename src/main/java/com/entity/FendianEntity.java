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
 * 分店
 *
 * @email
 * @date 2021-04-01
 */
@TableName("fendian")
public class FendianEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


    public FendianEntity() {

    }

    public FendianEntity(T t) {
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
     * 分店名称
     */
    @TableField(value = "name")

    private String name;


    /**
     * 分店图片
     */
    @TableField(value = "img_photo")

    private String imgPhoto;


    /**
     * 分店地址
     */
    @TableField(value = "dizhi")

    private String dizhi;


    /**
     * 店长
     */
    @TableField(value = "dianzhang")

    private String dianzhang;


    /**
     * 电话
     */
    @TableField(value = "phoen")

    private String phoen;


    /**
     * 创建时间
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
	 * 设置：分店名称
	 */
    public String getName() {
        return name;
    }


    /**
	 * 获取：分店名称
	 */

    public void setName(String name) {
        this.name = name;
    }
    /**
	 * 设置：分店图片
	 */
    public String getImgPhoto() {
        return imgPhoto;
    }


    /**
	 * 获取：分店图片
	 */

    public void setImgPhoto(String imgPhoto) {
        this.imgPhoto = imgPhoto;
    }
    /**
	 * 设置：分店地址
	 */
    public String getDizhi() {
        return dizhi;
    }


    /**
	 * 获取：分店地址
	 */

    public void setDizhi(String dizhi) {
        this.dizhi = dizhi;
    }
    /**
	 * 设置：店长
	 */
    public String getDianzhang() {
        return dianzhang;
    }


    /**
	 * 获取：店长
	 */

    public void setDianzhang(String dianzhang) {
        this.dianzhang = dianzhang;
    }
    /**
	 * 设置：电话
	 */
    public String getPhoen() {
        return phoen;
    }


    /**
	 * 获取：电话
	 */

    public void setPhoen(String phoen) {
        this.phoen = phoen;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
    return "Fendian{" +
            "id=" + id +
            ", name=" + name +
            ", imgPhoto=" + imgPhoto +
            ", dizhi=" + dizhi +
            ", dianzhang=" + dianzhang +
            ", phoen=" + phoen +
            ", createTime=" + createTime +
    "}";
    }
    }
