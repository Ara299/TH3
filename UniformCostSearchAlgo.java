package AI_lab3_UCS_DLS.task456;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class UniformCostSearchAlgo implements ISearchAlgo {

    @Override
    public Node execute(Node root, String goal) {
        PriorityQueue<Node> frontier = new PriorityQueue<>((o1, o2) -> {
            if(o1.getLabel().compareTo(o2.getLabel())==0) return Double.compare(o1.getPathCost(), o2.getPathCost());
            return o1.getLabel().compareTo(o2.getLabel());
        });
        List<Node> exploredSet = new ArrayList<>();
        frontier.add(root);
        root.setPathCost(0);
        while(!frontier.isEmpty()){
            Node current = frontier.poll();
            if(current.getLabel().equals(goal)) return current;
            exploredSet.add(current);
            for (Edge child : current.getChildren()) {
                Node n = child.getEnd();
                if (!exploredSet.contains(n) && !frontier.contains(n)) {
                    frontier.add(n);
                    n.setParent(current);
                    n.setPathCost(current.getPathCost() + child.getWeight());
                } else if (frontier.contains(n) && n.getPathCost()>current.getPathCost() + child.getWeight()) {
                    n.setParent(current);
                    n.setPathCost(current.getPathCost() + child.getWeight());
                } else if (exploredSet.contains(n)) {
                    frontier.add(n);
                    n.setParent(current);
                    n.setPathCost(current.getPathCost() + child.getWeight());
                }
            }
        }
        return null;
    }

    @Override
    public Node execute(Node root, String start, String goal) {
        PriorityQueue<Node> frontier = new PriorityQueue<>((o1, o2) -> {
            if(o1.getLabel().compareTo(o2.getLabel())==0) return Double.compare(o1.getPathCost(), o2.getPathCost());
            return o1.getLabel().compareTo(o2.getLabel());
        });
        List<Node> exploredSet = new ArrayList<>();
        frontier.add(root);
        root.setPathCost(0);
        boolean isStarted = false;
        while(!frontier.isEmpty()){
            Node current = frontier.poll();
            if(current.getLabel().equals(goal) && isStarted) return current;
            if(current.getLabel().equals(start)) {
                current.setPathCost(0);
                current.setParent(null);
                frontier.clear();
                exploredSet.clear();
                isStarted = true;
            }
            exploredSet.add(current);
            for (Edge child : current.getChildren()) {
                Node n = child.getEnd();
                if (!exploredSet.contains(n) && !frontier.contains(n)) {
                    frontier.add(n);
                    n.setParent(current);
                    n.setPathCost(current.getPathCost() + child.getWeight());
                } else if (frontier.contains(n) && n.getPathCost()>current.getPathCost() + child.getWeight()) {
                    n.setParent(current);
                    n.setPathCost(current.getPathCost() + child.getWeight());
                } else if (exploredSet.contains(n)) {
                    frontier.add(n);
                    n.setParent(current);
                    n.setPathCost(current.getPathCost() + child.getWeight());
                }
            }
        }
        return null;
    }
}
