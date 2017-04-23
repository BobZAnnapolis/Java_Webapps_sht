package net.javavideotutorials.assignment2.Human;

import java.util.Date;

import net.javavideotutorials.assignment2.Structure.Organization;

public class Employee extends Person
{
	private String name;
	private String sex;
	private Date birthdate;

	private String jobTitle;
	private Organization organization;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getSex() {
		return sex;
	}

	@Override
	public void setName(String p_name) {
		if ( null == p_name || p_name.equals("")) {
			throw new IllegalArgumentException("This is not a valid name !!");
		}
		else {
			this.name = p_name;
		}
	}

	@Override
	public void setSex(String p_sex) {
		if ( p_sex.equalsIgnoreCase("male") || p_sex.equalsIgnoreCase("female")) {
			this.sex = p_sex;
		}
		else {
			throw new IllegalArgumentException("This is not a valid sex !!");
		}
	}

	@Override
	public void setBirthday(Date p_birthdate) {
		if ( null == p_birthdate || p_birthdate.equals("")) {
			throw new IllegalArgumentException("This is not a valid name !!");
		}
		else {
			this.birthdate = p_birthdate;
		}
	}

	@Override
	public Date getBirthday() {
		return birthdate;
	}  

	@Override
	public boolean equals(Object o) {
		boolean retValue = true;
		Employee p = (Employee)o;
		if ( (! getName().equalsIgnoreCase(p.getName()))
		||   (! getSex().equalsIgnoreCase(p.getSex()))
		||   (! getBirthday().equals(p.getBirthday()))
		||   (! getOrganization().equalsIgnoreCase(p.getOrganization()))
		) 
		{
			retValue = false;
		}
		return retValue;
	}  

	@Override
	public String toString() {
		String message = super.toString()
				+ "Job Title: " + getJobTitle() 
				+ ", Organization: " + getOrganization();
	    return message; 
    }

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String p_jobTitle) {
		if ( null == p_jobTitle || p_jobTitle.equals("")) {
			throw new IllegalArgumentException("This is not a valid job title !!");
		}
		else {
			this.jobTitle = p_jobTitle;
		}
	}

	public String getOrganization() {
		return organization.getNameOfOrganization();
	}

	public void setOrganization(Organization p_organization) {
		this.organization = p_organization;
		if ( null == p_organization) {
			throw new IllegalArgumentException("This is not a valid organization !!");
		}
		else {
			this.organization = p_organization;
		}
	}
}
