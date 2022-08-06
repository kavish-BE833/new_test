package WebServices.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("SomeBeanFilter")
public class SomeBean {

	String field1;
	String field2;
	String field3;
	
	public SomeBean(String f1, String f2, String f3) {
		field1= f1;
		field2 = f2;
		field3 = f3;
	}

	public String getField1() {
		return field1;
	}

	public String getField2() {
		return field2;
	}

	public String getField3() {
		return field3;
	}
	
}
