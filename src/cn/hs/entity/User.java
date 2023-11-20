package cn.hs.entity;

/**
 *  管理员表的实体类
 */
public class User {
    // 编号
    private int id;
    // 用户名
    private String username;
    // 密码
    private String password;
    // 邮箱
    private String email;
    // 联系方式
    private String phone;

    public User() {
    }

    public User(int id, String username, String password, String email, String phone) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
