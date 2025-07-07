// файл: codillas/BauService/service/AdminService.java
package codillas.BauService.service;

import codillas.BauService.service.domain.Admin;
import java.util.List;

public interface AdminService {

    void createAdmin(Admin admin);

    Admin getAdmin(String id);

    List<Admin> getAllAdmins();

    void updateAdmin(String id, Admin admin);

    void deleteAdmin(String id);
}
