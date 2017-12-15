import java.util.ArrayList;
import java.util.Random;

public class DeckClass
{
	//class array list to hold the deck of cards
	private ArrayList<CardClass> deck;

	/**
	*Default Constructor that automatically creates a deck of cards.
	*Uses four for loops to create 13 cards for each suit.
	*Face Cards are represented by 11,12,13,14 for 
	*Jack,Queen,King,and Ace respectively.
	*/
	public DeckClass()
	{
		deck = new ArrayList<CardClass>();
		for(int i = 2; i < 15; i++)
		{
			deck.add(new CardClass(i, "Hearts"));
		}
		for(int i = 2; i < 15; i++)
		{
			deck.add(new CardClass(i, "Spades"));
		}
		for(int i = 2; i < 15; i++)
		{
			deck.add(new CardClass(i, "Diamonds"));
		}
		for(int i = 2; i < 15; i++)
		{
			deck.add(new CardClass(i, "Clubs"));
		}
	}
	/**
	*Constructor that creates a deck of cards based on an existing
	*array list.
	*@param ArrayList<CardClass> Another array list of cards.
	*/
	public DeckClass(ArrayList<CardClass> anotherDeck)
	{
		deck = new ArrayList<CardClass>(anotherDeck);
	}
	/**
	*Copy Constructor for the DeckClass.
	*@param DeckClass The object to be copied.
	*Takes the object to be copied and creates a new object based on it.
	*/
	public DeckClass(DeckClass copy)
	{
		deck = new ArrayList<CardClass>(copy.deck);
	}
	/**
	*A method for dealing a card.  This means it is removed from the deck.
	*@return CardClass The card to be dealt.
	*/
	public CardClass dealCard()
	{
		//remove from front of array list
		return deck.remove(0);
	}
	/**
	*A method for adding a card back to the deck.
	*@param CardClass The card to be added back to the deck.
	*/
	public void addCard(CardClass card)
	{
		//add back to end of array list
		deck.add(card);
	}
	/**
	*A method for shuffling the deck of cards.
	*Uses a random generated number as the index
	*and swaps each card in succession with another random card
	*in the deck.
	*/
	public void shuffleDeck()
	{
		//create a random object
		Random randIndex = new Random();
		//creat an index object
		int index = 0;

		for (int i = 0; i < deck.size(); i++)
		{
			//generate a random index
			index = randIndex.nextInt(deck.size());
			//create a temporary CardClass object
			CardClass a = new CardClass(deck.get(i));
			//swap part 1
			deck.set(i, deck.get(index));
			//swap part 2
			deck.set(index, a);
		}
	}
	/**
	*A method for printing the deck of cards.
	*Simply goes loops through the array list for the deck
	*and prints the value and suit of each card.
	*/
	public void printDeck()
	{
		for (int i = 0; i < deck.size(); i++)
		{
			System.out.print(deck.get(i).getValue());
			System.out.print(", ");
			System.out.println(deck.get(i).getSuit());
		}
	}



}