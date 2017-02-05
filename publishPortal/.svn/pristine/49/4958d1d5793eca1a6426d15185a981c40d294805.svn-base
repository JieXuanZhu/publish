package cn.com.shukaiken.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.com.shukaiken.model.CrawlNewsInfoSource;
import cn.com.shukaiken.model.TableInfo;

@Repository
public interface CrawlNewsInfoSourceDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CrawlNewsInfoSource record);

    int insertSelective(CrawlNewsInfoSource record);

    CrawlNewsInfoSource selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CrawlNewsInfoSource record);

    int updateByPrimaryKey(CrawlNewsInfoSource record);

    /**
	 * @Title: selectByCondition 
	 * @Description: TODO
	 * @param @param source
	 * @param @return
	 * @return List<CrawlNewsInfoSource>
	 * @throws 
	 */
	List<CrawlNewsInfoSource> selectByCondition(CrawlNewsInfoSource source);

	/**
	 * @Title: selectTableInfo 
	 * @Description: TODO
	 * @param @param tableName
	 * @param @return
	 * @return List<TableInfo>
	 * @throws 
	 */
	List<TableInfo> selectTableInfo(String tableName);
}