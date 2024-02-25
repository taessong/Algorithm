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
		
		N = Integer.parseInt(br.readLine());
		node = new Node[N+1];

	    	// 생성자를 통해 비어있는 node 생성해주기
	    	// 각 input 값마다 new Node를 해주면 node끼리 연결이 되지 않는다고 생각
		for(int n=1; n<=N; n++) {
			node[n] = new Node();
		}
	    
		// left와 right의 위치를 정해줄 index
	    	int index = 1;
		for(int n=1; n<=N; n++) {
			st = new StringTokenizer(br.readLine());
			String parent = st.nextToken();
			// parent가 node[]의 몇번째에 위치하는지 확인하기 위해 search 함수
			int now = search(parent);
			// 이렇게 작성하지 않고 new Node(parent)를 작성하면 노드가 매번 새롭게 생성되어 left, right로 연결되지 않는다고 생각함
			node[now].data = parent;
			
			String left = st.nextToken();
			String right = st.nextToken();

			// .이 아니면 data에 값을 넣어주고 부모의 left, right에 연결하기
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

    // search 함수는 input의 각 줄마다 들어온 parent가 ABCDEFG가 아닌 ABCEFDG인 것을 보고 구상함
    // D를 node[4]에 저장했는데, E가 4번째로 들어오면 data가 E로 덮어지기에 D가 사라지는 문제 발생
    // node[]를 순회하면서 parent와 같은 같이 있는 위치 반환, 같은 값이 없는 경우는 "A"인 경우 뿐이기에 1 반환
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
