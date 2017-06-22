package net.pvardanega.kdo_noel.me;

import lombok.RequiredArgsConstructor;
import net.pvardanega.kdo_noel.list.EnvyList;
import net.pvardanega.kdo_noel.list.EnvyListRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("me")
@RequiredArgsConstructor
public class MeController {

    private final EnvyListRepository envyListRepository;
    private final UserRepository userRepository;

    @GetMapping
    public User principal() {
        return userRepository.findByFirstName("Pierre-Jean");
    }

    @GetMapping("list")
    public EnvyList getPrincipalList() {
        return envyListRepository.findByOwner(principal());
    }
}
