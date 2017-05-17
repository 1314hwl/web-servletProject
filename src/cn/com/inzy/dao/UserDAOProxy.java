package cn.com.inzy.dao;

import cn.com.inzy.dbc.DatabaseConnection;
import cn.com.inzy.vo.User;
/**
 * @Description 
 * @author HuWeiLiang
 * @date 2017��5��17�� ����10:30:05
 */
public class UserDAOProxy implements IUserDAO {
    private DatabaseConnection dbc = null;// �������ݿ�����

    private IUserDAO dao = null;// ����DAO�ӿ�

    public UserDAOProxy() {
        try {
            dbc = new DatabaseConnection();// ʵ�������ݿ�����
        } catch (Exception e) {
            e.printStackTrace();
        }
        dao = new UserDAOImpI(dbc.getConnection());

    }

    public boolean findLogin(User user) throws Exception {
        boolean flag = false;
        try {
            flag = dao.findLogin(user);// ������ʵ����
        } catch (Exception e) {
            throw e;
        } finally {
            dbc.close();
        }
        return flag;
    }

}
