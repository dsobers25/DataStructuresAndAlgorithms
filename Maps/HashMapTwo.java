package Maps;
import java.util.HashMap;
import java.util.Map;

public class HashMapTwo {

     public static void main(String[] args) {

        System.out.println("Hey Mama");

        Map<String, String> mapOne = new HashMap<>();
        mapOne.put("a", "apple");
        mapOne.put("b", "banana");
        mapOne.put("c", "cherry");
        mapOne.put("d", "date");
        mapOne.put("e", "elderberry");

        mapOne.entrySet().stream().filter(entry -> entry.getKey() != "z")
        .forEach(entry -> System.out.println("Hey the key is " + entry.getKey()));
        

        
    }
    
}
