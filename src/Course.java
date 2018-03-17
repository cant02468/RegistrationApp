import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Course {
    private String name;
    private int level;
    private int section;
    private LocalTime time;

    private Course(String name, int level, int section, LocalTime time) {
        this.name = name;
        this.level = level;
        this.section = section;
        this.time = time;
    }

    @Override
    public String toString() {
        return name + ' ' + level + ' ' + section + ' ' + time;
    }

    public static Course valueOf(String courseValue) {
        String[] values = courseValue.split(" ");
        if (values[3].length() == 4) { values[3] = "0" + values[3]; }
        return new Course(values[0], Integer.parseInt(values[1]), Integer.parseInt(values[2]),  LocalTime.parse(values[3],DateTimeFormatter.ofPattern("HH:mm")));
    }
}
