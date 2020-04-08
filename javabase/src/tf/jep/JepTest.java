package tf.jep;


import com.singularsys.jep.Jep;
import com.singularsys.jep.JepException;

/**
 * @author stf
 */
public class JepTest {
    /**
     * @param args
     * @throws JepException
     */
    public static void main(String[] args) throws JepException {
        //护理员默认分成
        //医院分成
        //软件公司
        try {
            //自定义函数
            Jep jep = new Jep();
            //总金额
            jep.addVariable("amount", 86900);
            //实际金额
            jep.addVariable("price", 67900);
            jep.addVariable("peridos", 36);
            jep.addVariable("yearRate", 0.07125);
            jep.addFunction("annualInterestRate", new DefCacu());
            jep.parse("annualInterestRate(amount, price, peridos, yearRate)");
            System.out.println(jep.evaluate());
        } catch (JepException e) {
            throw new JepException("参数传递异常！！！");
        } finally {
            System.out.println("该方法仍然执行！！！");
        }
    }
}

