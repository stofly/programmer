package tf.java8.stream.Map;


import tf.common.Date;
import tf.common.PersonModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author stf
 */
public class StreamMap {

    public static void main(String[] args) {
        new StreamMap().newGetPersonName();
//        System.out.println(personName.size() == 0 ? "no date" : personName.toString());
    }

    public List<String> getPersonName() {
        List<String> nameList = new ArrayList<>(5);
        //获取源数据
        List<PersonModel> personModelDate = new Date().getPersonModelDate();
        for (PersonModel person : personModelDate) {
            nameList.add(person.getName());
        }

        return nameList;
    }

    public List<String> newGetPersonName() {
        List<PersonModel> personModelDate = new Date().getPersonModelDate();

        //取实体类集合得名字，单独成一个名字字符集合
        List<String> collect = personModelDate.stream().map(personModel -> personModel.getName()).collect(Collectors.toList());

        //与上一个方式相同
        List<String> collect2 = personModelDate.stream().map(PersonModel::getName).collect(Collectors.toList());

        //将名字与年龄从实体类形式转换成  key value值得形式，即以键值对得形式存储
        Map<String, Integer> personModelMap = personModelDate.stream().collect(Collectors.toMap(PersonModel::getName, PersonModel::getAge));

        //java8循环输出map
        //第一种
        personModelMap.forEach((s, integer) -> System.out.println(s+":"+integer));
        personModelMap.values().forEach(System.out::println);
        return null;
    }
}
