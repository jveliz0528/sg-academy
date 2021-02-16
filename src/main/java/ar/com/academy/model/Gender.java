package ar.com.academy.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table (name = "gender")

//Lombok
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Gender implements Serializable{

	private static final long serialVersionUID = -7970207721516375101L;

	//Constructor

	//Getter & Setter

	//hash & equal

	//toString

	//Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_gender", length = 11)
	private Long idGender;
	
	
	@Column (name = "cod_gender", length = 20, unique = true)
	private String codGender;
	
	
	@Column(name = "gender", length = 20, nullable = false)
	private String gender;
}
