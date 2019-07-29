package visitor;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

enum Color {
    RED, GREEN
}

abstract class Tree {

    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis
{
    public abstract int getResult();
    public abstract void visitNode(TreeNode node);
    public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {
    int sum = 0;
    public int getResult() {    
        return sum;
    }

    public void visitNode(TreeNode node) {
        
    }

    public void visitLeaf(TreeLeaf leaf) {
        sum += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
    long product = 1;
    
    public int getResult() {
        return (int) product;
    }

    public void visitNode(TreeNode node) {
        if (node.getColor().equals(Color.RED)) {
            product = (product * node.getValue()) % ((long) Math.pow(10, 9) + 7);
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor().equals(Color.RED)) {
        	product = (product * leaf.getValue()) % ((int) Math.pow(10, 9) + 7);
        }
    }
}

class FancyVisitor extends TreeVis {
    int resultNodes = 0;
    int resultLeafs = 0;
    
    public int getResult() {
        return Math.abs(resultNodes - resultLeafs);
    }

    public void visitNode(TreeNode node) {
        if (node.getDepth()%2 == 0) {
            resultNodes += node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor().equals(Color.GREEN)) {
            resultLeafs += leaf.getValue();
        }
    }
}


public class Solution {
  
    public static Tree solve() {
        Tree root = buildTree();      
        return root;
    }

	private static Tree buildTree() {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> values = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
        	values.add(in.nextInt());
        }
        List<Color> colors = new ArrayList<Color>();
        for (int i=0; i < n; i++) {
        	colors.add(in.nextInt() == 0? Color.RED: Color.GREEN);
        }
        
        // Create separated nodes
        List<TreeNode> nodes = new ArrayList<TreeNode>();
        for (int i=0; i < n; i++) {
        	nodes.add(new TreeNode(values.get(i), colors.get(i), 0));
        }
        
        TreeNode root = (TreeNode) nodes.get(0);
        
        // Read edges:
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        
        for (int i=0; i < n-1; i++) {
        	int nPai = in.nextInt()-1;
        	int nFilho = in.nextInt()-1;
        	if (nPai != 0 || !map.containsKey(nPai)) {
        		outerloop:
        		for (Integer x: map.keySet()) {
            		for (Integer y: map.get(x)) {
            			if (y == nPai) {
            				// descobriu que nPai já é filho de alguém, então nPai só pode ser pai
            				break outerloop;
            			} else if (y == nFilho && x != nPai) {
            				/// descobriu que nFilho ja é filho de alguem que não é nPai, então nFilho só pode ser pai
            				int aux = nPai;
            				nPai = nFilho;
            				nFilho = aux;
            				break outerloop;
            			}
            		}
            	}     		
        	}
     	
    		if (!map.containsKey(nPai)) {
    			List<Integer> list = new ArrayList<Integer>();
				list.add(nFilho);
        		map.put(nPai, list);
        	} else {
        		map.get(nPai).add(nFilho);
        	}
        		
        }
        
        // Build tree:
        root = (TreeNode) buildTreeAux(nodes, map, 0, 0);
        return root;
    
	}
 
	private static Tree buildTreeAux(List<TreeNode> nodes, Map<Integer, List<Integer>> map, int nIndex, int depth) {
		TreeNode node = nodes.get(nIndex);
		if (!map.containsKey(nIndex)) {
			// Transforma em folha e retorna
			return new TreeLeaf(node.getValue(), node.getColor(), depth);
		} else {
			node = new TreeNode(node.getValue(), node.getColor(), depth);
			nodes.set(nIndex, node);
			for (Integer cIndex: map.get(nIndex)) {
				node.addChild(buildTreeAux(nodes, map, cIndex, depth+1));
			}
			return node;
		}
	}

	public static void main(String[] args) {
      	Tree root = solve();
		SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
      	ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
      	FancyVisitor vis3 = new FancyVisitor();

      	root.accept(vis1);
      	root.accept(vis2);
      	root.accept(vis3);

      	int res1 = vis1.getResult();
      	int res2 = vis2.getResult();
      	int res3 = vis3.getResult();

      	System.out.println(res1);
     	System.out.println(res2);
    	System.out.println(res3);
	}
}