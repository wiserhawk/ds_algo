package datastructures.graphs.topologicalsorting;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/** 
 * Problem Statement: (Course Schedule): There are a total of n tasks you have to pick, labeled from 0 to n-1. 
 * Some tasks may have prerequisites tasks, for example, to pick task 0 you have to first finish tasks 1, which is expressed as a pair: [0, 1]

 * Given the total number of n tasks and a list of prerequisite pairs of size m.
 * 
 * - Return true if you can finish all courses. Otherwise, return false.
 * - Return the sequence of courses that you should take to finish all courses.

*/

// https://takeuforward.org/data-structure/course-schedule-i-and-ii-pre-requisite-tasks-topological-sort-g-24/

// Hint: Using Kahn's Algorithm

public class CourseSchedule {

    public boolean canCoursesFinish(int numCourses, int[][] prerequisites) {
        return coursesSequence(numCourses, prerequisites).size() == numCourses;
    }

    public List<Integer> coursesSequence(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacents = createPrerequisitesAdjacentGrapth(numCourses, prerequisites);
        int[] indegree = getIndegree(numCourses, adjacents);

        Queue<Integer> queue = new LinkedList<>();
        // fill all courses with zero degree.
        for (int i=0; i<numCourses; i++) {
            if (indegree[i] ==0)
                queue.add(i);
        }

        List<Integer> coursesSequence = new ArrayList<>();

        while (!queue.isEmpty()) {
            int course = queue.poll();
            coursesSequence.add(course);
            for (int prerequisite : adjacents.get(course)) {
                indegree[prerequisite]--;
                if (indegree[prerequisite] == 0) {
                    queue.add(prerequisite);
                }
            }
        }

        return coursesSequence; 
    }

    private List<List<Integer>> createPrerequisitesAdjacentGrapth(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacents = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacents.add(i, new ArrayList<>());
        }

        for (int[] pair : prerequisites) {
            adjacents.get(pair[0]).add(pair[1]);
        }
        return adjacents;
    }

    private int[] getIndegree(int numCourses, List<List<Integer>> prerequisites) {
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int course : prerequisites.get(i)) {
                indegree[course]++;
            }
        }
        return indegree;
    }

    public static void main(String[] args) {
        int numCourses = 4;
        
        int[][] prerequisites = new int[][] {
            {1, 0},
            {2, 0},
            {3, 1},
            {3, 2}
        };

        System.out.println("Course Schedule = " + new CourseSchedule().canCoursesFinish(numCourses, prerequisites));
        System.out.println("Course Schedule Topological Sequence = " + new CourseSchedule().coursesSequence(numCourses, prerequisites));

        prerequisites = new int[][] {
            {1, 0},
            {2, 0},
            {3, 1},
            {3, 2},
            {0, 3}
        };
        System.out.println("Course Schedule = " + new CourseSchedule().canCoursesFinish(numCourses, prerequisites));
        System.out.println("Course Schedule Topological Sequence = " + new CourseSchedule().coursesSequence(numCourses, prerequisites));

    }

}
