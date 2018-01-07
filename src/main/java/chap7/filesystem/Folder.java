package chap7.filesystem;

import java.util.ArrayList;
import java.util.List;

public class Folder extends Node {

    private List<Node> childeren = new ArrayList<Node>();

    public Folder(String name, Folder parent){
        super(name, parent);
    }

    public List<Node> getChilderen() {
        return childeren;
    }

}
