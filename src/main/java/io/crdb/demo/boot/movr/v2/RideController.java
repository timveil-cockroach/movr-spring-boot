package io.crdb.demo.boot.movr.v2;

import io.crdb.demo.boot.movr.Ride;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("RideControllerV2")
public class RideController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private RideRepository repository;

    @Autowired
    public RideController(RideRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/movr/v2/rides")
    public String getRides(Model model, @PageableDefault(size = 10, sort = "startTime", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Ride> page = repository.findAll(pageable);
        model.addAttribute("page", page);

        return "rides-pageable";
    }

}
