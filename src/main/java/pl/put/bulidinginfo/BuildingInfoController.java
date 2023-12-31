package pl.put.bulidinginfo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.put.bulidinginfo.models.Location;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
public class BuildingInfoController {

    private static final Logger logger = LoggerFactory.getLogger(BuildingInfoController.class);

    @GetMapping("/area")
    public Float getArea(@RequestBody Location body){
        logger.info("For location: " + body.name + " area is: " + body.getArea().toString() + " m^2");
        return body.getArea();
    }

    @GetMapping("/cube")
    public Float getCube(@RequestBody Location body){
        logger.info("For location: " + body.name + " cube is: " + body.getCube().toString() + " m^3");
        return body.getCube();
    }

    @GetMapping("/heating-per-cube-meter")
    public List<Location> getLocationsWithHigherHeatingRate(@RequestBody Location body, @RequestParam Float thresholdRate){
        logger.info("List of locations that have higher rate: " + body.getLocationsWithHigherHeatingRate(thresholdRate).toString());
        return body.getLocationsWithHigherHeatingRate(thresholdRate);
    }

    @GetMapping("/heating-consumption")
    public Float getHeatingPerCube(@RequestBody Location body){
        logger.info("For location: " + body.name  + " heating consumption is: " + body.getHeatingPerCubeMeter().toString() + " W/m^3");
        return body.getHeatingPerCubeMeter();
    }

    @GetMapping("/lighting-power")
    public Float getLightingPower(@RequestBody Location body){
        logger.info("For location: " + body.name  + " lighting power is: " + body.getHeatingPerCubeMeter().toString() + " W/m^2");
        return body.getLightingPower();
    }
}