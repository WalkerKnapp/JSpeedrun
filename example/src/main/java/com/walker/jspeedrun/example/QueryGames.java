package com.walker.jspeedrun.example;

import com.walker.jspeedrun.api.JSpeedrun;
import com.walker.jspeedrun.api.games.JSpeedrunGame;

public class QueryGames {
    public static void main(String[] args) {
        JSpeedrun jSpeedrun = new JSpeedrun();

        jSpeedrun.getGames()
                .thenAccept(response -> {
                    System.out.println("Got Response: ");
                    System.out.println("\tstatus=" + response.status);
                    System.out.println("\tmessage=" + response.message);
                    System.out.println("\tdata=");

                    for(JSpeedrunGame game : response.getData()) {
                        System.out.println("\t\tgame=");
                        System.out.println("\t\t\tname=" + game.names.get("international"));
                    }
                }).exceptionally(t -> {
                    t.printStackTrace();
                    return null;
                }).join();
    }
}
