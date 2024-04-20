package _03_SetsAndMaps.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P08UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        TreeMap<String, LinkedHashMap<String, Integer>> users = new TreeMap<>();

        while (!input.equals("end")) {
            String[] inputData = input.split("\\s+");

            int ipIndex = inputData[0].indexOf("=");
            String ip = inputData[0].substring(ipIndex + 1);
            int userIndex = inputData[2].indexOf("=");
            String user = inputData[2].substring(userIndex + 1);

            if (!users.containsKey(user)) {
                users.put(user, new LinkedHashMap<>());
            }
            if (!users.get(user).containsKey(ip)) {
                users.get(user).put(ip, 0);
            }
            users.get(user).put(ip, users.get(user).get(ip) + 1);

            input = scanner.nextLine();
        }
        for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : users.entrySet()) {
            String user = entry.getKey();
            System.out.println(user + ": ");
            StringBuilder print = new StringBuilder();
            entry.getValue().entrySet().forEach(innerEntry -> {
                String ip = innerEntry.getKey();
                int count = innerEntry.getValue();
                print.append(String.format("%s => %d, ",ip,count));
            });
            String output = print.substring(0, print.length() - 2);
            System.out.println(output + ".");
        }
    }
}
//    LinkedHashMap<String, Integer> usr = entry.getValue();
//    StringBuilder print = new StringBuilder();
//            for (Map.Entry<String, Integer> ipAttacks : usr.entrySet()) {
//        print.append(String.format("%s => %d,%n",ipAttacks.getKey(),ipAttacks.getValue()));
//        }
//        String output = print.substring(0, print.length() -3);
//        System.out.println(output + ".");