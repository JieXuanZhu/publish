package cn.com.shukaiken.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.shukaiken.dao.IBackFeedTypeDao;
import cn.com.shukaiken.model.BackFeedType;
import cn.com.shukaiken.service.IBackFeedTypeService;
@Service
public class BackFeedTypeServiceImpl implements IBackFeedTypeService{
	@Resource
	private IBackFeedTypeDao backFeedTypeDao;

	@Override
	public int addBackFeedType(BackFeedType backFeedType) {
	
		return backFeedTypeDao.insert(backFeedType);
	}

	@Override
	public BackFeedType getBackFeedTypeById(int id) {
		return backFeedTypeDao.selectByPrimaryKey(id);
	}

	@Override
	public BackFeedType selectByBackFeedType(BackFeedType backFeedType) {
		return backFeedTypeDao.selectBySelective(backFeedType);
	}

	@Override
	public List<BackFeedType> getBackFeedTypeLs(BackFeedType backFeedType) {
		return backFeedTypeDao.getBackFeedTypeLs(backFeedType);
	}

	@Override
	public int updateByBackFeedTypeId(BackFeedType backFeedType) {
		return backFeedTypeDao.updateByPrimaryKeySelective(backFeedType);
	}

}
