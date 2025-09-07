package org.csystem.util.string;

import java.util.Random;

/**
 * Utility class for string operations
 * Last Update: 7th September 2025
 * @author Java-Sep-2024 Group
 */
public final class StringUtil {
    private static final String LETTERS_TR = "abcçdefgğhıijklmnoöprsştuüvyz";
    private static final String LETTERS_EN = "abcdefghijklmnopqrstuvwxyz";
    private static final String CAPITAL_LETTERS_TR = "ABCÇDEFGĞHIİJKLMOÖPRSŞTUÜVYZ";
    private static final String CAPITAL_LETTERS_EN = "ABCDEFGHIJKLMOPQRSTUVWXYZ";
    private static final String ALL_LETTERS_TR = LETTERS_TR + CAPITAL_LETTERS_TR;
    private static final String ALL_LETTERS_EN = LETTERS_EN + CAPITAL_LETTERS_EN;

    private StringUtil()
    {
    }

    public static String capitalize(String s)
    {
        return s.isEmpty() ? s : Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
    }

    public static String changeCase(String s)
    {
        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < sb.length(); ++i) {
            char c = sb.charAt(i);

            sb.setCharAt(i, Character.isLowerCase(c) ? Character.toUpperCase(c) : Character.toLowerCase(c));
        }

        return sb.toString();
    }

    public static int countString(String s1, String s2)
    {
        int count = 0;

        for (int i = -1; (i = s1.indexOf(s2, i + 1)) != -1; ++count)
            ;

        return count;
    }

    public static String digits(String s)
    {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);

            if (Character.isDigit(c))
                sb.append(c);
        }

        return sb.toString();
    }

    public static boolean isPalindrome(String s)
    {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char cLeft = s.charAt(left);

            if (!Character.isLetter(cLeft)) {
                ++left;
                continue;
            }

            char cRight = s.charAt(right);

            if (!Character.isLetter(cRight)) {
                --right;
                continue;
            }

            if (Character.toLowerCase(cLeft) != Character.toLowerCase(cRight))
                return false;

            ++left;
            --right;
        }

        return true;
    }

    public static boolean isPangram(String s, String alphabet)
    {
        for (int i = 0; i < alphabet.length(); ++i)
            if (s.indexOf(alphabet.charAt(i)) == -1)
                return false;

        return true;
    }

    public static boolean isPangramEN(String s)
    {
        return isPangram(s.toLowerCase(), LETTERS_EN);
    }

    public static boolean isPangramTR(String s)
    {
        return isPangram(s.toLowerCase(), LETTERS_TR);
    }

    public static String join(String [] s)
    {
        return join(s, "");
    }

    public static String join(String [] s, char delimiter)
    {
        return join(s, String.valueOf(delimiter));
    }

    public static String join(String [] str, String delimiter)
    {
        StringBuilder sb = new StringBuilder();

        for (String s : str)
            sb.append(s).append(delimiter);

        return sb.substring(0, sb.length() - delimiter.length());
    }

    public static String join(String [] s, char delimiter, boolean ignoreEmpties)
    {
        return join(s, String.valueOf(delimiter), ignoreEmpties);
    }

    public static String join(String [] str, String delimiter, boolean ignoreEmpties)
    {
        StringBuilder sb = new StringBuilder();

        for (String s : str) {
            if (ignoreEmpties) {
                if (!s.isEmpty())
                    sb.append(s).append(delimiter);
            }
            else
                sb.append(s).append(delimiter);
        }

        return sb.substring(0, sb.length() - delimiter.length());
    }

    public static String join(String [] s, char delimiter, int ignoreStatus)
    {
        return join(s, String.valueOf(delimiter), ignoreStatus);
    }

    public static String join(String [] str, String delimiter, int ignoreStatus)
    {
        StringBuilder sb = new StringBuilder();

        for (String s : str) {
            if (ignoreStatus == 1) {
                if (!s.isEmpty())
                    sb.append(s).append(delimiter);
            }
            else if (ignoreStatus == 2) {
                if (!s.isBlank())
                    sb.append(s).append(delimiter);
            }
            else
                sb.append(s).append(delimiter);
        }

        return sb.substring(0, sb.length() - delimiter.length());
    }

    public static String letters(String s)
    {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);

            if (Character.isLetter(c))
                sb.append(c);
        }

        return sb.toString();
    }

    public static String padLeading(String s, int n, char ch)
    {
        int len = s.length();

        return len < n ? String.valueOf(ch).repeat(n - len) + s : s;
    }

    public static String padLeading(String s, int n)
    {
        return padLeading(s, n, ' ');
    }

    public static String padTrailing(String s, int n, char ch)
    {
        int len = s.length();

        return len < n ? s + String.valueOf(ch).repeat(n - len) : s;
    }

    public static String padTrailing(String s, int n)
    {
        return padTrailing(s, n, ' ');
    }

    public static String randomText(Random random, int count, String sourceText)
    {
        StringBuilder sb = new StringBuilder(count);

        for (int i = 0; i < count; ++i)
            sb.append(sourceText.charAt(random.nextInt(sourceText.length())));

        return sb.toString();
    }

    public static String randomTextTR(Random random, int count)
    {
        return randomText(random, count, ALL_LETTERS_TR);
    }

    public static String randomTextEN(Random random, int count)
    {
        return randomText(random, count, ALL_LETTERS_EN);
    }

    public static String [] randomTexts(Random random, int count, int min, int bound, String sourceText)
    {
        String [] texts = new String[count];

        for (int i = 0; i < count; ++i)
            texts[i] = randomText(random, random.nextInt(min, bound), sourceText);

        return texts;
    }

    public static String [] randomTextsTR(Random random, int count, int min, int bound)
    {
        return randomTexts(random, count, min, bound, ALL_LETTERS_TR);
    }

    public static String [] randomTextsEN(Random random, int count, int min, int bound)
    {
        return randomTexts(random, count, min, bound, ALL_LETTERS_EN);
    }

    public static String [] randomTexts(Random random, int count, int n, String sourceText)
    {
        String [] texts = new String[count];

        for (int i = 0; i < count; ++i)
            texts[i] = randomText(random, n, sourceText);

        return texts;
    }

    public static String [] randomTextsTR(Random random, int count, int n)
    {
        return randomTexts(random, count, n, ALL_LETTERS_TR);
    }

    public static String [] randomTextsEN(Random random, int count, int n)
    {
        return randomTexts(random, count, n, ALL_LETTERS_EN);
    }

    public static String reverse(String s)
    {
        return new StringBuilder(s).reverse().toString();
    }

    public static String [] split(String s, String delimiters)
    {
        return split(s, delimiters, false);
    }

    public static String [] split(String s, String delimiters, boolean removeEmpties)
    {
        StringBuilder sbRegex = new StringBuilder("[");

        for (int i = 0; i < delimiters.length(); ++i) {
            char c = delimiters.charAt(i);

            if (c == ']' || c == '[')
                sbRegex.append('\\');

            sbRegex.append(c);
        }

        sbRegex.append(']');

        if (removeEmpties)
            sbRegex.append('+');

        return s.split(sbRegex.toString());
    }

    public static String trim(String s)
    {
        return trimLeading(trimTrailing(s));
    }

    public static String trimLeading(String s)
    {
        int i = 0;

        for (; i < s.length() && Character.isWhitespace(s.charAt(i)); ++i)
            ;

        return s.substring(i);
    }

    public static String trimTrailing(String s)
    {
        int i = s.length() - 1;

        for (; i >= 0 && Character.isWhitespace(s.charAt(i)); --i)
            ;

        return s.substring(0, i + 1);
    }
}