package skayev.WeatherInTheHomeBack.service;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import skayev.WeatherInTheHomeBack.dto.AuthorizationInfoDto;
import skayev.WeatherInTheHomeBack.dto.UserDto;
import skayev.WeatherInTheHomeBack.exception.InvalidUserOrPasswordException;
import skayev.WeatherInTheHomeBack.repository.UserRepository;
import skayev.WeatherInTheHomeBack.security.SecurityUtil;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthorizationService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public Optional<Boolean> isAuthorize(UserDto userDto) {
        return userRepository.findByUsername(userDto
                .getUsername())
                .map(userEntity -> passwordEncoder.matches(userDto.getPassword(), userEntity.getPassword()));
    }

    public AuthorizationInfoDto getAuthorizationInfo(UserDto userDto) {
        Optional<Boolean> authorizeOptional = isAuthorize(userDto);

        if (authorizeOptional.isPresent() && Boolean.TRUE.equals(authorizeOptional.get())) {
            return new AuthorizationInfoDto(SecurityUtil.generateToken(userDto.getUsername()));
        } else {
            throw new InvalidUserOrPasswordException();
        }
    }


}
