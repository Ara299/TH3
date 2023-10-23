package AI_lab3_UCS_DLS.task456;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthLimitedSearchAlgo implements ISearchAlgo {

    public Node execute(Node root, String goal, int limitedDepth) {
        Stack<Node> frontier = new Stack<>();
        List<Node> exploredSet = new ArrayList<>();
        root.setDepth(0);
        frontier.add(root);
        int index = 0;
        while(!frontier.isEmpty()){
            Node current = frontier.remove(0);
            if(current.getLabel().equals(goal)) return current;
            else if(current.getDepth()<limitedDepth){
                exploredSet.add(current);
                List<Node> children = current.getChildrenNodes();
                for (Node child : children){
                    if (!frontier.contains(child) && !exploredSet.contains(child)){
                        frontier.add(index++, child);
                        child.setParent(current);
                        child.setDepth(current.getDepth()+1);
                    }
                }
                index = 0;
            }
        }
        return null;
    }

    @Override
    public Node execute(Node root, String goal) {
        return null;
    }

    @Override
    public Node execute(Node root, String start, String goal) {
        return null;
    }
}
