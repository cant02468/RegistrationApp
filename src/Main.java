import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n\nHello, RegistrationApp!\n");

        Registrar registrar = new Registrar( "registrar.txt" );
        System.out.println( "Registrar:\n" + registrar );
    }
}
        /**
        //read from the text files to convert into courses.
        ArrayList<Course> courseList = fileToCoursesArrayList("registrar.txt");
        System.out.println(courseList);

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
*/