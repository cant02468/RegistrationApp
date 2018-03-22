import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Course {
    private String dept;
    private int level;
    private int section;
    private LocalTime startTime;
    private LocalTime endTime;

    public Course(String course) {
        String[] values = course.split(" ");

        this.dept = values[0];
        this.level = Integer.parseInt(values[1]);
        this.section = Integer.parseInt(values[2]);
        this.startTime = LocalTime.parse(values[3],DateTimeFormatter.ofPattern("H:mm"));
        this.endTime = startTime.plusHours(1);
    }

    @Override
    public String toString() {
        return dept + ' ' + level + ' ' + section + ' ' + startTime + '-' + endTime;
    }
}
