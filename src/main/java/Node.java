/**
 * Alipay.com Inc.
 * Copyright (c) 20042019 All Rights Reserved.
 */

/**
 * @author Faisal_RM754
 * @version $Id: Node.java, v 0.1 20190206 11:14 Faisal_RM754 Exp $$
 */
public class Node {

    private int x;
    private int y;

    Node(int x, int y){
        this.x = x;
        this.y = y;
    }

    int getX(){
        return this.x;
    }

    int getY(){
        return this.y;
    }

    @Override
    public int hashCode(){
        return this.getX()+this.getY()+31;
    }

    @Override
    public boolean equals(Object obj){
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        Node tmp = (Node) obj;
        return tmp.getX() == this.getX() && this.getY() == tmp.getY();
    }

    @Override
    public String toString(){
        return "x: " + this.getX() + " y: " + this.getY();
    }
}