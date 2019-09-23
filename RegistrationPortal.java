import java.util.ArrayList;
import java.util.List;

public class RegistrationPortal {

	private static RegistrationPortal registrationPortal;
	List<Student> studentList=new ArrayList<Student>();

	private RegistrationPortal() {
	}

	public static RegistrationPortal getRegistrationPortal() {
		if (registrationPortal == null) {
			synchronized (RegistrationPortal.class) {
				if (registrationPortal == null) {
					registrationPortal = new RegistrationPortal();
				}
			}
		}
		return registrationPortal;

	}

	public void register(Student student) {
		synchronized (RegistrationPortal.class) {
			studentList.add(student);
		}
	}

	public List<Student> getRegisteredStudents() {
		return studentList;
	}

}
