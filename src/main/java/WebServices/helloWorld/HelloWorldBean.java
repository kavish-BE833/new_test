package WebServices.helloWorld;

public class HelloWorldBean {

	
	private String message;
	
	public HelloWorldBean(String message) {
		this.message = message;
	}


//It is important to create Get methods for the objects otherwise automatic conversion
//from bean to json will not happen. Refer video of 65 Section Rest of Spring Course.
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + "]";
	}


	
	
	
}

