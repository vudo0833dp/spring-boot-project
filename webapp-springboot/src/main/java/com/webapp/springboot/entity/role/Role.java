package com.webapp.springboot.entity.role;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "role_tb")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "role_id", nullable = false, unique = true)
	private Long id;
	
	@Column(name = "role_name", nullable = false, unique = true)
	private String roleName;
	
	@JsonBackReference
	@ManyToMany(mappedBy = "roles")
	private Set<User> users = new HashSet<>();

	public Role(){}
	
	public Role(String roleName) {
		this.roleName = roleName;
	}
	
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	public void setUser(User user) {
		this.users.add(user);
	}
}
