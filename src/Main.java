import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n\nHello, RegistrationApp!\n");

        //read from the text files to convert into courses.
        ArrayList<Course> courseList = fileToCoursesArrayList("registrar.txt");
        System.out.println(courseList);

        //TODO implement a transcript file.
        //TODO implement something (Queue?) to order courses with prerequisites such as CPSC and MATH.
        //TODO implement something (Tree with several leaves?) to qualify courses into necessary CPSC, MATH, African American Heritage, Human Past,  Scientific Reasoning, and CPSC Elective.
        //TODO implement a function or method to read from the curriculum.dat file to determine credits that are still unmet.

    }

    private static ArrayList<Course> fileToCoursesArrayList(String fileName) {
        ArrayList<Course> returnArray = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach(line -> returnArray.add(Course.valueOf(line)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return returnArray;
    }
}
