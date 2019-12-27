package tf.stream.Map;


import tf.common.Date;
import tf.common.PersonModel;
import tf.stream.filter.StreamFilter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMap {

    public static void main(String[] args) {
        List<String> personName = new StreamMap().newGetPersonName();
        System.out.println(personName.size() == 0 ? "no date" : personName.toString());
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
//        List<String> collect = personModelDate.stream().map(personModel -> personModel.getName()).collect(Collectors.toList());
        List<String> collect = personModelDate.stream().map(PersonModel::getName).collect(Collectors.toList());
        return collect;
    }
}
