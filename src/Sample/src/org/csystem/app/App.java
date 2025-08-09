package org.csystem.app;

import org.csystem.util.array.ArrayUtil;

import java.util.BitSet;

class App {
    public static void main(String[] args)
    {
        Fighter f = new Fighter();

        f.setName("test");
        f.setAgility(34);
        f.setHealth(45);
        f.setStrength(90);
        f.setRange(35);

        System.out.printf("Abilities average:%f%n", f.averageOfAbilities());
    }
}

class Fighter {
    private enum Ability {HEALTH, AGILITY, STRENGTH, RANGE, COUNT}
    private String m_name;
    private final int [] m_abilities = new int[Ability.COUNT.ordinal()];

    //...

    public String getName()
    {
        return m_name;
    }

    public void setName(String name)
    {
        m_name = name;
    }

    public int getHealth()
    {
        return m_abilities[Ability.HEALTH.ordinal()];
    }

    public void setHealth(int health)
    {
        m_abilities[Ability.HEALTH.ordinal()] = health;
    }

    public int getAgility()
    {
        return m_abilities[Ability.AGILITY.ordinal()];
    }

    public void setAgility(int agility)
    {
        m_abilities[Ability.AGILITY.ordinal()] = agility;
    }

    public int getStrength()
    {
        return m_abilities[Ability.STRENGTH.ordinal()];
    }

    public void setStrength(int strength)
    {
        m_abilities[Ability.STRENGTH.ordinal()] = strength;
    }

    public int getRange()
    {
        return m_abilities[Ability.RANGE.ordinal()];
    }

    public void setRange(int strength)
    {
        m_abilities[Ability.RANGE.ordinal()] = strength;
    }


    public int totalOfAbilities()
    {
        return (int)ArrayUtil.sum(m_abilities);
    }

    public double averageOfAbilities()
    {
        return totalOfAbilities() / (double)m_abilities.length;
    }
}

