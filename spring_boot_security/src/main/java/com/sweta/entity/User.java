package com.sweta.entity;

import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "users_role")
public class User {
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull(message="Please provide name")
	private String username;
	@NotNull(message="Please provide password")
	private String password;
	private boolean enabled;
	@NotNull(message="Please provide role")
    private String role;

}
