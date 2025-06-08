package com.dao;

import com.entity.DiscusstuijianxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusstuijianxinxiVO;
import com.entity.view.DiscusstuijianxinxiView;


/**
 * 推荐信息评论表
 * 
 * @author 
 * @email 
 * @date 2021-03-11 18:11:06
 */
public interface DiscusstuijianxinxiDao extends BaseMapper<DiscusstuijianxinxiEntity> {
	
	List<DiscusstuijianxinxiVO> selectListVO(@Param("ew") Wrapper<DiscusstuijianxinxiEntity> wrapper);
	
	DiscusstuijianxinxiVO selectVO(@Param("ew") Wrapper<DiscusstuijianxinxiEntity> wrapper);
	
	List<DiscusstuijianxinxiView> selectListView(@Param("ew") Wrapper<DiscusstuijianxinxiEntity> wrapper);

	List<DiscusstuijianxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusstuijianxinxiEntity> wrapper);
	
	DiscusstuijianxinxiView selectView(@Param("ew") Wrapper<DiscusstuijianxinxiEntity> wrapper);
	
}
