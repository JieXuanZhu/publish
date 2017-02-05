package cn.com.shukaiken.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.shukaiken.dao.ICustDao;
import cn.com.shukaiken.model.Cust;
import cn.com.shukaiken.service.ICustService;
@Service
public class ICustServiceImpl implements ICustService{
	
	@Resource
	private ICustDao  custDao;

	@Override
	public int addCust(Cust cust) {
		return custDao.insert(cust);
	}

	@Override
	public Cust getCustById(int id) {
		return custDao.selectByPrimaryKey(id);
	}

	@Override
	public Cust selectByCust(Cust cust) {
		return custDao.selectBySelective(cust);
	}

	@Override
	public List<Cust> getCustLs(Cust cust) {
		return custDao.getCustLs(cust);
	}

	@Override
	public int updateByCustId(Cust cust) {
		return custDao.updateByPrimaryKeySelective(cust);
	}
	
	
	
	
	
	
	
	
	

}
