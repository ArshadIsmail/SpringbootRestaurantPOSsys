package com.resturantmanagement.resturantmanagement.services;

import java.util.List;
import java.util.Set;

import com.resturantmanagement.resturantmanagement.models.Role;

public interface RoleService {

	public Set<Role> getDefaulRole();

	public void save(Role user);

	public List<Role> findAll();

	public Role findById(int theId);

	public void deleteById(int theId);

}
