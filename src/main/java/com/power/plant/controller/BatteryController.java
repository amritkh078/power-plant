package com.power.plant.controller;

import com.power.plant.dto.BatteryStatistics;
import com.power.plant.entity.Battery;
import com.power.plant.service.BatteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/batteries")
public class BatteryController {

    @Autowired
    private BatteryService batteryService;

    @PostMapping
    public List<Battery> addBatteries(@RequestBody List<Battery> batteries) {
        return batteryService.saveBatteries(batteries);
    }

    @GetMapping("/statistics")
    public BatteryStatistics getBatteriesByPostcodeRange(
            @RequestParam String startPostcode,
            @RequestParam String endPostcode) {
        return batteryService.getBatteryStatistics(startPostcode, endPostcode);
    }
}
