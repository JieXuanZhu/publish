package cn.com.shukaiken.dao;

import java.util.List;
import java.util.Map;

import cn.com.shukaiken.model.InfoEnshrine;

public interface InfoEnshrineDao {
    int deleteByPrimaryKey(Integer id);

    int insert(InfoEnshrine record);

    int insertSelective(InfoEnshrine record);

    InfoEnshrine selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InfoEnshrine record);

    int updateByPrimaryKey(InfoEnshrine record);
    
    InfoEnshrine selectBySelective(InfoEnshrine record);
    
    List<InfoEnshrine> getEnshrineInfoLs(InfoEnshrine record);
    
    int batchUpdateByList(List<InfoEnshrine> enshrineInfoLs);
    
    int batchUpdateByMap(Map<String,Object> map);
    
    InfoEnshrine selectInfoByInfoEnshrine(InfoEnshrine record);
    
    int cancelEnshrine(InfoEnshrine record);
}