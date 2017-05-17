/** 
*功能 定义数据库操作类
*作者 林炳文（ling20081005@126.com 博客：http://blog.csdn.net/evankaka） 
*时间 2015.4.22
*/
package cn.com.inzy.dbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @Description
 * @author HuWeiLiang
 * @date 2017年5月17日 上午10:01:05
 */
public class DatabaseConnection {
    private static final String DBDRIVER = "com.mysql.jdbc.Driver";

    private static final String DBURL = "jdbc:mysql://localhost:3306/example";// mysql对应的ip和端口

    private static final String DBUSER = "root";// mysql数据库对应的用户名

    private static final String DBPASS = "654321";// mysql数据库对应的密码

    private Connection connection = null;

    public DatabaseConnection() {
        // 加载驱动程序
        try {
            Class.forName(DBDRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("驱动程序加载失败,请把mysql-connector-java-5.1.7-bin.jar包放到tomcat安装目录的lib目录下");
        }
        try {
            connection = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void close() throws Exception {
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                throw e;
            }
        }

    }

}
