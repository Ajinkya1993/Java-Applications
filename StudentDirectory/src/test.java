
public class test {
    public static void main(String[] args) {
        Directory d = new Directory();
        Student s = new Student("animbalk");
        s.setFirstName("Ajinkya");
        s.setLastName("Nimbalkar");
        s.setPhoneNumber("4126089378");
        System.out.println(s.toString());
        d.addStudent(s);
        Student n = new Student("akarandi");
        n.setFirstName("Arch");
        n.setLastName("Karan");
        n.setPhoneNumber("41289378");
        System.out.println(n.toString());
        d.addStudent(n);
        Student ts = d.searchByAndrewId("animbalk");
        System.out.println(ts.toString());
    }
}
