package org.leanpoker.player;

public class Card {
    private String suit;
    private String rank;

    public Card(String rank, String suit) {
        this.suit = suit;
        if (rank.equals("J")) {
            this.rank = "11";
        } else if (rank.equals("Q")) {
            this.rank = "12";
        } else if (rank.equals("K")) {
            this.rank = "13";
        } else if (rank.equals("A")) {
            this.rank = "14";
        } else {
            this.rank = rank;
        }
    }

    public boolean isRankSame(Card card) {
        if (this.rank.equals(card.rank)) {
            return true;
        }
        return false;
    }
    public boolean isSuitSame(Card card){
        if (this.suit.equals(card.suit)) {
            return true;
        }
        return false;
    }



}
