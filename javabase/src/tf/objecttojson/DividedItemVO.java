package tf.objecttojson;


import java.io.Serializable;

/**
 * @program: javashop-b2b2c
 * @description: 分成配置类
 * @author: Xu.YangPing
 * @create: 2020-04-07 10:58
 **/
public class DividedItemVO implements Serializable{
    private static final long serialVersionUID = 573876528024850817L;

    private NursingDividedVO nursingDivided;
    private String hospitalExpression;
    private String hospitalDivided;

    private String softCompanyExpression;


    public String getHospitalDivided() {
        return hospitalDivided;
    }

    public void setHospitalDivided(String hospitalDivided) {
        this.hospitalDivided = hospitalDivided;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public NursingDividedVO getNursingDivided() {
        return nursingDivided;
    }

    public void setNursingDivided(NursingDividedVO nursingDivided) {
        this.nursingDivided = nursingDivided;
    }

    public String getHospitalExpression() {
        return hospitalExpression;
    }

    public void setHospitalExpression(String hospitalExpression) {
        this.hospitalExpression = hospitalExpression;
    }

    public String getSoftCompanyExpression() {
        return softCompanyExpression;
    }

    public void setSoftCompanyExpression(String softCompanyExpression) {
        this.softCompanyExpression = softCompanyExpression;
    }
}
