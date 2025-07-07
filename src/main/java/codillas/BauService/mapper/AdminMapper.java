package codillas.BauService.mapper;

import codillas.BauService.dto.AdminDetailsDto;
import codillas.BauService.dto.AdminRegistrationDto;
import codillas.BauService.dto.AdminUpdateDto;
import codillas.BauService.service.domain.Admin;
import codillas.BauService.service.domain.AdminStatus;
import codillas.BauService.service.domain.AdminType;
import org.springframework.stereotype.Component;

@Component
public class AdminMapper {
    public AdminDetailsDto toAdminDetailsDto(Admin admin) {
        return AdminDetailsDto.builder()
                .id(admin.getId())
                .firstName(admin.getFirstName())
                .lastName(admin.getLastName())
                .email(admin.getEmail())
                .phoneNumber(admin.getPhoneNumber())
                .status(admin.getStatus().name())
                .type(admin.getType().name())
                .build();
    }

    public Admin toAdmin(AdminRegistrationDto adminDetailsDto) {
        return Admin.builder()
                .firstName(adminDetailsDto.getFirstName())
                .lastName(adminDetailsDto.getLastName())
                .email(adminDetailsDto.getEmail())
                .phoneNumber(adminDetailsDto.getPhoneNumber())
                .type(AdminType.valueOf(String.valueOf(AdminType.valueOf(adminDetailsDto.getType()))))
                .build();
    }

    public Admin toAdmin(AdminUpdateDto adminDetailsDto) {
        return Admin.builder()
                .firstName(adminDetailsDto.getFirstName())
                .lastName(adminDetailsDto.getLastName())
                .email(adminDetailsDto.getEmail())
                .phoneNumber(adminDetailsDto.getPhoneNumber())
                .type(AdminType.valueOf(String.valueOf(AdminType.valueOf(adminDetailsDto.getType()))))
                .status(AdminStatus.valueOf(String.valueOf(AdminStatus.valueOf(adminDetailsDto.getStatus()))))
                .build();
    }
}