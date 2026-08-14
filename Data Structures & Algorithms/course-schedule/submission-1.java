class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < numCourses; i++ ) {
            adjacency.add(new ArrayList<>());
        }

        for(int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int prerequisite = prerequisites[i][1];

            adjacency.get(course).add(prerequisite);
        }

        int[] states = new int[numCourses];
        for (int i = 0; i < numCourses; i++ ) {
            if (!canFinishCourse(i, states, adjacency)) {
                return false;
            }
        }


        return true;
    }

    public boolean canFinishCourse(
        int course,
        int[] state, 
        List<List<Integer>> adjacencyList) {

        if (state[course] == 1) return false;

        if (state[course] == 2) return true;

        state[course] = 1;

        for (int prerequisite : adjacencyList.get(course)) {
            if (!canFinishCourse(prerequisite, state, adjacencyList)) {
                return false;
            }
        }

        state[course] = 2;
        return true;
    }
}
