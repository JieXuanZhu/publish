package cn.com.shukaiken.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.com.shukaiken.model.CrawlNewsInfoConfig;
@Repository
public interface CrawlNewsInfoConfigDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CrawlNewsInfoConfig record);

    int insertSelective(CrawlNewsInfoConfig record);

    CrawlNewsInfoConfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CrawlNewsInfoConfig record);

    int updateByPrimaryKey(CrawlNewsInfoConfig record);
    
    List<CrawlNewsInfoConfig> selectConfigsBySourceId(Integer srcId);
}