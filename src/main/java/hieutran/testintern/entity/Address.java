package hieutran.testintern.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "addresses")
@Builder
public class Address extends AbstractEntity {
    @Column(name = "street", nullable = false)
    private String street;
    @Column(name = "city", nullable = false)
    private String city;
    @Column(name = "country", nullable = false)
    private String country;
    @Column(name = "is_active", nullable = false)
    private boolean is_active = false;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

}
