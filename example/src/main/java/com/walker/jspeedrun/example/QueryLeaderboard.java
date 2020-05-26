package com.walker.jspeedrun.example;

import com.walker.jspeedrun.api.JSpeedrun;
import com.walker.jspeedrun.api.leaderboards.JSpeedrunLeaderboard;

public class QueryLeaderboard {
    public static void main(String[] args) {
        JSpeedrun jSpeedrun = new JSpeedrun();

        jSpeedrun.getCategoryLeaderboard("om1mw4d2", "jzd33ndn")
                .thenAccept(response -> {
                    JSpeedrunLeaderboard leaderboard = response.getData().get(0);

                    System.out.println("leaderboard=");
                    System.out.println("\tgame=" + leaderboard.game);
                    System.out.println("\tcategory=" + leaderboard.category);
                    System.out.println("\tplaces=");
                    for(JSpeedrunLeaderboard.LeaderboardPlace place : leaderboard.runs) {
                        System.out.println("\t\tplace=" + place.place);
                        System.out.println("\t\trun=");
                        System.out.println("\t\t\tfirstplayer=" + place.run.players.get(0).id);
                        System.out.println("\t\t\ttime=" + place.run.times.primaryTime);
                        System.out.println("\t\t\tcomment=" + place.run.comment);
                    }
                }).exceptionally(t -> {
            t.printStackTrace();
            return null;
        }).join();
    }
}
