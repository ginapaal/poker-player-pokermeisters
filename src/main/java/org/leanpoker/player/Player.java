package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Player {

    static final String VERSION = "Default Java folding player";

    public static int betRequest(JsonElement request) {
        try {
            JsonObject jsonObject = request.getAsJsonObject();
            int currentBuyIn = jsonObject.get("current_buy_in").getAsInt();
            int minimumRaise;

            minimumRaise = jsonObject.get("minimum_raise").getAsInt();

            System.out.println(minimumRaise);
            JsonArray array = jsonObject.get("players").getAsJsonArray();
            List<String> myCards = new ArrayList();
            List<String> communityCardsList = new ArrayList();
            JsonArray communityCards = jsonObject.get("community_cards").getAsJsonArray();

            for (int i = 0; i < communityCards.size(); i++) {
                communityCardsList.add(communityCards.get(i).getAsString());
            }

            int bet = 0;
            int in_action = jsonObject.get("in_action").getAsInt();
            for (int i = 0; i < array.size(); i++) {
                JsonObject arrayData = array.get(i).getAsJsonObject();
                System.out.println(bet);
                JsonArray holeCards = arrayData.get("hole_cards").getAsJsonArray();
                for (int j = 0; j < holeCards.size(); j++) {
                    JsonObject card = holeCards.get(j).getAsJsonObject();
                    if (in_action == i) {
                        bet = arrayData.get("bet").getAsInt();
                        String mycardRank = card.get("rank").getAsString();
                        String mycardSuit = card.get("suit").getAsString();
                        myCards.add(mycardRank);
                        myCards.add(mycardSuit);
                    }
                }
            }
            List<Card> cardOnTable = new ArrayList<>();
            for (int i = 0; i < communityCardsList.size(); i++) {
                cardOnTable.add(new Card(communityCardsList.get(i), communityCardsList.get(++i)));
            }
            List<Card> myCardList = new ArrayList<>();

            Card card1 = new Card(myCards.get(0), myCards.get(1));
            Card card2 = new Card(myCards.get(0), myCards.get(1));
            myCardList.add(card1);
            myCardList.add(card2);
            int newBet = logic(myCardList, cardOnTable);
            if (card1.isSuitSame(card2)) {
                return currentBuyIn - bet + minimumRaise + newBet;
            } else if (card1.isRankSame(card2)) {
                return currentBuyIn - bet + minimumRaise + newBet;
            } else {
                return 0;
            }
        } catch (Exception e) {
            return 0;
        }
    }

    public static void showdown(JsonElement game) {
    }

    public static int logic(List<Card> myCards, List<Card> cards) {
        int pair = 0;
        int color = 0;
        int bet = 0;
        for (Card card : cards) {
            for (Card myCard : myCards) {
                if (card.isRankSame(myCard)) {
                    pair++;
                }
                if (card.isSuitSame(myCard)) {
                    color++;
                }
            }
        }
        if (pair >= 3) {
            bet = pair * 25;
        }
        if (color == 5) {
            bet += 50;
        }
        return bet;
    }
}
