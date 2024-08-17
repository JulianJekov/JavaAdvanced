package _03_SetsAndMaps.Exercise;

import java.util.*;

public class P10LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String,Integer> nameAndDuration = new TreeMap<>();
        Map<String, TreeSet<String>> ipAndName = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String ip = data[0];
            String name = data[1];
            int count = Integer.parseInt(data[2]);

            if(!nameAndDuration.containsKey(name)){
                nameAndDuration.put(name,0);
            }
            nameAndDuration.put(name,nameAndDuration.get(name) + count);

            if(!ipAndName.containsKey(name)){
                ipAndName.put(name,new TreeSet<>());
            }
            ipAndName.get(name).add(ip);

        }
        nameAndDuration.forEach((key, value) -> {
            System.out.printf("%s: %d ",key,value);
            StringBuilder sb = new StringBuilder();
            ipAndName.get(key).forEach(ip-> sb.append(String.format("%s, ",ip)));
            String output = "[" + sb.substring(0,sb.length() - 2) + "]";
            System.out.println(output);

        });
    }
}
