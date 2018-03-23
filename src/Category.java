import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Category {
    private String name;
    private int creditHours;
    private ArrayList<String> deptNames;
    public Category (String category) {
        String[] values = category.replaceAll("\\* ", "").split("(?<=\\D)(?=\\d)");
        this.name = values[0];
        this.creditHours = Integer.parseInt(values[1]);
    }

    @Override
    public String toString() {
        return name +
                "requires " + creditHours +
                " credit hours and includes any courses from " + deptNames;
    }

    public String getName() {
        return name;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public ArrayList<String> getDeptNames() {
        return deptNames;
    }
}
