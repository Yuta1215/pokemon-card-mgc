package management.pokemon.card.controllers.user;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import management.pokemon.card.domains.models.users.UserEntity;
import management.pokemon.card.domains.models.users.IUserRepository;
import management.pokemon.card.domains.models.users.SessionRepository;

@RestController
final class CreateController {

    private final IUserRepository userRepository;

    private final SessionRepository sessionRepository;

    public CreateController(final IUserRepository userRepository, final SessionRepository sessionRepository) {
        this.userRepository = userRepository;
        this.sessionRepository = sessionRepository;
    }

    @GetMapping("/tmp")
    public int tmp() {
        Integer id = new Integer(1);
        System.out.println(id);
        Optional<UserEntity> user = this.userRepository.findById(id);
        System.out.println(user);
        String result = this.sessionRepository.getItem();
        System.out.println(result);
        return 1;
    }
}
