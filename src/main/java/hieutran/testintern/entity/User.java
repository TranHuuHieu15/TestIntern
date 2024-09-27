package hieutran.testintern.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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

    @OneToMany(mappedBy = "users", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Address> address;

}
