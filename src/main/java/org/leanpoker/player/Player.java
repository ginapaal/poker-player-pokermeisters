package org.leanpoker.player;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Map;

public class Player {

    static final String VERSION = "Default Java folding player";

    public static int betRequest(JsonElement request) {
        JsonObject jsonObject = request.getAsJsonObject();
        int currentBuyIn = jsonObject.get("current_buy_in").getAsInt();
        int minimumRaise = jsonObject.get("minimum_raise").getAsInt();
        return currentBuyIn + minimumRaise;
    }

    public static void showdown(JsonElement game) {
    }
}
