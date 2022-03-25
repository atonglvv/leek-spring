package cn.atong.leek.spring.test.beans;

/**
 * @description  User Service
 * @author atong
 * @date 10:27 2022/3/25
 * @version 1.0.0.1
 **/
public class UserService {

    private String name;

    public UserService() {
    }

    public UserService(String name) {
        this.name = name;
    }

    public void queryUserInfo(){
        System.out.println("查询用户信息:" + this.name);
    }

}
