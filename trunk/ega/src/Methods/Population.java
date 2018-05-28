/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Methods;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Nicolas
 */
public class Population {
    private final static Integer _fixed = 0;
    private final static Integer _increase = 1;
    private final static Integer _decrease = 2;
    private final static Map<Integer, String> IncreasingStyles = new HashMap<Integer, String>();
    
    private static void createIncreasingStyleMap(){
        if (Population.IncreasingStyles.isEmpty()){
            Population.IncreasingStyles.put(Population._fixed, "fixed");
            Population.IncreasingStyles.put(Population._increase, "up");
            Population.IncreasingStyles.put(Population._decrease, "down");
        }
    }
    
    public static String getTypeNameFromID(int IncreasingStyleID){
        Population.createIncreasingStyleMap();
        
        return Population.IncreasingStyles.get(IncreasingStyleID);
    }
    
}
