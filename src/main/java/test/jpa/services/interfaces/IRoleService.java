package test.jpa.services.interfaces;

import java.util.List;

import test.jpa.entities.*;

public interface IRoleService {
	List<Role> findAll();

	Role findOne(Long idRole);

	Role save(Role role);

	void delete(Long idRole);
}