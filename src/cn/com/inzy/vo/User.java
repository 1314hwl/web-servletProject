package cn.com.inzy.vo;

/**
 * @Description User实体类
 * @author HuWeiLiang
 * @date 2017年5月17日 上午9:58:20
 */
public class User {
    private int id;

    private String name;// 对应数据库中name

    private String password;// 对应数据库中password

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
