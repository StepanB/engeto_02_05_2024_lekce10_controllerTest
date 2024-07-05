package cz.engeto.ControllerTest.controller;

import cz.engeto.ControllerTest.dto.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private List<User> users = new ArrayList<>();

    public void createDefaultUsers() {
        User user = new User();
        user.setName("Stepan");
        user.setLastName("Bohm");
        user.setUserId(1L);

        User user2 = new User("Karel", "Novak", 2L, "Kaja");

        users.add(user);
        users.add(user2);
    }

    @GetMapping("create")
    public void createUsers() {
        createDefaultUsers();
    }

    @GetMapping
    public List<User> getUser() {
        return users;
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        User user = new User("User", "Zadny", id, null);
        return user;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        users.add(user);

        return user;
    }


}
