package AI_lab3_UCS_DLS.task456;

import java.util.List;

public class ClientTest {

    public static void main(String[] args) {
        Node nodeS = new Node("S");
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");
        Node nodeG = new Node("G");
        Node nodeH = new Node("H");
        nodeS.addEdge(nodeA, 5);
        nodeS.addEdge(nodeB, 2);
        nodeS.addEdge(nodeC, 4);
        nodeA.addEdge(nodeD, 9);
        nodeA.addEdge(nodeE, 4);
        nodeB.addEdge(nodeG, 6);
        nodeC.addEdge(nodeF, 2);
        nodeD.addEdge(nodeH, 7);
        nodeE.addEdge(nodeG, 6);
        nodeF.addEdge(nodeG, 1);
        DepthLimitedSearchAlgo dlsAlgo = new DepthLimitedSearchAlgo();
        Node result = dlsAlgo.execute(nodeS, "G", 3);
        List<String> path = NodeUtils.printPath(result);
        for (int i = 0; i < path.size(); i++) {
            if (i== path.size()-1) System.out.print(path.get(i));
            else System.out.print(path.get(i) + " -> ");
        }
        System.out.println();
    }
}
