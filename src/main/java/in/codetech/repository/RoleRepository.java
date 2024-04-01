package in.codetech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.codetech.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

}
