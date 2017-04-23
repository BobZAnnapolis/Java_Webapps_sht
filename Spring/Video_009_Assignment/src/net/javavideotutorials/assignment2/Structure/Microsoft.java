package net.javavideotutorials.assignment2.Structure;

// import net.javavideotutorials.assignment2.Human.Employee;

public class Microsoft implements Organization
{
	private Integer numEmployees;
	private String nameOfOrganization;

	public Microsoft(String organization) {
		this.numEmployees = 13;
		this.nameOfOrganization = organization;
	}
	
	@Override
	public Integer getNumberOfEmployees() {
		return numEmployees;
	}

	@Override
	public String getNameOfOrganization() {
		return nameOfOrganization;
	}

	@Override
	public void setNumberOfEmployees(Integer p_numEmployees) {
		this.numEmployees = p_numEmployees;
	}

	@Override
	public void setNameOfOrganization(String p_nameOfOrganization) {
		this.nameOfOrganization = p_nameOfOrganization;
	}

	@Override
	public boolean equals(Object p_o) {
		boolean retValue = true;
		Organization org = (Organization)p_o;
		if (! getNameOfOrganization().equalsIgnoreCase(org.getNameOfOrganization())) {
			retValue = false;
		}
		return retValue;
	}  

}
