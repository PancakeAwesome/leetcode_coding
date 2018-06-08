/**
 * 
 */
package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author edward.guan
 *
We start with trimming.
* If we see [0-9] we reset the number flags.
* We can only see . if we didn't see e or ..
* We can only see e if we didn't see e but we did see a number. We reset numberAfterE flag.
* We can only see + and - in the beginning and after an e
* any other character break the validation.
At the and it is only valid if there was at least 1 number and if we did see an e then a number after it as well.
 */

class Solution65 {
    public boolean isNumber(String s) {
//         remove white spaces
        s = s.trim();
        
        boolean numSeen = false;
        boolean eSeen = false;
        boolean pointSeen = false;
        boolean numAfterE = true; // number must after E
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if(c >= '0' && c <= '9') {
                numSeen = true;
                numAfterE = true;
            }else if(c == 'e') {
                if(eSeen || !numSeen) {
                    return false;
                }
                eSeen = true;
                numAfterE = false;
            }else if(c == '.') {
                if(eSeen || pointSeen) {
                    return false;
                }
                pointSeen = true;
            }else if(c == '+' || c == '-'){
                if(i != 0 && s.charAt(i - 1) != 'e') {
                    return false;
                }
            }else {
                return false;
            }
        }
        
        return numSeen && numAfterE;
    }
}

public class oj65_Valid_Number {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "1e-3";
		System.out.println(new Solution65().isNumber(s));
	}

}
