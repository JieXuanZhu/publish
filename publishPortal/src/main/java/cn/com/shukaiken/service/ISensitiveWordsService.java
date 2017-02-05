package cn.com.shukaiken.service;

import java.util.List;

import cn.com.shukaiken.model.SensitiveWords;

/**
 * 
 * @author jiexuan.zhu
 * @date   2015-11-13
 *
 */
public interface ISensitiveWordsService {
	
	int addSensitiveWords(SensitiveWords sensitiveWords);
	
	SensitiveWords getSensitiveWordsById(int id);
	
	SensitiveWords selectBySensitiveWords(SensitiveWords sensitiveWords);
	
	List<SensitiveWords> getSensitiveLs(SensitiveWords sensitiveWords);
	
	int updateBySensitiveWordsId(SensitiveWords sensitiveWords);
	

}
