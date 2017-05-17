/** 
*���� �������ݿ������
*���� �ֱ��ģ�ling20081005@126.com ���ͣ�http://blog.csdn.net/evankaka�� 
*ʱ�� 2015.4.22
*/
package cn.com.inzy.dbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @Description
 * @author HuWeiLiang
 * @date 2017��5��17�� ����10:01:05
 */
public class DatabaseConnection {
    private static final String DBDRIVER = "com.mysql.jdbc.Driver";

    private static final String DBURL = "jdbc:mysql://localhost:3306/example";// mysql��Ӧ��ip�Ͷ˿�

    private static final String DBUSER = "root";// mysql���ݿ��Ӧ���û���

    private static final String DBPASS = "654321";// mysql���ݿ��Ӧ������

    private Connection connection = null;

    public DatabaseConnection() {
        // ������������
        try {
            Class.forName(DBDRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("�����������ʧ��,���mysql-connector-java-5.1.7-bin.jar���ŵ�tomcat��װĿ¼��libĿ¼��");
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
