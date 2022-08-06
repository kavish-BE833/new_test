package WebServices.user;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

//@JsonIgnoreProperties(value = {"id", "name" })

@Entity
public class User {

	@Id
	@GeneratedValue
	
	@Min(value = 2)
	private Integer id;
	
	@Size(min = 2, message = "Name should have atleast 2 characters")
	private String name;
	

//	 @JsonIgnore
	 //This will filter out this property and will not expose it to consumer
//		@Past
	private Date birthDate;
	
	
	public User() {
		
	}
	
	public User(Integer id,String name, Date birthDate){
	    super();
	    this.id=id;
	    this.name=name;
	    this.birthDate=birthDate;
	}


//It is important to create Get methods for the objects otherwise automatic conversion
//from bean to json will not happen. Refer video of 65 Section Rest of Spring Course.
	
	public void setId(Integer id) {
		this.id = id;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}


	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}

	
}
