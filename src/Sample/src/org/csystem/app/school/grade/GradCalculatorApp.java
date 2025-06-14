package org.csystem.app.school.grade;

import org.csystem.app.datetime.DateUtil;
import org.csystem.util.string.StringUtil;

import java.util.Scanner;

public class GradCalculatorApp {
    public static void printGradeInfo(GradeInfo gi)
    {
        String [] birthDateInfo = StringUtil.split(gi.birthDate, "-");
        String birthDateStr = DateUtil.getLongDateEN(Integer.parseInt(birthDateInfo[2]),
                Integer.parseInt(birthDateInfo[1]), Integer.parseInt(birthDateInfo[0]));

        System.out.println("Student Information:");
        System.out.printf("Number: %s%n", gi.studentNumber);
        System.out.printf("Name: %s%n", gi.studentName);
        System.out.printf("Birth Date: %s%n", birthDateStr);
        System.out.printf("Lecture Name: %s%n", gi.lectureName);
        System.out.printf("Midterm Grade: %d%n", gi.midTermGrade);
        System.out.printf("Final Grade: %d%n", gi.finalGrade);
        System.out.printf("Grade: %.1f%n", gi.getGrade());
        System.out.printf("Status: %s%n", gi.isSuccess() ? "Success" : "Fail");
    }

    public static void run()
    {
        Scanner kb = new Scanner(System.in);

        System.out.print("Input data:");
        GradeCalculator gc = new GradeCalculator(kb.nextLine());

        GradeInfo gi = gc.getGradeInfo();

        printGradeInfo(gi);
    }

    public static void main(String[] args)
    {
        run();
    }
}


/*
Student Information:
Number: 12345
Name: Oğuz Karan
Birth Date: 10th September 1976 Friday
Lecture Name: Matematik
Midterm Grade:67
Final Grade:90
Grade: 80.8
Status: Success
 */