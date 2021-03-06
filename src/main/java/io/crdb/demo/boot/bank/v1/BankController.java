package io.crdb.demo.boot.bank.v1;

import io.crdb.demo.boot.bank.Bank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * this example uses the DataSource directly
 */
@Controller("BankControllerV1")
public class BankController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    private DataSource cockroach;

    @Autowired
    public BankController(DataSource cockroach) {
        this.cockroach = cockroach;
    }

    @GetMapping("/bank/v1/banks")
    public String getBanks(Model model) {

        List<Bank> banks = new ArrayList<>();

        try (Connection connection = cockroach.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select * from bank limit 25")) {

            while (resultSet.next()) {
                Bank bank = new Bank();
                bank.setId(resultSet.getLong(1));
                bank.setBalance(resultSet.getLong(2));
                bank.setPayload(resultSet.getString(3));

                banks.add(bank);
            }
        } catch (SQLException e) {
            log.error("error getting /bank/v1/banks", e);
        }

        model.addAttribute("banks", banks);

        return "banks";
    }
}
