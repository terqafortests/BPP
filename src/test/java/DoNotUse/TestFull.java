package DoNotUse;

import Actions.MarkingWorkflow;
import org.testng.annotations.Test;
import utils.MainClass;

/**
 * Created by roma on 10/8/15.
 */
public class TestFull extends MainClass {

    MarkingWorkflow marking = new MarkingWorkflow();

    String name = "Calendar001 StCal001";
    String course = "Test 2";
    String courseGroup = "CIMA Certificate";
    int step = 1;
    String active = "For Test";

//    String name = "Calendar001 StCal001";
//    String course = "Regression Test";
//    String courseGroup = "QA Fusion Test";
//    int step = 1;
//    String active = "Active assigment";

    /**
     * name - student name
     * course - needed course
     * step - number of step
     * courseGroup - course category
     * */


    @Test
    public void markingWorkFlowTest() {
        marking.estimeteStudent(name, course, step, courseGroup, active);
//        marking.estimate(name, course, step, active);
    }
}
