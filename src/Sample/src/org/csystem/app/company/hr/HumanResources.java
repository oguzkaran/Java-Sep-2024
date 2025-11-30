package org.csystem.app.company.hr;

import org.csystem.app.company.employee.IInsured;
import org.csystem.util.console.Console;

public class HumanResources {
    //...

    public void payInsurance(IInsured insured)
    {
        Console.writeLine("Citizen Id:%s", insured.getId());
        Console.writeLine("Insurance Payment%f", insured.calculateInsurancePayment());
    }
}
