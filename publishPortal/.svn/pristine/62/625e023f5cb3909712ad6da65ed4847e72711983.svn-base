package cn.com.shukaiken.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.shukaiken.dao.IDataDao;
import cn.com.shukaiken.model.Data;
import cn.com.shukaiken.service.IDataService;

@Service
public class IDataServiceImpl implements IDataService{ 
	
	@Resource
	private IDataDao dataDao;

	@Override
	public int addDataSelective(Data data) {
		return dataDao.insert(data);
	}

	@Override
	public Data selectByDataSelective(Data data) {
		
		return dataDao.selectBySelective(data);
	}

	@Override
	public List<Data> getDataLs(Data data) {
		
		return dataDao.getDataLs(data);
	}

	@Override
	public int updateByDataId(Data data) {
	
		return dataDao.updateByPrimaryKeySelective(data);
	}

}
