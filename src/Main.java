import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n\nHello, RegistrationApp!\n");

        Registrar registrar = new Registrar( "registrar.txt" );
        System.out.println( "Registrar:\n" + registrar );

        String dept = "CPSC";
        ArrayList<Course> registrarCoursesInDept = registrar.findDeptCourses( dept );
        System.out.println( "The registrar courses in " + dept + " are " + registrarCoursesInDept );

        Transcript transcript = new Transcript("transcript.txt");
        System.out.println("The transcript contains the following: " + transcript);
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