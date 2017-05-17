package cn.com.inzy.sevlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import cn.com.inzy.dao.UserDAOProxy;
import cn.com.inzy.vo.User;

@WebServlet("/LoginServlet3")
public class HibernateServlet extends HttpServlet {

    public HibernateServlet() {
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
            // User user = new User();
            // user.setName(name);
            // user.setPassword(password);
            // UserDAOProxy userDAOProxy = new UserDAOProxy();
            try {
                Configuration cfg = new Configuration();
                // cfg.configure("cn.com.inzy.hiber/hibernate.cfg.xml");
                SessionFactory sf = cfg.configure().buildSessionFactory();
                Session session = sf.openSession();
                // session.beginTransaction();
                // session.save(s);
                // session.getTransaction().commit();
                String queryStr = "from User where name = '" + name + "' and password = '" + password + "'";
                Query query = session.createQuery(queryStr);
                User user = (User) query.list().get(0);
                session.close();
                sf.close();
                if (user != null) {
                    System.out.println("��¼�ɹ�" + "user:" + user.toString());
                    info.add("�û���¼�ɹ�����ӭ" + user.getName() + "���٣�");
                } else {
                    info.add("�û���¼ʧ�ܣ�������û���������");
                    System.out.println("�û���¼ʧ�ܣ�������û���������");
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("��¼ʧ��" + e.toString());
            }
        }
        request.setAttribute("info", info);// ���������Ϣ
        request.getRequestDispatcher("Login.jsp").forward(request, response);// ��ת
    }

}
