import java.util.LinkedList;

public class Node {
    public int maNode;
    public int maNodeCha;
    public String tenNode;
    public LinkedList<Integer> nodeCon;

    public Node(){

    }

    public Node(int maNode, int maNodeCha, String tenNode){
        this.maNode = maNode;
        this.maNodeCha = maNodeCha;
        this.tenNode = tenNode;
    }

    @Override
    public String toString() {
        return "Node{" +
                "maNode=" + maNode +
                ", maNodeCha=" + maNodeCha +
                ", tenNode='" + tenNode + '\'' +
                '}';
    }
}
