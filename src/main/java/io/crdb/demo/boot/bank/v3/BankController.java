package io.crdb.demo.boot.bank.v3;

import io.crdb.demo.boot.bank.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("BankControllerV3")
public class BankController {

    private BankRepository repository;

    @Autowired
    public BankController(BankRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/bank/v3/banks")
    public String getBanks(Model model, @PageableDefault(size = 10) Pageable pageable) {
        Page<Bank> page = repository.findAll(pageable);
        model.addAttribute("page", page);

        return "banks-pageable";
    }
}
