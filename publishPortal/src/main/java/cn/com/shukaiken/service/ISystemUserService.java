package cn.com.shukaiken.service;

import java.util.List;

import cn.com.shukaiken.model.SystemUser;

/**
 * @ClassName: ILogService 
 * @Description: <p>系统用户Service接口</p>
 * @date 2015年11月7日 下午18:26:16 
 * @author  jiexuan.zhu
 *
 */
public interface ISystemUserService {
	
	int deleteByPrimaryKey(Integer id);

    int insert(SystemUser record);

    int insertSelective(SystemUser record);

    SystemUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SystemUser record);

    int updateByPrimaryKey(SystemUser record);
    
    SystemUser getSystemUserByName(SystemUser record);
    
    SystemUser login (SystemUser record);
    
    List<SystemUser> getUserLs(SystemUser record);
    
    public void editUserRole(String[] ids,int roleId);
    
    public void delUser(int id);
    

}
