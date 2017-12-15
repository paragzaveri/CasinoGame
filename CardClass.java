public class CardClass
{
	/*
	Class variables for the value of a card
	and its suit.
	*/
	private int value;
	private String suit;

	/**
	*Default Constructor.  Sets the card value to 0
	*and the suit to empty string.
	*/
	public CardClass()
	{
		value = 0;
		suit = "";
	}

	/**
	*Constructor that accepts a card value and suit.
	*@param int The value of the card as an integer.
	*@param String The name of the suit of the card.
	*/
	public CardClass(int cardValue, String cardSuit)
	{
		value = cardValue;
		suit = cardSuit;
	}

	/**
	*Copy Constructor that accepts a CardClass object and constructs
	*a new object
	*@param CardClass The object to be copied.
	*/
	public CardClass(CardClass copy)
	{
		this(copy.getValue(), copy.getSuit());
	}

	/**
	*Accessor for getting the value of the card
	*@return int The value of the card.
	*/
	public int getValue()
	{
		return value;
	}

	/**
	*Accessor for getting the value of the suit of the card.
	*@return String the value of the suit.
	*/
	public String getSuit()
	{
		return suit;
	}

	/**
	*Mutator for setting the value of the card.
	*@param int The value of the card.
	*/
	public void setValue(int cardValue)
	{
		value = cardValue;
	}

	/**
	*Mutator for setting the value of the suit.
	*@param String The value of the suit of the card.
	*/
	public void setSuit(String cardSuit)
	{
		suit = cardSuit;
	}
}