package cn.com.shukaiken.service;

import java.util.List;

import cn.com.shukaiken.model.Data;

public interface IDataService {
	
	 int addDataSelective(Data data);
	
	 Data selectByDataSelective(Data data);
	    
	 List<Data> getDataLs(Data data);
	 
	 int updateByDataId(Data data);

}
