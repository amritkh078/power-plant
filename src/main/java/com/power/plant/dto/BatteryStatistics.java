package com.power.plant.dto;

import java.util.List;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BatteryStatistics {
    private List<String> batteryNames;
    private int totalWattCapacity;
    private double averageWattCapacity;
}
