package angel.zxiu.career.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zxiu on 19.07.16.
 */
public class CurriculumVitae {
    PersonalInfo personalInfo = new PersonalInfo();
    List<WorkingExp> workingExpList = new ArrayList(){{
        add(new WorkingExp());
    }};
}
