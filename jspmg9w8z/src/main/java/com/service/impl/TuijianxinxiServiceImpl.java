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


import com.dao.TuijianxinxiDao;
import com.entity.TuijianxinxiEntity;
import com.service.TuijianxinxiService;
import com.entity.vo.TuijianxinxiVO;
import com.entity.view.TuijianxinxiView;

@Service("tuijianxinxiService")
public class TuijianxinxiServiceImpl extends ServiceImpl<TuijianxinxiDao, TuijianxinxiEntity> implements TuijianxinxiService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TuijianxinxiEntity> page = this.selectPage(
                new Query<TuijianxinxiEntity>(params).getPage(),
                new EntityWrapper<TuijianxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TuijianxinxiEntity> wrapper) {
		  Page<TuijianxinxiView> page =new Query<TuijianxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<TuijianxinxiVO> selectListVO(Wrapper<TuijianxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public TuijianxinxiVO selectVO(Wrapper<TuijianxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<TuijianxinxiView> selectListView(Wrapper<TuijianxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public TuijianxinxiView selectView(Wrapper<TuijianxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
