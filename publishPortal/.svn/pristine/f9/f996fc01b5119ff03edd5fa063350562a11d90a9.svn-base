/**
 * @Title: TagServiceImpl.java 
* @Package cn.com.shukaiken.service.impl 
* @Description: <p>TODO</p> 
* @author zhaox   
* @date 2015年11月24日 上午11:30:56 
* @version V1.0 
 */
package cn.com.shukaiken.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.shukaiken.dao.InfoTagRelDao;
import cn.com.shukaiken.dao.LabelTagRelDao;
import cn.com.shukaiken.dao.TagDao;
import cn.com.shukaiken.model.InfoTagRel;
import cn.com.shukaiken.model.LabelTagRel;
import cn.com.shukaiken.model.Tag;
import cn.com.shukaiken.service.ITagService;

/**
 * @ClassName: TagServiceImpl 
 * @Description: <p>TODO</p>
 * @date 2015年11月24日 上午11:30:56 
 * @author Zhao Xiang
 *
 */
@Service
@Transactional
public class TagServiceImpl implements ITagService {

	Logger logger = LoggerFactory.getLogger(TagServiceImpl.class);
	
	@Autowired
	private TagDao tagDao; 
	
	@Autowired
	private LabelTagRelDao relDao;
	
	@Autowired
	private InfoTagRelDao infoTagDao;
	@Override
	public List<Tag> getTagsByCondition(Tag tag) {
		
		return tagDao.selectByCondition(tag);
	}
	/* (non-Javadoc)
	 * <p>Title: addTag</p> 
	 * <p>Description: </p> 
	 * @param temp
	 * @return 
	 * @see cn.com.shukaiken.service.ITagService#addTag(cn.com.shukaiken.model.Tag) 
	 */
	@Override
	public int addTag(Tag temp) {
		// TODO Auto-generated method stub
		return tagDao.insertSelective(temp);
	}
	/* (non-Javadoc)
	 * <p>Title: getTagById</p> 
	 * <p>Description: </p> 
	 * @param parseInt
	 * @return 
	 * @see cn.com.shukaiken.service.ITagService#getTagById(int) 
	 */
	@Override
	public Tag getTagById(int tagId) {
		// TODO Auto-generated method stub
		return tagDao.selectByPrimaryKey(tagId);
	}
	/* (non-Javadoc)
	 * <p>Title: updateByTagId</p> 
	 * <p>Description: </p> 
	 * @param tag 
	 * @see cn.com.shukaiken.service.ITagService#updateByTagId(cn.com.shukaiken.model.Tag) 
	 */
	@Override
	public int updateByTagId(Tag tag) {
		return tagDao.updateByPrimaryKeySelective(tag);
		
	}
	/* (non-Javadoc)
	 * <p>Title: getLabelTagsByCondition</p> 
	 * <p>Description: </p> 
	 * @param qlt
	 * @return 
	 * @see cn.com.shukaiken.service.ITagService#getLabelTagsByCondition(cn.com.shukaiken.model.LabelTagRel) 
	 */
	@Override
	public List<LabelTagRel> getLabelTagsByCondition(LabelTagRel qlt) {
		
		return relDao.getLabelTagsByCondition(qlt);
	}
	/* (non-Javadoc)
	 * <p>Title: getTagsByLabel</p> 
	 * <p>Description: </p> 
	 * @param qlt
	 * @return 
	 * @see cn.com.shukaiken.service.ITagService#getTagsByLabel(cn.com.shukaiken.model.LabelTagRel) 
	 */
	@Override
	public List<Tag> getTagsByLabel(LabelTagRel qlt) {
		// TODO Auto-generated method stub
		return tagDao.getAllTagsByLabel(qlt.getLabelId());
	}
	@Override
	public List<Tag> selectByInfoId(Integer infoId) {
		return tagDao.selectByInfoId(infoId);
	}
	@Override
	public int addInfotagRel(InfoTagRel itr) {
		// TODO Auto-generated method stub
		return infoTagDao.insert(itr);
	}
	@Override
	public int removeAllRelByInfoId(Integer infoId) {
		// TODO Auto-generated method stub
		return infoTagDao.removeByInfoId(infoId);
	}

}
