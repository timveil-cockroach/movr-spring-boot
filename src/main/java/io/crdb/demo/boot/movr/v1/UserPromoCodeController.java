package io.crdb.demo.boot.movr.v1;

import io.crdb.demo.boot.movr.UserPromoCode;
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
import java.util.UUID;

@Controller("UserPromoCodeControllerV1")
public class UserPromoCodeController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private DataSource cockroach;

    @Autowired
    public UserPromoCodeController(DataSource cockroach) {
        this.cockroach = cockroach;
    }

    @GetMapping("/movr/v1/userPromoCodes")
    public String getUserPromoCodes(Model model) {

        List<UserPromoCode> promoCodes = new ArrayList<>();

        try (Connection connection = cockroach.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select * from user_promo_codes limit 25")) {

            while (resultSet.next()) {
                UserPromoCode userPromoCodes = new UserPromoCode();
                userPromoCodes.setCity(resultSet.getString(1));
                userPromoCodes.setUserId(UUID.fromString(resultSet.getString(2)));
                userPromoCodes.setCode(resultSet.getString(3));
                userPromoCodes.setTimestamp(resultSet.getDate(4));
                userPromoCodes.setUsageCount(resultSet.getInt(5));
                promoCodes.add(userPromoCodes);
            }
        } catch (SQLException e) {
            log.error("error getting /movr/v1/userPromoCodes", e);
        }

        model.addAttribute("userPromoCodes", promoCodes);

        return "user-promo-codes";
    }
}
