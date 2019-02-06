/**
 * Alipay.com Inc.
 * Copyright (c) 20042019 All Rights Reserved.
 */

import java.util.List;

/**
 * @author Faisal_RM754
 * @version $Id: DeepFirstSearch.java, v 0.1 20190206 9:33 Faisal_RM754 Exp $$
 *  Values:
 *             0 = not-visited node
 *             1 = wall (blocked)
 *             2 = visited node
 *             3 = target node
 */
public class DeepFirstSearch {

    public static boolean findPath(int[][] maze, int x, int y, List<Integer> path){

        if(maze[y][x] == MazeProperty.EXIT_MAZE){
            path.add(x);
            path.add(y);

            return true;
        }

        if(maze[y][x] == 0){
            maze[y][x] = 2;

            int dx = -1;
            int dy = 0;

            if(findPath(maze, x + dx, y + dy, path)){
                path.add(x);
                path.add(y);

                return true;
            }

            dx = 1;
            dy = 0;

            if(findPath(maze, x + dx, y + dy, path)){
                path.add(x);
                path.add(y);

                return true;
            }

            dx = 0;
            dy = -1;

            if(findPath(maze,x+dx, y+dy,path)){
                path.add(x);
                path.add(y);

                return true;
            }

            dx = 0;
            dy = 1;

            if(findPath(maze,x+dx, y+dy,path)){
                path.add(x);
                path.add(y);

                return true;
            }
        }
        return false;
    }

}
