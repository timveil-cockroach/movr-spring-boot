package io.crdb.demo.boot.bank.v3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("BankControllerV3")
public class BankController {

    @GetMapping("/bank/v3/banks")
    public String getBanks(Model model) {

        return "banks";

    }
}
