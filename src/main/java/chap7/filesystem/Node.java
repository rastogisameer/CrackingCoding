package chap7.filesystem;


public abstract class Node {

    private String name;
    private Node parent;

    public Node(String name, Node parent) {
        this.name = name;
        this.parent = parent;
    }

    private Permission permission;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }



    @Override
    public int hashCode(){
        return name.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        if (!name.equals(node.name)) return false;
        return parent.equals(node.parent);
    }

    public String getPath(){

        StringBuilder path = new StringBuilder();
        Node ptr = this;
        while(ptr.getParent() != null){

            path.append(ptr);
            ptr = ptr.getParent();
        }
        return path.toString();
    }
}
