package a;
import java.util.*;
/**
 * Created by Alex Tol on 12/9/2016.
 */

public class adjacencyList {
    //if an item is true within the array, that means there exists an edge between both indexes (nodes)
    private boolean[][] edgeList;
    private int mSize;
    private int mOrder;
    private int trueRoot;   //helps size the array
    private int smallRoot;

    public adjacencyList(int size, int order)
    {
        mSize = size;
        mOrder = order;
            //trueRoot will be the biggest dimension
            if(mSize > mOrder)
                 {
                     trueRoot = mSize;
                     smallRoot = mOrder;
                 }
            else
                {
                    trueRoot = mOrder;
                    smallRoot = mSize;
                }
        //we make it one bigger, so we don't have any node 0's
        edgeList = new boolean[trueRoot + 1][trueRoot + 1];

        for(int i =0; i <= trueRoot; i++)
        {
            //populate the array with false values, so we don't run into nulls
            for(int j = 0; j <= trueRoot; j++)
            {
                edgeList[i][j] = false;
            }

        }

        while(size > 0)
        {   //here, edges are created
            int node1 = (int) (Math.random() * order) + 1;
            int node2 = (int) (Math.random() * order) + 1;
                while(node1 == node2){node2 = (int) (Math.random() * order) + 1;} //edges between the same node is disallowed


            //this means the edge already exists, so we go to the next loop iteration without decrementing size
           if(  edgeList[node1][node2] == true)
           {
               continue;
           }
            //we bring the edge into existence, this means setting the edge to true for both sides (a -> b) and (b -> a)
           edgeList[node1][node2] = true;
            edgeList[node2][node1] = true;
            //two items are made true, but both of these represent just one edge

            size--; //decrement size
        }

    }




    public void displayList()
    {
        //we start from 1, since we don't use node 0s
        for(int i = 1 ; i <= mOrder; i++)
        {   //instantiate adj list for the node
            String adj = i + ": ";
            for(int j = 1; j <= trueRoot; j++)
            {

                //append each neighbor the node has
                if(edgeList[i][j] == true)
                {
                    adj = adj + j +", ";
                }
            }
            //display
            System.out.println(adj);

        }
    }

    public void bfs(int origin)
    {
        Queue<Integer> visited = new LinkedList<Integer>();
        Queue<Integer> q = new LinkedList<Integer>();
        int count = 1;
        int currentNode = origin;
        visited.add(currentNode);
        String  path = "";
        int size = 1;

        while(count < smallRoot ) //because we can only traverse as many times as we have edges
        {
            path = path +" " + Integer.toString(currentNode);

            for(int i = 1; i <= trueRoot; i++)
            {
                if(edgeList[currentNode][i] == true && !visited.contains(i))
                {
                    visited.add(i);
                    q.add(i);
                    count++;
                    System.out.println("The shortest path to " + i + " from " + origin + ", is" + path + " " + i + "    Distance:" + " " + size);

                }

            }


            if (!q.isEmpty())
            {
                currentNode = q.remove();
                size++;
            }
            else if(count == 1)
            {
                System.out.println("No node is reachable from " + origin);
                return;
            }
        }

    }




    public void dfs(int origin)
    {

    }


}
