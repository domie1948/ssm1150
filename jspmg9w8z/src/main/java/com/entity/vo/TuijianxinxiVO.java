package com.entity.vo;

import com.entity.TuijianxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
 

/**
 * 推荐信息
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2021-03-11 18:11:06
 */
public class TuijianxinxiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 歌曲名称
	 */
	
	private String gequmingcheng;
		
	/**
	 * 歌曲类别
	 */
	
	private String gequleibie;
		
	/**
	 * 歌手
	 */
	
	private String geshou;
		
	/**
	 * 歌曲
	 */
	
	private String gequ;
		
	/**
	 * 账号
	 */
	
	private String zhanghao;
		
	/**
	 * 相关图片
	 */
	
	private String xiangguantupian;
		
	/**
	 * 姓名
	 */
	
	private String xingming;
		
	/**
	 * 推荐理由
	 */
	
	private String tuijianliyou;
		
	/**
	 * 推荐日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date tuijianriqi;
		
	/**
	 * 赞
	 */
	
	private Integer thumbsupnum;
		
	/**
	 * 踩
	 */
	
	private Integer crazilynum;
				
	
	/**
	 * 设置：歌曲名称
	 */
	 
	public void setGequmingcheng(String gequmingcheng) {
		this.gequmingcheng = gequmingcheng;
	}
	
	/**
	 * 获取：歌曲名称
	 */
	public String getGequmingcheng() {
		return gequmingcheng;
	}
				
	
	/**
	 * 设置：歌曲类别
	 */
	 
	public void setGequleibie(String gequleibie) {
		this.gequleibie = gequleibie;
	}
	
	/**
	 * 获取：歌曲类别
	 */
	public String getGequleibie() {
		return gequleibie;
	}
				
	
	/**
	 * 设置：歌手
	 */
	 
	public void setGeshou(String geshou) {
		this.geshou = geshou;
	}
	
	/**
	 * 获取：歌手
	 */
	public String getGeshou() {
		return geshou;
	}
				
	
	/**
	 * 设置：歌曲
	 */
	 
	public void setGequ(String gequ) {
		this.gequ = gequ;
	}
	
	/**
	 * 获取：歌曲
	 */
	public String getGequ() {
		return gequ;
	}
				
	
	/**
	 * 设置：账号
	 */
	 
	public void setZhanghao(String zhanghao) {
		this.zhanghao = zhanghao;
	}
	
	/**
	 * 获取：账号
	 */
	public String getZhanghao() {
		return zhanghao;
	}
				
	
	/**
	 * 设置：相关图片
	 */
	 
	public void setXiangguantupian(String xiangguantupian) {
		this.xiangguantupian = xiangguantupian;
	}
	
	/**
	 * 获取：相关图片
	 */
	public String getXiangguantupian() {
		return xiangguantupian;
	}
				
	
	/**
	 * 设置：姓名
	 */
	 
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	
	/**
	 * 获取：姓名
	 */
	public String getXingming() {
		return xingming;
	}
				
	
	/**
	 * 设置：推荐理由
	 */
	 
	public void setTuijianliyou(String tuijianliyou) {
		this.tuijianliyou = tuijianliyou;
	}
	
	/**
	 * 获取：推荐理由
	 */
	public String getTuijianliyou() {
		return tuijianliyou;
	}
				
	
	/**
	 * 设置：推荐日期
	 */
	 
	public void setTuijianriqi(Date tuijianriqi) {
		this.tuijianriqi = tuijianriqi;
	}
	
	/**
	 * 获取：推荐日期
	 */
	public Date getTuijianriqi() {
		return tuijianriqi;
	}
				
	
	/**
	 * 设置：赞
	 */
	 
	public void setThumbsupnum(Integer thumbsupnum) {
		this.thumbsupnum = thumbsupnum;
	}
	
	/**
	 * 获取：赞
	 */
	public Integer getThumbsupnum() {
		return thumbsupnum;
	}
				
	
	/**
	 * 设置：踩
	 */
	 
	public void setCrazilynum(Integer crazilynum) {
		this.crazilynum = crazilynum;
	}
	
	/**
	 * 获取：踩
	 */
	public Integer getCrazilynum() {
		return crazilynum;
	}
			
}
