package cn.com.inzy.sevlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.inzy.dao.UserDAOProxy;
import cn.com.inzy.vo.User;

/**
 * @Description 
 * @author HuWeiLiang
 * @date 2017��5��17�� ����10:02:21
 */
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("do post...");
        // doGet(request, response);
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        List<String> info = new ArrayList<String>();
        if (name == null || "".equals(name)) { // �û��������ʽ����
            info.add("�û�������Ϊ��");
            System.out.println("�û�������Ϊ��");
        }

        if (password == null || "".equals(password)) {// ���������ʽ����
            info.add("���벻��Ϊ��");
            System.out.println("���벻��Ϊ��");
        }
        if (info.size() == 0) {
            User user = new User();
            user.setName(name);
            user.setPassword(password);
            UserDAOProxy userDAOProxy = new UserDAOProxy();
            try {

                if (userDAOProxy.findLogin(user)) {
                    System.out.println("��¼�ɹ�");
                    info.add("�û���¼�ɹ�����ӭ" + user.getName() + "���٣�");
                } else {
                    info.add("�û���¼ʧ�ܣ�������û���������");
                    System.out.println("�û���¼ʧ�ܣ�������û���������");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        request.setAttribute("info", info);// ���������Ϣ
        request.getRequestDispatcher("Login.jsp").forward(request, response);// ��ת
    }

}
