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
 * @date 2017年5月17日 上午10:02:21
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
        if (name == null || "".equals(name)) { // 用户名输入格式问题
            info.add("用户名不能为空");
            System.out.println("用户名不能为空");
        }

        if (password == null || "".equals(password)) {// 密码输入格式问题
            info.add("密码不能为空");
            System.out.println("密码不能为空");
        }
        if (info.size() == 0) {
            User user = new User();
            user.setName(name);
            user.setPassword(password);
            UserDAOProxy userDAOProxy = new UserDAOProxy();
            try {

                if (userDAOProxy.findLogin(user)) {
                    System.out.println("登录成功");
                    info.add("用户登录成功，欢迎" + user.getName() + "光临！");
                } else {
                    info.add("用户登录失败，错误的用户名和密码");
                    System.out.println("用户登录失败，错误的用户名和密码");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        request.setAttribute("info", info);// 保存错误信息
        request.getRequestDispatcher("Login.jsp").forward(request, response);// 跳转
    }

}
