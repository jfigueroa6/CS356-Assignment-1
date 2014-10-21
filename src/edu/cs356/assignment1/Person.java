package edu.cs356.assignment1;

import java.util.Calendar;

public interface Person {
	/**
	 * Get the birthday of the person
	 * @return	Birthday in Calendar
	 */
	public Calendar getBirthday();
	/**
	 * Get First Name of Person
	 * @return First Name
	 */
	public String getFirstName();
	/**
	 * Get ID of Person
	 * @return ID
	 */
	public String getID();
	/**
	 * Get last name of Person
	 * @return Last Name
	 */
	public String getLastName();
	/**
	 * Get Middle name of person
	 * @return middle name
	 */
	public String getMiddleName();
	/**
	 * Set the birthday for the person
	 * @param Bday Birthday of person in DateFormat
	 */
	public void setBirthday(Calendar Bday);
	/**
	 * Set First Name of Person
	 * @param FName First Name to set
	 */
	public void setFirstName(String FName);
	/**
	 * Set ID of Person
	 * @param id ID to set
	 */
	public void setID(String id);
	/**
	 * Set Last name of Person
	 * @param LName Last Name to set
	 */
	public void setLastName(String LName);
	/**
	 * Set Middle name of Person
	 * @param MName Middle Name to set
	 */
	public void setMiddleName(String MName);
}
