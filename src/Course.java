import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Course {
    private String dept;
    private int number;
    private int section;
    private LocalTime startTime;
    private LocalTime endTime;

    Course(String course) {
        String[] values = course.split(" ");

        this.dept = values[0];
        this.number = Integer.parseInt(values[1]);
        this.section = Integer.parseInt(values[2]);
        this.startTime = LocalTime.parse(values[3],DateTimeFormatter.ofPattern("H:mm"));
        this.endTime = startTime.plusHours(1);
    }

    Course(Course rhs){
        this.dept = rhs.dept;
        this.number = rhs.number;
        this.section = rhs.section;
        this.startTime = rhs.startTime;
        this.endTime = rhs.endTime;
}

    public String getDept() {
        return dept;
    }

    public int getNumber() {
        return number;
    }

    public int getSection() {
        return section;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    @Override
    public String toString() {
        return dept + ' ' + number + ' ' + section + ' ' + startTime + '-' + endTime;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null || obj.getClass()!= this.getClass())
            return false;
        Course comparison = (Course) obj;
        return (comparison.dept.equals(this.dept) && comparison.number == this.number && comparison.section == this.section);
    }
}
