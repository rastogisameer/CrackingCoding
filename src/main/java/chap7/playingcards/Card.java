package chap7.playingcards;

public class Card {

    Deck.Suite suite;
    Deck.CardNumber number;

    public Card(Deck.Suite suite, Deck.CardNumber number) {
        this.suite = suite;
        this.number = number;
    }

    public Deck.Suite getSuite() {
        return suite;
    }
    public Deck.CardNumber getNumber() {
        return number;
    }

}
