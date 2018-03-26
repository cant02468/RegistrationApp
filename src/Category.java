import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Category {
    private String name;
    private int creditHours;
    private ArrayList<String> deptNames;
    Category(String category) {
        deptNames = new ArrayList<>();
        String[] values = category.replaceAll("\\* ", "").split("(?<=\\D)(?=\\d)");
        this.name = values[0];
        if (this.name.contains("African American Heritage")) {this.deptNames.add("AADS");}
        else if (this.name.contains("Human Past")) {this.deptNames.addAll(Arrays.asList("HIST", "PHIL", "THEO"));}
        else if (this.name.contains("Scientific Reasoning")) {this.deptNames.addAll( Arrays.asList("BIOL", "CHEM", "PHYS"));}
        else if (this.name.contains("CPSC Elective")) {this.deptNames.add("CPSC");}
        this.creditHours = Integer.parseInt(values[1]);
    }

    @Override
    public String toString() {
        return name +
                "requires " + creditHours +
                " credit hours and includes courses from " + deptNames;
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
