package tf.exception;

import com.sun.org.apache.xpath.internal.objects.XString;

public class TestTryCatch {
    public static void main(String[] args) {

        String uri = "/open/forwardwx/wxa/commit?appId={appId}";
        System.out.println(uri.contains("/wxa/commit"));
        try {
            //错误前
            System.out.println("errorBefor");
            int i =10/0;
            System.out.println("errorBefor");
        }catch (Exception e){
            System.out.println(e.getMessage()+"---result");
        }
        System.out.println(111);
    }

}
