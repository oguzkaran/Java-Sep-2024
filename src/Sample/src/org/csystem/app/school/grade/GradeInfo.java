package org.csystem.app.school.grade;

public class GradeInfo {
    private String m_studentNumber;
    private String m_studentName;
    private String m_birthDate;
    private String m_lectureName;
    private int m_midTermGrade;
    private int m_finalGrade;

    public String getStudentNumber()
    {
        return m_studentNumber;
    }

    public void setStudentNumber(String studentNumber)
    {
        m_studentNumber = studentNumber;
    }

    public String getStudentName()
    {
        return m_studentName;
    }

    public void setStudentName(String studentName)
    {
        m_studentName = studentName;
    }

    public String getBirthDate()
    {
        return m_birthDate;
    }

    public void setBirthDate(String birthDate)
    {
        m_birthDate = birthDate;
    }

    public String getLectureName()
    {
        return m_lectureName;
    }

    public void setLectureName(String lectureName)
    {
        m_lectureName = lectureName;
    }

    public int getMidTermGrade()
    {
        return m_midTermGrade;
    }

    public void setMidTermGrade(int midTermGrade)
    {
        m_midTermGrade = midTermGrade;
    }

    public int getFinalGrade()
    {
        return m_finalGrade;
    }

    public void setFinalGrade(int finalGrade)
    {
        m_finalGrade = finalGrade;
    }

    public double getGrade()
    {
        return m_midTermGrade * 0.4 + m_finalGrade * 0.6;
    }

    public boolean isSuccess()
    {
        return getGrade() >= 50;
    }
}
