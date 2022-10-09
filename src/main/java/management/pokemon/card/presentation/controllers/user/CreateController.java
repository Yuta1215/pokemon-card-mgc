package management.pokemon.card.presentation.controllers.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import management.pokemon.card.domain.models.users.IUserRepository;
import management.pokemon.card.domain.models.users.SessionRepository;
import management.pokemon.card.domain.models.users.UserEntity;

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
        // Integer id = new Integer(1);
        // System.out.println(id);
        // Optional<UserEntity> user = this.userRepository.findById(id);
        // System.out.println(user);
        // String result = this.sessionRepository.getItem();
        // System.out.println(result);
        // List<Integer> sample = new ArrayList<>();
        class A {}
        class B extends A {}
        class C extends B {
            public void execute (List<? extends A> aList) {
                System.out.println(aList);
            }
            public void handle (List<? super B> bList) {
                System.out.println(bList);
            }
        }
        class D {}
        List<A> la = new ArrayList<>();
        List<B> lb = new ArrayList<>();
        List<C> lc = new ArrayList<>();
        A a = new A();
        B b = new B();
        C c = new C();
        la.add(a);
        lb.add(b);
        lc.add(c);
        c.execute(lc);
        c.handle(lb);
        System.out.println(c);
        return 1;
    }
}
