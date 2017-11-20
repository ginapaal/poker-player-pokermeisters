package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import java.util.HashMap;
import java.util.List;


public class Player {

    static final String VERSION = "Default Java folding player";

    public static int betRequest(JsonElement request) {
        JsonObject jsonObject = request.getAsJsonObject();
        int currentBuyIn = jsonObject.get("current_buy_in").getAsInt();
        JsonArray array = jsonObject.get("players").getAsJsonArray();
        System.out.println(array);
        int bet = 0;
        for (int i = 0; i < array.size(); i++) {
            JsonObject arrayData = array.get(i).getAsJsonObject();
            bet = arrayData.get("bet").getAsInt();
            System.out.println(bet);
            JsonArray holeCards = arrayData.get("hole_cards").getAsJsonArray();
            for (int j = 0; j < holeCards.size(); j++) {
                JsonObject card = holeCards.get(j).getAsJsonObject();
                String cardRank = card.get("rank").getAsString();
                String cardSuit = card.get("suit").getAsString();
            }
        }
        int in_action = jsonObject.get("in_action").getAsInt();
        System.out.println(bet);
        return 0;
    }

    public static void showdown(JsonElement game) {
    }
}
