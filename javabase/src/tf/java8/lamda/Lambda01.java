package tf.java8.lamda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda01 {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>(2);
        names.add("TaoBao");
        names.add("ZhiFuBao");
        List<String> lowercaseNames = names.stream().map((String name) -> {
            return name.toLowerCase();
        }).collect(Collectors.toList());
        System.out.println(lowercaseNames);
    }
}
