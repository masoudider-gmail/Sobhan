package sobhan.sobhankafka.consumer;

import java.util.LinkedList;
import java.util.List;

public class ListCollector {
    public static List<Integer> list = new LinkedList<>();

    public ListCollector(String string) {
        list.add(Integer.valueOf(string));
        System.out.println(list);
    }
}
