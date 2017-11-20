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
        JsonArray array = jsonObject.get("players").getAsJsonArray();
        List myCards = new ArrayList();
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
        System.out.println(myCards);
        System.out.println(bet);
        return 0;
    }

    public static void showdown(JsonElement game) {
    }
}
