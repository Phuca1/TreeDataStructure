import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class test3 {
    static HashMap<String, Node> tree;
    static HashMap<Integer, Node> tree2;
    static Scanner sc;

    public void bai1() throws FileNotFoundException {
        System.out.println("Bai 1");
        tree = new HashMap<String, Node>();
        tree2 = new HashMap<Integer, Node>();

        sc = new Scanner(new File("src/tree.txt"));

        Node zero = new Node(0, 0, "0");
        zero.nodeCon = new LinkedList<Integer>();
        tree.put("0", zero);
        tree2.put(0, zero);
        while (sc.hasNext()) {
            int id = Integer.parseInt(sc.next());
            int parentId = Integer.parseInt(sc.next());
            String name = sc.next();
            Node x = new Node(id, parentId, name);
            x.nodeCon = new LinkedList<Integer>();
            tree.put(name, x);
            tree2.put(id, x);
        }

        for(Integer key : tree2.keySet()){
            try{
                Node x = tree2.get(key);
                int id = x.maNode;
                int parentId = x.maNodeCha;
                String name = x.tenNode;
                tree2.get(parentId).nodeCon.add(id);
            }catch (Exception e){
                System.out.printf("something went wrong");
            }

        }


        for (String key : tree.keySet()) {
            System.out.println(tree.get(key));
        }
    }

    public void bai2(){
        System.out.println("Bai 2");

        Scanner sc2 = new Scanner(System.in);
        String in = sc2.nextLine();

        String[] nameNodeList = in.split(" ");
        Node node1 = tree.get(nameNodeList[0]);
        Node node2 = tree.get(nameNodeList[1]);
        if(node2.maNodeCha == node1.maNode){
            System.out.println(node2.tenNode +" la con cua nut "+node1.tenNode);
        }else {
            System.out.println(node2.tenNode +" khong la con cua nut "+node1.tenNode);
        }

        LinkedList<Integer> nParent1 = new LinkedList<Integer>();
        LinkedList<Node> queue1 = new LinkedList<Node>();
        queue1.add(node1);
        while(queue1.size() != 0){
            Node x = queue1.poll();

            if(x.maNode == x.maNodeCha){
                break;
            }
            nParent1.add(x.maNodeCha);
            queue1.add(tree2.get(x.maNodeCha));
        }

        LinkedList<Integer> nParent2 = new LinkedList<Integer>();
        LinkedList<Node> queue2 = new LinkedList<Node>();
        queue2.add(node2);
        while(queue2.size() != 0){
            Node x = queue2.poll();
            if(x.maNode == x.maNodeCha){
                break;
            }
            nParent2.add(x.maNodeCha);
            queue2.add(tree2.get(x.maNodeCha));

        }

        Object[] p1 = nParent1.toArray();
        Object[] p2 = nParent2.toArray();
        int m = p1.length;
        int n = p2.length;
        while (m >=1 && n>=1){
            if(p1[m-1] ==p2[n-1]){
                m--;
                n--;
            }
        }


        System.out.print(node1.tenNode + "=>");
        for(int i = 0;i <= m;i++){
            System.out.print(tree2.get(p1[i]).tenNode+"=>");
        }
        for(int i = n-1;i >=0 ; i--){
            System.out.print(tree2.get(p2[i]).tenNode+"=>");
        }
        System.out.println(node2.tenNode );
    }

    public void bai3(){
        Scanner sc3 = new Scanner(System.in);
        System.out.println("Bai 3 : Nhap vao ten nut");
        String nx = sc3.nextLine();

        LinkedList<Node> nParent = new LinkedList<Node>();
        nParent.add(tree.get(nx));
        while(nParent.size() != 0){
            Node x = nParent.poll();
            System.out.println(x.toString());
            ListIterator li = x.nodeCon.listIterator();
            while (li.hasNext()){
                nParent.add(tree2.get(li.next()));
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        test3 ins = new test3();
        ins.bai1();
        ins.bai2();
        ins.bai3();
    }
}
