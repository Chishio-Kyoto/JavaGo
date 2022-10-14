package sample02;

public class MyNode extends Node<Integer>{
    public MyNode(Integer data) {
        super(data);
    }

    /**
     * 桥方法
     */
    // public void setData(Object data) {
    //     setData((Integer) data);
    // }

    // public void setData(Integer data) {
    //     System.out.println("MyNode.setData");
    //     super.setData(data);
    // }

    public static void main(String[] args) {
        Node<Integer> node = new Node<>(1234);
        System.out.println(node.data);
        node.setData(2234);
        System.out.println(node.data);

        MyNode myNode = new MyNode(3234);
        System.out.println(myNode.data);
        myNode.setData(4234);
        System.out.println(myNode.data);

        Node<Object> node2 = new Node<>("1234");
        System.out.println(node2.data);
        node2.setData(2233.4);
        System.out.println(node2.data);
    }
}
