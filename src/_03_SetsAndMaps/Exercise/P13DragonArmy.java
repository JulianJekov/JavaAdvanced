package _03_SetsAndMaps.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P13DragonArmy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Map<String,int[]>> dragons = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            int[] stats = new int[3];
            String type = input[0];
            String name = input[1];
            stats[0] = input[2].equals("null") ? 45 : Integer.parseInt(input[2]);
            stats[1] = input[3].equals("null") ? 250 : Integer.parseInt(input[3]);
            stats[2] = input[4].equals("null") ? 10 : Integer.parseInt(input[4]);

            if(!dragons.containsKey(type)){
                dragons.put(type,new TreeMap<>());
            }
            dragons.get(type).putIfAbsent(name,stats);
            dragons.get(type).put(name,stats);

        }

        dragons.forEach((key,value)->{
            double[] avg = new double[3];
            StringBuilder sb = new StringBuilder();
            value.forEach((k,v)-> {
                avg[0]+=v[0];
                avg[1]+=v[1];
                avg[2]+=v[2];
                sb.append(String.format("-%s -> damage: %d, health: %d, armor: %d%n",
                        k,
                        v[0],
                        v[1],
                        v[2]
                ));
                    });
            avg[0] /= value.size();
            avg[1] /= value.size();
            avg[2] /= value.size();
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n",key,avg[0],avg[1],avg[2]);
            System.out.print(sb);
        });
    }
}
