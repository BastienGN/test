package test.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import test.jpa.entities.Role;
import test.jpa.services.interfaces.IRoleService;

@RestController
@CrossOrigin
public class RoleController {

	@Autowired
	IRoleService roleService;

	@RequestMapping(value = "roles", method = RequestMethod.GET)
	public List<Role> findAll() {
		return roleService.findAll();
	}

	@RequestMapping(value = "roles/{idR}", method = RequestMethod.GET)
	public Role findOne(@PathVariable("idR") Long idRole) {
		return roleService.findOne(idRole);
	}

	@RequestMapping(value = "roles", method = RequestMethod.POST)
	public Role saveRole(@RequestBody Role role) {
		return roleService.save(role);
	}

	@RequestMapping(value = "roles/{idR}", method = RequestMethod.PUT)
	public Role updateRole(@PathVariable(value = "idR") Long idRole, @RequestBody Role role) {
		Role currentRole = roleService.findOne(idRole);
		currentRole.setLibelle(role.getLibelle());
		return roleService.save(currentRole);
	}

	@RequestMapping(value = "roles/{idR}", method = RequestMethod.DELETE)
	public void deleteRole(@PathVariable(value = "idR") Long idRole) {
		roleService.delete(idRole);
	}

}