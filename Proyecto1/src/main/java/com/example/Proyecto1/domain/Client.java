package com.example.Proyecto1.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity//Solo sirve para decirle a spring que la clase es un entity
@Table (name="Client" )//Dice que la clase va a mapear una tabla de una base de datos y que se llama Client en el esquema
public class Client implements Serializable{
//Serializable indica que se va a persistir un objeto y se va a convertir a un stream de datos seguro
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//significa la forma en cómo se va a generar ese ID
	private long id;
	private String name;
	@Column(name="last_name")//Column sirve para indicar que un atributo va a mapear una columna de la tabla y que no se llama igual que el atributo
	private String lastName;
	private String email;
	@Column(name="creation_date")
	@Temporal(TemporalType.DATE)//las variables que mapean fechas y datos de tiempo les pones la anotación @Temporal(TemporalType. DATE)
	private Date creationDate;

	@PrePersist//Indica que quieres que haga tu objeto antes de que se use y se persista
	public void prePersist() {
		creationDate= new Date();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date date) {
		this.creationDate = date;
	}

}
