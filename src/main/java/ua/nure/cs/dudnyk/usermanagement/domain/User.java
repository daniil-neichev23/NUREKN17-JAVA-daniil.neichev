package ua.nure.cs.dudnyk.usermanagement.domain;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6238880692940276364L;
	private Long id;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public String getFullName() {
		return getLastName() + ", " + getFirstName();
	}
	
	public int getAge() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int currentYear = calendar.get(Calendar.YEAR);
		int currentDay = calendar.get(Calendar.DATE);
		int currentMonth = calendar.get(Calendar.MONTH)+1;
		calendar.setTime(getDateOfBirth());
		int birthYear = calendar.get(Calendar.YEAR);
		int birthDay = calendar.get(Calendar.DATE);
		int birthMonth = calendar.get(Calendar.MONTH);
		if(birthMonth>currentMonth || (birthMonth==currentMonth && birthDay>currentDay) ) {
			return currentYear-birthYear-1;
		}
		else{
			return currentYear-birthYear;
		}
	}
	
}



