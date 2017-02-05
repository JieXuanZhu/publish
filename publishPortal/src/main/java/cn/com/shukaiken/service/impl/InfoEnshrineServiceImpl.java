package cn.com.shukaiken.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.shukaiken.dao.InfoDao;
import cn.com.shukaiken.dao.InfoEnshrineDao;
import cn.com.shukaiken.model.Info;
import cn.com.shukaiken.model.InfoEnshrine;
import cn.com.shukaiken.service.IInfoEnshrineService;
@Service
public class InfoEnshrineServiceImpl implements IInfoEnshrineService {
	
	@Resource
	private InfoEnshrineDao infoEnshrineDao;
	
	@Resource
	private InfoDao infoDao;

	@Override
	public int addInfoEnshrine(InfoEnshrine infoEnshrine) {
		
		return infoEnshrineDao.insert(infoEnshrine);
	}

	@Override
	public List<InfoEnshrine> getEnshrineInfoLs(InfoEnshrine infoEnshrine) {
		
		return infoEnshrineDao.getEnshrineInfoLs(infoEnshrine);
	}

	@Override
	public int updateEnshrineInfoStatusByMap(Map<String,Object> map){
		return infoEnshrineDao.batchUpdateByMap(map);
	}

	@Override
	public InfoEnshrine viewEnshrineInfo(InfoEnshrine infoEnshrine) {
		
		return infoEnshrineDao.selectInfoByInfoEnshrine(infoEnshrine);
	}

	@Override
	public InfoEnshrine selectByInfoEnshrine(InfoEnshrine infoEnshrine) {
		
		return infoEnshrineDao.selectBySelective(infoEnshrine);
	}

	@Override
	public int cancelEnshrine(InfoEnshrine record) {
		return infoEnshrineDao.cancelEnshrine(record);
	}
	
	

}
