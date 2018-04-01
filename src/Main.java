import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n\nHello, RegistrationApp!\n");

        Registration registration = new Registration( "registrar.txt", "curriculum.dat", "transcript.txt" );
        // TODO output registration data in three groupings:
        // registrar.txt sorted by time
        // curriculum.dat sorted by credit hours
        // transcript.txt sorted by department

        ArrayList<CurriculumCourse> coursesNeededToGraduate = registration.whatsLeftToTake();
        System.out.println( "What's left to take:\n" + coursesNeededToGraduate );

        ArrayList<Course> prospectiveCoursesToTakeThisSemester = registration.whatsNeededAndAvailable();
        System.out.println( "Prospective courses to take this semester:\n" + prospectiveCoursesToTakeThisSemester );

        ArrayList<CurriculumCourse> transcriptLeftoverCourses = registration.transcriptCoursesLeftover();
        System.out.println( "You have extra courses:\n" + transcriptLeftoverCourses);

        /**
        ArrayList<Course> neededCoursesWithNoOverlap = registration.whatCoursesToTakeTogether();
        System.out.println( "What courses are needed and no time overlap:\n" + neededCoursesWithNoOverlap );

        ArrayList<Course> whatToTake = registration.registerFor( 6 );
        System.out.println( "What 6 courses should you take: " + whatToTake );
         */
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