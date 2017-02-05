package cn.com.shukaiken.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.shukaiken.dao.IDataCategoryDao;
import cn.com.shukaiken.model.DataCategory;
import cn.com.shukaiken.service.IDataCategoryService;
@Service
public class IDataCategoryImpl implements IDataCategoryService {
	
	@Resource 
	private IDataCategoryDao dataCategoryDao;

	@Override
	public int addDataCategory(DataCategory dataCategory) {
		return dataCategoryDao.insert(dataCategory);
	}

	@Override
	public DataCategory getDataCategoryById(int id) {
		return dataCategoryDao.selectByPrimaryKey(id);
	}

	@Override
	public DataCategory selectByDataCategory(DataCategory dataCategory) {
		return dataCategoryDao.selectBySelective(dataCategory);
	}

	@Override
	public List<DataCategory> getDataCategoryLs(DataCategory dataCategory) {
		
		return dataCategoryDao.getDataCategoryLs(dataCategory);
	}

	@Override
	public int updateByDataCategoryId(DataCategory dataCategory) {
		return dataCategoryDao.updateByPrimaryKeySelective(dataCategory);
	}

}
