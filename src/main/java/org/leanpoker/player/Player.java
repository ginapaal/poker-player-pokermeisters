package org.leanpoker.player;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Map;

public class Player {

    static final String VERSION = "Default Java folding player";

    public static int betRequest(JsonElement request) {
        JsonObject jsonObject = request.getAsJsonObject();
        JsonElement inAction = jsonObject.get("in_action");
        String stringInAction = inAction.getAsString();
        JsonElement currBuyIn = jsonObject.get("current_buy_in");

        JsonObject players = jsonObject.get("players").getAsJsonObject();
        JsonElement ourPlayerNum = players.get(stringInAction);
        int intCurrBuyIn = currBuyIn.getAsInt();
        JsonObject ourPlayer = ourPlayerNum.getAsJsonObject();
        JsonElement ourPlayerBet = ourPlayer.get("bet");
        int intBet = ourPlayerBet.getAsInt();

        return intCurrBuyIn - intBet;
    }

    public static void showdown(JsonElement game) {
    }
}
