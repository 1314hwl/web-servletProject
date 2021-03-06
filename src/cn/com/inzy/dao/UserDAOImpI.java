package cn.com.inzy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.com.inzy.vo.User;

/**
 * 
 * @Description
 * @author HuWeiLiang
 * @date 2017年5月17日 上午10:26:55
 */
public class UserDAOImpI implements IUserDAO {
    private Connection conn = null;// 定义数据库连接对象

    private PreparedStatement pstmt = null;// 定义数据库操作对象

    public UserDAOImpI(Connection conn) { // 设置数据库连接
        this.conn = conn;
    }

    public boolean findLogin(User user) throws Exception {
        boolean flag = false;
        try {
            String sql = "select name from user where name=? and password=?";
            pstmt = conn.prepareStatement(sql);// 实例化操作
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getPassword());
            ResultSet rSet = pstmt.executeQuery();// 取得结果
            if (rSet.next()) {
                user.setName(rSet.getString(1));// 取得用户名
                flag = true;
            }

        } catch (Exception e) {
            throw e;
        } finally {
            // 关闭操作
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (Exception e) {
                    throw e;
                }

            }

        }
        return flag;
    }

}
