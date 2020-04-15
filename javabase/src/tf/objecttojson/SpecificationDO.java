package tf.objecttojson;


import java.io.Serializable;


/**
 * 规格项实体
 * @author fk
 * @version v2.0
 * @since v7.0.0
 * 2018-03-20 09:31:27
 */

public class SpecificationDO implements Serializable {
			
    private static final long serialVersionUID = 5111769180376075L;
    
    /**主键*/

    private Integer specId;
    /**规格项名称*/

    private String specName;
	/**是否被删除0 删除   1  没有删除*/

    private Integer disabled;
    /**规格描述*/

    private String specMemo;
    /**所属卖家 0属于平台*/
    private Integer sellerId;
    public SpecificationDO() {}
    
    
    public SpecificationDO(String specName, Integer disabled, String specMemo, Integer sellerId) {
		super();
		this.specName = specName;
		this.disabled = disabled;
		this.specMemo = specMemo;
		this.sellerId = sellerId;
	}

    public Integer getSpecId() {
        return specId;
    }
    public void setSpecId(Integer specId) {
        this.specId = specId;
    }

    public String getSpecName() {
        return specName;
    }
    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public Integer getDisabled() {
        return disabled;
    }
    public void setDisabled(Integer disabled) {
        this.disabled = disabled;
    }

    public String getSpecMemo() {
        return specMemo;
    }
    public void setSpecMemo(String specMemo) {
        this.specMemo = specMemo;
    }

    public Integer getSellerId() {
        return sellerId;
    }
    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    @Override
   	public String toString() {
   		return "SpecificationDO [specId=" + specId + ", specName=" + specName + ", disabled=" + disabled + ", specMemo="
   				+ specMemo + ", sellerId=" + sellerId + "]";
   	}
	
}