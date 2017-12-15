import java.util.Arrays;

public class HandClass
{
	//A class array for holding the hand of cards
	private CardClass [] hand;
	//constant for the size of the array
	public final int HANDSIZE = 5;

	/**
	*Default Constructor
	*Constructs an array of size 5 to hold the hand of cards.
	*/
	public HandClass()
	{
		hand = new CardClass[HANDSIZE];
	}
	/**
	*Constructor that takes in five cards for the hand.
	*Constructs a new array and sets the five cards to 5 locations in the array
	*@param CardClass The first card.
	*@param CardClass The second card.
	*@param CardClass The third card.
	*@param CardClass The fourth card.
	*@param CardClass The fifth card.
	*/
	public HandClass(CardClass a, CardClass b,
		CardClass c, CardClass d, CardClass e)
	{
		//construct new array
		hand = new CardClass[HANDSIZE];
		//set five cards to array
		hand[0] = new CardClass(a);
		hand[1] = new CardClass(b);
		hand[2] = new CardClass(c);
		hand[3] = new CardClass(d);
		hand[4] = new CardClass(e);
	}
	/**
	*Copy Constructor for HandClass
	*@param HandClass The object to be copied.
	*Creates a new object using the five cards in the hand.
	*/
	public HandClass(HandClass copy)
	{
		this(copy.getFirst(), copy.getSecond(), 
			copy.getThird(), copy.getFourth(), copy.getFifth());
	}
	/**
	*Accessor for the First Card in the Hand
	*@return CardClass The first card.
	*/
	public CardClass getFirst()
	{
		return hand[0];
	}
	/**
	*Mutator for setting the First Card in the Hand
	*@param CardClass The card to change the first card in the hand.
	*/
	public void setFirst(CardClass a)
	{
		hand[0] = a;
	}
	/**
	*Accessor for getting the Second Card in the Hand.
	*@return CardClass The second card.
	*/
	public CardClass getSecond()
	{
		return hand[1];
	}
	/**
	*Mutator for changing the Second Card in the Hand
	*@param CardClass The card to change the second card in the hand.
	*/
	public void setSecond(CardClass b)
	{
		hand[1] = b;
	}
	/**
	*Accessor for getting the Third Card in the Hand.
	*@return CardCLass The third card.
	*/
	public CardClass getThird()
	{
		return hand[2];
	}
	/**
	*Mutator for changing the Third Card in the Hand
	*@param CardClass The card to change the third card in the hand.
	*/
	public void setThird(CardClass c)
	{
		hand[2] = c;
	}
	/**
	*Accessor for getting the fourth card in the hand.
	*@return CardClass The fourth card.
	*/
	public CardClass getFourth()
	{
		return hand[3];
	}
	/**
	*Mutator for changing the fourth card in the hand.
	*@param CardClass The card to change the fourth card in the hand.
	*
	*/
	public void setFourth(CardClass d)
	{
		hand[3] = d;
	}
	/**
	*Accessor for getting the fifth card in the hand.
	*@return CardClass The fifth card.
	*/
	public CardClass getFifth()
	{
		return hand[4];
	}
	/**
	*Mutator for changing the fifth card in the hand.
	*@param CardClass The card to change the fifth card in the hand.
	*/
	public void setFifth(CardClass e)
	{
		hand[4] = e;
	}
	/**
	*Algorithm for sorting the Hand by value.
	*Necessary method for future comparing to find the type of hand.
	*Uses a bubble sort
	*The first item in the hand is checked along with the rest and 
	*the next item is check with the rest and so forth.
	*There is no return or any parameters.
	*/
	public void sortHand()
	{
		CardClass temp = new CardClass();
		//loop for the items used in overall comparisons
		for (int i = 0; i < hand.length; i++)
		{
			//loop for the items in each overall iteration to be compared
			for (int j = i + 1; j < hand.length; j++)
			{
				//if the value is larger than a subseqent value swap
				if(hand[i].getValue() > hand[j].getValue())
				{
					//swap operation
					temp = hand[i];
					hand[i] = hand[j];
					hand[j] = temp;
				}
			}
		}
	}
	/**
	*Algorithm for printing the hand
	*Prints A list of all five cards with the value followed by the suit
	*There is no return type or any parameters.
	*/
	public void printHand()
	{
		//first card
		System.out.println("1) " + getFirst().getValue() 
		+ " " + getFirst().getSuit());
		//second card
		System.out.println("2) " + getSecond().getValue() 
		+ " " + getSecond().getSuit());
		//third card
		System.out.println("3) " + getThird().getValue() 
		+ " " + getThird().getSuit());
		//fourth card
		System.out.println("4) " + getFourth().getValue() 
		+ " " + getFourth().getSuit());
		//fifth card
		System.out.println("5) " + getFifth().getValue() 
		+ " " + getFifth().getSuit());
	}

}