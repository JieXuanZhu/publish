/**
 * @Title: LogServiceImpl.java 
* @Package cn.com.shukaiken.service.impl 
* @Description: <p>TODO 日志实现类</p> 
* @author zhaox   
* @date 2015年11月3日 下午1:28:31 
* @version V1.0 
 */
package cn.com.shukaiken.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.shukaiken.dao.ILogDao;
import cn.com.shukaiken.model.Log;
import cn.com.shukaiken.service.ILogService;

/**
 * @ClassName: LogServiceImpl 
 * @Description: <p>TODO</p>
 * @date 2015年11月3日 下午1:28:31 
 * @author Zhao Xiang
 *
 */
@Service
@Transactional
public class LogServiceImpl implements ILogService {


	private Logger logger = LoggerFactory.getLogger(LogServiceImpl.class);

	@Resource
    private ILogDao logDao;
	
	@Override
	public int logDeleteByPrimaryKey(Integer id) {
		return logDao.deleteByPrimaryKey(id);
	}

	@Override
	public int logInsert(Log record) {
		
		return logDao.insert(record);
	}

	@Override
	public int logInsertSelective(Log record) {
		
		return logDao.insertSelective(record);
	}

	@Override
	public Log logSelectByPrimaryKey(Integer id) {
		
		return logDao.selectByPrimaryKey(id);
	}

	@Override
	public List<Log> logSelectLogByCondition(Log log) {
		
		return logDao.selectLogByCondition(log);
	}

	@Override
	public int logUpdateByPrimaryKey(Log record) {
		
		return logDao.updateByPrimaryKey(record);
	}

	@Override
	public int logUpdateByPrimaryKeySelective(Log record) {
		
		return logDao.updateByPrimaryKeySelective(record);
	}
	
	
}
