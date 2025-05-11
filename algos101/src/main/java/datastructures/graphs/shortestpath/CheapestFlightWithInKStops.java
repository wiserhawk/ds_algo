package datastructures.graphs.shortestpath;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://takeuforward.org/data-structure/g-38-cheapest-flights-within-k-stops/

/**
 * There are n cities and m edges connected by some number of flights. 
 * You are given an array of flights where flights[i] = [ fromi, toi, pricei] indicates that 
 * there is a flight from city fromi to city toi with cost price. 
 * You have also given three integers src, dst, and k, and 
 * return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.
 */
public class CheapestFlightWithInKStops {

    public static class Flight {
        int destination, price;

        public Flight(int destination, int price) {
            this.destination = destination;
            this.price = price;
        }
    }

    public static class Stop {
        int stop, stopCount, totalPrice;

        public Stop(int stop) {
            this.stop = stop;
            stopCount = 0;
            totalPrice =0;
        }
        
    }


    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Flight>> graph = createGraph(n, flights);

        Queue<Stop> queue = new LinkedList<>();
        queue.add(new Stop(src));

        int minPrice = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Stop currStop = queue.poll();

            if (currStop.stop != dst && currStop.stopCount <= k) {
                for (Flight f : graph.get(currStop.stop)) {
                    Stop nextStop = new Stop(f.destination);
                    nextStop.stopCount = currStop.stopCount + 1;
                    nextStop.totalPrice = currStop.totalPrice + f.price;
                    queue.add(nextStop);
                }
            } else if (currStop.stop == dst) {
                minPrice = Math.min(minPrice, currStop.totalPrice);
            }
        }
        
        return (minPrice != Integer.MAX_VALUE) ? minPrice : -1;

    }

    private List<List<Flight>> createGraph(int n, int[][] flights) {
        List<List<Flight>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            graph.get(flight[0]).add(new Flight(flight[1], flight[2]));
        }

        return graph;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] flights = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int src = 0, dst = 3, k = 1;
        System.out.println("Cheapest Price = " + new CheapestFlightWithInKStops().findCheapestPrice(n, flights, src, dst, k));
    }

}
