package cn.com.inzy.dao;

import cn.com.inzy.dbc.DatabaseConnection;
import cn.com.inzy.vo.User;
/**
 * @Description 
 * @author HuWeiLiang
 * @date 2017年5月17日 上午10:30:05
 */
public class UserDAOProxy implements IUserDAO {
    private DatabaseConnection dbc = null;// 定义数据库连接

    private IUserDAO dao = null;// 定义DAO接口

    public UserDAOProxy() {
        try {
            dbc = new DatabaseConnection();// 实例化数据库连接
        } catch (Exception e) {
            e.printStackTrace();
        }
        dao = new UserDAOImpI(dbc.getConnection());

    }

    public boolean findLogin(User user) throws Exception {
        boolean flag = false;
        try {
            flag = dao.findLogin(user);// 调用真实主题
        } catch (Exception e) {
            throw e;
        } finally {
            dbc.close();
        }
        return flag;
    }

}
