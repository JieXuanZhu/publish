/**
 * @Title: ITagService.java 
* @Package cn.com.shukaiken.service 
* @Description: <p>TODO</p> 
* @author zhaox   
* @date 2015年11月24日 上午11:30:23 
* @version V1.0 
 */
package cn.com.shukaiken.service;

import java.util.List;

import cn.com.shukaiken.model.InfoTagRel;
import cn.com.shukaiken.model.LabelTagRel;
import cn.com.shukaiken.model.Tag;

/**
 * @ClassName: ITagService 
 * @Description: <p>TODO</p>
 * @date 2015年11月24日 上午11:30:23 
 * @author Zhao Xiang
 *
 */
public interface ITagService {

	/**
	 * @Title: getTagsByCondition 
	 * @Description: TODO
	 * @param @param tag
	 * @param @return
	 * @return List<Label>
	 * @throws 
	 */
	public List<Tag> getTagsByCondition(Tag tag);

	/**
	 * @Title: addTag 
	 * @Description: TODO
	 * @param @param temp
	 * @return void
	 * @throws 
	 */
	public int addTag(Tag temp);

	/**
	 * @Title: getTagById 
	 * @Description: TODO
	 * @param @param parseInt
	 * @param @return
	 * @return Label
	 * @throws 
	 */
	public Tag getTagById(int parseInt);

	/**
	 * @return 
	 * @Title: updateByTagId 
	 * @Description: TODO
	 * @param @param tag
	 * @return void
	 * @throws 
	 */
	public int updateByTagId(Tag tag);

	/**
	 * @Title: getLabelTagsByCondition 
	 * @Description: TODO
	 * @param @param qlt
	 * @param @return
	 * @return List<LabelTagRel>
	 * @throws 
	 */
	public List<LabelTagRel> getLabelTagsByCondition(LabelTagRel qlt);

	/**
	 * @Title: getTagsByLabel 
	 * @Description: TODO
	 * @param @param qlt
	 * @param @return
	 * @return List<LabelTagRel>
	 * @throws 
	 */
	public List<Tag> getTagsByLabel(LabelTagRel qlt);
	
	public List<Tag> selectByInfoId(Integer infoId);

	public int addInfotagRel(InfoTagRel itr);

	public int removeAllRelByInfoId(Integer infoId);

}
