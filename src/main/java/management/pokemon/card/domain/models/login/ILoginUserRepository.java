package management.pokemon.card.domain.models.login;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILoginUserRepository extends JpaRepository<LoginUserEntity, Integer> {
  long countByEmailAndPassword(String email, String passowrd);
}
