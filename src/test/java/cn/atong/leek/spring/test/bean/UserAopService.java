package cn.atong.leek.spring.test.bean;

import java.util.Random;

/**
 * @program: leek-spring
 * @description:
 * @author: atong
 * @create: 2023-10-25 17:07
 */
public class UserAopService implements IUserAopService {

    public String queryUserInfo() {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "atong，100001，深圳";
    }

    public String register(String userName) {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "注册用户：" + userName + " success！";
    }

}
