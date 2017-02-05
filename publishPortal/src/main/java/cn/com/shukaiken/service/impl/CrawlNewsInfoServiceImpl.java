/**
 * @Title: CrawlNewsInfoServiceImpl.java 
* @Package cn.com.shukaiken.service.impl 
* @Description: <p>TODO</p> 
* @author zhaox   
* @date 2015年11月29日 下午6:10:34 
* @version V1.0 
 */
package cn.com.shukaiken.service.impl;

import java.util.Date;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.shukaiken.dao.CrawlNewsInfoConfigDao;
import cn.com.shukaiken.dao.CrawlNewsInfoDao;
import cn.com.shukaiken.dao.CrawlNewsInfoSourceDao;
import cn.com.shukaiken.model.CrawlNewsInfo;
import cn.com.shukaiken.model.CrawlNewsInfoConfig;
import cn.com.shukaiken.model.CrawlNewsInfoSource;
import cn.com.shukaiken.model.Info;
import cn.com.shukaiken.model.InfoBanner;
import cn.com.shukaiken.model.InfoContent;
import cn.com.shukaiken.model.TableInfo;
import cn.com.shukaiken.service.ICrawlNewsInfoService;
import cn.com.shukaiken.service.IInfoBannerService;
import cn.com.shukaiken.service.IInfoContentService;
import cn.com.shukaiken.service.IInfoService;
import cn.com.shukaiken.util.Constant;
import cn.com.shukaiken.util.ValidateUtils;

/**
 * @ClassName: CrawlNewsInfoServiceImpl 
 * @Description: <p>TODO</p>
 * @date 2015年11月29日 下午6:10:34 
 * @author Zhao Xiang
 *
 */
@Service
@Transactional
public class CrawlNewsInfoServiceImpl implements ICrawlNewsInfoService {
	Logger logger = LoggerFactory.getLogger(CrawlNewsInfoServiceImpl.class);

	@Autowired
	private CrawlNewsInfoDao infoDao;
	@Autowired
	private CrawlNewsInfoConfigDao configDao;
	@Autowired
	private CrawlNewsInfoSourceDao sourceDao;
	@Autowired
	private IInfoService infoService;
	@Autowired
	private IInfoContentService contentService;
	@Autowired
	private IInfoBannerService infoBannerService;
	
	/* (non-Javadoc)
	 * <p>Title: getSourceList</p> 
	 * <p>Description: </p> 
	 * @param source
	 * @return 
	 * @see cn.com.shukaiken.service.ICrawlNewsInfoService#getSourceList(cn.com.shukaiken.model.CrawlNewsInfoSource) 
	 */
	@Override
	public List<CrawlNewsInfoSource> getSourceList(CrawlNewsInfoSource source) {
		
		return sourceDao.selectByCondition(source);
	}

	/* (non-Javadoc)
	 * <p>Title: getSourceById</p> 
	 * <p>Description: </p> 
	 * @param valueOf
	 * @return 
	 * @see cn.com.shukaiken.service.ICrawlNewsInfoService#getSourceById(java.lang.Integer) 
	 */
	@Override
	public CrawlNewsInfoSource getSourceById(Integer id) {
		// TODO Auto-generated method stub
		return sourceDao.selectByPrimaryKey(id);
	}

	/* (non-Javadoc)
	 * <p>Title: removeSourceById</p> 
	 * <p>Description: </p> 
	 * @param source
	 * @return 
	 * @see cn.com.shukaiken.service.ICrawlNewsInfoService#removeSourceById(cn.com.shukaiken.model.CrawlNewsInfoSource) 
	 */
	@Override
	public int removeSourceById(CrawlNewsInfoSource source) {
		// TODO Auto-generated method stub
		return sourceDao.updateByPrimaryKeySelective(source);
	}

	/* (non-Javadoc)
	 * <p>Title: selectTableInfo</p> 
	 * <p>Description: </p> 
	 * @param string
	 * @return 
	 * @see cn.com.shukaiken.service.ICrawlNewsInfoService#selectTableInfo(java.lang.String) 
	 */
	@Override
	public List<TableInfo> selectTableInfo(String tableName) {
		// TODO Auto-generated method stub
		return sourceDao.selectTableInfo(tableName);
	}

	/* (non-Javadoc)
	 * <p>Title: addNewNewsSource</p> 
	 * <p>Description: </p> 
	 * @param source
	 * @return 
	 * @see cn.com.shukaiken.service.ICrawlNewsInfoService#addNewNewsSource(cn.com.shukaiken.model.CrawlNewsInfoSource) 
	 */
	@Override
	public int addNewNewsSource(CrawlNewsInfoSource source) {
		logger.info("插入数据源数据");
		int srcId = 0;
		try {
			if(source!=null){
				source.setIsValid(Constant.VALID);
				srcId = sourceDao.insertSelective(source);
				if(srcId>0){
					if(source.getInfoConfigs()!=null && source.getInfoConfigs().size()>0){
						List<CrawlNewsInfoConfig> configs = source.getInfoConfigs();
						for(int i=0;i<configs.size();i++){
							CrawlNewsInfoConfig config = configs.get(i);
							config.setSrcId(srcId);
							configDao.insertSelective(config);
						}
					}
				}
			}
		} catch (Exception e) {
			logger.error("addNewNewsSource.ERROR:"+e, e);
			e.printStackTrace();
			return 0;
		}
		return srcId;
	}

