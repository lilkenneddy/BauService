// файл: codillas/BauService/service/AdminServiceImpl.java
package codillas.BauService.service;

import codillas.BauService.exception.AdminNotFoundException;
import codillas.BauService.service.domain.Admin;
import codillas.BauService.service.domain.AdminStatus;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AdminServiceImpl implements AdminService {

    private final Map<String, Admin> adminMap = new HashMap<>();

    @Override
    public void createAdmin(Admin admin) {
        log.info("Creating new admin");
        admin.setId(UUID.randomUUID().toString());
        admin.setStatus(AdminStatus.PENDING);
        adminMap.put(admin.getId(), admin);
        log.info("Admin created: {}", admin);
    }

    @Override
    public Admin getAdmin(String id) {
        Admin existing = adminMap.get(id);
        if (existing != null) {
            return existing;
        }
        throw new AdminNotFoundException("Admin with id " + id + " not found");
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminMap.values().stream().toList();
    }

    @Override
    public void updateAdmin(String id, Admin admin) {
        log.info("Updating admin with id: {}", id);

        if (!adminMap.containsKey(id)) {
            throw new AdminNotFoundException("Admin with id " + id + " not found");
        }

        // Приміром, повністю замінюємо об’єкт:
        admin.setId(id);
        adminMap.put(id, admin);

        log.info("Admin updated: {}", admin);
    }

    @Override
    public void deleteAdmin(String id) {
        if (adminMap.containsKey(id)) {
            log.info("Deleting admin with id: {}", id);
            adminMap.remove(id);
            log.info("Admin deleted: {}", id);
        } else {
            throw new AdminNotFoundException("Admin with id " + id + " not found");
        }
    }
}
