/*
Utility Class for Comparing Cards to the types of 
hands possible in poker.
*/
public class CompareCards
{
	/*
	Royal Flush requires that all cards be 10, J, Q, K,A of the
	same suit
	*/
	public static boolean royalFlush(HandClass hand)
	{
		/*
		In order for al cards to be of those types they must
		sum exactly to 60, this is the constant
		*/
		final int SUMOFHANDS = 60;
		//return this boolean when the program check for if the
		//hand is a royal flush
		boolean result = false;

		//simplify the syntax for the values of the cards
		int value1 = hand.getFirst().getValue();
		int value2 = hand.getSecond().getValue();
		int value3 = hand.getThird().getValue();
		int value4 = hand.getFourth().getValue();
		int value5 = hand.getFifth().getValue();	

		//compute the sum of the cards
		int sum = value1 + value2 + value3 + value4 + value5;
		
		/*
		There is a separate method for computing a flush and straight.
		If this hand is a flush, a straight, and the sum is 60, then it
		has to be a Royal Flush.
		*/
		if (flush(hand) && straight(hand) && (sum == SUMOFHANDS))
		{
			//change boolean
			result = true;
		}
		//return result
		return result;
	}
	/*
	Straight Flush requires that all cards be in successive order
	and the same suit
	*/
	public static boolean straightFlush(HandClass hand)
	{

		boolean result = false;
		/*
		Separate methods check if its a flush and a straight.
		If it's both, then the hand is a straight flush.
		*/
		if (flush(hand) && straight(hand))
		{
			result = true;
		}

		//return boolean value of the result
		return result;

	}

	/*
	Four of a kind means that four of the cards in the five card hand
	all have the same numerical value.
	*/
	public static boolean fourOfAKind(HandClass hand)
	{
		boolean result = false;

		/*
		It is important to sort the hand to make it easier in terms
		of combinations of possible cards that make any of the pairs
		in this program.  Here is a call to sorting the hand.
		*/
		hand.sortHand();

		//store values in separate variables to make using them easier
		int value1 = hand.getFirst().getValue();
		int value2 = hand.getSecond().getValue();
		int value3 = hand.getThird().getValue();
		int value4 = hand.getFourth().getValue();
		int value5 = hand.getFifth().getValue();	

		//check if first four ordered cards are the same
		if ((value1 == value2) && (value2 == value3) && (value3 == value4))
		{
			result = true;
		}
		//check if final four ordered cards are the same
		else if ((value2==value3) && (value3==value4) && (value4==value5))
		{
			result = true;
		}
		else
		{
			result = false;
		}
		//return true or false evaulation of four of a kind
		return result;
	}

	/*
	In order for a hand to be a full house, there must be a 3 of a kind
	and a 2 of kind that comprise the full hand.
	*/
	public static boolean fullHouse(HandClass hand)
	{
		boolean result = false;
		//sort the hand to make comparision easy
		hand.sortHand();

		//store values in separate variables
		int value1 = hand.getFirst().getValue();
		int value2 = hand.getSecond().getValue();
		int value3 = hand.getThird().getValue();
		int value4 = hand.getFourth().getValue();
		int value5 = hand.getFifth().getValue();

		/*
		One possibility of an ordered full house is if the first 3 are the same
		and if the second two are the same.  Check this possibility.
		*/
		if (((value1 == value2) && (value2==value3)) 
			&& (value4 == value5))
		{
			result = true;
		}
		/*
		The other possibility of an ordered full house is if the last three
		are the same and if the first two are the same.  Check this possibility.
		*/
		else if (((value3 == value4) && (value4 == value5)) 
			&& (value1 == value2))
		{
			result = true;
		}
		//Otherwise its not a full house
		else
		{
			result = false;
		}

		return result;

	}

	/*
	In order for a hand to be a flush all five cards would need to be the
	same suit.
	*/
	public static boolean flush(HandClass hand)
	{
		boolean result = false;
		//store the suits in helper variables
		String suit1 = hand.getFirst().getSuit();
		String suit2 = hand.getSecond().getSuit();
		String suit3 = hand.getThird().getSuit();
		String suit4 = hand.getFourth().getSuit();
		String suit5 = hand.getFifth().getSuit();

		/*check that all the suits equal each other by copious
		use of the transitive property*/
		if (suit1.equals(suit2) && suit2.equals(suit3) 
			&& suit3.equals(suit4) && suit4.equals(suit5))
		{
			result = true;
		}

		return result;

	}

