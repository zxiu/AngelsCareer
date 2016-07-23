package angel.zxiu.career.bean;

import java.util.Date;

/**
 * Created by zxiu on 19.07.16.
 */
public class WorkingExp {
    public Date from, to;
    public String position;
    public Employer employer = new Employer();
}
