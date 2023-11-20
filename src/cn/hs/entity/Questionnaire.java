package cn.hs.entity;

/**
 *  表实体类
 */
public class Questionnaire {

    private int id;

    private String name;

    private int age;

    private String gender;
    private String email;

    private String file;


    public Questionnaire(String name, int age, String gender, String email, String file) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.file = file;
    }

    public Questionnaire() {
    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}