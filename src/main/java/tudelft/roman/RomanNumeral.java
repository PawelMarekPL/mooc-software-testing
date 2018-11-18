package tudelft.roman;

import java.util.HashMap;
import java.util.Map;

public class RomanNumeral {

    private static Map<Character, Integer> map;

    static {
        map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public int _convert(String s) {

        int convertedNumber = 0;
        for(int i = 0; i < s.length(); i++) {
            int currentNumber = map.get(s.charAt(i));
            int next = i+1 < s.length() ? map.get(s.charAt(i+1)) : 0;

            if(currentNumber >= next)
                convertedNumber += currentNumber;
            else
                convertedNumber -= currentNumber;
        }

        return convertedNumber;

    }

    public int convert(String s) {
        return convertM(s.toUpperCase().trim(), 0);
    }

    int convertM(String s, int value) {
        if(s.startsWith("MMM"))
            return convertD(s.substring(3), value+3000);
        if(s.startsWith("MM"))
            return convertD(s.substring(2), value+2000);
        if(s.startsWith("M"))
            return convertD(s.substring(1), value+1000);
        return convertD(s, value);
    }

    int convertD(String s, int value) {
        if(s.startsWith("CM"))
            return convertD(s.substring(2), value+900);
        if(s.startsWith("CD"))
            return convertC(s.substring(2), value+400);
        if(s.startsWith("D"))
            return convertC(s.substring(1), value+500);
        return convertC(s, value);
    }

    int convertC(String s, int value) {
        if(s.startsWith("CCC"))
            return convertL(s.substring(3), value+300);
        if(s.startsWith("CC"))
            return convertL(s.substring(2), value+200);
        if(s.startsWith("C"))
            return convertL(s.substring(1), value+100);
        return convertL(s, value);
    }

    int convertL(String s, int value) {
        if(s.startsWith("XC"))
            return convertL(s.substring(2), value+90);
        if(s.startsWith("XL"))
            return convertX(s.substring(2), value+40);
        if(s.startsWith("L"))
            return convertX(s.substring(1), value+50);
        return convertX(s, value);
    }

    int convertX(String s, int value) {
        if(s.startsWith("XXX"))
            return convertV(s.substring(3), value+30);
        if(s.startsWith("XX"))
            return convertV(s.substring(2), value+20);
        if(s.startsWith("X"))
            return convertV(s.substring(1), value+10);
        return convertV(s, value);
    }

    int convertV(String s, int value) {
        if(s.startsWith("IX"))
            return convertV(s.substring(2), value+9);
        if(s.startsWith("IV"))
            return convertI(s.substring(2), value+4);
        if(s.startsWith("V"))
            return convertI(s.substring(1), value+5);
        return convertI(s, value);
    }

    int convertI(String s, int value) {
        if(s.startsWith("III"))
            return convert0(s.substring(3), value+3);
        if(s.startsWith("II"))
            return convert0(s.substring(2), value+2);
        if(s.startsWith("I"))
            return convert0(s.substring(1), value+1);
        return convert0(s, value);
    }

    int convert0(String s, int value){
        if (s.isEmpty()) return value;
        System.out.format("ERROR: Left=%s, value=%d\r\n", s, value);
        return -1;
    }
}
