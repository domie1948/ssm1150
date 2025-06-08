package com.dao;

import com.entity.TuijianxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.TuijianxinxiVO;
import com.entity.view.TuijianxinxiView;


/**
 * 推荐信息
 * 
 * @author 
 * @email 
 * @date 2021-03-11 18:11:06
 */
public interface TuijianxinxiDao extends BaseMapper<TuijianxinxiEntity> {
	
	List<TuijianxinxiVO> selectListVO(@Param("ew") Wrapper<TuijianxinxiEntity> wrapper);
	
	TuijianxinxiVO selectVO(@Param("ew") Wrapper<TuijianxinxiEntity> wrapper);
	
	List<TuijianxinxiView> selectListView(@Param("ew") Wrapper<TuijianxinxiEntity> wrapper);

	List<TuijianxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<TuijianxinxiEntity> wrapper);
	
	TuijianxinxiView selectView(@Param("ew") Wrapper<TuijianxinxiEntity> wrapper);
	
}
