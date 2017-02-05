package cn.com.shukaiken.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.shukaiken.dao.ISensitiveWordsDao;
import cn.com.shukaiken.model.SensitiveWords;
import cn.com.shukaiken.service.ISensitiveWordsService;
/**
 * 
 * @author jiexuan.zhu
 * @date   2015-11-13
 *
 */
@Service
public class SensitiveWordsServiceImpl implements ISensitiveWordsService{
	
	@Resource
	private ISensitiveWordsDao sensitiveWordsDao;

	@Override
	public List<SensitiveWords> getSensitiveLs(SensitiveWords sensitiveWords) {
		return sensitiveWordsDao.getSensitiveLs(sensitiveWords);
	}

	@Override
	public SensitiveWords getSensitiveWordsById(int id) {
		return sensitiveWordsDao.selectByPrimaryKey(id);
	}

	@Override
	public int addSensitiveWords(SensitiveWords sensitiveWords) {
		return sensitiveWordsDao.insert(sensitiveWords);
	}

	@Override
	public int updateBySensitiveWordsId(SensitiveWords sensitiveWords) {
		return sensitiveWordsDao.updateByPrimaryKeySelective(sensitiveWords);
	}

	@Override
	public SensitiveWords selectBySensitiveWords(SensitiveWords sensitiveWords) {
		
		return sensitiveWordsDao.selectBySelective(sensitiveWords);
	}
	
	

}
