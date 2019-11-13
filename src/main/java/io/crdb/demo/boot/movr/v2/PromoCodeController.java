package io.crdb.demo.boot.movr.v2;

import io.crdb.demo.boot.movr.PromoCode;
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

@Controller("PromoCodeControllerV2")
public class PromoCodeController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private PromoCodeRepository repository;

    @Autowired
    public PromoCodeController(PromoCodeRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/movr/v2/promoCodes")
    public String getPromoCodes(Model model, @PageableDefault(size = 10, sort = "code", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<PromoCode> page = repository.findAll(pageable);
        model.addAttribute("page", page);
        return "promo-codes-pageable";
    }
}
