package cn.com.shukaiken.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.shukaiken.dao.ISearchWordsDao;
import cn.com.shukaiken.model.SearchWords;
import cn.com.shukaiken.service.ISearchWordsService;

/**
 * 
 * @author jiexuan.zhu
 * @date 2015-11-17
 *
 */
@Service
public class SearchWordsServiceImpl implements ISearchWordsService {
	
	@Resource
	private ISearchWordsDao searchWordsDao;

	@Override
	public int addSearchWords(SearchWords searchWords) {
		return searchWordsDao.insert(searchWords);
	}

	@Override
	public SearchWords getSearchWordsById(int id) {
		return searchWordsDao.selectByPrimaryKey(id);
	}

	@Override
	public SearchWords selectBySearchWords(SearchWords searchWords) {
		
		return searchWordsDao.selectBySelective(searchWords);
	}

	@Override
	public List<SearchWords> getSearchWordsLs(SearchWords searchWords) {
		
		return searchWordsDao.getSearchWordsLs(searchWords);
	}

	@Override
	public int updateBySearchWordsId(SearchWords searchWords) {
	
		return searchWordsDao.updateByPrimaryKeySelective(searchWords);
	}

}
