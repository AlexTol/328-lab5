package a;
import java.util.*;

/**
 * Created by Alexandru Tol on 12/9/2016.
 */
public class main {

        public static void main(String[] args)
        {
          Scanner in = new Scanner(System.in);

            System.out.println("what is the order of the graph?");
            int order = in.nextInt();

            int maxSize = order*(order-1)/2;

            System.out.println("What is the size of the graph? Note: cannot exceed " + maxSize);

            int size = in.nextInt();
                if(size > maxSize)
                {
                    System.out.println("I see you're trying to break my code, please input a proper size. Note: max size for this graph is " + maxSize);

                    while(size > maxSize)
                    {
                        size = in.nextInt();
                    }
                }

            adjacencyList adj = new adjacencyList(size,order);
            System.out.println("/n Here's the adjacency list");
            adj.displayList();

            System.out.println("/n What would you like to be the origin node?");
            int origin = in.nextInt();

            adj.bfs(origin);
        }

}
