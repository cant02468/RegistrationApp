import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
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

    @Override
    public String toString() {
        return "Courses" + courses +
                ", along with the following categories:" + categories;
    }
}
