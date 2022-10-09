package management.pokemon.card.domain.models.users;

import javax.persistence.*;

@Entity
@Table(name = "dtb_user")
public class UserEntity {
    @Id
    @Column(name = "user_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "activation_date")
    private String activation_date;
}
