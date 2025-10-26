package org.csystem.app.company;

import org.csystem.app.company.employee.Employee;
import org.csystem.app.company.employee.EmployeeFactory;
import org.csystem.app.company.hr.HumanResources;
import org.csystem.util.thread.ThreadUtil;

public class DemoApp {
    private static void run()
    {        HumanResources humanResources = new HumanResources();
        EmployeeFactory employeeFactory = new EmployeeFactory();

        while (true) {
            Employee employee = employeeFactory.getEmployee();

            humanResources.payInsurance(employee);
            ThreadUtil.sleep(1000);
        }
    }

    public static void main(String[] args)
    {
        run();
    }
}
