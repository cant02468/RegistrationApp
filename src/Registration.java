import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Registration {
    private Registrar registrar;
    private Curriculum curriculum;
    private Transcript transcript;

    Registration(String registrarFile, String curriculumFile, String transcriptFile){
        registrar = new Registrar(registrarFile);
        curriculum = new Curriculum(curriculumFile);
        transcript = new Transcript(transcriptFile);
    }

    public ArrayList<CurriculumCourse> transcriptCoursesLeftover(){
        ArrayList<CurriculumCourse> returnArray = new ArrayList<>(this.transcript.getCourses());
        returnArray.removeAll(this.curriculum.getCourses());
        return returnArray;
    }

    public ArrayList<CurriculumCourse> whatsLeftToTake() {
        ArrayList<CurriculumCourse> returnArray = new ArrayList<>(this.curriculum.getCourses());
        returnArray.removeAll(this.transcript.getCourses());
        return returnArray;
    }

    public ArrayList<Course> whatsNeededAndAvailable() {
        Set<Course> coursesNeeded = new HashSet<>(registrar.curriculumCoursesToCourses(whatsLeftToTake()));
        coursesNeeded.addAll(registrar.findAllCoursesFromAllCategories(curriculum.getCategories()));
        return new ArrayList<>(coursesNeeded);
    }
}
