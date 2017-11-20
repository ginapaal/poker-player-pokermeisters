package org.leanpoker.player;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Map;

public class Player {

    static final String VERSION = "Default Java folding player";

    public static int betRequest(JsonElement request) {
        JsonObject jsonObject = request.getAsJsonObject();
        JsonElement currBuyIn = jsonObject.get("current_buy_in");
        JsonObject players = jsonObject.get("players").getAsJsonObject();
        JsonElement bet = players.get("bet");
        int intCurrBuyIn = currBuyIn.getAsInt();
        int intBet = bet.getAsInt();

        return intCurrBuyIn+15;
    }

    public static void showdown(JsonElement game) {
    }
}
