import java.util.*;

public class TestComparable01 {
	public static void main(String[] args) {
		List l1 = new LinkedList();
		l1.add(new Name("Kar1","M"));
		l1.add(new Name("Steven","Lee"));	
		l1.add(new Name("John","O"));
		l1.add(new Name("Tom","M"));
		System.out.println(l1);
		Collections.sort(l1);
		System.out.println(l1);
	}	
}

class Name implements Comparable {
	private String firstname,lastname;
	
	public Name(String firstname,String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;	
	}
	
	public String getFirstName() {
		return firstname;	
	}
	
	public String getLastName() {
		return lastname;	
	}
	
	public String toString() {
		return firstname + " " + lastname;	
	}
	/*
		��дequals()����,Ӧ����дhashCode()����
		����������equals,����֮���hashCodeӦ�����(��������������ʱʹ��)
	*/
	public boolean equals(Object obj) {
		if(obj instanceof Name) {
			Name name = (Name)obj;  //ǿ������ת��
			return firstname.equals(name.firstname)
			&& lastname.equals(name.lastname);
		}	else {
			return super.equals(obj);	
		}
  }
  
  public int hashCode() {
  	return firstname.hashCode();	
  }
  
  public int compareTo(Object o) {
  	Name name = (Name)o;
  	int lastCmp = 
  				lastname.compareTo(name.lastname);	
  
  	return lastCmp != 0 ? 
  								lastCmp : 
  										firstname.compareTo(name.firstname);
  }
}