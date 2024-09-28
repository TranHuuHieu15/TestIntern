package hieutran.testintern.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
@Builder
public class User extends AbstractEntity {
    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "fullname", nullable = false)
    private String fullname;
    @Column(name = "phone", nullable = false, unique = true)
    private String phone;
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @OneToMany(mappedBy = "user")
    private Set<Address> address;

}
