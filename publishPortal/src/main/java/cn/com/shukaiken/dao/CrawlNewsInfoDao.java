package cn.com.shukaiken.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.com.shukaiken.model.CrawlNewsInfo;

@Repository
public interface CrawlNewsInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CrawlNewsInfo record);

    int insertSelective(CrawlNewsInfo record);

    CrawlNewsInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CrawlNewsInfo record);

    int updateByPrimaryKeyWithBLOBs(CrawlNewsInfo record);

    int updateByPrimaryKey(CrawlNewsInfo record);

	List<CrawlNewsInfo> selectDatas(CrawlNewsInfo qInfo);
    
}