package org.csystem.app.school.grade;

import org.csystem.app.datetime.DateUtil;
import org.csystem.util.string.StringUtil;

import java.util.Scanner;

public class GradeCalculatorApp {
    public static void printGradeInfo(GradeInfo gi)
    {
        String [] birthDateInfo = StringUtil.split(gi.getBirthDate(), "-");
        String birthDateStr = DateUtil.getLongDateEN(Integer.parseInt(birthDateInfo[2]),
                Integer.parseInt(birthDateInfo[1]), Integer.parseInt(birthDateInfo[0]));

        System.out.println("Student Information:");
        System.out.printf("Number: %s%n", gi.getStudentNumber());
        System.out.printf("Name: %s%n", gi.getStudentName());
        System.out.printf("Birth Date: %s%n", birthDateStr);
        System.out.printf("Lecture Name: %s%n", gi.getLectureName());
        System.out.printf("Midterm Grade: %d%n", gi.getMidTermGrade());
        System.out.printf("Final Grade: %d%n", gi.getFinalGrade());
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
