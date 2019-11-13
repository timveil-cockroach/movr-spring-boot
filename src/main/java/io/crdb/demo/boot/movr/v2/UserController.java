package io.crdb.demo.boot.movr.v2;

import io.crdb.demo.boot.movr.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("UserControllerV2")
public class UserController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private UserRepository repository;

    @Autowired
    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/movr/v2/users")
    public String getUsers(Model model, @PageableDefault(size = 10, sort = "name", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<User> page = repository.findAll(pageable);
        model.addAttribute("page", page);

        return "users-pageable";
    }
}
