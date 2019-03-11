package map;


import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("D","L");
        String a = map.get("D");
        System.out.println(a);
    }
}
