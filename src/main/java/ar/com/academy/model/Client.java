package ar.com.academy.model;

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
@Table(name = "Clints")
@Audited

//Lombok
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String consumerId;
	private String documentType;
	private String documentNumber;
	private String channel;
	private String ipAddress;
	private String terminal;
	private String origin;
	private String timestamp;
}
