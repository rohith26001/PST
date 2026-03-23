import java.util.*;

class EntityRecord {
    int enrollmentId;
    String student, course, instructor, startDate;
    int duration;

    EntityRecord(int id, String s, String c, String i, String d, int dur) {
        enrollmentId = id;
        student = s;
        course = c;
        instructor = i;
        startDate = d;
        duration = dur;
    }

    void display() {
        System.out.println("Enrollment_ID: " + enrollmentId +
                ", Student: " + student +
                ", Course: " + course +
                ", Instructor: " + instructor +
                ", Start Date: " + startDate +
                ", Duration: " + duration + " weeks");
    }
}

public class EntityRecordSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<EntityRecord> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(new EntityRecord(
                    sc.nextInt(),
                    sc.next(),
                    sc.next(),
                    sc.next(),
                    sc.next(),
                    sc.nextInt()
            ));
        }

        for (EntityRecord e : list) {
            e.display();
        }
    }
}