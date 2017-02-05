package cn.com.shukaiken.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.shukaiken.dao.IBackFeedDao;
import cn.com.shukaiken.model.BackFeed;
import cn.com.shukaiken.service.IBackFeedService;
@Service
public class IBackFeedServiceImpl implements IBackFeedService {
	@Resource
	private IBackFeedDao backFeedDao;

	@Override
	public int addBackFeed(BackFeed backFeed) {
	
		return backFeedDao.insert(backFeed);
	}

	@Override
	public BackFeed getBackFeedById(int id) {
		return backFeedDao.selectByPrimaryKey(id);
	}

	@Override
	public BackFeed selectByBackFeed(BackFeed backFeed) {
		return backFeedDao.selectBySelective(backFeed);
	}

	@Override
	public List<BackFeed> getBackFeedLs(BackFeed backFeed) {
		return backFeedDao.getBackFeedLs(backFeed);
	}

	@Override
	public int updateByBackFeedId(BackFeed backFeed) {
		return backFeedDao.updateByPrimaryKeySelective(backFeed);
	}

}
