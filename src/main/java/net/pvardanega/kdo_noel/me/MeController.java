package net.pvardanega.kdo_noel.me;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MeController {

    @GetMapping("/me")
    public User principal() {
        return new User("Pierre-Jean", "Vardanéga");
    }

}
