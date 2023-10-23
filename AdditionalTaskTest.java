package AI_lab3_UCS_DLS.task456;

import java.util.List;

public class AdditionalTaskTest {

    public static void main(String[] args) {
        Node nodeS = new Node("START");
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");
        Node nodeG = new Node("GOAL");
        Node nodeH = new Node("H");
        Node nodeP = new Node("P");
        Node nodeQ = new Node("Q");
        Node nodeR = new Node("R");

        nodeS.addEdge(nodeD, 3); //SD
        nodeS.addEdge(nodeE, 9); //SE
        nodeS.addEdge(nodeP, 1); //SP

        nodeP.addEdge(nodeQ, 15); //PQ

        nodeD.addEdge(nodeB, 1); //DB
        nodeD.addEdge(nodeE, 2); //DE
        nodeD.addEdge(nodeC, 8); //DC

        nodeB.addEdge(nodeA, 2); //BA

        nodeE.addEdge(nodeH, 1); //EH
        nodeE.addEdge(nodeR, 9); //ER

        nodeC.addEdge(nodeA, 2); //CA

        nodeH.addEdge(nodeP, 4); //HP
        nodeH.addEdge(nodeQ, 4); //HQ

        nodeQ.addEdge(nodeR, 3); //QR

        nodeR.addEdge(nodeF, 5); //RF

        nodeF.addEdge(nodeC, 5); //FC
        nodeF.addEdge(nodeG, 5); //FG

        ISearchAlgo algo1 = new UniformCostSearchAlgo();
        Node result = algo1.execute(nodeS, "P","GOAL");
        List<String> path = NodeUtils.printPath(result);
        for (int i = 0; i < path.size(); i++) {
            if (i== path.size()-1) System.out.print(path.get(i));
            else System.out.print(path.get(i) + " -> ");
        }
        System.out.println();
    }
}
