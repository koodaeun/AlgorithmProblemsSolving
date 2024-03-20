class Solution {
    HashSet<Integer> set = new HashSet<>();

    public int solution(String numbers) {
        int answer = 0;
        Stack<Node> stack = new Stack<>();
        stack.push(new Node("", numbers));

        while (!stack.isEmpty()) {
            Node node = stack.pop(); 
            String prefix = node.prefix; 
            String str = node.str;

            if (!prefix.equals("")) {
                set.add(Integer.valueOf(prefix));
            }

            for (int i = 0; i < str.length(); i++) {
                String newPrefix = prefix + str.charAt(i);
                String newStr = str.substring(0, i) + str.substring(i + 1);
                stack.push(new Node(newPrefix, newStr));
                
            }
        }

        for (int num : set) { 
            if (prime(num)) {
                answer++;
            }
        }

        return answer;
    }

    public boolean prime(int num) {
        if (num == 0 || num == 1)
            return false;
        for (int i = 2; i <= Math.sqrt(num); i++)
            if (num % i == 0)
                return false;
        return true;
    }

    class Node {
        String prefix; 
        String str; 

        public Node(String prefix, String str) {
            this.prefix = prefix;
            this.str = str;
        }
    }
}
