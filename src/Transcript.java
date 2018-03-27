import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class Transcript {
    private ArrayList<CurriculumCourse> courses;

    Transcript(String fileName) {
        ArrayList<CurriculumCourse> base = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach(line -> base.add(new CurriculumCourse(line)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.courses = base;
    }

    public ArrayList<CurriculumCourse> getCourses() {
        return courses;
    }

    @Override
    public String toString() {
        return "Transcript" + courses;
    }
}
