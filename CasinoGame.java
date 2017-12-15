import java.util.Scanner;
import java.lang.Character;

public class CasinoGame
{
	/*
	Method that runs through the game play interface.
	Accepts a deck of cards and the players hands (which can hold five cards)
	as parameters.  Return type is void.
	*/
	public static void playGame(DeckClass deck, HandClass hand)
	{
		//shuffle the deck using the shuffle deck method of deck class
		deck.shuffleDeck();
		/*
		Deal the first five cards.  This effectively removes them from the
		deck and puts them in the "players" hands.
		*/
		hand.setFirst(deck.dealCard());
		hand.setSecond(deck.dealCard());
		hand.setThird(deck.dealCard());
		hand.setFourth(deck.dealCard());
		hand.setFifth(deck.dealCard());

		//Show the user the hand
		System.out.println("\nHere is your first hand.");
		//Use print function of the hand class
		hand.printHand();

		//create input object to see which cards they want to give back
		Scanner cardInput = new Scanner(System.in);

		//Prompt and switch cards potentially for each card
		for (int i = 0; i < 5; i++)
		{
			//prompt
			System.out.print("Would you like to change Card " + (i+1) + ")? (y or n): ");
			/*
			Store choice into a char after trimming the string to just the first value
			*/
			char choice = cardInput.next().trim().charAt(0);
			/*
			If they want to change a card.  Then check which card it was again. To
			find the value to remove and add with.  Unfortunately my accessors are
			stored as string names and I can't convert my integer value of i into the
			proper string.
			*/
			if (Character.toLowerCase(choice) == 'y')
			{
				//if it was the first card
				if (i == 0)
				{
					//add the card back to the deck
					deck.addCard(hand.getFirst());
					//re-deal a new card to the player
					hand.setFirst(deck.dealCard());
				}
				//if it was the second card
				else if (i == 1)
				{
					deck.addCard(hand.getSecond());
					hand.setSecond(deck.dealCard());
				}
				//if it was the third card
				else if (i == 2)
				{
					deck.addCard(hand.getThird());
					hand.setThird(deck.dealCard());
				}
				//if it was the fourth card
				else if (i == 3)
				{
					deck.addCard(hand.getFourth());
					hand.setFourth(deck.dealCard());
				}
				//if it was the fifth card
				else
				{
					deck.addCard(hand.getFifth());
					hand.setFifth(deck.dealCard());
				}
			}
		} 
		//Print the final hand, the user only gets one chance to switch cards
		System.out.println("\nHere is your final hand.");
		hand.printHand();

	}

	/*
	Method for Calculating the value of the Hand and assigning the reward
	to earning said hand.  The parameters if the hand the player ended up with.
	There is a return type of int which is the value of the reward for the
	hand the user ended up with.
	*/
	public static int calculateHand(HandClass hand)
	{
		//reward value
		int reward = 0;
		/*
		The following conditional branch uses the comparision methods
		from the CompareCards class and prints the result after checking
		the returned boolean value from the compare cards class.  The
		order of these checks is important.  Obviously a pair could be
		confused with two pair if pair is checked first.  Check going
		downhill.
		*/
		//check if its a royal flush
		if (CompareCards.royalFlush(hand))
		{
			System.out.println("\nCongrats! You got a Royal Flush!");
			reward = 250;
		}
		//check if its a straight flush
		else if (CompareCards.straightFlush(hand))
		{
			System.out.println("\nCongrats! You got a Straight Flush!");
			reward = 50;
		}
		//check if its a four of a kind
		else if (CompareCards.fourOfAKind(hand))
		{
			System.out.println("\nAmazing! You got four of a kind!");
			reward = 25;
		}
		//check if its a full house
		else if (CompareCards.fullHouse(hand))
		{
			System.out.println("\nAmazing! You got a full house!");
			reward = 6;
		}
		//check if its a flush
		else if (CompareCards.flush(hand))
		{
			System.out.println("\nSweet! You got a flush!");
			reward = 5;
		}
		//check if its a straight
		else if (CompareCards.straight(hand))
		{
			System.out.println("\nSweet! You got a straight!");
			reward = 4;
		}
		//check if its a three of a kind
		else if (CompareCards.threeOfAKind(hand))
		{
			System.out.println("\nCool! You got three of a kind.");
			reward = 3;
		}
		//check if there are two pairs
		else if (CompareCards.twoPairs(hand))
		{
			System.out.println("\nCool! You got two pairs.");
			reward = 2;
		}
		//check if there is one pair
		else if (CompareCards.onePair(hand))
		{
			System.out.println("\nNice, you got a pair.");
			reward = 1;
		}
		//this means that its a bust and just high card
		else
		{
			System.out.println("\nBust! You got a high card.");
			reward = 0;
		}
		return reward;
	}

	public static void main(String[] args)
	{
		//create a new deck of cards
		DeckClass cardDeck = new DeckClass();
		//create a new object for storing the players hand of 5 cards
		HandClass playerHand = new HandClass();

		//prompt and welcome the user
		System.out.println("Welcome to the Poker Game!");
		//prompt the user and ask if they want to make a wager.
		//*Note tokens can be expensive!
		System.out.print("Would you like to make a wager? (y or n): ");

		//create an input object
		Scanner wagerInput = new Scanner(System.in);

		/*
		Store the value of their choice.  Collect a string, trim it
		to just the first character and store that in a char variable.
		*/
		char choice = wagerInput.next().trim().charAt(0);

		//initialize the wager amount
		int wager = 0;

		//if they want to wager tokens...
		if (Character.toLowerCase(choice) == 'y')
		{
			//prompt
			System.out.print("How many tokens would you like to wager?: ");
			//input validation loop
			while (true)
			{
				//take only integer values because tokens can't be partial
				if(wagerInput.hasNextInt())
				{
					//store the wager
					wager = wagerInput.nextInt();
					//break the loop
					break;
				}
				else
				{
					//there was an error, make sure they enter an integer
					System.out.println("Error: That is not an integer.  Please try again");
					//move to the next line of input
					wagerInput.nextLine();
				}
			}
		}
		//call play game function to run the driver of playing the game
		playGame(cardDeck,playerHand);
		//calculate the hand and store the result of the reward for the hand
		int reward = calculateHand(playerHand);

		//if they wagered....
		if (Character.toLowerCase(choice) == 'y')
		{
			//calculate their winnings
			reward = reward*wager;
			//let them know what they won!
			System.out.println("\nYour winnings are " + reward + " tokens");
		}



	
	}
}