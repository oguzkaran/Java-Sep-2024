package org.csystem.app.school.grade;

import org.csystem.util.string.StringUtil;

public class GradeCalculator {
    private final String m_dataStr;

    public GradeCalculator(String str)
    {
        //...
        m_dataStr = str;
    }

    public GradeInfo getGradeInfo()
    {
        String [] gradeInfo = StringUtil.split(m_dataStr, ":");

        GradeInfo gi = new GradeInfo();

        gi.setStudentNumber(gradeInfo[0]);
        gi.setStudentName(gradeInfo[1]);
        gi.setBirthDate(gradeInfo[2]);
        gi.setLectureName(gradeInfo[3]);
        gi.setMidTermGrade(Integer.parseInt(gradeInfo[4]));
        gi.setFinalGrade(Integer.parseInt(gradeInfo[5]));

        return gi;
    }
}
