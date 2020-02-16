package algorithms.common;

import java.awt.Point;
import java.math.RoundingMode;
import java.nio.channels.OverlappingFileLockException;
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

public class CountMaxPointsLiesOnLine {
	
	static class Point {
		int x, y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == null)
				return false;
			Point p = (Point) obj;
			if (x == p.x && y == p.y) 
				return true;
			return false;
			
		}

	}
	
	public int maxPoints(Point[] points) {
		if (points == null) 
			return 0;
		
		if (points.length < 2) 
			return points.length;
		
		int maxPoints = 0;
		int currentMax , overlayPoints, verticalPoints;
		Map<Point, Integer> slopeMap = new HashMap<Point, Integer>();
		
		for (int i = 0; i < points.length; i++) {
			
			currentMax = overlayPoints = verticalPoints = 0;
			
			for (int j = i+1; j < points.length; j++) {
				
				if (points[i].equals(points[j]))
					overlayPoints++;
				
				else if (points[i].x == points[j].x) 
					verticalPoints++;
				
				else {
					
					int xDiff = points[j].x - points[i].x;
					int yDiff = points[j].y - points[i].y;
					
					//compute the gcd of xDiff and yDiff; so that 2/4 is considered same as 1/2. correct ration.
					int gcd = generateGCD(xDiff, yDiff);
					
					//if gcd != 0 then bring the xDiff and yDiff to its simplest form
	                if (gcd != 0) {
	                	xDiff /= gcd;
	                	yDiff /= gcd;
	                }
					
	                Point p = new Point(xDiff, yDiff);
	                if (slopeMap.get(p) == null)
	                	slopeMap.put(p, 1);
	                else 
	                	slopeMap.put(p, slopeMap.get(p) + 1);
					
	                currentMax = Math.max(currentMax, slopeMap.get(p));
				}
				currentMax = Math.max(currentMax, verticalPoints);
			}
			
			// updating global maximum by current point's maximum 
	        maxPoints = Math.max(maxPoints, currentMax + overlayPoints + 1);
	        
	        slopeMap.clear();
			
		}
		
		return maxPoints;
        
    }
	
	//Greatest Common Divisor. Recursive function to compute gcd, 
	// if remainder is 0 then return divisor else nr = divisor and dr = nr % dr
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
		
		CountMaxPointsLiesOnLine slope = new CountMaxPointsLiesOnLine();
		int maximumPoints = slope.maxPoints(points);
		System.out.println("Maximum points lies on one straight line is = " + maximumPoints);
	}

}
