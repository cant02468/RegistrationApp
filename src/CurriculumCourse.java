import java.util.Arrays;

public class CurriculumCourse {
    private String dept;
    private int number;
    private int creditHours;

    CurriculumCourse(String course) {
        String[] values = course.replaceAll(" {3}", " ").split(" ");
        this.dept = values[0];
        this.number = Integer.parseInt(values[1]);
        this.creditHours = Integer.parseInt(values[2]);
    }

    public String getDept() {
        return dept;
    }

    @Override
    public String toString() {
        return dept + ' ' + number + ' ' + creditHours;
    }
}
