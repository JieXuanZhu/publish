/**
 * @Title: InfoSearchWordServiceImpl.java 
* @Package cn.com.shukaiken.service.impl 
* @Description: <p>TODO</p> 
* @author zhaox   
* @date 2015年11月22日 下午3:54:20 
* @version V1.0 
 */
package cn.com.shukaiken.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.shukaiken.dao.InfoSerarchWordDao;
import cn.com.shukaiken.dao.InfoWordRelDao;
import cn.com.shukaiken.model.InfoSearchWord;
import cn.com.shukaiken.model.InfoWordRel;
import cn.com.shukaiken.service.IInfoSearchWordService;
import cn.com.shukaiken.util.Constant;
import cn.com.shukaiken.util.PinyinUtil;
import cn.com.shukaiken.util.ValidateUtils;

/**
 * @ClassName: InfoSearchWordServiceImpl 
 * @Description: <p>TODO</p>
 * @date 2015年11月22日 下午3:54:20 
 * @author Zhao Xiang
 *
 */
@Service
@Transactional
public class InfoSearchWordServiceImpl implements IInfoSearchWordService {

	Logger logger = LoggerFactory.getLogger(InfoSearchWordServiceImpl.class);
	
	@Autowired
	private InfoSerarchWordDao wordDao;
	@Autowired
	private InfoWordRelDao relDao;
		
	/* (non-Javadoc)
	 * <p>Title: addNewWord</p> 
	 * <p>Description:返回新增的关联的行数 </p> 
	 * @param word
	 * @param infoId
	 * @return 
	 * @see cn.com.shukaiken.service.IInfoSearchWordService#addNewWord(cn.com.shukaiken.model.InfoSearchWord, java.lang.Integer) 
	 */
	@Override
	
	public int addNewWord(InfoSearchWord word,Integer infoId) {
		int result = 0;
		if(!ValidateUtils.isEmpty(word.getWord())){
			List<InfoSearchWord> words = wordDao.selectByWord(word);
			if(words!=null&&words.size()>0){
				InfoSearchWord exWord = words.get(0);
				InfoWordRel wordRel = new InfoWordRel();
				wordRel.setInfoId(infoId);
				wordRel.setWordId(exWord.getWordId());
				wordRel.setCreateTime(new Date());
				wordRel.setIsValid(Constant.VALID);
				result = relDao.insertSelective(wordRel);
			}else {
				word.setCreateDate(new Date());
				word.setIsValid(Constant.VALID);
				word.setHitCount(0);
				word.setNameInitial(PinyinUtil.cn2py(word.getWord()));
				wordDao.insertSelective(word);
				int wordId=word.getWordId();
				InfoWordRel wordRel = new InfoWordRel();
				wordRel.setInfoId(infoId);
				wordRel.setWordId(wordId);
				wordRel.setCreateTime(new Date());
				wordRel.setIsValid(Constant.VALID);
				result = relDao.insertSelective(wordRel);
			}
		}
		
		return result;
	}

	/* (non-Javadoc)
	 * <p>Title: getWordsByInfoId</p> 
	 * <p>Description: </p> 
	 * @param infoId
	 * @return 
	 * @see cn.com.shukaiken.service.IInfoSearchWordService#getWordsByInfoId(java.lang.Integer) 
	 */
	@Override
	public List<InfoSearchWord> getWordsByInfoId(Integer infoId) {
		return wordDao.selectByInfoId(infoId);
	}

	/* (non-Javadoc)
	 * <p>Title: removeAllByInfoId</p> 
	 * <p>Description: </p> 
	 * @param infoId
	 * @return 
	 * @see cn.com.shukaiken.service.IInfoSearchWordService#removeAllByInfoId(java.lang.Integer) 
	 */
	@Override
	public int removeAllByInfoId(Integer infoId) {
		InfoWordRel wordRel = new InfoWordRel();
		wordRel.setIsValid(Constant.INVALID);
		wordRel.setInfoId(infoId);
		return relDao.updateByInfoId(wordRel);
	}

}
