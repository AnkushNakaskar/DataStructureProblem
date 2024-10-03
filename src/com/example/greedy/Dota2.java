package com.example.greedy;

/**
 * @author ankush.nakaskar
 */
public class Dota2 {

    public static void main(String[] args) {
        System.out.println(predictPartyVictory("DDRRR"));
        System.out.println(predictPartyVictory("DDDD"));
        System.out.println(predictPartyVictory("DR"));
        System.out.println(predictPartyVictory("DRR"));
    }
    public static String predictPartyVictory(String input) {
        StringBuilder sb =new StringBuilder(input);
        while(sb.length()>1){
            char ch = sb.charAt(0);
            int i=1;
            while(i<sb.length() && sb.charAt(i)==ch){
                i++;
            }
            if(!sb.isEmpty() && sb.length()==i){
                return sb.charAt(sb.length()-1)=='D' ? "Dire" : "Radiant";
            }else if(!sb.isEmpty()){
                sb.deleteCharAt(i);
                sb.deleteCharAt(0);
                sb.append(ch);
            }
        }
        if(!sb.isEmpty()){
            return sb.charAt(sb.length()-1)=='D' ? "Dire" : "Radiant";
        }
        return "";
    }
}
