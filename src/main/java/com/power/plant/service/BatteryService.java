package com.power.plant.service;

import com.power.plant.entity.Battery;
import com.power.plant.repository.BatteryRepository;
import com.power.plant.dto.BatteryStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BatteryService {

    @Autowired
    private BatteryRepository batteryRepository;

    public List<Battery> saveBatteries(List<Battery> batteries) {
        return batteryRepository.saveAll(batteries);
    }

    public List<Battery> getBatteriesByPostcodeRange(String startPostcode, String endPostcode) {
        return batteryRepository.findByPostcodeBetween(startPostcode, endPostcode);
    }

    // Method to get statistics for batteries within a postcode range
    public BatteryStatistics getBatteryStatistics(String startPostcode, String endPostcode) {
        List<Battery> batteries = getBatteriesByPostcodeRange(startPostcode, endPostcode);

        List<String> batteryNames = batteries.stream()
                .map(Battery::getName)
                .sorted()
                .collect(Collectors.toList());

        int totalWattCapacity = batteries.stream()
                .mapToInt(Battery::getWattCapacity)
                .sum();

        double averageWattCapacity = batteries.stream()
                .mapToInt(Battery::getWattCapacity)
                .average()
                .orElse(0.0);

        return new BatteryStatistics(batteryNames, totalWattCapacity, averageWattCapacity);
    }
}
