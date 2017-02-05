package cn.com.shukaiken.dao;

import java.util.List;

import cn.com.shukaiken.model.SearchWords;

/**
 * 
 * @author jiexuan.zhu
 * @date 2015-11-17
 *
 */
public interface ISearchWordsDao {
    int deleteByPrimaryKey(Integer word_id);

    int insert(SearchWords record);

    int insertSelective(SearchWords record);

    SearchWords selectByPrimaryKey(Integer word_id);

    int updateByPrimaryKeySelective(SearchWords record);

    int updateByPrimaryKey(SearchWords record);
    
    SearchWords selectBySelective(SearchWords record);
    
    List<SearchWords> getSearchWordsLs(SearchWords record);
}