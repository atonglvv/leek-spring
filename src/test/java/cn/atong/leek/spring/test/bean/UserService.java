package cn.atong.leek.spring.test.bean;

/**
 * @author atong
 * @version 1.0.0.1
 * @description User Service
 * @date 10:57 2022/3/25
 **/
public class UserService {

    private String uId;

    private String name;

    private Integer age;

    private UserDao userDao;

    public UserService() {
    }

    public UserService(String name) {
        this.name = name;
    }

    public String queryUserInfo() {
        System.out.println("用户Id = " + uId);
        System.out.println("用户age = " + age);
        System.out.println("查询用户信息:" + userDao.queryUserName(uId));
        return userDao.queryUserName(uId);
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }
}
