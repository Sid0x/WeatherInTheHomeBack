package skayev.WeatherInTheHomeBack.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import skayev.WeatherInTheHomeBack.dto.ExceptionDto;
import skayev.WeatherInTheHomeBack.exception.InvalidUserOrPasswordException;

@ControllerAdvice
public class DefaultAdvice {

    @ExceptionHandler(InvalidUserOrPasswordException.class)
    public ResponseEntity<ExceptionDto> handleException() {

        return new ResponseEntity<>(new ExceptionDto("Invalid user or password"), HttpStatus.BAD_REQUEST);
    }
}
