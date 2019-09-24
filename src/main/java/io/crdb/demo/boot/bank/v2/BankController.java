package io.crdb.demo.boot.bank.v2;

import io.crdb.demo.boot.bank.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller("BankControllerV2")
public class BankController {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BankController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/bank/v2/banks")
    public String getBanks(Model model) {

        List<Bank> banks = jdbcTemplate.query("select * from bank limit 25", (resultSet, i) -> {
            Bank bank = new Bank();
            bank.setId(resultSet.getLong(1));
            bank.setBalance(resultSet.getLong(2));
            bank.setPayload(resultSet.getString(3));
            return bank;
        });

        model.addAttribute("banks", banks);

        return "banks";

    }
}
