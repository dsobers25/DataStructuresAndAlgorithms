package Maps;
import java.util.HashMap;
import java.util.Map;

public class HashMapOne {
    public static void main(String[] args) {
        
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        map.put("d", 4);
        map.put("e", 5);

        // time to output the map content
        // use an enhanced for loop to iterate over the map  
        map.forEach((k, v) -> System.out.println(k + " : " + v));

    }
    
}
