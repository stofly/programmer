package tf.objecttojson;


import java.io.Serializable;
import java.util.List;

/**
 * @program: javashop-b2b2c
 * @description: 护理员分成设置
 * @author: Xu.YangPing
 * @create: 2020-04-08 09:58
 **/
public class NursingDividedVO implements Serializable {
    private static final long serialVersionUID = -1277431993789860371L;
    private String expression;
    private String divided;
    private SpecificationDO spec;
    private List<SpecValueDivideVO> specValueDivides;


    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public String getDivided() {
        return divided;
    }

    public void setDivided(String divided) {
        this.divided = divided;
    }

    public SpecificationDO getSpec() {
        return spec;
    }

    public void setSpec(SpecificationDO spec) {
        this.spec = spec;
    }

    public List<SpecValueDivideVO> getSpecValueDivides() {
        return specValueDivides;
    }

    public void setSpecValueDivides(List<SpecValueDivideVO> specValueDivides) {
        this.specValueDivides = specValueDivides;
    }
}
