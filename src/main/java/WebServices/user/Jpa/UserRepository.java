package WebServices.user.Jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import WebServices.user.User;

//@Repository
public interface UserRepository extends  JpaRepository<User, Integer>{

	
	//Always make a default constructor for Entity
	//Write @Repository annotation on this class
	//Autowired this interface in userService class
}
