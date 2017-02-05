package cn.com.shukaiken.service;

import java.util.List;

import cn.com.shukaiken.model.BackFeed;
/**
 * @author jiexuan.zhu
 * @date 2015-11-22
 * 
 */
public interface IBackFeedService {
	
	int addBackFeed(BackFeed backFeed);
	
	BackFeed getBackFeedById(int id);
	
	BackFeed selectByBackFeed(BackFeed backFeed);
	
	List<BackFeed> getBackFeedLs(BackFeed backFeed);
	
	int updateByBackFeedId(BackFeed backFeed);
	
}
