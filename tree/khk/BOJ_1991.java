package tree.khk;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * [BOJ] 1991 - 트리 순회
 * https://www.acmicpc.net/problem/1991
 *
 * 이진 트리를 입력받아 전위 순회(preorder traversal), 중위 순회(inorder traversal), 후위 순회(postorder traversal)한
 * 결과를 출력하는 프로그램을 작성하시오.
 *
 * 예를 들어 위와 같은 이진 트리가 입력되면,
 *
 * 전위 순회한 결과 : ABDCEFG // (루트) (왼쪽 자식) (오른쪽 자식)
 * 중위 순회한 결과 : DBAECFG // (왼쪽 자식) (루트) (오른쪽 자식)
 * 후위 순회한 결과 : DBEGFCA // (왼쪽 자식) (오른쪽 자식) (루트)
 *
 * 입력
 * 첫째 줄에는 이진 트리의 노드의 개수 N(1 ≤ N ≤ 26)이 주어진다.
 * 둘째 줄부터 N개의 줄에 걸쳐 각 노드와 그의 왼쪽 자식 노드, 오른쪽 자식 노드가 주어진다.
 * 노드의 이름은 A부터 차례대로 알파벳 대문자로 매겨지며, 항상 A가 루트 노드가 된다.
 * 자식 노드가 없는 경우에는 .으로 표현한다.
 *
 * 출력
 * 첫째 줄에 전위 순회, 둘째 줄에 중위 순회, 셋째 줄에 후위 순회한 결과를 출력한다.
 * 각 줄에 N개의 알파벳을 공백 없이 출력하면 된다.
 */
public class BOJ_1991 {
	//알파벳 수만큼 배열 크기를 할당한다.
	static Node[] nodes = new Node[26];

	static class Node {
		int node;
		int leftChild;
		int rightChild;

		Node(int node, int leftChild, int rightChild) {
			this.node = node;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
		}
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			int n = Integer.parseInt(br.readLine());
			for (int i = 0; i < n; i++) {
				String[] inputs = br.readLine().split(" ");
				//A 아스키코드 = 65
				int node = inputs[0].charAt(0) - 65;
				int leftChild = inputs[1].charAt(0) - 65;;
				int rightChild = inputs[2].charAt(0) - 65;;

				nodes[node] = new Node(node, leftChild, rightChild);
			}

			//전위순회
			preSearch(0);
			System.out.println();
			//중위순회
			middleSearch(0);
			System.out.println();
			//후위순회
			postSearch(0);

			br.close();
		} catch(Exception e) {

		}
	}

	static void preSearch(int idx) {
		Node node = nodes[idx];
		int parent = node.node + 65;
		int leftChild = node.leftChild;
		int rightChild = node.rightChild;

		//부모 노드 방문 -> 왼쪽 자식 노드 방문 -> 오른쪽 자식 방문
		System.out.print("" + (char)parent);
		if (leftChild > 0) preSearch(leftChild);
		if (rightChild > 0) preSearch(rightChild);
	}

	static void middleSearch(int idx) {
		Node node = nodes[idx];
		int parent = node.node + 65;
		int leftChild = node.leftChild;
		int rightChild = node.rightChild;

		//왼쪽 자식 노드 방문 -> 부모 노드 방문 -> 오른쪽 자식 방문
		if (leftChild > 0) middleSearch(leftChild);
		System.out.print("" + (char)parent);
		if (rightChild > 0) middleSearch(rightChild);
	}

	static void postSearch(int idx) {
		Node node = nodes[idx];
		int parent = node.node + 65;
		int leftChild = node.leftChild;
		int rightChild = node.rightChild;

		//왼쪽 자식 노드 방문 -> 오른쪽 자식 방문 -> 부모 노드 방문
		if (leftChild > 0) postSearch(leftChild);
		if (rightChild > 0) postSearch(rightChild);
		System.out.print("" + (char)parent);
	}
}
