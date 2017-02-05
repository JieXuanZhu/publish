package cn.com.shukaiken.dao;

import java.util.List;

import cn.com.shukaiken.model.Log;
/**
 * 日志操作Dao
 * @author Zhao Xiang
 *
 */
public interface ILogDao {
	/**
	 * 根据ID删除日志记录
	 * @param id
	 * @return 删除的行数
	 */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入日志记录
     * @param record
     * @return 插入行数
     */
    int insert(Log record);

    /**
     * 根据条件插入日志记录
     * @param record
     * @return 插入行数
     */
    int insertSelective(Log record);

    /**
     * 根据ID查询记录
     * @param id
     * @return 日志记录
     */
    Log selectByPrimaryKey(Integer id);

    /**
     * 根据主键条件修改日志记录
     * @param record
     * @return 修改的行数
     */
    int updateByPrimaryKeySelective(Log record);

    /**
     * 根据条件修改全变量
     * @param record
     * @return 修改的行数
     */
    int updateByPrimaryKey(Log record);
    
    /**
     * 根据条件查询日志记录
     * @param log
     * @return 日志记录列表
     */
    List<Log> selectLogByCondition(Log log);
}