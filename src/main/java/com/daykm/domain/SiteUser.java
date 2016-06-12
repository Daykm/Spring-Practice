package com.daykm.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SiteUser {

	private Long id;

	@NotNull
	@Size(min=1)
    private String firstName;
	@NotNull
	@Size(min = 1)
    private String lastName;
    private String password;
	@NotNull
	@Size(min = 5)
    private String email;


    public SiteUser() {
    }


	public SiteUser(String firstName, String lastName, String password, String email) {
		this(null, firstName, lastName, password, email);
	}

	public SiteUser(Long id, String firstName, String lastName, String password, String email) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
	}

	public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
