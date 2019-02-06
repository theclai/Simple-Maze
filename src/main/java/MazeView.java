/**
 * Alipay.com Inc.
 * Copyright (c) 20042019 All Rights Reserved.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Faisal_RM754
 * @version $Id: MazeView.java, v 0.1 20190206 11:29 Faisal_RM754 Exp $$
 */
public class MazeView extends JFrame {

    private int[][] maze;
    private final List<Node> nodePath = new ArrayList<Node>();
    private final List<Integer> path = new ArrayList<Integer>();
    private int pathMazeIndex ;

    public MazeView(int[][] maze){

        setTitle("Maze Solver");
        setSize(640,480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.maze = maze;
    }

    public void run(){

//        MazeSolver mazeSolver = new MazeSolver(this.maze, 10, 13);
//        mazeSolver.solve(new Node(1,1));
//        mazeSolver.fillPath(nodePath);

        DeepFirstSearch.findPath(maze,1,1,path);
        pathMazeIndex = path.size()-2;
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);

        g.translate(50,50);

        //render maze
        for(int i=0;i<this.maze.length;i++){
            for(int j=0;j<this.maze[0].length;j++){
                Color color = Color.WHITE;

                if(this.maze[i][j] == MazeProperty.WALL_MAZE){
                    color = Color.RED;
                }
                else if(maze[i][j] == MazeProperty.EXIT_MAZE){
                    color = Color.GREEN;
                }

                g.setColor(color);
                g.fillRect(30 * j, 30 * i, 30,30);
                g.setColor(Color.RED);
                g.drawRect(30 * j, 30 * i, 30,30);
            }
        }

//       //draw dot on the maze
//        int dotX = 1;
//        int dotY = 1;
//
//        g.setColor(Color.BLUE);
//        g.fillOval(dotX * 30, dotY * 30, 30, 30);
//
//        //render path
//        for(int i=0;i<nodePath.size();i++) {
//            int x = nodePath.get(i).getX();
//            int y = nodePath.get(i).getY();
//
//            g.setColor(Color.GRAY);
//            g.fillRect(x * 30, y * 30, 20, 20);
//        }

        //draw dot on the maze
        int dotX = path.get(pathMazeIndex);
        int dotY = path.get(pathMazeIndex+1);

        g.setColor(Color.YELLOW);
        g.fillOval(dotX * 30, dotY * 30, 30, 30);

        //render path
        for(int i=0;i<path.size();i+=2){
            int x = path.get(i);
            int y = path.get(i+1);

            g.setColor(Color.GRAY);
            g.fillRect(x * 30, y * 30, 20, 20);
        }
    }

    @Override
    protected void processKeyEvent(KeyEvent e){

        if (e.getID() != KeyEvent.KEY_PRESSED) {
            return;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            pathMazeIndex -= 2;
            if (pathMazeIndex < 0) {
                pathMazeIndex = 0;
            }
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            pathMazeIndex += 2;
            if (pathMazeIndex > path.size() - 2) {
                pathMazeIndex = path.size() - 2;
            }
        }
        repaint();
    }
}
