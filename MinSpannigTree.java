import java.util.ArrayList;
import java.util.Scanner;

// ����ġ �׷����� ���� ������ ǥ���ϴ� Ŭ����
class Edge {
	int v1, v2;  	// ���� (v1, v2)�� �̷�� ���� ��ȣ
	int weight;	// ���� ����ġ	
	public Edge(int v1, int v2, int weight) {
		this.v1 = v1;
		this.v2 = v2;
		this.weight = weight;
	}
}

// ũ�罺Į �˰����� �̿��Ͽ� �ּҺ�����Ʈ���� ���ϴ� ���α׷�
public class MinSpannigTree {
	// Ʈ���� �̿��� ��ȣ��Ÿ�� ���� ǥ��
	private static int [] parent;  	// Ʈ���� �� ����� �θ� ��� ��ȣ�� ������ �迭 parent

	public static void main(String[] args) {		
		

		// ���� ��(n), ���� ��(e)�� �Է¹���
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();  	// ���� �� n (���� ��ȣ�� 1, 2, 3, ..., n)
		int e = scanner.nextInt();	// ���� �� e

		// e���� ����(v1, v2, weight)�� �Է¹޾� ���� ����Ʈ�� ����
		ArrayList<Edge> edgeList = new ArrayList<>();
		for (int i = 0; i < e; i++) {
			edgeList.add(new Edge(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
		}

		// ���� ����Ʈ�� ����ġ ������������ ����
		edgeList.sort((o1, o2) -> {
			return (o1.weight - o2.weight);     
		} );

		// Ʈ���� �̿��� ��ȣ��Ÿ�� ���� ǥ��
		parent = new int[n+1];
			// �迭 parent�� ����. [0...n-1]�̸� ���������, �ε��� ����� �����ϱ� ���� �ϱ� ���� [0...n]�� �����غ���.
		

		// �� �������� ������ n���� ��ȣ��Ÿ�� ���� ���� 
		for (int x = 1; x <= n; x++) {
			makeSet(x);
		}

		// ������������ ���ĵ� edgeList���� ������ �ϳ��� �˻��Ͽ�, ����Ŭ�� �������� ������ Ʈ�� ������(����ġ �տ� ����)
		int treeEdgeCount = 0;  // Ʈ�� ���� ��
		int treeWeightSum = 0;  // Ʈ�� ����ġ ��
		for(int i = 0; (i < e) && (treeEdgeCount <n-1); i++ ) {
			Edge edge = edgeList.get(i);			
			if (findSet(edge.v1) != findSet(edge.v2)) {  // ����Ŭ�� �������� ������(��, edge�� v1, v2�� ���� ���տ� ������ ������)
				union(edge.v1,edge.v2);   // v1, v2�� ���� ������ ��ħ 
				treeWeightSum+=edge.weight;   // ����ġ �տ� edge�� ����ġ�� ����
				treeEdgeCount++;
			}
		}		
		
		// �ּҽ���Ʈ���� ���� ����ġ ���� ���
		System.out.println(treeWeightSum);
	}

	private static void makeSet(int x) { 
		parent[x]=x;
		
	}	// �ϳ��� ���� x�� ������ ���� ����		 
	
	private static int findSet(int x) { 
	
		if(parent[x] != x) {
			parent[x]= findSet(parent[x]);
		}
		return parent[x];
				
	}	// x�� ��ǥ ���Ҹ� �˾Ƴ� - ��ξ��� ���		 

	private static void union(int x, int y) { 
	    parent[findSet(y)]=findSet(x); 
	}	// x�� ���� ���հ� y�� ���� ������ ��ħ  
}
