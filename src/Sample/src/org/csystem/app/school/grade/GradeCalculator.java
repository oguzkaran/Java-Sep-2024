package org.csystem.app.school.grade;

import org.csystem.util.string.StringUtil;

public class GradeCalculator {
    public String dataStr;

    public GradeCalculator(String str)
    {
        //...
        dataStr = str;
    }

    public GradeInfo getGradeInfo()
    {
        String [] gradeInfo = StringUtil.split(dataStr, ":");

        GradeInfo gi = new GradeInfo();

        gi.studentNumber = gradeInfo[0];
        gi.studentName = gradeInfo[1];
        gi.birthDate = gradeInfo[2];
        gi.lectureName = gradeInfo[3];
        gi.midTermGrade = Integer.parseInt(gradeInfo[4]);
        gi.finalGrade = Integer.parseInt(gradeInfo[5]);

        return gi;
    }
}
