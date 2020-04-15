package tf.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import tf.exception.ServiceException;
import tf.exception.UserException;

/**
 * @author stf
 */
@ControllerAdvice
public class ServiceExceptionHandler {

    //通过用服务异常抛出
    @ExceptionHandler(value = ServiceException.class)
    @ResponseBody
    public ExceptionToFront errorHandler(ServiceException e) {
        ExceptionToFront exceptionToFront = new ExceptionToFront();
        exceptionToFront.setResultCode(e.getCode());
        exceptionToFront.setResultMsg(e.getMessage());
        return exceptionToFront;
    }

    //用户异常抛出
    @ExceptionHandler(value = UserException.class)
    @ResponseBody
    public ExceptionToFront errorHandler(UserException e) {
        ExceptionToFront exceptionToFront = new ExceptionToFront();
        exceptionToFront.setResultCode(e.getCode());
        exceptionToFront.setResultMsg(e.getMessage());
        return exceptionToFront;
    }
}
