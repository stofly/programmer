package tf.objecttojson;



import java.io.Serializable;

/**
 * @description: 规格分成
 * @author: huangyuan
 * @create: 2020/04/08 14:30
 */
public class SpecValueDivideVO implements Serializable {
    private static final long serialVersionUID = 8653627980641444564L;
    private Long specValueId;
    private String specValue;
    private String expression;
    private String divided;


    public String getDivided() {
        return divided;
    }

    public void setDivided(String divided) {
        this.divided = divided;
    }

    public Long getSpecValueId() {
        return specValueId;
    }

    public void setSpecValueId(Long specValueId) {
        this.specValueId = specValueId;
    }

    public String getSpecValue() {
        return specValue;
    }

    public void setSpecValue(String specValue) {
        this.specValue = specValue;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }
}
