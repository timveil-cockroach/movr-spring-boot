package io.crdb.demo.boot.movr.v1;

import io.crdb.demo.boot.movr.Ride;
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

@Controller("RideControllerV1")
public class RideController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private DataSource cockroach;

    @Autowired
    public RideController(DataSource cockroach) {
        this.cockroach = cockroach;
    }

    @GetMapping("/movr/v1/rides")
    public String getRides(Model model) {

        List<Ride> rides = new ArrayList<>();

        try (Connection connection = cockroach.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select * from rides limit 25")) {

            while (resultSet.next()) {
                Ride ride = new Ride();
                ride.setId(UUID.fromString(resultSet.getString(1)));
                ride.setCity(resultSet.getString(2));
                ride.setVehicleCity(resultSet.getString(3));
                ride.setRiderId(UUID.fromString(resultSet.getString(4)));
                ride.setVehicleId(UUID.fromString(resultSet.getString(5)));
                ride.setStartAddress(resultSet.getString(6));
                ride.setEndAddress(resultSet.getString(7));
                ride.setStartTime(resultSet.getDate(8));
                ride.setEndTime(resultSet.getDate(9));
                ride.setRevenue(resultSet.getDouble(10));
                rides.add(ride);
            }
        } catch (SQLException e) {
            log.error("error getting /movr/v1/rides", e);
        }

        model.addAttribute("rides", rides);

        return "rides";
    }
}
