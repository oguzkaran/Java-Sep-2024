package org.csystem.app.company.hr;

import org.csystem.app.company.employee.Employee;
import org.csystem.util.console.Console;

public class HumanResources {
    //...

    public void payInsurance(Employee employee)
    {
        Console.writeLine("Citizen Id:%s", employee.getCitizenId());
        Console.writeLine("Name:%s", employee.getName());
        Console.writeLine("Insurance Payment%f", employee.calculateInsurancePayment());
    }
}
