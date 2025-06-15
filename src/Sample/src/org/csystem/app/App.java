package org.csystem.app;

class App {
	public static void main(String[] args)
	{
		Date birthDate = new Date(10, 9, 1976);

		System.out.printf("%02d/%02d/%04d%n", birthDate.getDay());

		birthDate.setDay(6);
	}
}

class Date {
	private int m_day, m_month, m_year;

	public Date(int day, int month, int year)
	{
		//...

		m_day = day;
		m_month = month;
		m_year = year;
	}

	public int getDay() //accessor / getter
	{
		return m_day;
	}

	public void setDay(int val) // mutator / setter
	{
		//...
		m_day = val;
	}

	//...
}

