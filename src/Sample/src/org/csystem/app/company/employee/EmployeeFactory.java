package org.csystem.app.company.employee;

import java.util.Random;

public class EmployeeFactory {
    private final Random m_random = new Random();

    private static Manager getManager()
    {
        return new Manager("12345678912", "Ali Veli", "Mecidiyeköy", "Pazarlama", 300000);
    }

    private static SalesManager getSalesManager()
    {
        return new SalesManager("12345678914", "Zeynep Ayşe", "Şişli", "Pazarlama", 300000, 100000);
    }

    private static Worker getWorker()
    {
        return new Worker("12345678916", "Ahmet Veli", "Bahçelievler", 1000, 8);
    }

    private static ProjectWorker getProjectWorker()
    {
        return new ProjectWorker("12345678918", "Banu Oya", "Beykoz", 1000, 8, "Haberleşme", 800);
    }

    public Employee getEmployee()
    {
        return switch (m_random.nextInt(4)) {
            case 0 -> getManager();
            case 1 -> getSalesManager();
            case 2 -> getWorker();
            default -> getProjectWorker();
        };
    }
}
