package org.csystem.app.company.employee;

public abstract class Employee implements IInsured {
    private String m_citizenId;
    private String m_name;
    private String m_address;

    protected Employee()
    {
        this("", "", "");
    }

    protected Employee(String citizenId, String name, String address)
    {
        m_citizenId = citizenId;
        m_name = name;
        m_address = address;
    }

    public String getId()
    {
        return m_citizenId;
    }

    public void setId(String citizenId)
    {
        m_citizenId = citizenId;
    }

    public String getName()
    {
        return m_name;
    }

    public void setName(String name)
    {
        m_name = name;
    }

    public String getAddress()
    {
        return m_address;
    }

    public void setAddress(String address)
    {
        m_address = address;
    }
}
