/**
 * Alipay.com Inc.
 * Copyright (c) 20042019 All Rights Reserved.
 */

import javax.swing.*;

/**
 * @author Faisal_RM754
 * @version $Id: MainBoard.java, v 0.1 20190206 13:16 Faisal_RM754 Exp $$
 */
public class MainBoard {

    public static void main(String[] args) {

        final int [][] mazeArray =
                {       {1,1,1,1,1,1,1,1,1,1,1,1,1},
                        {1,0,1,0,1,0,1,0,0,0,0,0,1},
                        {1,0,1,0,0,0,1,0,1,1,1,0,1},
                        {1,0,0,0,1,1,1,0,0,0,0,0,1},
                        {1,0,1,0,0,0,0,0,1,1,1,0,1},
                        {1,0,1,0,1,1,1,0,1,0,0,0,1},
                        {1,0,1,0,1,0,0,0,1,1,1,0,1},
                        {1,0,1,0,1,1,1,0,1,0,1,0,1},
                        {1,0,0,0,0,0,0,0,0,0,1,3,1},
                        {1,1,1,1,1,1,1,1,1,1,1,1,1}

                };

        SwingUtilities.invokeLater(new Runnable() {

            public void run() {

                MazeView mazeView = new MazeView(mazeArray);
                mazeView.run();
                mazeView.setVisible(true);
            }
        });
    }
}
