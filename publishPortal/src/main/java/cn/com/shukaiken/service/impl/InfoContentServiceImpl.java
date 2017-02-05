/**
 * @Title: InfoContentServiceImpl.java 
* @Package cn.com.shukaiken.service.impl 
* @Description: <p>TODO</p> 
* @author zhaox   
* @date 2015年11月13日 上午11:31:42 
* @version V1.0 
 */
package cn.com.shukaiken.service.impl;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.shukaiken.dao.InfoContentDao;
import cn.com.shukaiken.model.InfoContent;
import cn.com.shukaiken.service.IInfoContentService;
import cn.com.shukaiken.service.ISensitiveWordsService;
import cn.com.shukaiken.util.Constant;
import cn.com.shukaiken.util.SensitivewordFilter;
import cn.com.shukaiken.util.ValidateUtils;

/**
 * @ClassName: InfoContentServiceImpl 
 * @Description: <p>TODO</p>
 * @date 2015年11月13日 上午11:31:42 
 * @author Zhao Xiang
 *
 */
@Service
@Transactional
public class InfoContentServiceImpl implements IInfoContentService {
	Logger logger = LoggerFactory.getLogger(InfoContentServiceImpl.class);

	@Resource
	private InfoContentDao contentDao;
	@Autowired 
	private ISensitiveWordsService sensitiveWordService;
	
	
	/* (non-Javadoc)
	 * <p>Title: addNewContent</p> 
	 * <p>Description: </p> 
	 * @param infoContent
	 * @throws Exception 
	 * @see cn.com.shukaiken.service.IInfoContentService#addNewContent(cn.com.shukaiken.model.InfoContent) 
	 */
	@Override
	public int addNewContent(InfoContent infoContent) throws Exception {
		int result = 0;
		if(infoContent!=null){
			try {
				logger.info("新增资讯的内容:infoId="+infoContent.getInfoId());
				contentDao.insertSelective(infoContent);
				result = infoContent.getContentId();
			} catch (Exception e) {
				result = 0;
				logger.error("InfoContentServiceImpl.addNewContent.ERROR:"+e, e);
				e.printStackTrace();
				throw new RuntimeException("addNewContent出错");
			}
		}
		return result;
		
	}
	@Override
	public InfoContent viewNewsDetail(InfoContent infoContent) {
		InfoContent content = contentDao.selectInfoDetail(infoContent);
		if(content!= null){
			SensitivewordFilter filter = new SensitivewordFilter(false,sensitiveWordService);
			/*String string = "太多的伤感情怀也许只局限于饲养基地 荧幕中的情节，主人公尝试着去用某种方式渐渐的很潇洒地释自杀指南怀那些自己经历的伤感。"
							+ "然后法轮功 我们的扮演的角色就是跟随着主人公的喜红客联盟 怒哀乐而过于牵强的把自己的情感也附加于银幕情节中，然后感动就流泪，"
							+ "难过就躺在某一个人的怀里尽情的阐述心扉或者手机卡复制器一个人一杯红酒一部电影在夜三级片 深人静的晚上，关上电话静静的发呆着。";
			System.out.println("待检测语句字数：" + string.length());*/
			String con = content.getContent();
			String brief = content.getBrief();
			long beginTime = System.currentTimeMillis();
			if(!ValidateUtils.isEmpty(con)){
				con = filter.replaceSensitiveWord(con, 1, "*");
				content.setContent(con);
			}
			if(!ValidateUtils.isEmpty(brief)){
				brief = filter.replaceSensitiveWord(brief, 1, "*");
				content.setBrief(brief);
			}
			//Set<String> set = filter.getSensitiveWord(string, 1);
			long endTime = System.currentTimeMillis();
			/*System.out.println("语句中包含敏感词的个数为：" + set.size() + "。包含：" + set);*/
			logger.info("总共消耗时间为：" + (endTime - beginTime));
		}
		return content;
	}
	/* (non-Javadoc)
	 * <p>Title: updateInfoContentById</p> 
	 * <p>Description: </p> 
	 * @param infoContent
	 * @return 
	 * @see cn.com.shukaiken.service.IInfoContentService#updateInfoContentById(cn.com.shukaiken.model.InfoContent) 
	 */
	@Override
	public int updateInfoContentById(InfoContent infoContent) {
		int result = 0;
		if(infoContent!=null){
			try {
				logger.info("修改资讯的内容:contentId="+infoContent.getContentId());
				result = contentDao.updateByPrimaryKeySelective(infoContent);
			} catch (Exception e) {
				result = 0;
				logger.error("InfoContentServiceImpl.updateInfoContentById.ERROR:"+e, e);
				e.printStackTrace();
				throw new RuntimeException("updateInfoContent出错");
			}
		}
		return result;
	}
	/* (non-Javadoc)
	 * <p>Title: removeContentByInfoId</p> 
	 * <p>Description: </p> 
	 * @param infoId
	 * @return 
	 * @see cn.com.shukaiken.service.IInfoContentService#removeContentByInfoId(java.lang.Integer) 
	 */
	@Override
	public int removeContentByInfoId(Integer infoId) {
		int result = 0;
		// TODO Auto-generated method stub
		logger.info("根据资讯的Id:"+infoId+",移除所有的content");
		if(infoId!=null){
			InfoContent content = new InfoContent();
			content.setIsValid(Constant.INVALID);
			content.setInfoId(infoId);
			result = contentDao.updateByInfoId(content);
		}
		return result;
	}
	
	@Override
	public List<InfoContent> getCategoryInfoLs(InfoContent record) {
		return contentDao.getCategoryInfoLs(record);
	}
	
	@Override
	public InfoContent getNewestInfo() {
		return contentDao.getNewestInfo();
	}
	
	@Override
	public InfoContent getHotInfo() {
		return contentDao.getHotInfo();
	}
	
	@Override
	public List<InfoContent> getSearchInfoLs(InfoContent record) {
		
		return contentDao.getSearchInfoLs(record);
	}
	
	@Override
	public List<InfoContent> getHeadBannerInfoLs() {
		
		return contentDao.getHeadBannerInfoLs();
	}
	
	@Override
	public List<InfoContent> getCategoryBannerInfoLs() {
		
		return contentDao.getCategoryBannerInfoLs();
	}
	@Override
	public List<InfoContent> getHeadCategoryInfoLs(InfoContent record) {
		return contentDao.getHeadCategoryInfoLs(record);
	}
}
