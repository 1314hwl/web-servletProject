/** 
*���� ����DAO�ӿ�
*���� �ֱ��ģ�ling20081005@126.com ���ͣ�http://blog.csdn.net/evankaka�� 
*ʱ�� 2015.4.22
*/
package cn.com.inzy.dao;

import cn.com.inzy.vo.User;

public interface IUserDAO {
/**
 * �û���¼��֤
 * @param user����vo����
 * @return ��֤�Ĳ������ 
 * @throws Exception
 */
public boolean findLogin(User user) throws Exception;

}
