package org.csystem.game.card;

public class Card {
    private CardType m_cardType;
    private CardValue m_cardValue;

    public Card(CardType cardType, CardValue cardValue)
    {
        m_cardType = cardType;
        m_cardValue = cardValue;
    }

    public CardType getCardType()
    {
        return m_cardType;
    }

    public void setCardType(CardType cardType)
    {
        m_cardType = cardType;
    }

    public CardValue getCardValue()
    {
        return m_cardValue;
    }

    public void setCardValue(CardValue cardValue)
    {
        m_cardValue = cardValue;
    }

    public String toString()
    {
        return "%s-%s".formatted(m_cardType.toString(), m_cardValue.toString());
    }
}
