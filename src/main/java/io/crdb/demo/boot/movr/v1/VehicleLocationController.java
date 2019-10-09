package io.crdb.demo.boot.movr.v1;

import io.crdb.demo.boot.movr.PromoCode;
import io.crdb.demo.boot.movr.VehicleLocationHistory;
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

@Controller("VehicleLocationControllerV1")
public class VehicleLocationController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private DataSource cockroach;

    @Autowired
    public VehicleLocationController(DataSource cockroach) {
        this.cockroach = cockroach;
    }

    @GetMapping("/movr/v1/vehicleLocations")
    public String getVehicleLocationHistory(Model model) {

        List<VehicleLocationHistory> locations = new ArrayList<>();

        try (Connection connection = cockroach.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select * from vehicle_location_histories limit 25")) {

            while (resultSet.next()) {
                VehicleLocationHistory history = new VehicleLocationHistory();
                history.setCity(resultSet.getString(1));
                history.setRideId(UUID.fromString(resultSet.getString(2)));
                history.setTimestamp(resultSet.getDate(3));
                history.setLatitude(resultSet.getFloat(4));
                history.setLongitude(resultSet.getFloat(5));

                locations.add(history);
            }
        } catch (SQLException e) {
            log.error("error getting /movr/v1/vehicleLocations", e);
        }

        model.addAttribute("locations", locations);

        return "locations";
    }
}
