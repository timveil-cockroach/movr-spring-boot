package io.crdb.demo.boot.movr.v1;

import io.crdb.demo.boot.movr.User;
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

@Controller("UserControllerV1")
public class UserController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private DataSource cockroach;

    @Autowired
    public UserController(DataSource cockroach) {
        this.cockroach = cockroach;
    }

    @GetMapping("/movr/v1/users")
    public String getUsers(Model model) {

        List<User> users = new ArrayList<>();

        try (Connection connection = cockroach.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select * from users limit 25")) {

            while (resultSet.next()) {
                User user = new User();
                user.setId(UUID.fromString(resultSet.getString(1)));
                user.setCity(resultSet.getString(2));
                user.setName(resultSet.getString(3));
                user.setAddress(resultSet.getString(4));
                user.setCreditCard(resultSet.getString(5));

                users.add(user);
            }
        } catch (SQLException e) {
            log.error("error getting /movr/v1/users", e);
        }

        model.addAttribute("users", users);

        return "users";
    }
}
