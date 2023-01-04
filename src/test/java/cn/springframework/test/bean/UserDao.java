package cn.springframework.test.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname UserDao
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/12/28 10:34
 * @Created by kevynpan
 */
public class UserDao {

    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("1001", "小楷");
        hashMap.put("1002", "小吴");
        hashMap.put("1003", "小陈");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }
}