	/*
	In order for a hand to be a straight is if all five cards of an ordered
	pair are all exactly one greater than the one before it.
	*/
	public static boolean straight(HandClass hand)
	{
		boolean result = false;
		//make sure to sort the hand!
		hand.sortHand();

		//helper value variables
		int value1 = hand.getFirst().getValue();
		int value2 = hand.getSecond().getValue();
		int value3 = hand.getThird().getValue();
		int value4 = hand.getFourth().getValue();
		int value5 = hand.getFifth().getValue();

		/*
		Check if each successive value is 1 plus the previous value.
		If true, then return a true result for straight.
		*/
		if ((value2 == (value1 + 1)) && (value3 == (value2 + 1)) 
			&& (value4 == (value3 + 1)) && (value5 == (value4 + 1)))
		{
			result = true;
		}
		return result;
	}
	/*
	In order for a hand to be a three of a kind, exactly 3 cards must
	be the same.  Note, a 4 of a kind could be misconstrued as a 3 of a kind
	so make sure to call this function AFTER checking if its a four of a kind.
	Keep this in mind for the rest of the comparisions.
	*/
	public static boolean threeOfAKind(HandClass hand)
	{
		boolean result = false;
		//Make sure to sort to make the possibilites manageable
		hand.sortHand();

		//helper value variables
		int value1 = hand.getFirst().getValue();
		int value2 = hand.getSecond().getValue();
		int value3 = hand.getThird().getValue();
		int value4 = hand.getFourth().getValue();
		int value5 = hand.getFifth().getValue();

		//One possibility is if the first three cards are all equal
		if ((value1 == value2) && (value2==value3))
		{
			result = true;
		}
		//Another possibility is if the middle three cards are all equal
		else if ((value2 == value3) && (value3 == value4))
		{
			result = true;
		}
		//The final possiblity is if the last three cardss are all equal
		else if ((value3 == value4) && (value4 == value5))
		{
			result = true;
		}
		//Otherwise its not a 3 of a kind.
		else
		{
			result = false;
		}

		return result;
	}

	/*
	Note this could be misconstrued as a higher hand, so check the above ones first.
	In order to have two pairs, exactly two of the cards have to be the same two times
	in the hand.  So Q,Q,K,K,J would be considered "two" pair.
	*/
	public static boolean twoPairs(HandClass hand)
	{
		boolean result = false;

		//sort the hand to make the number of comparisions manageable
		hand.sortHand();

		//helper value variables
		int value1 = hand.getFirst().getValue();
		int value2 = hand.getSecond().getValue();
		int value3 = hand.getThird().getValue();
		int value4 = hand.getFourth().getValue();
		int value5 = hand.getFifth().getValue();

		//One possibility is if the first four cards have two pairs
		if ((value1 == value2) && (value3 == value4))
		{
			result = true;
		}
		//Another possibility is if the first two, and 3 and 5 are pairs.
		else if ((value1 == value2) && (value4==value5))
		{
			result = true;
		}
		//The other possiblity is if the last two and 2 and 3 are pairs.
		else if ((value2 == value3) && (value4==value5))
		{
			result = true;
		}
		//Otherwise there are not two pairs.
		else
		{
			result = false;
		}
		return result;

	}

	/*
	In order for there to be one pair there only needs to be two cards that matchup
	in a five card hard.
	*/
	public static boolean onePair(HandClass hand)
	{
		boolean result = false;

		//sort! sort! this makes a dramatic difference
		hand.sortHand();

		//helper value variables
		int value1 = hand.getFirst().getValue();
		int value2 = hand.getSecond().getValue();
		int value3 = hand.getThird().getValue();
		int value4 = hand.getFourth().getValue();
		int value5 = hand.getFifth().getValue();

		/*
		Since the hand is sorted the pairs will be in successive order 
		so just check one card and the one after until you find one
		that is matching the previous one.
		*/
		//check 1 and 2
		if (value1 == value2)
		{
			result = true;
		}
		//check 2 and 3
		else if (value2 == value3)
		{
			result = true;
		}
		//check 3 and 4
		else if (value3 == value4)
		{
			result = true;
		}
		//check 4 and 5
		else if (value4 == value5)
		{
			result = true;
		}
		//no pairs, this means you just have a high card hand, unfortunately
		else
		{
			result = false;
		}

		return result;
	
	}

}