package tf.java8.stream.filter;

import tf.common.Date;
import tf.common.PersonModel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//流--过滤器
public class StreamFilter {

    public static void main(String[] args) {
        //过滤男性
//        new StreamFilter().filterSex().forEach(System.out::println);
        //过滤男性新方法
        List<PersonModel> personModels = new StreamFilter().newFilterSex();
        System.out.println(personModels.size()==0?"no date":personModels.toString());
        //过滤年龄旧方法
//       filterAge().stream().forEach(System.out::println);
        //过滤年龄java8方法
//        newFilterAge().stream().forEach(System.out::println);
    }

    public static List<PersonModel> filterAge() {
        //获取源数据
        List<PersonModel> personModelDate = new Date().getPersonModelDate();
        //建立临时数组存放符合条件的数据
        List<PersonModel> tempList = new ArrayList<>();
        for (PersonModel person : personModelDate) {
            if (person.getAge() > 26) {
                tempList.add(person);
            }
        }
        return tempList ;
    }

    public static List<PersonModel> newFilterAge() {
        List<PersonModel> personModelDate = new Date().getPersonModelDate();
        //过滤年龄大于26的
        return personModelDate.stream().filter(personModel -> personModel.getAge() > 26).collect(Collectors.toList());
    }

    public List<PersonModel> filterSex() {
        //获取源数据
        List<PersonModel> personModelDate = new Date().getPersonModelDate();
        //建立临时数组存放符合条件的数据
        List<PersonModel> tempList = new ArrayList<>();
        for (PersonModel person : personModelDate) {
            if ("男".equals(person.getSex())) {
                tempList.add(person);
            }
        }
        return tempList;
    }


    public List<PersonModel> newFilterSex() {
        List<PersonModel> personModelDate = new Date().getPersonModelDate();
        //过滤年龄大于26的
        return personModelDate.stream().filter(personModel -> personModel.getSex().equals("男")&&personModel.getAge()>30).collect(Collectors.toList());
    }
}
