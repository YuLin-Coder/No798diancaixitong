package com.entity.vo;

import com.entity.FendianEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 分店
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @email
 * @date 2021-04-01
 */
@TableName("fendian")
public class FendianVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 分店名称 Search
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
	 * 设置：分店名称 Search
	 */
    public String getName() {
        return name;
    }


    /**
	 * 获取：分店名称 Search
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

}
