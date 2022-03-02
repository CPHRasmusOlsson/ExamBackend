package dtos.user;

import entities.Role;


public class RoleDTO {
    private String rolename;

    public RoleDTO(Role role) {
        this.rolename = role.getRoleName();
    }
    
    
    
    public Role getEntity(){
       return new Role(this.rolename);
    }
}
