import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, String> mp = new HashMap<>();
        mp.put(1,"AAA");
        mp.put(2,"AAA");
        mp.put(3,"AAA");
        mp.put(4,"AAA");
        System.out.println(mp.keySet());
        System.out.println(mp.values());

        for (Map.Entry<Integer,String> items: mp.entrySet()){
            System.out.printf("%d - %s \n",items.getKey(), items.getValue());
        }
    }
}