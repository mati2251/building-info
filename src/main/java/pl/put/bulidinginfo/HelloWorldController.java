package pl.put.bulidinginfo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class HelloWorldController {

    private static final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

    @GetMapping("/")
    public String helloWorld(@RequestBody HelloWorldRequestBody body){
        logger.info("Hello World!");
        return "Hello World " + body.name + "!";
    }

    static class HelloWorldRequestBody {
        public String name;
    }
}