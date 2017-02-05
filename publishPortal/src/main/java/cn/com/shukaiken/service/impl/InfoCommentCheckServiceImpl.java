/**
 * @Title: InfoCommentCheckServiceImpl.java 
* @Package cn.com.shukaiken.service.impl 
* @Description: <p>TODO</p> 
* @author zhaox   
* @date 2015年11月13日 上午11:31:06 
* @version V1.0 
 */
package cn.com.shukaiken.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.shukaiken.service.IInfoCommentCheckService;

/**
 * @ClassName: InfoCommentCheckServiceImpl 
 * @Description: <p>TODO</p>
 * @date 2015年11月13日 上午11:31:06 
 * @author Zhao Xiang
 *
 */
@Service
@Transactional
public class InfoCommentCheckServiceImpl implements IInfoCommentCheckService {
	Logger logger = LoggerFactory.getLogger(InfoCommentCheckServiceImpl.class);
}
