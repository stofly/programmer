package tf.stream.flatmap;

import tf.common.Date;
import tf.common.PersonModel;
import tf.stream.Map.StreamMap;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class StreamFlatMap {
    public static void main(String[] args) {
        List<String> personName = new StreamFlatMap().flatMapString();
        System.out.println(personName.size() == 0 ? "no date" : personName.toString());
    }

    public List<String>  flatMapString() {
        List<PersonModel> personModelDate = new Date().getPersonModelDate();
        List<String> collect = personModelDate.stream().flatMap(personModel -> Arrays.stream(personModel.getName().split("stf"))).collect(toList());
        return collect;
    }
}
