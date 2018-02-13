package chap7.filesystem;

public class InMemFS {


    public static final Folder root = new Folder("", null);

    public boolean create(Folder parent, Node node){

        if(exists(parent)){
            parent.getChilderen().add(node);
            node.setParent(parent);
            return true;
        }
        return false;
    }
    public boolean delete(Node node){

        if(exists(node)){

            node.setParent(null);
            return true;
        }
        return false;
    }
    public Node[] list(Folder folder){

        return folder.getChilderen().toArray(new Node[] {});
    }
    public void rename(Node node, String newname){

        node.setName(newname);
    }
    public static char getPathSeparator(){
        return '/';
    }
    public boolean exists(Node node){

        if(node.equals(root) || node.getParent().equals(root)){
            return true;
        }

        return node != null && exists(node.getParent());


    }
}
