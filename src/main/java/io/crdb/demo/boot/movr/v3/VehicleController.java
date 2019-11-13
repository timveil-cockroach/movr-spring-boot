package io.crdb.demo.boot.movr.v3;

import io.crdb.demo.boot.movr.Vehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("VehicleControllerV3")
public class VehicleController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private VehicleRepository repository;

    @Autowired
    public VehicleController(VehicleRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/movr/v3/vehicles")
    public String getVehicles(Model model, @PageableDefault(size = 10) Pageable pageable) {
        Page<Vehicle> page = repository.findAll(pageable);
        model.addAttribute("page", page);

        return "vehicles-pageable";
    }
}
