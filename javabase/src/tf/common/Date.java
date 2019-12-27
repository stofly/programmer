package tf.common;

import java.util.Arrays;
import java.util.List;

public class Date {

    private static List<PersonModel> personModelList = null;

    //静态代码块，初始化数据
    static {
        PersonModel personModel1 = new PersonModel("stf", 25, "男");
        PersonModel personModel2 = new PersonModel("stf2", 26, "女");
        PersonModel personModel3 = new PersonModel("stf3", 27, "男");
        PersonModel personModel4 = new PersonModel("stf4", 28, "女");
        PersonModel personModel5 = new PersonModel("stf5", 29, "男");

        personModelList = Arrays.asList(personModel1, personModel2, personModel3, personModel4, personModel5);
    }

    //数据源获取方法
    public List<PersonModel> getPersonModelDate() {
        return personModelList;
    }
}
