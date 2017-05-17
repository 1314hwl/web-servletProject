/** 
*功能 定义DAO接口
*作者 林炳文（ling20081005@126.com 博客：http://blog.csdn.net/evankaka） 
*时间 2015.4.22
*/
package cn.com.inzy.dao;

import cn.com.inzy.vo.User;

public interface IUserDAO {
/**
 * 用户登录验证
 * @param user传入vo对象
 * @return 验证的操作结果 
 * @throws Exception
 */
public boolean findLogin(User user) throws Exception;

}
