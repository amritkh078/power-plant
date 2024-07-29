package com.power.plant.repository;

import com.power.plant.entity.Battery;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BatteryRepository  extends JpaRepository<Battery, Long> {

    List<Battery> findByPostcodeBetween(String startPostcode, String endPostcode);
}
