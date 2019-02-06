/**
 * Alipay.com Inc.
 * Copyright (c) 20042019 All Rights Reserved.
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

/**
 * @author Faisal_RM754
 * @version $Id: MazeSolver.java, v 0.1 20190206 11:23 Faisal_RM754 Exp $$
 */
public class MazeSolver {

    private int[][] maze;
    // previous grids array
    private Node[][] prev;

    private int sizeX;
    private int sizeY;

    private Node lastNode;

    MazeSolver(int[][] maze, int sizeY, int sizeX) {
        this.maze = maze;
        this.sizeY = sizeY;
        this.sizeX = sizeX;

        prev = new Node[sizeY][sizeX];
    }

    private boolean inBoundsX(int number){
        return number >= 0 && number < sizeX;
    }

    private boolean inBoundsY(int number){
        return number >= 0 && number < sizeY;
    }

    public void solve(Node start){
        Stack<Node> stack = new Stack<Node>();
        HashSet<Node> visited = new HashSet<Node>();

        stack.push(start);

        while(!stack.isEmpty()) {
            Node tmp = stack.pop();
            visited.add(tmp);

            if (maze[tmp.getY()][tmp.getX()] == 3) {
                lastNode = tmp;
                break;
            }

            for(Node node : this.getAdjacentEdges(tmp)) {
                if (!visited.contains(node)) {
                    stack.push(node);
                    prev[node.getY()][node.getX()] = tmp;
                }
            }
        }
    }

    public void fillPath(List<Node> path) {
        if (lastNode == null) {
            System.out.println("No path in maze");
        } else {
            // assume, that start point and end point are different
            for (;;) {
                lastNode = prev[lastNode.getY()][lastNode.getX()];

                // There's no previous node for start point, so we can break
                if (lastNode == null) {
                    break;
                }

                maze[lastNode.getY()][lastNode.getX()] = 2;
                path.add(lastNode);

            }
        }
    }

    private List<Node> getAdjacentEdges(Node tmp) {
        List<Node> neighbours = new ArrayList<Node>();
        if(this.inBoundsX(tmp.getX()+1)){
            if(this.maze[tmp.getY()][tmp.getX()+1] != 1){
                neighbours.add(new Node(tmp.getX()+1, tmp.getY()));
            }
        }
        if(this.inBoundsX(tmp.getX()-1)){
            if(this.maze[tmp.getY()][tmp.getX()-1] != 1){
                neighbours.add(new Node(tmp.getX()-1, tmp.getY()));
            }
        }
        if(this.inBoundsY(tmp.getY()+1)){
            if(this.maze[tmp.getY()+1][tmp.getX()] != 1){
                neighbours.add(new Node(tmp.getX(), tmp.getY()+1));
            }
        }
        if(this.inBoundsY(tmp.getY()-1)){
            if(this.maze[tmp.getY()-1][tmp.getX()] != 1){
                neighbours.add(new Node(tmp.getX(), tmp.getY()-1));
            }
        }
        return neighbours;
    }
}
