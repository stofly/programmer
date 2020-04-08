package tf.jep;

import com.singularsys.jep.EvaluationException;
import com.singularsys.jep.functions.NaryFunction;

//自定义函数
public class DefCacu extends NaryFunction {

    @Override
    public boolean checkNumberOfParameters(int n) {
        return n == 3 ? true : false;
    }

    //处理方法及相应的入参
    @Override
    public Object eval(Object[] args) throws EvaluationException {
        double amount = asDouble(0,args[0]);
        double newPrice = asDouble(1,args[1]);
        Integer periods = asInt(2,args[2]);
        double yearRate = asDouble(3,args[3]);
        return "ok";
    }


    //计算规则
    //院方
//    private Double getYearRate(Double amount, Double newPrice, Integer periods, Double yearRate) {
//        double yuegong = getMonth(amount, periods, yearRate);
//
//        double yg = 1d;
//
//        double yh = 1d;
//        while (com.lz.utils.math.DoubleMathUtils.sub(yg, yuegong) <= 0) {
//            yg = getMonth(newPrice, periods, yh);// 月供
//            yh = com.lz.utils.math.DoubleMathUtils.sum(yh, 0.01);
//        }
//        return yh;
//    }
//
//    private Double getMonth(Double amount, Integer periods, Double yearRate) {
//        double a = 0, i = 0;
//        int n = 0;
//        double c1;
//        double c2;
//
//        a = amount;// 总贷款
//        n = periods;
//
//        i = com.lz.utils.math.DoubleMathUtils.div(yearRate - 0.001d, 1200, 4);
//        c2 = com.lz.utils.math.DoubleMathUtils.div(a * i * Math.pow((1 + i), n), Math.pow((1 + i), n) - 1, 2);
//        return c2; // 161102 向下取整到小数点后两位
//    }
}
