package io.crdb.demo.boot.movr.v1;

import io.crdb.demo.boot.movr.PromoCode;
import io.crdb.demo.boot.movr.Vehicle;
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

@Controller("VehicleControllerV1")
public class VehicleController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private DataSource cockroach;

    @Autowired
    public VehicleController(DataSource cockroach) {
        this.cockroach = cockroach;
    }

    @GetMapping("/movr/v1/vehicles")
    public String getPromoCodes(Model model) {

        List<Vehicle> vehicles = new ArrayList<>();

        try (Connection connection = cockroach.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select * from vehicles limit 25")) {

            while (resultSet.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setId(UUID.fromString(resultSet.getString(1)));
                vehicle.setCity(resultSet.getString(2));
                vehicle.setType(resultSet.getString(3));
                vehicle.setOwnerId(UUID.fromString(resultSet.getString(4)));
                vehicle.setCreationDate(resultSet.getDate(5));
                vehicle.setStatus(resultSet.getString(6));
                vehicle.setCurrentLocation(resultSet.getString(7));
                vehicle.setExt(resultSet.getString(8));

                vehicles.add(vehicle);
            }
        } catch (SQLException e) {
            log.error("error getting /movr/v1/vehicles", e);
        }

        model.addAttribute("vehicles", vehicles);

        return "vehicles";
    }
}
