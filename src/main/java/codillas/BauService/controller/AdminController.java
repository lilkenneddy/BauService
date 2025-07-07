package codillas.BauService.controller;

import codillas.BauService.dto.AdminDetailsDto;
import codillas.BauService.dto.AdminUpdateDto;
import codillas.BauService.dto.AdminRegistrationDto;
import codillas.BauService.exception.AdminNotFoundException;
import codillas.BauService.service.AdminService;
import codillas.BauService.mapper.AdminMapper;
import codillas.BauService.service.domain.Admin;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admins")
@RequiredArgsConstructor
public class AdminController {

    private Map<String, Admin> adminMap = new HashMap<>();

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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable String id) {
        adminService.deleteAdmin(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ExceptionHandler(AdminNotFoundException.class)
    public ResponseEntity<Void> handleAdminNotFoundException(AdminNotFoundException e) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

