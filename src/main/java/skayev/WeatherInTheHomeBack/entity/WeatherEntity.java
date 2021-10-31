package skayev.WeatherInTheHomeBack.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "weather")
@EntityListeners(AuditingEntityListener.class)
public class WeatherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    @JoinColumn(name = "room_id", nullable = false)
    private RoomEntity room;

    @Column(name = "co2")
    private String co2;

    @Column(name = "temperature", nullable = false)
    private String temperature;

    @Column(name = "humidity", nullable = false)
    private String humidity;

    @Column(name = "atmospheric_pressure", nullable = false)
    private String atmosphericPressure;

    @Column(name = "date", nullable = false)
    private Date date;
}
