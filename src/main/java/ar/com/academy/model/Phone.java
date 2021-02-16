package ar.com.academy.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name = "phones")

//Lombox
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Audited //Check if this class will be audited
public class Phone implements Serializable{
	
	private static final long serialVersionUID = 8530098289918553120L;

	//Constructor

	//Getter & Setter

	//hash & equal

	//toString

	//Atributos
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_phone", length = 11)
    private Long idPhone;

	@Column (name = "cod_phone", length = 20)
	private String codPhone;
	
    @Column(name = "phone", length = 11, unique = true)
    private String phone;
}
