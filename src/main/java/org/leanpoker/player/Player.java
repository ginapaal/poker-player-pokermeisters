package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.List;
import java.util.Map;

public class Player {

    static final String VERSION = "Default Java folding player";

    public static int betRequest(JsonElement request) {
        JsonObject jsonObject = request.getAsJsonObject();
<<<<<<< Updated upstream
        int currentBuyIn = jsonObject.get("current_buy_in").getAsInt();
        int minimumRaise = jsonObject.get("minimum_raise").getAsInt();
        return currentBuyIn + minimumRaise;
=======
        JsonElement inAction = jsonObject.get("in_action");
        String stringInAction = inAction.getAsString();
        JsonElement currBuyIn = jsonObject.get("current_buy_in");

        JsonObject players = jsonObject.get("players").getAsJsonObject();
        int intCurrBuyIn = currBuyIn.getAsInt();

        JsonObject ourPlayers = players.get("name").getAsJsonObject();
        JsonArray ourPlayerList = ourPlayers.getAsJsonArray();
        JsonElement ourPlayerString;

        for (JsonElement player: ourPlayerList
             ) {
            if (player.getAsString().equals("PokerMeisters")){
                   ourPlayerString = player;
            }
        }
        JsonElement ourPlayerBet = ourPlayers.get("bet");
        int intBet = ourPlayerBet.getAsInt();

        return intCurrBuyIn - intBet;
>>>>>>> Stashed changes
    }

    public static void showdown(JsonElement game) {
    }
}
