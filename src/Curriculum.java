import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class Curriculum {
    ArrayList<CurriculumCourse> courses;
    ArrayList<Category> categories;

    public Curriculum(String fileName) {
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

    @Override
    public String toString() {
        return "Curriculum{" +
                "courses" + courses +
                ", categories:" + categories +
                '}';
    }
}