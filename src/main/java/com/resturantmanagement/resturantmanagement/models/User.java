package com.resturantmanagement.resturantmanagement.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;





@Entity
@Table(name="user")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User extends Auditable<String> {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private int id;
	
	
	@NotEmpty(message = "User Name can't be empty!")
	@Size(min=3, message="Username must be more than 3 letters")
	@Column(name="username")
	private String username;
	
	
	@NotEmpty(message = "Password can't be empty!")
	@Size(min=8 ,message="Password must be more than 8 letters")
	@Column(name="password")
	private String password;
	
	
	


	
	@ManyToMany(fetch=FetchType.EAGER,cascade=CascadeType.PERSIST
			
			)
	@JoinTable(name="user_role",joinColumns=@JoinColumn(name="user_id"),
	inverseJoinColumns=@JoinColumn(name="role_id"))
	private Set<Role> roles = new HashSet<>();
	
	
	
	
	
	@ManyToOne(
			fetch=FetchType.EAGER,
			cascade= {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.DETACH})
	@JoinColumn(name="status_id")
	private UserStatus userStatus;

	

}
