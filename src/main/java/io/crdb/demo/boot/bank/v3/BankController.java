package io.crdb.demo.boot.bank.v3;

import io.crdb.demo.boot.bank.Bank;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller("BankControllerV3")
public class BankController {

    @GetMapping("/v3/banks")
    public String getBanks(Model model) {

        return "banks";

    }
}
