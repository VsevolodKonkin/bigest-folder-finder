import java.io.File;
import java.util.ArrayList;

public class Node {
    private File folder;
    private ArrayList<Node> children;
    private long size;
    private int level;
    private long limit;


    public Node(File folder, long limit) {
        this.folder = folder;
        this.limit = limit;
        children = new ArrayList<>();
    }

    public long getLimit() {
        return limit;
    }

    public File getFolder() {
        return folder;
    }

    public void addChild(Node node) {
        node.setLevel(level + 1);
        children.add(node);
    }

    private void setLevel(int level) {
        this.level = level;
    }

    public ArrayList<Node> getChildren() {
        return children;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getSize() {
        return size;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        String size = SizeCalculator.getHumanReadableSize(getSize());
            builder.append(folder.getName() + " - " + size + "\n");
            for (Node child : children) {
                if (child.getSize() < limit) {
                    continue;
                }
                builder.append("  ".repeat(level) + child.toString());
            }
        return builder.toString();
    }
}
