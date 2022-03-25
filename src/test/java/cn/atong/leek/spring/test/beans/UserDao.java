package cn.atong.leek.spring.test.beans;

import java.util.HashMap;
import java.util.Map;

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

}
