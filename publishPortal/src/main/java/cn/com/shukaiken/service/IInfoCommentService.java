package cn.com.shukaiken.service;

import java.util.List;

import cn.com.shukaiken.model.InfoComment;

/**
 * @ClassName: IInfoCommentService 
 * @Description: <p></p>
 * @date 2015年11月13日 上午11:19:28 
 * @author Xiang.Zhao 
 *
 */
public interface IInfoCommentService {
	
	int addInfoComment(InfoComment comment);
	
	List<InfoComment> getCommentLs(InfoComment comment);
	

}
