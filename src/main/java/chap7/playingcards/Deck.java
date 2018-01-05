package chap7.playingcards;

import java.util.ArrayList;
import java.util.List;

public class Deck {

    static int NUM_CARDS = 13;

    List<Card> cards = new ArrayList<Card>();

    public Deck(){

        Card c1 = new Card(Suite.Club, CardNumber.ACE);
        Card c2 = new Card(Suite.Club, CardNumber.TWO);
        Card c3 = new Card(Suite.Club, CardNumber.THREE);
        Card c4 = new Card(Suite.Club, CardNumber.FOUR);
        Card c5 = new Card(Suite.Club, CardNumber.FIVE);
        Card c6 = new Card(Suite.Club, CardNumber.SIX);
        Card c7 = new Card(Suite.Club, CardNumber.SEVEN);
        Card c8 = new Card(Suite.Club, CardNumber.EIGHT);
        Card c9 = new Card(Suite.Club, CardNumber.NINE);
        Card c10 = new Card(Suite.Club, CardNumber.TEN);
        Card c11 = new Card(Suite.Club, CardNumber.JACK);
        Card c12 = new Card(Suite.Club, CardNumber.QUEEN);
        Card c13 = new Card(Suite.Club, CardNumber.KING);

        cards.add(c1);
        cards.add(c2);
        cards.add(c3);
        cards.add(c4);
        cards.add(c5);
        cards.add(c6);
        cards.add(c7);
        cards.add(c8);
        cards.add(c9);
        cards.add(c10);
        cards.add(c11);
        cards.add(c12);
        cards.add(c13);

    }

    public Card getCard(Suite s, CardNumber n){

        return null;
    }
    enum Suite {Club, Diamond, Heart, Spade};
    enum CardNumber {
        ACE (1),
        TWO (2),
        THREE (3),
        FOUR (4),
        FIVE (5),
        SIX (6),
        SEVEN (7),
        EIGHT (8),
        NINE (9),
        TEN (10),
        JACK (11),
        QUEEN (12),
        KING (13)
        ;
        int pointValue;
        CardNumber(int value){
            this.pointValue = value;
        }
    }
}
