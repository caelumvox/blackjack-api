package com.sysbldr.blackjackapi.domain.model;

public class Card implements Comparable{
    public enum Suit {
        CLUB(100),
        DIAMOND(200),
        SPADE(300),
        HEART(400);
        private int hashValue;
        Suit(int hashValue) {
            this.hashValue = hashValue;
        }
        public int getHashValue() {
            return hashValue;
        }
    }
    public enum Rank {
        TWO("2", 2, 2, 2),
        THREE("3", 3, 3, 3),
        FOUR("4", 4, 4, 4),
        FIVE("5", 5, 5, 5),
        SIX("6", 6, 6, 6),
        SEVEN("7", 7, 7, 7),
        EIGHT("8", 8, 8, 8),
        NINE("9", 9, 9, 9),
        TEN("T", 10, 10, 10),
        JACK("J", 10, 10, 11),
        QUEEN("Q", 10, 10, 12),
        KING("K", 10, 10, 13),
        ACE("A", 11, 1, 1);

        private String abbreviation;
        private int hardValue;
        private int softValue;
        private int hashValue;
        Rank(String abbreviation, int hardValue, int softValue, int hashValue) {
            this.abbreviation = abbreviation;
            this.hardValue = hardValue;
            this.softValue = softValue;
            this.hashValue = hashValue;
        }

        public int getHardValue() {
            return hardValue;
        }

        public int getHashValue() {
            return hashValue;
        }

        public String getAbbreviation() {
            return abbreviation;
        }

        public int getSoftValue() {
            return softValue;
        }
    }

    private Suit suit;
    private Rank rank;
    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return "Card [suit=" + suit.name() + ", rank=" + rank.name() + "]";
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Card) {
            Card card = (Card) object;
            return (this.suit == card.getSuit() && this.rank == card.getRank());
        }
        // Otherwise, this is an unknown object, return false.
        return false;
    }

    @Override
    public int hashCode() {
        return suit.getHashValue() + rank.getHashValue();
    }

    @Override
    public int compareTo(Object object) {
        if (object instanceof Card) {
            Card card = (Card) object;
            return this.hashCode() - card.hashCode();
        }
        return 0;
    }
}
