package edu.cs356.assignment1;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Student implements Person {
	//=================================================================
	// Data Members
	//=================================================================
	private Calendar birthday;	/**Stores Birthday of Student*/
	private String firstName,		/**Stores First Name of Student*/
				   id,				/**Stores ID of Student*/
				   lastName,		/**Stores Last Name of Student*/
				   middleName;		/**Stores Middle Name of Student*/

	//=================================================================
	// Constructor
	//=================================================================
	/**
	 * Initializes the student to empty fields, and a birthday of when
	 * the object was created.
	 */
	public Student() {
		initialize();
	}
	
	/**
	 * Initializes the object with the given name
	 * @param FName	First Name
	 * @param MName Middle Name
	 * @param LName Last Name
	 */
	public Student(String FName, String MName, String LName) {
		initialize();
		setFirstName(FName);
		setMiddleName(MName);
		setLastName(LName);
	}
	
	//==================================================================
	// Methods
	//==================================================================
	@Override
	public Calendar getBirthday() {
		return birthday;
	}

	@Override
	public String getFirstName() {
		return firstName;
	}

	@Override
	public String getID() {
		return id;
	}

	@Override
	public String getLastName() {
		return lastName;
	}

	@Override
	public String getMiddleName() {
		return middleName;
	}

	private void initialize() {
		birthday = new GregorianCalendar();
		firstName = "";
		lastName = "";
		id = "";
		middleName = "";
	}
	
	@Override
	public void setBirthday(Calendar Bday) {
		birthday = Bday;

	}

	@Override
	public void setFirstName(String FName) {
		if (FName.matches("[a-zA-Z]*"))
			firstName = FName;

	}

	@Override
	public void setID(String id) {
		if (id.matches("\\d*"))
			this.id = id;
	}

	@Override
	public void setLastName(String LName) {
		if (LName.matches("[a-zA-Z]*"))
			lastName = LName;
	}

	@Override
	public void setMiddleName(String MName) {
		if (MName.matches("[a-zA-Z]*"))
			middleName = MName;
	}

}
