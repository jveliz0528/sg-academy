package ar.com.academy.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "teachers")
@Audited // Check if this class will be audited
public class Teacher implements Serializable {
	private static final long serialVersionUID = -7200857198201703374L;

	// Constructors
	public Teacher() {

	}

	public Teacher(Long idTeacher, Long document, String firstName, String lastName, int age, Gender gender,
			List<Phone> phone) {
		this.idTeacher = idTeacher;
		this.document = document;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.phone = phone;
	}

	// Gette and setter
	public Long getIdTeacher() {
		return idTeacher;
	}

	public void setIdTeacher(Long idTeacher) {
		this.idTeacher = idTeacher;
	}

	public Long getDocument() {
		return document;
	}

	public void setDocument(Long document) {
		this.document = document;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirthBate() {
		return birthBate;
	}

	public void setBirthBate(Date birthBate) {
		this.birthBate = birthBate;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public List<Phone> getPhone() {
		return phone;
	}

	public void setPhone(List<Phone> phone) {
		this.phone = phone;
	}

	// hashCode & equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((birthBate == null) ? 0 : birthBate.hashCode());
		result = prime * result + ((document == null) ? 0 : document.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((idTeacher == null) ? 0 : idTeacher.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Teacher other = (Teacher) obj;
		if (age != other.age)
			return false;
		if (birthBate == null) {
			if (other.birthBate != null)
				return false;
		} else if (!birthBate.equals(other.birthBate))
			return false;
		if (document == null) {
			if (other.document != null)
				return false;
		} else if (!document.equals(other.document))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (idTeacher == null) {
			if (other.idTeacher != null)
				return false;
		} else if (!idTeacher.equals(other.idTeacher))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		return true;
	}

	// toString
	@Override
	public String toString() {
		return "Teacher [idTeacher=" + idTeacher + ", document=" + document + ", firstName=" + firstName + ", lastName="
				+ lastName + ", age=" + age + ", birthBate=" + birthBate + ", gender=" + gender + ", phone=" + phone
				+ "]";
	}

	// Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_teacher", length = 11)
	private Long idTeacher;

	@NotNull(message = "{teacher.document.notNull}")
	@Column(name = "document", length = 11, unique = true, nullable = false)
	private Long document;

	@NotEmpty
	@Column(name = "first_name", length = 50, nullable = false)
	private String firstName;

	@NotEmpty
	@Column(name = "last_name", length = 50, nullable = false)
	private String lastName;

	@NotNull(message = "{teacher.age.notNull}")
	@Min(value = 3, message = "{teacher.age.min}")
	@Max(value = 100)
	@Column(name = "age", length = 3, nullable = false)
	private int age;

	@NotNull(message = "{teacher.birthday.notNull}")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Past(message = "{teacher.birthday.past}")
	@Column(name = "birth_bate")
	private Date birthBate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_gender", referencedColumnName = "cod_gender", nullable = false)
	@NotAudited // indicates that this entity will not be audited
	private Gender gender;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "teachers_phones", joinColumns = {
			@JoinColumn(name = "idTeacher", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "idPhone", nullable = false, updatable = false) })
	private List<Phone> phone = new ArrayList<>();

}
