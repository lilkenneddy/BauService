package codillas.BauService.dto;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AdminDetailsDto {
    private final String id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phoneNumber;
    private final String status;
    private final String type;
}
