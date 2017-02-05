/**
 * @Title: InfoCommentServiceImpl.java 
* @Package cn.com.shukaiken.service.impl 
* @Description: <p>TODO</p> 
* @author zhaox   
* @date 2015年11月13日 上午11:28:20 
* @version V1.0 
 */
package cn.com.shukaiken.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.shukaiken.dao.InfoCommentDao;
import cn.com.shukaiken.model.InfoComment;
import cn.com.shukaiken.service.IInfoCommentService;

/**
 * @ClassName: InfoCommentServiceImpl 
 * @Description: <p>新闻评论实现类</p>
 * @date 2015年11月13日 上午11:28:20 
 * @author  Xiang.Zhao
 *
 */
@Service
@Transactional
public class InfoCommentServiceImpl implements IInfoCommentService {
	Logger logger = LoggerFactory.getLogger(InfoCommentServiceImpl.class);
	@Resource
	private InfoCommentDao commentDao;

	@Override
	public int addInfoComment(InfoComment comment) {
		
		return commentDao.insert(comment);
	}

	@Override
	public List<InfoComment> getCommentLs(InfoComment comment) {
		
		return commentDao.getCommentLs(comment);
	}

}
