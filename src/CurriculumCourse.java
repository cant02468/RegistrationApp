import java.util.ArrayList;
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

    CurriculumCourse(CurriculumCourse rhs) {
        this.dept = rhs.dept;
        this.number = rhs.number;
        this.creditHours = rhs.creditHours;
    }

    public String getDept() {
        return dept;
    }

    public int getNumber() {
        return number;
    }

    public int getCreditHours() {
        return creditHours;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null || obj.getClass()!= this.getClass())
            return false;
        CurriculumCourse comparison = (CurriculumCourse) obj;
        return (comparison.dept.equals(this.dept) && comparison.number == this.number && comparison.creditHours == this.creditHours);
    }

    @Override
    public String toString() {
        return dept + ' ' + number + ' ' + creditHours;
    }
}
