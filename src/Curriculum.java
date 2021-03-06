import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Curriculum {
    private ArrayList<CurriculumCourse> courses;
    private ArrayList<Category> categories;

    Curriculum(String fileName) {
        ArrayList<CurriculumCourse> baseCourses = new ArrayList<>();
        ArrayList<Category> baseCategories = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach((String line) -> {
                if (line.contains("*")) { baseCategories.add(new Category(line)); }
                else { baseCourses.add(new CurriculumCourse(line)); }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.courses = baseCourses;
        this.categories = baseCategories;
    }

    public ArrayList<CurriculumCourse> getCourses() {
        return courses;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public boolean categorySatisfaction(Category category, List<CurriculumCourse> courses){
        return categoryCreditHoursNeededMultipleCourses(category, courses) <= 0;
    }

    public int categoryCreditHoursNeededMultipleCourses (Category category, List<CurriculumCourse> courses){
        int leftoverCreditHours = category.getCreditHours();
        for (CurriculumCourse course : courses) {
            if (category.getDeptNames().contains(course.getDept())){
                leftoverCreditHours -= course.getCreditHours();
            }
        }
        return leftoverCreditHours;
    }

    public int categoryCreditHoursNeededSingleCourse (Category category, CurriculumCourse course){
        if (category.getDeptNames().contains(course.getDept())){
            return category.getCreditHours() - course.getCreditHours();
        }
        else return category.getCreditHours();
    }

    @Override
    public String toString() {
        return "Courses" + courses +
                ", along with the following categories:" + categories;
    }


}
