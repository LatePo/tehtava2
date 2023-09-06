package backend.thyme.s23Tunti2.domain;

public class Friend {
	
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Friend(String name) {
		super();
		this.name = name;
	}
	


	public Friend() {
		super();
	}

	@Override
	public String toString() {
		return "Friend [name=" + name + "]";
	}
	
	

}
