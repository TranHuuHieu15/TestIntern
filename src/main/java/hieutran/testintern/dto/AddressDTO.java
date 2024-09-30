package hieutran.testintern.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AddressDTO {
    private Long id;
    private String street;
    private String city;
    private String country;
    private boolean active;
    private Long userId;
}
