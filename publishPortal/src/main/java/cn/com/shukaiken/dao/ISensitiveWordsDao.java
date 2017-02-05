package cn.com.shukaiken.dao;

import java.util.List;

import cn.com.shukaiken.model.SensitiveWords;
/**
 * 
 * @author jiexuan.zhu
 * @date   2015-11-13
 *
 */
public interface ISensitiveWordsDao {
    int deleteByPrimaryKey(Integer id);

    int insert(SensitiveWords record);

    int insertSelective(SensitiveWords record);

    SensitiveWords selectByPrimaryKey(Integer id);
    
    SensitiveWords selectBySelective(SensitiveWords record);

    int updateByPrimaryKeySelective(SensitiveWords record);

    int updateByPrimaryKey(SensitiveWords record);
    
    List<SensitiveWords> getSensitiveLs(SensitiveWords record);
}