package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.TuijianxinxiEntity;
import com.entity.view.TuijianxinxiView;

import com.service.TuijianxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 推荐信息
 * 后端接口
 * @author 
 * @email 
 * @date 2021-03-11 18:11:06
 */
@RestController
@RequestMapping("/tuijianxinxi")
public class TuijianxinxiController {
    @Autowired
    private TuijianxinxiService tuijianxinxiService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,TuijianxinxiEntity tuijianxinxi, 
		HttpServletRequest request){

        EntityWrapper<TuijianxinxiEntity> ew = new EntityWrapper<TuijianxinxiEntity>();
    	PageUtils page = tuijianxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tuijianxinxi), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,TuijianxinxiEntity tuijianxinxi, HttpServletRequest request){
        EntityWrapper<TuijianxinxiEntity> ew = new EntityWrapper<TuijianxinxiEntity>();
    	PageUtils page = tuijianxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tuijianxinxi), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( TuijianxinxiEntity tuijianxinxi){
       	EntityWrapper<TuijianxinxiEntity> ew = new EntityWrapper<TuijianxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( tuijianxinxi, "tuijianxinxi")); 
        return R.ok().put("data", tuijianxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(TuijianxinxiEntity tuijianxinxi){
        EntityWrapper< TuijianxinxiEntity> ew = new EntityWrapper< TuijianxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( tuijianxinxi, "tuijianxinxi")); 
		TuijianxinxiView tuijianxinxiView =  tuijianxinxiService.selectView(ew);
		return R.ok("查询推荐信息成功").put("data", tuijianxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        TuijianxinxiEntity tuijianxinxi = tuijianxinxiService.selectById(id);
        return R.ok().put("data", tuijianxinxi);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        TuijianxinxiEntity tuijianxinxi = tuijianxinxiService.selectById(id);
        return R.ok().put("data", tuijianxinxi);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        TuijianxinxiEntity tuijianxinxi = tuijianxinxiService.selectById(id);
        if(type.equals("1")) {
        	tuijianxinxi.setThumbsupnum(tuijianxinxi.getThumbsupnum()+1);
        } else {
        	tuijianxinxi.setCrazilynum(tuijianxinxi.getCrazilynum()+1);
        }
        tuijianxinxiService.updateById(tuijianxinxi);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody TuijianxinxiEntity tuijianxinxi, HttpServletRequest request){
    	tuijianxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(tuijianxinxi);

        tuijianxinxiService.insert(tuijianxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
	@IgnoreAuth
    @RequestMapping("/add")
    public R add(@RequestBody TuijianxinxiEntity tuijianxinxi, HttpServletRequest request){
    	tuijianxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(tuijianxinxi);

        tuijianxinxiService.insert(tuijianxinxi);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody TuijianxinxiEntity tuijianxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(tuijianxinxi);
        tuijianxinxiService.updateById(tuijianxinxi);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        tuijianxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<TuijianxinxiEntity> wrapper = new EntityWrapper<TuijianxinxiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = tuijianxinxiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	


}
