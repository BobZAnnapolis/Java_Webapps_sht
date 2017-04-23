package net.javavideotutorials.assignment2.Structure;

public class Google implements Organization
{
	private Integer numEmployees;
	private String nameOfOrganization;

	public Google(String organization) {
		this.numEmployees = 666;
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
	public void setNumberOfEmployees(Integer numEmployees) {
		this.numEmployees = numEmployees;
	}

	@Override
	public void setNameOfOrganization(String nameOfOrganization) {
		this.nameOfOrganization = nameOfOrganization;
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
