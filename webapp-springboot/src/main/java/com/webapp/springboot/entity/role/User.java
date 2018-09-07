package com.webapp.springboot.entity.role;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "user_tb")
public class User{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id", nullable = false, unique = true)
	private Long id;
	
	@Column(name = "user_name", nullable = false, unique = true)
	private String username;
	
	@Column(name = "pass_word", nullable = false, unique = true)
	private String password;

	@JsonManagedReference
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "user_role", 
		joinColumns = {
			@JoinColumn(name = "user_id", updatable = false)},
		inverseJoinColumns = {
			@JoinColumn(name = "role_id", updatable = false)
	})
	private Set<Role> roles = new HashSet<>(0);

	public User(){}
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRole(Role role) {
		this.roles.add(role);
		role.setUser(this);
	}
}
