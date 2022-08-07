package com.resturantmanagement.resturantmanagement.services;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resturantmanagement.resturantmanagement.models.Role;
import com.resturantmanagement.resturantmanagement.repositories.RoleRepository;

@Service
public class RoleImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Set<Role> getDefaulRole() {

		int theDefaultRoleId = 2;

		Optional<Role> DefaultRoleOptional = roleRepository.findById(theDefaultRoleId);

		Role userRole = null;

		if (DefaultRoleOptional.isPresent()) {

			userRole = DefaultRoleOptional.get();

		} else {

			throw new RuntimeException("Did not find theDefaultRoleId id -" + theDefaultRoleId);
		}

		// CREATING A SET AND ADDING THE VALUE:

		// Using Stream API
		Set<Role> DefaultRole = Stream.of(userRole).collect(Collectors.toCollection(HashSet::new));

		// Adding to SET Collections
		Set<Role> DefaultRole2 = new HashSet<>();

		return DefaultRole;
	}

	public void save(Role role) {
		roleRepository.save(role);

	}

	public List<Role> findAll() {

		return roleRepository.findAll();

	}

	public Role findById(int theId) {

		Optional<Role> results = roleRepository.findById(theId);
		Role theRole = null;

		if (results.isPresent()) {
			theRole = results.get();

		} else {
			throw new RuntimeException("Did not find Role id -" + theId);
		}

		return theRole;

	}

	public void deleteById(int theId) {

		roleRepository.deleteById(theId);

	}

}
