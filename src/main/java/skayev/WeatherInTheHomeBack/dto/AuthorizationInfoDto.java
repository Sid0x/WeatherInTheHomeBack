package skayev.WeatherInTheHomeBack.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthorizationInfoDto {
    private String token;
}