	/* (non-Javadoc)
	 * <p>Title: modifyNewsSource</p> 
	 * <p>Description: </p> 
	 * @param source
	 * @return 
	 * @see cn.com.shukaiken.service.ICrawlNewsInfoService#modifyNewsSource(cn.com.shukaiken.model.CrawlNewsInfoSource) 
	 */
	@Override
	public int modifyNewsSource(CrawlNewsInfoSource source) {
		logger.info("插入数据源数据");
		int result = 0;
		try {
			if(source!=null){
				result = sourceDao.updateByPrimaryKeySelective(source);
				if(result>0){
					if(source.getInfoConfigs()!=null && source.getInfoConfigs().size()>0){
						List<CrawlNewsInfoConfig> configs = source.getInfoConfigs();
						for(int i=0;i<configs.size();i++){
							CrawlNewsInfoConfig config = configs.get(i);
							configDao.updateByPrimaryKeySelective(config);
						}
					}
				}
			}
		} catch (Exception e) {
			logger.error("modifyNewsSource.ERROR:"+e, e);
			e.printStackTrace();
			return 0;
		}
		return result;
	}

	@Override
	public int addNewsInfo(CrawlNewsInfo info, CrawlNewsInfoSource source) {
		int result = 0;
		try {
			 infoDao.insertSelective(info);
			 result = info.getId();
			logger.info("插入抓取新闻数据，Id="+result+",标题:"+info.getSubtitle());
			logger.info("向资讯表中插入数据");
			Info mainInfo = new Info();
            mainInfo.setOrigin(Constant.INFO_ORIGIN_EXTRACTOR);
            mainInfo.setOriginName(source.getSiteName());
            mainInfo.setOriginUrl(info.getCrawlerurl());
            mainInfo.setTagId(source.getLabelId());
            mainInfo.setStatus(Constant.INFO_STATUS_UNCHECKED);
            mainInfo.setIsValid(Constant.VALID);
            mainInfo.setCreateTime(new Date());
            mainInfo.setUpdateTime(new Date());
            mainInfo.setAuthorName(info.getAuthor());
            int infoId= infoService.addCrawlNewsInfo(mainInfo);
            logger.info("向资讯表中插入数据成功，Id="+infoId);
            Integer contentId = null;
            if(infoId>0){
            	logger.info("向资讯内容表中插入数据");
            	InfoContent con = new InfoContent();
            	con.setInfoId(infoId);
            	con.setTitle(info.getSubtitle());
            	con.setBrief(info.getSubtitle());
            	con.setContent(info.getContent());
            	con.setCreateTime(new Date());
            	con.setIsValid(Constant.VALID);
            	contentService.addNewContent(con);
            	contentId = con.getContentId();
            	logger.info("向资讯内容表插入数据成功,Id="+con.getContentId());
            }
            
            String firstImageUrl = this.getImageFromContent(info.getContent());
			//SimpleImageInfo imageInfo = getImageFileFromUrl(firstImageUrl,request);
			if(!ValidateUtils.isEmpty(firstImageUrl)){
				InfoBanner banner = new InfoBanner();
				banner.setBanName(firstImageUrl.substring(firstImageUrl.lastIndexOf("/"), firstImageUrl.lastIndexOf(".")));
				//banner.setBanSize(imageInfo.getSize().divide(new BigDecimal(1024), 2, BigDecimal.ROUND_HALF_DOWN));
				//banner.setBanType(imageInfo.getMimeType());
				banner.setUrl(firstImageUrl);
				banner.setInfoId(mainInfo.getInfoId());
				banner.setContentId(contentId);
				banner.setIsValid(Constant.VALID);
				banner.setCreateTime(new Date());
				infoBannerService.addNewBanner(banner);
			}
            
		} catch (Exception e) {
			logger.error("插入数据失败:addNewsInfo.ERROR:"+e, e);
			e.printStackTrace();
		}
		return result;
		
	}
	
	@Override
	public int updateNewsInfoSourceById(List<CrawlNewsInfoSource> sources){
		if(sources!=null && sources.size()>0){
			for(int i=0;i<sources.size();i++){
				CrawlNewsInfoSource source = sources.get(i);
				source.setLastCrawlTime(new Date());
				sourceDao.updateByPrimaryKeySelective(source);
			}
			return sources.size();
		}
		return 0;
	}

	@Override
	public List<CrawlNewsInfo> selectAllInfos(CrawlNewsInfo qInfo) {
		// TODO Auto-generated method stub
		return infoDao.selectDatas(qInfo);
	}

	@Override
	public CrawlNewsInfo getCrawlDataById(Integer id) {
		// TODO Auto-generated method stub
		return infoDao.selectByPrimaryKey(id);
	}
	
	private String getImageFromContent(String content) {
		String imgUrl = null;
		Document doc = Jsoup.parse(content);
		if(doc !=null){
			Element imgDoc = doc.select("img").first();
			if(imgDoc!=null){
				imgUrl = doc.select("img").first().attr("src");
			}
		}
	
		return imgUrl;
	}
}
