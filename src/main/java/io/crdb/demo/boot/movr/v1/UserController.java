package io.crdb.demo.boot.movr.v1;

import io.crdb.demo.boot.movr.PromoCode;
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

@Controller("UserControllerV1")
public class UserController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private DataSource cockroach;

    @Autowired
    public UserController(DataSource cockroach) {
        this.cockroach = cockroach;
    }

    @GetMapping("/movr/v1/users")
    public String getPromoCodes(Model model) {

        List<PromoCode> promoCodes = new ArrayList<>();

        try (Connection connection = cockroach.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select * from promo_codes limit 25")) {

            while (resultSet.next()) {
                PromoCode promoCode = new PromoCode();
                promoCode.setCode(resultSet.getString(1));
                promoCode.setDescription(resultSet.getString(2));
                promoCode.setCreationTime(resultSet.getDate(3));
                promoCode.setExpirationTime(resultSet.getDate(4));
                promoCode.setRules(resultSet.getString(5));

                promoCodes.add(promoCode);
            }
        } catch (SQLException e) {
            log.error("error getting /movr/v1/users", e);
        }

        model.addAttribute("promoCodes", promoCodes);

        return "promo-codes";
    }
}
