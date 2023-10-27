package cn.atong.leek.spring.test.bean;

import cn.atong.leek.spring.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserDao {

    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001", "atong");
        hashMap.put("10002", "cc");
        hashMap.put("10003", "aa");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }

    public void initDataMethod(){
        System.out.println("======UserDao.init-method======");
    }

    public void destroyDataMethod(){
        System.out.println("======UserDao.destroy-method======");
        hashMap.clear();
    }

}
