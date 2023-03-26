package com.entity;


import lombok.AllArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "user_table")
public class User {

	@Id
	private int id;
	private String userName;
	private String password;
	private String email;
}
