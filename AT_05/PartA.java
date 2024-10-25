/*
 * Jahja Ibrakovic
 * 10/24/24
 */

package AT_05;
import java.util.Random;

public class PartA {
    public static void main(String[] args) {
        Random ran = new Random();
        
        for(int num = 0; num<100; num = num + 1){
            int randomnum = ran.nextInt(100);//this should not include 0 I believe
            System.out.println(randomnum);
        }
    }
}
