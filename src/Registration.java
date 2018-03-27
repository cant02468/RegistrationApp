import java.util.ArrayList;
import java.util.Collection;

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
}
