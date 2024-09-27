package hieutran.testintern.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserDTO {
    private Long id;
    private String username;
    private String fullname;
    private String email;
    private String phone;
}
