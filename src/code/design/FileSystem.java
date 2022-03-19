package code.design;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FileSystem {

    private static class FileNode {
        public Map<String, FileNode> children;
        public boolean isFile;
        public String fileContent;

        public FileNode(boolean isFile) {
            this.isFile = isFile;
            children = new HashMap<>();
            this.fileContent = "";
        }
    }

    private FileNode root;

    public FileSystem() {
        root = new FileNode(false);
    }

    public List<String> ls(String path) {
        String[] subdirs = path.split("/");
        FileNode node = root;
        for (int i = 1; i < subdirs.length; i++) {
            node = node.children.get(subdirs[i]);
        }

        List<String> fileAndDirs = new LinkedList<>();
        if (node.isFile) {
            fileAndDirs.add(subdirs[subdirs.length - 1]);
        } else {
            fileAndDirs.addAll(node.children.keySet());
        }

        return fileAndDirs;
    }

    public void mkdir(String path) {
        String[] subdirs = path.split("/");
        FileNode fileNode = root;
        for (int i = 1; i < subdirs.length; i++) {
            String subdir = subdirs[i];
            if (fileNode.children.containsKey(subdir)) {
                fileNode = fileNode.children.get(subdir);
            } else {
                FileNode newNode = new FileNode(false);
                fileNode.children.put(subdir, newNode);
                fileNode = newNode;
            }
        }
    }

    public void addContentToFile(String filePath, String content) {
        String[] subdirs = filePath.split("/");
        FileNode fileNode = root;
        for (int i = 1; i < subdirs.length; i++) {
            String subdir = subdirs[i];
            if (fileNode.children.containsKey(subdir)) {
                fileNode = fileNode.children.get(subdir);
            } else {
                FileNode newNode = new FileNode(i == subdirs.length - 1);
                fileNode.children.put(subdir, newNode);
                fileNode = newNode;
            }
        }

        fileNode.fileContent += content;
    }

    public String readContentFromFile(String path) {
        String[] subdirs = path.split("/");
        FileNode node = root;
        for (int i = 1; i < subdirs.length; i++) {
            node = node.children.get(subdirs[i]);
        }

        return node.fileContent;
    }
}
