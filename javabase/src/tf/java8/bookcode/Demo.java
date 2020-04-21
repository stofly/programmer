package tf.java8.bookcode;

/**
 * @author user
 */
public class Demo {

    public Object getNewInstance(Class cla,int code,String msg) throws IllegalAccessException, InstantiationException {
        Object o = cla.newInstance();
        return o;
    }

}

//实例化多个方法

class dog {
    private int code;
    private String msg;

    public dog(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public dog() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

class cat{
    private int code;
    private String msg;

    public cat(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public cat() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}