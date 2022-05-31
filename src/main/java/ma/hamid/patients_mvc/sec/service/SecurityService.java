package ma.hamid.patients_mvc.sec.service;

import ma.hamid.patients_mvc.sec.entities.AppRole;
import ma.hamid.patients_mvc.sec.entities.AppUser;

public interface SecurityService {
    AppUser saveNewUser(String username, String password, String rePassword);
    AppRole saveRole(String roleName, String description);
    void  addRoleToUser(String username , String roleName);
    void removeRoleFromUser(String Username, String roleName);
    AppUser loadUserByUserName(String Username);
}
