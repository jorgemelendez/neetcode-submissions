class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> adjacency = new HashMap<>();
        for(int i = 0; i < prerequisites.length; i++) {
            int origin = prerequisites[i][0];
            int dest = prerequisites[i][1];

            adjacency.computeIfAbsent(origin, k -> new HashSet<>()).add(dest);
        }


        for (int i = 0; i < numCourses; i++ ) {
            Set<Integer> visited = new HashSet<>();
            if (!canFinishCourse(i, adjacency, visited)) {
                return false;
            }
        }


        return true;
    }

    public boolean canFinishCourse(
        int course, 
        Map<Integer, Set<Integer>> adjacency,
        Set<Integer> visited) {

        Set<Integer> adjacencySet = adjacency.get(course);
        if (adjacencySet == null || adjacencySet.size() == 0) {
            visited.remove(course);
            return true;
        }

        for (int courseNumber : adjacencySet) {
            if (visited.contains(courseNumber)) {
                return false;
            }

            visited.add(courseNumber);
            if (canFinishCourse(courseNumber, adjacency, visited)) {
                adjacencySet.remove(courseNumber);
            } else {
                return false;
            }
        }

        return true;
    }
}
