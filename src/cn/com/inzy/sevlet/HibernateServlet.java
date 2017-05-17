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
        if (name == null || "".equals(name)) { // 用户名输入格式问题
            info.add("用户名不能为空");
            System.out.println("用户名不能为空");
        }

        if (password == null || "".equals(password)) {// 密码输入格式问题
            info.add("密码不能为空");
            System.out.println("密码不能为空");
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
                    System.out.println("登录成功" + "user:" + user.toString());
                    info.add("用户登录成功，欢迎" + user.getName() + "光临！");
                } else {
                    info.add("用户登录失败，错误的用户名和密码");
                    System.out.println("用户登录失败，错误的用户名和密码");
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("登录失败" + e.toString());
            }
        }
        request.setAttribute("info", info);// 保存错误信息
        request.getRequestDispatcher("Login.jsp").forward(request, response);// 跳转
    }

}
