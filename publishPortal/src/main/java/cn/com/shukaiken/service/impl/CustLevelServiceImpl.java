package cn.com.shukaiken.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.shukaiken.dao.ICustLevelDao;
import cn.com.shukaiken.model.CustLevel;
import cn.com.shukaiken.service.ICustLevelService;
@Service
public class CustLevelServiceImpl implements ICustLevelService {
	
	@Resource
	private ICustLevelDao custLevelDao;

	@Override
	public int addCustLevel(CustLevel custLevel) {
		return custLevelDao.insert(custLevel);
	}

	@Override
	public CustLevel getCustLevelById(int id) {
		return custLevelDao.selectByPrimaryKey(id);
	}

	@Override
	public CustLevel selectByCustLevel(CustLevel custLevel) {
		return custLevelDao.selectBySelective(custLevel);
	}

	@Override
	public List<CustLevel> getCustLevelLs(CustLevel custLevel) {
		return custLevelDao.getCustLevelLs(custLevel);
	}

	@Override
	public int updateByCustLevelId(CustLevel custLevel) {
		return custLevelDao.updateByPrimaryKeySelective(custLevel);
	}
	
	

}
