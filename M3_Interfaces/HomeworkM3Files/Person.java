
public class Person implements Comparable<Person> {

	private String firstName, lastName;
	private int id;

	public Person(String firstName, String lastName, int id) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName + " (" + id + ")";
	}

	@Override
	public int compareTo(Person other) {
		int lastNameCompareValue = this.lastName.compareToIgnoreCase(other.lastName);

		if (lastNameCompareValue != 0) {
			return lastNameCompareValue;
		}

		int firstNameCompareValue = this.firstName.compareToIgnoreCase(other.firstName);

		if (firstNameCompareValue != 0) {
			return firstNameCompareValue;
		}
		return Integer.compare(this.id, other.id);
	}

}
