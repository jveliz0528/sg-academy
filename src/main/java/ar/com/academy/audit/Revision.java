package ar.com.academy.audit;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

import ar.com.academy.setting.CustomRevisionListener;

@Entity
@Table(name = "revision_info")
@RevisionEntity(CustomRevisionListener.class)
public class Revision implements Serializable{
	
	private static final long serialVersionUID = -5588291941563331412L;

	//constructor
	public Revision() {
		
	}
	
	public Revision(Long id, Date date) {
		this.id = id;
		this.date = date;
	}
	
	//Gettet & Setter
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	//hashCode & equal
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Revision other = (Revision) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	//toString
	@Override
	public String toString() {
		return "Review [id=" + id + ", date=" + date + "]";
	}


	//Attribute
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "revision_seq")
	@SequenceGenerator(name ="revision_seq", sequenceName = "rbac.seq_revision_id")
	@RevisionNumber
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "revision_date")
	@RevisionTimestamp
	private Date date;
	

}
