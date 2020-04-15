package tf.handler;

/**
 * 会员异常码
 * Created by kingapex on 2018/3/13.
 *
 * @author kingapex
 * @version 1.0
 * @since 7.0.0
 * 2018/3/13
 */
public enum ServiceErrorCode {

    //会员error code
    E100("会员地址已达上限！"),
    E101("无法更改当前默认地址为非默认地址！"),
    E102("无法收藏自己的店铺！"),
    E103("此店铺已经添加为收藏！");

    private String describe;

    ServiceErrorCode(String des) {
        this.describe = des;
    }

    /**
     * 获取异常码
     *
     * @return
     */
    public String code() {
        return this.name().replaceAll("E", "");
    }


}
