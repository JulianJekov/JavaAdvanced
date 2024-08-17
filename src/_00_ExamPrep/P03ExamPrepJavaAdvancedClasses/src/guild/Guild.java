package _00_ExamPrep.P03ExamPrepJavaAdvancedClasses.src.guild;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Guild {
    private List<Player> roster;
    private String name;
    private int capacity;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if (roster.size() < capacity) {
            roster.add(player);
        }
    }

    public boolean removePlayer(String name) {
        for (Player player : roster) {
            if (player.getName().equals(name)) {
                roster.remove(player);
                return true;
            }
        }
        return false;
    }

    public void promotePlayer(String name) {
        for (Player player : roster) {
            if (player.getName().equals(name) && player.getRank().equals("Trial")) {
                player.setRank("Member");
                return;
            }
        }
    }

    public void demotePlayer(String name) {
        for (Player player : roster) {
            if (player.getName().equals(name) && player.getRank().equals("Member")) {
                player.setRank("Trial");
                return;
            }
        }
    }

    public Player[] kickPlayersByClass(String clazz) {
        List<Player> listResult = roster.stream().filter(e -> e.getClazz().equals(clazz)).collect(Collectors.toList());
        roster.removeAll(listResult);
        return listResult.toArray(Player[]::new);
    }

    public int count() {
        return roster.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder("Players in the guild: " + name + ":");
        for (Player player : roster) {
            sb.append(System.lineSeparator()).append(player);
        }

        return sb.toString().trim();
    }
}
