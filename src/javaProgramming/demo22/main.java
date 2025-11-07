package javaProgramming.demo22;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入字符串: ");
        String d = sc.nextLine();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < d.length(); i++){
            char c = d.charAt(i);
            if(map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        System.out.println("\n=== 字符统计结果 ===");
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            char character = entry.getKey();
            int count = entry.getValue();
            String charDisplay;
            switch(character) {
                case ' ': charDisplay = "[空格]"; break;
                case '\t': charDisplay = "[制表符]"; break;
                case '\n': charDisplay = "[换行符]"; break;
                case '\r': charDisplay = "[回车符]"; break;
                default: charDisplay = String.valueOf(character);
            }
            System.out.println("字符 '" + charDisplay + "' 的个数为 " + count);
        }
        sc.close();
    }
}