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
        JsonObject jsonObject = request.getAsJsonObject();
        int currentBuyIn = jsonObject.get("current_buy_in").getAsInt();
        int minimumRaise = jsonObject.get("minimum_raise").getAsInt();
        JsonArray array = jsonObject.get("players").getAsJsonArray();
        List<String> myCards = new ArrayList();
        int bet = 0;
        int in_action = jsonObject.get("in_action").getAsInt();
        for (int i = 0; i < array.size(); i++) {
            JsonObject arrayData = array.get(i).getAsJsonObject();
            bet = arrayData.get("bet").getAsInt();
            System.out.println(bet);
            JsonArray holeCards = arrayData.get("hole_cards").getAsJsonArray();
            for (int j = 0; j < holeCards.size(); j++) {
                JsonObject card = holeCards.get(j).getAsJsonObject();
                if (in_action == i) {
                    String mycardRank = card.get("rank").getAsString();
                    String mycardSuit = card.get("suit").getAsString();
                    myCards.add(mycardRank);
                    myCards.add(mycardSuit);
                }
            }
        }
        try {
            Card card1 = new Card(myCards.get(0), myCards.get(1));
            Card card2 = new Card(myCards.get(0), myCards.get(1));


            if (card1.isSuitSame(card2)) {
                return currentBuyIn - bet + minimumRaise;
            } else if (card1.isRankSame(card2)) {
                return currentBuyIn - bet + minimumRaise;

            }
        } catch (Exception e) {
            return 0;
        }
        return 0;
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
        if (pair >= 2) {
            bet = pair * 200;
        }
        if (color == 5) {
            bet += 500;
        }
        return bet;
    }
}
