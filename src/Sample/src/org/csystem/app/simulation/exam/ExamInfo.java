package org.csystem.app.simulation.exam;

import org.csystem.util.array.ArrayUtil;

public class ExamInfo {
    private final String m_lectureName;
    private final int [][] m_grades;
    private final double [] m_averages;
    private double m_totalAverage;

    public ExamInfo(String lectureName, int n)
    {
        m_lectureName = lectureName;
        m_grades = new int[n][];
        m_averages = new double[n];
    }

    public String getLectureName()
    {
        return m_lectureName;
    }

    public int getNumberOfClasses()
    {
        return m_grades.length;
    }

    public int getNumberOfStudents(int i)
    {
        return m_grades[i].length;
    }

    public void setNumberOfStudents(int i, int count)
    {
        m_grades[i] = new int[count];
    }

    public int getGrade(int i, int k)
    {
        return m_grades[i][k];
    }

    public void setGrade(int i, int k, int grade)
    {
        m_grades[i][k] = grade;
    }

    public double getTotalAverage()
    {
        return m_totalAverage;
    }

    public double getAverage(int i)
    {
        return m_averages[i];
    }

    public void run()
    {
        int totalNumberOfStudents = 0;
        int totalGrades = 0;

        for (int i = 0; i < m_grades.length; ++i) {
            int total = (int)ArrayUtil.sum(m_grades[i]);

            m_averages[i] = (double)total / m_grades[i].length;
            totalNumberOfStudents += m_grades[i].length;
            totalGrades += total;
        }

        m_totalAverage = (double)totalGrades / totalNumberOfStudents;
    }
}
