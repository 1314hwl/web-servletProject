package cn.com.inzy.vo;

/**
 * @Description Userʵ����
 * @author HuWeiLiang
 * @date 2017��5��17�� ����9:58:20
 */
public class User {
    private int id;

    private String name;// ��Ӧ���ݿ���name

    private String password;// ��Ӧ���ݿ���password

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", password=" + password + "]";
    }

}
