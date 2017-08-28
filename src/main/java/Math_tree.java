package hacker_rank;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sshreekantja on 8/28/2017.
 */
public class Math_tree {

    public static void main(String[] args) {
        System.out.println(evaluate("E 4 3"));
    }

    static class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x=x;
            this.y=y;
        }
    }

    static String evaluate(String inputLine){
        String output="";
        String[] input = inputLine.split(" ");
        switch(inputLine.charAt(0)){
            case 'N':
                output = evaluateN((int)Integer.parseInt(""+input[1]));
            break;

            case 'E':
                output = evaluteE((int)Integer.parseInt(""+input[1]),(int)Integer.parseInt(""+input[2]));

        }
        return output;
    }

    private static String evaluteE(int p, int q) {
        if(p==1 && q==1){
            return "1";
        }
        int count=1;
        Queue<Node> queue = new LinkedList<Node>();
        Node root = new Node(1,1);
        queue.add(root);
        while(!queue.isEmpty()){
            Node node = queue.remove();
            int x = node.x;
            int y = node.y;
            addChildToQ(x+y,x,queue);
            count++;
            if(x+y==p && x==q)
                return ""+count;
            addChildToQ(y,x+y,queue);
            count++;
            if(p==y&&q==x+y)
                return ""+count;

        }
        return "";
    }

    private static String evaluateN(int pos) {
        if(pos==1){
            return "1/1";
        }
        int count=1;
        Queue<Node> q = new LinkedList<Node>();
        Node root = new Node(1,1);
        q.add(root);
        while(!q.isEmpty()){
            Node node = q.remove();
            int x = node.x;
            int y = node.y;
            addChildToQ(x+y,x,q);
            count++;
            if(count==pos)
                return ""+(x+y)+"/"+x;
            addChildToQ(y,x+y,q);
            count++;
            if(count==pos)
                return ""+y+"/"+(x+y);

        }
        return "";
    }

    private static void addChildToQ(int x, int y, Queue<Node> q) {
        Node node = new Node(x,y);
        q.add(node);
    }
}
