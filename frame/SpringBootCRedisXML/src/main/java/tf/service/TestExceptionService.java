package tf.service;

import org.springframework.stereotype.Service;
import tf.exception.ServiceException;
import tf.exception.UserException;
import tf.handler.ServiceErrorCode;

/**
 * @author stf
 */
@Service
public class TestExceptionService {

    public void testServiceExc() {
        throw new ServiceException(ServiceErrorCode.E100.code(),"服务参数校验错误");
    }

    public void testUserExc() {
        throw new UserException(ServiceErrorCode.E100.code(),"用户参数校验错误");
    }
}
