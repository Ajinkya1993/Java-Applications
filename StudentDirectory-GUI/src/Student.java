/**
 * Class to model a single student.
 * @author Ajinkya Nimbalkar
 *
 */
public class Student {
    /**
     * contains andrew id.
     */
    private String andrwid;
    /**
     * contains firstname.
     */
    private String fname;
    /**
     * contains lastname.
     */
    private String lname;
    /**
     * contains phonenumber.
     */
    private String pnumber;
    /**
     * my constructor.
     * @param andrewId andrew id of the student
     */
    public Student(String andrewId) {
        andrwid = andrewId;
    }
    /**
     * get andrew id.
     * @return andrwid
     */
    public String getAndrewId() {
        return andrwid;
    }
    /**
     * get first name.
     * @return fname
     */
    public String getFirstName() {
        return fname;
    }
    /**
     * get last name.
     * @return lname
     */
    public String getLastName() {
        return lname;
    }
    /**
     * get phone number.
     * @return pnumber
     */
    public String getPhoneNumber() {
        return pnumber;
    }
    /**
     * set first name.
     * @param s new student
     */
    public void setFirstName(String s) {
        if (fname == null) {
            fname = s;
        }
    }
    /**
     * set last name.
     * @param s new student
     */
    public void setLastName(String s) {
        if (lname == null) {
            lname = s;
        }
    }
    /**
     * set phone number.
     * @param s new student
     */
    public void setPhoneNumber(String s) {
        if (pnumber == null) {
            pnumber = s;
        }
    }
    /**
     * toString method.
     * @return string equivalent.
     */
    public String toString() {
        return fname + ' ' + lname + " (Andrew ID: "
    + andrwid + ", Phone Number: " + pnumber + ')';
    }
}
