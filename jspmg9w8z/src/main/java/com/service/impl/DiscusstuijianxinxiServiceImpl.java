package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.DiscusstuijianxinxiDao;
import com.entity.DiscusstuijianxinxiEntity;
import com.service.DiscusstuijianxinxiService;
import com.entity.vo.DiscusstuijianxinxiVO;
import com.entity.view.DiscusstuijianxinxiView;

@Service("discusstuijianxinxiService")
public class DiscusstuijianxinxiServiceImpl extends ServiceImpl<DiscusstuijianxinxiDao, DiscusstuijianxinxiEntity> implements DiscusstuijianxinxiService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusstuijianxinxiEntity> page = this.selectPage(
                new Query<DiscusstuijianxinxiEntity>(params).getPage(),
                new EntityWrapper<DiscusstuijianxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusstuijianxinxiEntity> wrapper) {
		  Page<DiscusstuijianxinxiView> page =new Query<DiscusstuijianxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscusstuijianxinxiVO> selectListVO(Wrapper<DiscusstuijianxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusstuijianxinxiVO selectVO(Wrapper<DiscusstuijianxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusstuijianxinxiView> selectListView(Wrapper<DiscusstuijianxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusstuijianxinxiView selectView(Wrapper<DiscusstuijianxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
