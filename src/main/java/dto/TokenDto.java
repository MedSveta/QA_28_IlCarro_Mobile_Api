package dto;

import lombok.*;

@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class TokenDto {
    private String accessToken;
}
