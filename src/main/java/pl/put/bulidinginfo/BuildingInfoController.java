package pl.put.bulidinginfo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pl.put.bulidinginfo.models.Location;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class    BuildingInfoController {

    private static final Logger logger = LoggerFactory.getLogger(BuildingInfoController.class);

    @GetMapping("/area")
    public Float getArea(@RequestBody Location body){
        logger.info("For location: " + body.name + " area is: " + body.getArea().toString() + " m^2");
        return body.getArea();
    }

}