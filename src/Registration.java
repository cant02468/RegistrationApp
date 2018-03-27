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


    public ArrayList<CurriculumCourse> whatsLeftToTake() {
        ArrayList<CurriculumCourse> returnArray = new ArrayList<>(this.curriculum.getCourses());
        returnArray.removeAll(this.transcript.getCourses());
        return returnArray;
    }

    public ArrayList<Course> whatsNeededAndAvailable() {
        ArrayList<Course> returnArray = new ArrayList<>();
        ArrayList<CurriculumCourse> coursesNeeded = whatsLeftToTake();
        Set<String> departments = new HashSet<>();
        for (CurriculumCourse curriculumCourse: coursesNeeded) {
            if (!departments.contains(curriculumCourse.getDept())){
                departments.add(curriculumCourse.getDept());
                returnArray.addAll(registrar.findDeptAndNumberCourses(curriculumCourse.getDept(), curriculumCourse.getNumber()));
            }
        }
        return returnArray;
    }
}
