package ex.soundex;

public class SoundEx {

    private static final char[] MAP = {
    //A    B    D    D    E    F    G    H    I    J    K    L    M
     '0', '1', '2', '3', '0', '1', '2', '-', '0', '2', '2', '4', '5',
    //N    O    P    W    R    S    T    U    V    W    X    Y    Z
     '5', '0', '1', '2', '6', '2', '3', '0', '1', '-', '2', '0', '2'
    };

    public static String encode(String input) {

        input = input.toUpperCase();

        StringBuffer result = new StringBuffer();

        char current, previous = '?';

        for(int i=0; i < input.length() && result.length() < 4; i++) {

            current = input.charAt(i);
            char mapped = MAP[current-'A'];

            if(mapped == previous) continue;

            previous = mapped;

            if(i==0) {
                result.append(current);//.append('-');
                continue;
            }

            if(mapped != '0' && mapped != '-')
                result.append(mapped);
            else if(mapped == '-') previous = MAP[input.charAt(i-1)-'A'];
        }

        if(result.length() == 0) return null;

        for(int i=result.length(); i < 4; i++) result.append('0');

        return result.toString();
    }

    public static void main(String args[]) {

      

      System.out.println("Value is "+SoundEx.encode("Rubin"));
    }
}