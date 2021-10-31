package skayev.WeatherInTheHomeBack.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import skayev.WeatherInTheHomeBack.dto.AuthorizationInfoDto;
import skayev.WeatherInTheHomeBack.dto.UserDto;
import skayev.WeatherInTheHomeBack.service.AuthorizationService;


@RestController
@AllArgsConstructor
public class AuthorizationApi {
    private AuthorizationService authorizationService;

    @PostMapping("/login")
    public AuthorizationInfoDto login(@RequestBody UserDto userDto) {
        return authorizationService.getAuthorizationInfo(userDto);
    }

}
