package codillas.BauService.controller;

import codillas.BauService.dto.AdminDetailsDto;
import codillas.BauService.dto.AdminUpdateDto;
import codillas.BauService.dto.AdminRegistrationDto;
import codillas.BauService.service.AdminService;
import codillas.BauService.mapper.AdminMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admins")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;
    private final AdminMapper adminMapper;

    @GetMapping
    public ResponseEntity<List<AdminDetailsDto>> getAdmins() {
        List<AdminDetailsDto> adminDetailsDtoList =
                adminService.getAllAdmins().stream().map(adminMapper::toAdminDetailsDto).toList();

        return ResponseEntity.ok(adminDetailsDtoList);
    }

    @GetMapping("/{id}")
    public <Admin> ResponseEntity<AdminDetailsDto> getAdmin(@PathVariable String id) {
        Admin admin = (Admin) adminService.getAdmin(id);
        AdminDetailsDto adminDetailsDto = adminMapper.toAdminDetailsDto((codillas.BauService.service.domain.Admin) admin);
        return ResponseEntity.ok(adminDetailsDto);
    }

    @PostMapping
    public ResponseEntity<Void> createAdmin(@RequestBody AdminRegistrationDto adminRegistrationDto) {
        adminService.createAdmin(adminMapper.toAdmin(adminRegistrationDto));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateAdmin(@PathVariable String id,
                                            @RequestBody AdminUpdateDto adminUpdateDto) {
        adminService.updateAdmin(id, adminMapper.toAdmin(adminUpdateDto));
        return ResponseEntity.ok().build();
    }
}
