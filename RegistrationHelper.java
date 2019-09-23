/*
 * Create the RegistrationPortal class here.
 */
class RegistrationHelper {
    private final RegistrationPortal registrationPortal;
    
    public RegistrationHelper(RegistrationPortal registrationPortal) {
        this.registrationPortal = registrationPortal;
    }
    
    public void register(Student student) {
        if (this.registrationPortal != null) {
            this.registrationPortal.register(student);
        }
    }
}

class Student {
    private final String id;
    private final String name;
    
    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public String getId() {
        return this.id;
    }
    
    public String getName() {
        return this.name;
    }
}

class RegistrationRunnable implements Runnable {
    private final RegistrationPortal registration;
    private final int studentsCount;
    private final String studentsIdPrefix;
    
    public RegistrationRunnable(RegistrationPortal registration, int studentsCount, String studentsIdPrefix) {
        this.registration = registration;
        this.studentsCount = studentsCount;
        this.studentsIdPrefix = studentsIdPrefix;
    }
    
    @Override
    public void run() {
        RegistrationHelper registrationHelper = new RegistrationHelper(registration);
        
        for (int i = 1; i <= studentsCount; i++) {
            String studentId = "id-" + studentsIdPrefix + "-" + i;
            String studentName = "name-" + i;
            
            Student student = new Student(studentId, studentName);
            
            registrationHelper.register(student);
        }
    }
}

