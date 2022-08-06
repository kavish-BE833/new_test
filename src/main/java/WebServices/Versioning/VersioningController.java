package WebServices.Versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningController {

//	### Versioning
//	 -Media type versioning(a.k.a"content negotiation"or"accept header")
//	   -GitHub
//	  (Custom)headers versioning
//	    Microsoft
//	-URI Versioning
//	   -Twitter
//	 -
//	 -
//	  Parameter versioning
//	    Amazon
//	   Factors
//	  -URI Pollution
//	  -Misuse of HTTP Headers
//	  -Caching
//	   Can we execute the request on the browser?
//	   API Documentation
//	   No Perfect Solution
	
	
	//URI versioning
	
	@GetMapping("v1/person")
	public Person1 person1(){
	
	    return new Person1("Bob Charlie");
	}
	       
	@GetMapping("v2/person")
	public Person2 person2(){
	    return new Person2(new Name("Bob","Charlie"));
	}
	
	
	
	//Here we are doing Versioning using the request parameter
	//Request Parameter Versioning
	
	@GetMapping(value="/person/param",params="version=1")
	public Person1 param1(){
	    return new Person1("Bob Charlie");
	}
	@GetMapping(value="/person/param",params="version=2")
	public Person2 param2(){
	    return new Person2(new Name("Bob","Charlie"));
	}
	
	
	
	//Header versioning
	
	@GetMapping(value="/person/header",headers="X-API-VERSION=1")
	public Person1 header1(){
		
	    return new Person1("Bob Charlie");
	}
	
	@GetMapping(value="/person/header",headers="X-API-VERSION=2")
	public Person2 header2(){
		
	    return new Person2(new Name("Bob","Charlie"));
	}
	
	
	
	//Content Negoitation pr Accept versioning

@GetMapping(value="/person/produces",produces="application/vnd.company.app-v1+json")
	public Person1 produces1(){
		
	    return new Person1("Bob Charlie");
	}
	
@GetMapping(value="/person/produces",produces="application/vnd.company.app-v2+json")
	public Person2 produces2(){
		
	    return new Person2(new Name("Bob","Charlie"));
	}
	
	
}
