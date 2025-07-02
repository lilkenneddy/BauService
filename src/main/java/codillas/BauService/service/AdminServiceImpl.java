package codillas.BauService.service;

import codillas.BauService.service.domain.Admin;
import codillas.BauService.service.domain.AdminStatus;
import codillas.BauService.service.domain.AdminType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AdminServiceImpl implements AdminService {

    @Override
    public void createAdmin(Admin admin) {
        log.info("Creating new admin");

        admin.setStatus(AdminStatus.PENDING);
        log.info("Admin created: {}", admin);


    }

    @Override
    public Admin getAdmin(String id) {
        return new Admin(
                "uuid",
                "Rostyslav",
                "Skliaruk",
                "sklarukrostislav@gmail.com",
                null,
                "+3809843460703",
                AdminStatus.ACTIVE,
                AdminType.ADMIN);
    }

    @Override
    public List<Admin> getAllAdmins() {
        return List.of(
                new Admin(
                        "uuid",
                        "Rostyslav",
                        "Skliaruk",
                        "sklarukrostislav@gmail.com",
                        null,
                        "+380983460703",
                        AdminStatus.ACTIVE,
                        AdminType.ADMIN)
        );
    }

    @Override
    public void updateAdmin(String id, Admin admin) {
        log.info("Updating admin with id: {}", id);

    }

    @Override
    public void deleteAdmin(String id) {
        log.info("Deleting admin with id: {}", id);

    }
}
