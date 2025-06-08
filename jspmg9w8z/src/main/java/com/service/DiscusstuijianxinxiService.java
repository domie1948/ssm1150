package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusstuijianxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusstuijianxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusstuijianxinxiView;


/**
 * 推荐信息评论表
 *
 * @author 
 * @email 
 * @date 2021-03-11 18:11:06
 */
public interface DiscusstuijianxinxiService extends IService<DiscusstuijianxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusstuijianxinxiVO> selectListVO(Wrapper<DiscusstuijianxinxiEntity> wrapper);
   	
   	DiscusstuijianxinxiVO selectVO(@Param("ew") Wrapper<DiscusstuijianxinxiEntity> wrapper);
   	
   	List<DiscusstuijianxinxiView> selectListView(Wrapper<DiscusstuijianxinxiEntity> wrapper);
   	
   	DiscusstuijianxinxiView selectView(@Param("ew") Wrapper<DiscusstuijianxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusstuijianxinxiEntity> wrapper);
   	
}

