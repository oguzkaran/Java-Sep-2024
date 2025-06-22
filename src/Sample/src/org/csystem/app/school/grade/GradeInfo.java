package org.csystem.app.school.grade;

public class GradeInfo {
    private String studentNumber;
    private String studentName;
    private String birthDate;
    private String lectureName;
    private int midTermGrade;
    private int finalGrade;

    public String getStudentNumber()
    {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber)
    {
        this.studentNumber = studentNumber;
    }

    public String getStudentName()
    {
        return studentName;
    }

    public void setStudentName(String studentName)
    {
        this.studentName = studentName;
    }

    public String getBirthDate()
    {
        return birthDate;
    }

    public void setBirthDate(String birthDate)
    {
        this.birthDate = birthDate;
    }

    public String getLectureName()
    {
        return lectureName;
    }

    public void setLectureName(String lectureName)
    {
        this.lectureName = lectureName;
    }

    public int getMidTermGrade()
    {
        return midTermGrade;
    }

    public void setMidTermGrade(int midTermGrade)
    {
        this.midTermGrade = midTermGrade;
    }

    public int getFinalGrade()
    {
        return finalGrade;
    }

    public void setFinalGrade(int finalGrade)
    {
        this.finalGrade = finalGrade;
    }

    public double getGrade()
    {
        return midTermGrade * 0.4 + finalGrade * 0.6;
    }

    public boolean isSuccess()
    {
        return getGrade() >= 50;
    }
}
