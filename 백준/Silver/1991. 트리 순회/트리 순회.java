import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Node {
	String data;
	Node left; 
	Node right;
	
	Node(){}
	
	Node(String data){
		this.data = data;
	}
}

public class Main {
	static Node[] node;
	static int N;
	
    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int index = 1;
		N = Integer.parseInt(br.readLine());
		node = new Node[N+1];
		
		for(int n=1; n<=N; n++) {
			node[n] = new Node();
		}
		
		for(int n=1; n<=N; n++) {
			st = new StringTokenizer(br.readLine());
			String parent = st.nextToken();
			int now = search(parent);
			node[now].data = parent;
			
			String left = st.nextToken();
			String right = st.nextToken();
			
			if(!left.equals(".")) {
				node[++index].data = left; 
				node[now].left = node[index];
			} 
			if(!right.equals(".")) {
				node[++index].data = right;
				node[now].right = node[index];
			} 
		}
		preorder(node[1]);
		System.out.println();
		inorder(node[1]);
		System.out.println();
		postorder(node[1]);
    }
    
    static int search(String data) {
    	for(int i=1; i<=N; i++) {
    		if(node[i].data == null) {
    			break;
    		}
    		else if(node[i].data.equals(data)) {
    			return i;
    		}
    	}
    	return 1;
    }
    
    static void preorder(Node node) {
    	if(node == null) {
    		return;
    	}
    	
    	System.out.print(node.data);
    	preorder(node.left);
    	preorder(node.right);
    }
    
    static void inorder(Node node) {
    	if(node == null) {
    		return;
    	}
    	
    	inorder(node.left);
    	System.out.print(node.data);
    	inorder(node.right);
    }
    
    static void postorder(Node node) {
    	if(node == null) {
    		return;
    	}
    	
    	postorder(node.left);
    	postorder(node.right);
    	System.out.print(node.data);
    }
}