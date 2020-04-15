package tf.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tf.service.TestExceptionService;

/**
 * @author stf
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestExceptionService testExceptionService;

    @PostMapping(value = "/serviceException")
    public void  testException1() {
       this.testExceptionService.testServiceExc();
    }

    @PostMapping(value = "/userException")
    public void  testException2() {
        this.testExceptionService.testUserExc();
    }
}
