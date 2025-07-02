package codillas.BauService.dto;

import lombok.Data;

@Data
public class AdminDetailsDto {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phone_number;
    private final String type;
    private final String status;
}