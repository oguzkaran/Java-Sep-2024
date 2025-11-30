package org.csystem.random.generator;

import org.csystem.util.string.StringUtil;

import java.util.random.RandomGenerator;

public class RandomStringArrayGenerator {
    private final String [] m_texts;

    public RandomStringArrayGenerator(RandomGenerator randomGenerator, int count, int origin, int bound)
    {
        m_texts = StringUtil.randomTextsEN(randomGenerator, count, origin, bound);
    }

    public int count()
    {
        return m_texts.length;
    }

    public String get(int i)
    {
        return m_texts[i];
    }
}
