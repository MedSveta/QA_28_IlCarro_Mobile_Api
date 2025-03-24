package dto;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class RegistrationBodyDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
