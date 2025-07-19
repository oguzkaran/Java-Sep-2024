package org.csystem.app.simulation.exam;

import java.util.Random;
import java.util.Scanner;

public class ExamSimulation {
    public static void set(ExamInfo examInfo, Scanner kb)
    {
        Random random = new Random();

        for (int i = 0; i < examInfo.getNumberOfClasses(); ++i) {
            System.out.printf("Input number of student of class %d:", i + 1);
            examInfo.setNumberOfStudents(i, Integer.parseInt(kb.nextLine()));

            for (int k = 0; k < examInfo.getNumberOfStudents(i); ++k)
                examInfo.setGrade(i, k, random.nextInt(0, 11));
        }
    }

    public static void printGrades(ExamInfo examInfo)
    {
        for (int i = 0; i < examInfo.getNumberOfClasses(); ++i) {
            int numberOfStudents = examInfo.getNumberOfStudents(i);
            System.out.printf("Class %d (%d student) -> ", i + 1, numberOfStudents);
            for (int k = 0; k < numberOfStudents; ++k)
                System.out.printf("%02d ", examInfo.getGrade(i, k));

            System.out.println();
        }
    }

    public static void printReport(ExamInfo examInfo)
    {
        System.out.printf("Report of '%s':%n", examInfo.getLectureName());
        printGrades(examInfo);
        examInfo.run();
        for (int i = 0; i < examInfo.getNumberOfClasses(); ++i)
            System.out.printf("Average of Class is %f%n", examInfo.getAverage(i));

        System.out.printf("Total average is %f%n", examInfo.getTotalAverage());
    }

    public static void run()
    {
        System.out.print("Input number of classes:");
        Scanner kb = new Scanner(System.in);
        ExamInfo examInfo = new ExamInfo("Mathematics", Integer.parseInt(kb.nextLine()));

        set(examInfo, kb);
        printReport(examInfo);
    }
}
