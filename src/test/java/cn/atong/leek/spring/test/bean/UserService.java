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

    private UserDao userDao;

    public UserService() {
    }

    public UserService(String name) {
        this.name = name;
    }

    public String queryUserInfo() {
        System.out.println("用户Id = " + uId);
        System.out.println("查询用户信息:" + userDao.queryUserName(uId));
        return userDao.queryUserName(uId);
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

}
