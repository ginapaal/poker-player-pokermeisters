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
//        int currentBuyIn = jsonObject.get("current_buy_in").getAsInt();
        JsonArray array = jsonObject.get("players").getAsJsonArray();
        System.out.println(array);
        for (int i = 0; i < array.size(); i++) {
            JsonObject arrayData = array.get(i).getAsJsonObject();
            int bet = arrayData.get("bet").getAsInt();
            System.out.println(bet);
        }
        int in_action = jsonObject.get("in_action").getAsInt();
        System.out.println(in_action);
        return 0;

    }

    public static void showdown(JsonElement game) {
    }

    public static int logic(List<Card> myCards,List<Card> cards){
        int pair = 0;
        int color = 0;
        int bet = 0;
        for (Card card: cards){
            for (Card myCard: myCards){
                if (card.isRankSame(myCard)){
                    pair++;
                }
                if (card.isSuitSame(myCard)){
                    color++;
                }
            }
        }

        if (pair >=2){
            bet = pair * 200;
        }
        if (color ==5){
            bet += 500;
        }
        return bet;
    }
}
