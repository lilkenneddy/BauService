package codillas.BauService.controller;

import codillas.BauService.dto.AdminDetailsDto;
import codillas.BauService.dto.AdminUpdateDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController("/admins")
public class AdminController {

    @GetMapping
    public ResponseEntity<List<AdminDetailsDto>> getAdmins() {
        List<AdminDetailsDto> adminsDto = new ArrayList<>();
        AdminDetailsDto rostik = new AdminDetailsDto("Rostik", "Skliaruk", "sklarukrostislav@gmail.com", "380983460703","EMPLOYEE", "ACTIVE");
        return new ResponseEntity<>(adminsDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> createAdmin(@RequestBody AdminDetailsDto adminDetailsDto) {
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Void> updateAdmin(@RequestBody AdminUpdateDto adminUpdateDto) {
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
