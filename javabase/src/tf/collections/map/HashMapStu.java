package tf.collections.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapStu {
    public static void main(String[] args) {
        Map<String,String> hashMap =new HashMap<String,String>(12);
        Map<String,String> safeHashMap = Collections.synchronizedMap(hashMap);
        safeHashMap.put("111","大狗蛋");
        //覆盖旧值
        safeHashMap.put("111","");
        for (Map.Entry<String,String> i:safeHashMap.entrySet()) {
            System.out.print("Key:" + i.getKey() + "    ");
            System.out.println("Value:" + i.getValue());
        }

        final ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();

    }
}
