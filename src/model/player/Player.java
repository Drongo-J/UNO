package model.player;

import model.cards.Card;
import model.enums.Color;
import model.user.User;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private User user;
    private List<Card> hand;

    public Player(User user, ArrayList<Card> hand) {
        this.user = user;
        this.hand = hand;
    }

    public User getUser() {
        return user;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public void removeCard(Card card) {
        hand.remove(card);
    }
    
    public int getCardCount() {
    	return hand.size();
    }

    public Card getPlayableCard(Card topCard, Color colorToPlay) {
        for (Card card : hand) {
            if (card.isPlayableOn(topCard) && card.getColor() == colorToPlay) {
                return card;
            }
        }
        return null;
    }

    public boolean hasWon() {
        return hand.size() == 0;
    }
}
