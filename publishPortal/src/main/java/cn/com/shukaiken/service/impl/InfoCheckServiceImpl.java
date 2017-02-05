/**
 * @Title: InfoCheckServiceImpl.java 
* @Package cn.com.shukaiken.service.impl 
* @Description: <p>TODO</p> 
* @author zhaox   
* @date 2015年11月13日 上午11:27:48 
* @version V1.0 
 */
package cn.com.shukaiken.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.shukaiken.dao.InfoCheckDao;
import cn.com.shukaiken.model.InfoCheck;
import cn.com.shukaiken.service.IInfoCheckService;
import cn.com.shukaiken.util.Constant;

/**
 * @ClassName: InfoCheckServiceImpl 
 * @Description: <p>TODO</p>
 * @date 2015年11月13日 上午11:27:48 
 * @author Zhao Xiang
 *
 */
@Service
@Transactional
public class InfoCheckServiceImpl implements IInfoCheckService {
	Logger logger = LoggerFactory.getLogger(InfoCheckServiceImpl.class);
	
	@Autowired
	private InfoCheckDao checkDao;

	@Override
	public int addNewCheck(InfoCheck check) {
		int result = 0;
		
		try {
			checkDao.insertSelective(check);
			result = check.getCheckId();
		} catch (Exception e) {
			result = 0;
			logger.error("InfoCheckServiceImpl.addNewCheck.ERROR:"+e,e);
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int removeAllCheckByInfoId(Integer infoId) {
		int result = 0;
		try {
			if(infoId!=null){
				InfoCheck check = new InfoCheck();
				check.setInfoId(infoId);
				check.setIsValid(Constant.INVALID);
				result = checkDao.updateByInfoId(check);
			}
		} catch (Exception e) {
			result = 0;
			logger.error("InfoCheckServiceImpl.removeAllCheckByInfoId.ERROR:"+e,e);
			e.printStackTrace();
		}
		return result;
	}
}
