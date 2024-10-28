package com.entity.model;

import com.entity.FendianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 分店
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @email
 * @date 2021-04-01
 */
public class FendianModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 分店名称 Search
     */
    private String name;


    /**
     * 分店图片
     */
    private String imgPhoto;


    /**
     * 分店地址
     */
    private String dizhi;


    /**
     * 店长
     */
    private String dianzhang;


    /**
     * 电话
     */
    private String phoen;


    /**
     * 创建时间
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
