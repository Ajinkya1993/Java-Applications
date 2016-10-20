import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Uses three maps to maintain collection of students.
 * @author Ajinkya Nimbalkar
 */
public class Directory {
    /**
     * map from andrewId to student object.
     */
    private Map<String, Student> m1;
    /**
     * map the first name to a list of student objects.
     */
    private Map<String, List<Student>> m2;
    /**
     * map the last name to a list of student objects.
     */
    private Map<String, List<Student>> m3;
    /**
     * constructor.
     */
    public Directory() {
        /**
         * map from andrewId to student object.
         */
        m1 = new HashMap<String, Student>();
        /**
         * map the first name to a list of student objects.
         */
        m2 = new HashMap<String, List<Student>>();
        /**
         * map the last name to a list of student objects.
         */
        m3 = new HashMap<String, List<Student>>();
    }
    /**
     * adds the new student into the three maps.
     * @param s new student
     */
    public void addStudent(Student s) {
        List<Student> l;
        List<Student> j;
        if (s == null) {
            throw new IllegalArgumentException("Student object is null");
        }
        if (m1.get(s.getAndrewId()) == null) {
            m1.put(s.getAndrewId(), s);
        }
        if (m2.get(s.getFirstName()) == null) {
            l =  new ArrayList<Student>();
            } else {
            l = m2.get(s.getFirstName());
        }
        if (l.contains(s) != true) {
            l.add(s);
            m2.put(s.getFirstName(), l);
        }
        if (m3.get(s.getLastName()) == null) {
            j =  new ArrayList<Student>();
            } else {
            j = m3.get(s.getLastName());
        }
        if (j.contains(s) != true) {
            j.add(s);
            m3.put(s.getLastName(), j);
        }
    }
    /**
     * removes the student object if no andrewId matches.
     * @param andrewId andrew id of student
     */
    public void deleteStudent(String andrewId) {
        Student s = m1.get(andrewId);
        if (s == null) {
            throw new IllegalArgumentException("Invalid AndrewId");
        }
        List<Student> l = m2.get(s.getFirstName());
        l.remove(s);
        m2.put(s.getFirstName(), l);
        List<Student> j = m3.get(s.getLastName());
        j.remove(s);
        m3.put(s.getLastName(), j);
        m1.remove(andrewId);
    }
    /**
     * return the student given the andrewId.
     * @param andrewId andrew id of new student
     * @return Student matching student
     */
    public Student searchByAndrewId(String andrewId) {
        if (andrewId == null) {
            throw new IllegalArgumentException("Invalid AndrewId");
        }
        Student s = m1.get(andrewId);
        return s;
    }
    /**
     * return list of all students given the firstname.
     * @param firstName first naem of the student
     * @return List of students
     */
    public List<Student> searchByFirstName(String firstName) {
        if (firstName == null) {
            throw new IllegalArgumentException("Invalid firstName");
        }
        List<Student> l = m2.get(firstName);
        if (l == null) {
            l = new ArrayList<Student>();
        }
        return l;
    }
    /**
     * return list of all students given the lastname.
     * @param lastName last name of the student
     * @return List of Students
     */
    public List<Student> searchByLastName(String lastName) {
        if (lastName == null) {
            throw new IllegalArgumentException("Invalid lastName");
        }
        List<Student> j = m3.get(lastName);
        if (j == null) {
            j = new ArrayList<Student>();
        }
        return j;
    }
    /**
     * returns the number of students in the directory.
     * @return number of students
     */
    public int size() {
        int sz = m1.size();
        return sz;
    }
}
