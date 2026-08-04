import java.io.*;
import java.util.*;

class Main{
    private static BufferedInputStream bis = new BufferedInputStream(System.in);
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int handSize = 5;
    private static int dauSize = 6;

    public static char readChar()throws IOException{
        int n;
        while((n = bis.read()) <= ' ' && n != -1);
        if(n == -1) return '.'; //sentinel char
        return (char) n;  
    }

    public static void readHand(char[] hand)throws IOException{
        for(int i = 0; i < handSize; ++i) if((hand[i] = readChar()) == '.') return;
    }

    public static int score(int n){
        return switch(n){
            case 2 -> 1; // doble = 1, doble parella = 2;
            case 3 -> 3; // trio = 3, full = trio + parella = 4
            case 4 -> 5; // poquer = 5 
            case 5 -> 6; // repoquer = 6;
            default -> 0;
        };
    }

    public static int translate(char c){
        return switch(c){
                case 'A' -> 0;
                case 'R' -> 1;
                case 'Q' -> 2;
                case 'C' -> 3;
                case 'D' -> 4;
                case 'N' -> 5;
                default -> -1;
        };
    }

    public static int resultat(char[] hand, int[] cares){
        int totalScore = 0;
        char comb1Char = '.', comb2Char = '.';
        for(int i = 0; i < handSize; ++i) ++cares[translate(hand[i])];
        for(int i = 0; i < dauSize; ++i){
            if(cares[i] > 1) totalScore += score(cares[i]);
        }
        return totalScore;
    }

    public static void main(String[] args)throws IOException{
        char[] handAnna = new char[handSize], handBernat = new char[handSize];
        readHand(handAnna);
        int[] caresAnna = new int[dauSize], caresBernat = new int[dauSize];
        int Anna = 0, Bernat = 0;
        while(handAnna[0] != '.'){
            readHand(handBernat);
            if(handBernat[0] == '.') break;
            boolean guanyaAnna = true;
            Arrays.fill(caresAnna, 0);
            Arrays.fill(caresBernat, 0);
            int resAnna = resultat(handAnna, caresAnna);
            int resBernat = resultat(handBernat, caresBernat);
            if(resAnna < resBernat) guanyaAnna = false;
            else if(resAnna == resBernat){
                boolean found = false;
                for(int freq = handSize; freq > 0 && !found; --freq){
                    for(int val = 0; val < dauSize; ++val){
                        if(caresAnna[val] == freq && caresBernat[val] != freq){
                            found = true;
                            break;
                        }
                        if(caresAnna[val] != freq && caresBernat[val] == freq){
                            found = true;
                            guanyaAnna = false;
                            break;
                        }
                    }
                }
            }
            if(guanyaAnna){
                bw.write("Anna\n");
                ++Anna;
            }
            else{
                bw.write("Bernat\n");
                ++Bernat;
            }
            readHand(handAnna);
        }
        bw.write("Guanyades per l'Anna: ");
        bw.write(String.valueOf(Anna));
        bw.write('\n');
        bw.write("Guanyades per en Bernat: ");
        bw.write(String.valueOf(Bernat));
        bw.write('\n');
        bw.close(); 
    }
}

