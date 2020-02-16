package algorithms.common;

import java.util.HashMap;
import java.util.Map;

/**

Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

Example 1:

Input: [[1,1],[2,2],[3,3]]
Output: 3
Explanation:
^
|
|        o
|     o
|  o  
+------------->
0  1  2  3  4
Example 2:

Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
Output: 4
Explanation:
^
|
|  o
|     o        o
|        o
|  o        o
+------------------->
0  1  2  3  4  5  6
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 * 
 * @author mkumar
 *
 */

public class PointsLiesOnStraightLine {

	/** Definition for a point. */
	  static class Point {
	      int x;
	      int y;
	      Point() { x = 0; y = 0; }
	      Point(int a, int b) { x = a; y = b; }
	  }
	  
	  public int maxPoints(Point[] points) {
	        //declare hashmap at result variable
	        int result = 0;
	        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
	        
	        //iterate over length of points array of obj
	        for (int i = 0; i < points.length; i++) {
	            //reset map when considering for every point obj
	            map.clear();
	            
	            //reset overlap and max declaration to 0 when considering for every fresh point obj in i
	            int overlap = 0;
	            int max = 0;
	            
	            //iterate j from i+1 to points length
	            for (int j = i+1; j < points.length; j++) {
	                
	                //compute the slope numerator and denominator
	                int x = points[j].x - points[i].x;
	                int y = points[j].y - points[i].y;
	                
	                //if both x and y == 0 then both the points in consideration are same, so inc overlap
	                //and continue the loop since there is no slope for overlapping points
	                if (x == 0 && y == 0) {
	                    overlap++;
	                    continue;
	                }
	                
	                //compute the gcd of x and y; so that 2/4 is considered same as 1/2
	                int gcd = generateGCD(x, y);
	                
	                //if gcd != 0 then bring the x and y to its simplest form
	                if (gcd != 0) {
	                    x /= gcd;
	                    y /= gcd;
	                }
	                
	                //if the map contains x ie slope numerator
	                if(map.containsKey(x)) {
	                    
	                    //if thats the case check whether x is mapped to y ie slope denominator
	                    if(map.get(x).containsKey(y)) {
	                        //if thats the case then we have found one more point on the same line so get x get y and increment 
	                        //the value and store it back with an internal key of y mapped overall to x
	                        map.get(x).put(y, map.get(x).get(y) + 1);
	                    } else {
	                        //otherwise new point having a new slope with current point detected so map x with y,1
	                        map.get(x).put(y, 1);
	                    }
	                } else {
	                    //if x itself is not present, then create a new map m and map y,1 to m and x,m to map
	                    Map<Integer, Integer> m = new HashMap<>();
	                    m.put(y, 1);
	                    map.put(x, m);
	                }
	                //local max will be max of running value max, and the no of points with slope x/y given by map.get(x).get(y)
	              max = Math.max(max, map.get(x).get(y));  
	            }
	            //global result will be max of running result and sum of max + overlap (to consider points that overlap) + 1 to consider current point in consideration
	            result = Math.max(result, max + overlap + 1);
	        }
	        
	        return result; //T O(n^2) S O(1)
	    }
	    
	    //Recursive function to compute gcd, if remainder is 0 then return divisor else nr = divisor and dr = nr % dr
	    private int generateGCD(int a, int b) {
	        if (b == 0) return a;
	        
	        return generateGCD(b, a % b);
	    }
	    
	    public static void main(String[] args) {
	    	// Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
	    	// Output: 4
	    	
			Point[] points = new Point[6];
			points[0] = new Point(1, 1);
			points[1] = new Point(3, 2);
			points[2] = new Point(5, 3);
			points[3] = new Point(4, 1);
			points[4] = new Point(2, 3);
			points[5] = new Point(1, 4);
			
			PointsLiesOnStraightLine solution = new PointsLiesOnStraightLine();
			int maximumPoints = solution.maxPoints(points);
			System.out.println("Maximum points lies on one straight line is = " + maximumPoints);
		}
	 
}
