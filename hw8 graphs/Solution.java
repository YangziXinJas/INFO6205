import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Solution {
	
	/**
	 * Question 1:
	 */
	public static void main(String[] args) {
		
		Vertex v1 = new Vertex("A");
		Vertex v2 = new Vertex("B");
		Vertex v3 = new Vertex("C");
		Vertex v4 = new Vertex("D");
		Vertex v5 = new Vertex("E");
		Vertex v6 = new Vertex("F");

		// build the graph
		v1.addNeighbor(new Edge(10, v1, v2));
		v1.addNeighbor(new Edge(15, v1, v3));
		
		v2.addNeighbor(new Edge(12, v2, v4));
		v2.addNeighbor(new Edge(15, v2, v6));
		
		v3.addNeighbor(new Edge(10, v3, v5));
		
		v4.addNeighbor(new Edge(1, v4, v6));
		v4.addNeighbor(new Edge(2, v4, v5));
		
		v6.addNeighbor(new Edge(5, v6, v5));
		
		ArrayList<Vertex> vs = new ArrayList<>();
		vs.add(v1);
		vs.add(v2);
		vs.add(v3);
		vs.add(v4);
		vs.add(v5);
		vs.add(v6);
		

		for(int i = 0; i < vs.size(); i++) {
			for(int j = 0; j < vs.size(); j++) {
				Graph g = new Graph();
				g.addVertices(vs);
				g.dijkstra(g.getVertices().get(i));
				System.out.println("Path from " + g.getVertices().get(i).getValue() + " to " + g.getVertices().get(j).getValue());
				if(i == j) {
					System.out.println("NO COST");	
				}else {
					System.out.println(g.getShortestPath(g.getVertices().get(j)));
				}
			}
			System.out.println();
		}
		
		
		// q2 test
		int [][] preq = {{1,0}, {0,1}};
		System.out.println("Question 2 Result: " + canFinish(2, preq));
		
		// q3 test
		String begin = "hit";
		String end = "cog";
		List<String> wList = new ArrayList<>();
		wList.add("hot");
		wList.add("dot");
		wList.add("dog");
		wList.add("lot");
		wList.add("log");
		wList.add("cog");
		System.out.println("Question 3 Result: " + ladderLength(begin, end, wList));
		
		// q4 test
		char[][] grid = {{'1','1','0','0','1'},
						 {'1','1','0','1','0'},
						 {'0','0','1','0','0'},
						 {'1','1','0','1','1'}};
		
		System.out.println("Question 4 Result: " + numIslands(grid));
	}
	
	/**
	 * Question 2:
	 */
	public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = new List[numCourses]; 
        for (int[] edge : prerequisites) {
            if (adj[edge[1]] == null) adj[edge[1]] = new ArrayList<>();
            adj[edge[1]].add(edge[0]);
        }
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(i, adj, visited)) return false;
        }
        return true;
    }
    
	// recursive dfs cycle detection
    private static boolean hasCycle(int curr, List<Integer>[] adj, int[] visited) { 
        visited[curr] = 1;
        if (adj[curr] != null) {
            for (Integer nbor : adj[curr]) {
                if (visited[nbor] == 2) continue; // fully visited
                if (visited[nbor] == 1) return true; // visited!! cycle
                if (hasCycle(nbor, adj, visited)) return true;
            }
        }
        visited[curr] = 2; // set to fully visited
        return false;
    }
    
    /**
     * Question 3:
     */
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if(wordList.size() == 0 || !wordList.contains(endWord)){
            return 0;
        } 
        
        HashSet<String> visited = new HashSet<>();
        Queue<String> bfs = new LinkedList<>();
        bfs.offer(beginWord);
        visited.add(beginWord);
        int res = 0;

        //do BFS
        while (!bfs.isEmpty()){
            ++res;
            int sz = bfs.size();
            for(int m = 0; m < sz; m++){
                String str = bfs.poll();
                if(str.equals(endWord)){
                    return res;
                }
                List<String> posb = permutation(str,wordList);
                for(int j = 0; j < posb.size(); j++){
                    String s = posb.get(j);
                    if(visited.contains(s)){
                        continue;
                    }
                    bfs.offer(s);
                    visited.add(s);
                }                
            }
        }
        return 0;
        
    }
    
    private static List<String> permutation(String word, List<String> wordList){
        //return all string in wordList that there is only one character different with word
        List<String> res = new ArrayList<>();
        for(int i = 0; i < wordList.size(); i++){
            String str = wordList.get(i);
            int cnt = 0;
            for(int j = 0; j < str.length(); j++){
                if(word.charAt(j) != str.charAt(j)){
                    ++cnt;
                }
            }
            if(cnt == 1){
                res.add(str);
            }
        }
        return res;
    }
    
    
    /**
     * Question 4:
     */
    public static int numIslands(char[][] grid) {
        if(grid.length < 0 || grid[0].length < 0 || grid == null){
            return 0;
        }
        
        int result = 0;
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[0].length; c++){
                // encounter 1, set all connected '1's to zero
                if(grid[r][c] == '1'){
                    result++;
                    dfs(grid, r, c);
                }
            }
        }
        return result;
    }
    
    private static void dfs(char[][] grid, int r, int c){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length ||
          grid[r][c] == '0'){
            return;
        }
        
        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r + 1, c);
        dfs(grid, r, c + 1);
    }
}

