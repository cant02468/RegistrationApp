import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class Registrar{
    private ArrayList<Course> courses;

    Registrar(String fileName) {
        ArrayList<Course> base = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach(line -> base.add(new Course(line)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.courses = base;
    }

    @Override
    public String toString() {
        return "Courses in the Registrar{" + courses +
                '}';
    }
}
