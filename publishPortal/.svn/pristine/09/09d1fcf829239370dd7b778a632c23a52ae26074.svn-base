package cn.com.shukaiken.service;

import java.util.List;

import cn.com.shukaiken.model.Log;

/**
 * @ClassName: ILogService 
 * @Description: <p>TODO  日志文档Service接口</p>
 * @date 2015年11月3日 下午1:26:16 
 * @author Zhao Xiang
 *
 */
public interface ILogService {
	/**
	 * 根据ID删除日志记录
	 * @param id
	 * @return 删除的行数
	 */
    int logDeleteByPrimaryKey(Integer id);

    /**
     * 插入日志记录
     * @param record
     * @return 插入行数
     */
    int logInsert(Log record);

    /**
     * 根据条件插入日志记录
     * @param record
     * @return 插入行数
     */
    int logInsertSelective(Log record);

    /**
     * 根据ID查询记录
     * @param id
     * @return 日志记录
     */
    Log logSelectByPrimaryKey(Integer id);

    /**
     * 根据主键条件修改日志记录
     * @param record
     * @return 修改的行数
     */
    int logUpdateByPrimaryKeySelective(Log record);

    /**
     * 根据条件修改全变量
     * @param record
     * @return 修改的行数
     */
    int logUpdateByPrimaryKey(Log record);
    
    /**
     * 根据条件查询日志记录
     * @param log
     * @return 日志记录列表
     */
    List<Log> logSelectLogByCondition(Log log);
}
