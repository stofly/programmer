package tf.java8.stream.sumcode;
//java8特性-Stream

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

//+--------------------+       +------+   +------+   +---+   +-------+
//| stream of elements +-----> |filter+-> |sorted+-> |map+-> |collect|
//+--------------------+       +------+   +------+   +---+   +-------+
public class Java8Trad {
    public static void main(String[] args) {
        new Java8Trad().StreamProcessMap();

    }

    public void StreamProcess() {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        //筛选出非空的数据
//        System.out.println(strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList()).size());
        strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList()).forEach(System.out::println);
    }

    public void StreamProcessForEach() {
        //Stream 提供了新的方法 'forEach' 来迭代流中的每个数据
        Random random = new Random();
        //limit 方法用于获取指定数量的流
        random.ints().limit(10).forEach(System.out::println);
    }

    public void StreamProcessMap() {
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        // 获取对应的平方数,并去重
        // List<Integer> squaresList = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        // 排序、去重
        List<Integer> squaresList = numbers.stream().sorted().distinct().collect(Collectors.toList());
        squaresList.forEach(System.out::println);
    }

    public void StreamProcessFilter() {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        // 获取空字符串的数量，具体筛选机制根据具体业务需求
        long count = strings.stream().filter(string -> string.length()==3).count();
        long count1 = strings.stream().filter(string -> string.isEmpty()).count();
        long count2 = strings.stream().filter(string -> !string.isEmpty()).count();
        long count13 = strings.stream().filter(string -> string.length() > 3).count();
        System.out.println(count);
    }
    public void StreamProcessCollectors() {
        //各类归约操作
        List<String>strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println("筛选列表: " + filtered);
        String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("合并字符串: " + mergedString);
    }

    public void StreamProcessCount() {
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());
    }

}
