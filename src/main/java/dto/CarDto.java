package dto;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class CarDto {
    private String serialNumber;
    private String manufacture;
    private String model;
    private String city;
    private double price;
    private String carClass;
    private String fuel;
    private String year;
    private int seats;
    private String about;
}
