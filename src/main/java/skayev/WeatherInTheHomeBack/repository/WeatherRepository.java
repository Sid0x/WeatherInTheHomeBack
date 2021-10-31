package skayev.WeatherInTheHomeBack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import skayev.WeatherInTheHomeBack.entity.UserEntity;

public interface WeatherRepository extends JpaRepository<UserEntity, Long> {
}
