package org.csystem.app.school.grade;

public class GradeInfo {
    public String studentNumber;
    public String studentName;
    public String birthDate;
    public String lectureName;
    public int midTermGrade;
    public int finalGrade;

    public double getGrade()
    {
        return midTermGrade * 0.4 + finalGrade * 0.6;
    }

    public boolean isSuccess()
    {
        return getGrade() >= 50;
    }
}
