package dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor

//serialNumber*	string
//manufacture*	string
//model*	string
//year*	string
//fuel*	string
//seats*	integer($int32)
//carClass*	string
//pricePerDay*	number($double)
//about	string
//city*	string
//lat	number($double)
//lng	number($double)
//image	string
//owner	string
//bookedPeriods	[...]

public class CarDto {
    private String serialNumber;
    private String manufacture;
    private String model;
    private String year;
    private String fuel;
    private int seats;
    private String carClass;
    private double pricePerDay;
    private String about;
    private String city;
    private double lat;
    private double lng;
    private String image;
    private String owner;
    private List<BookedDto> bookedPeriods;
}
