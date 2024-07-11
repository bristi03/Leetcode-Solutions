class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        for(char ch:s.toCharArray()){
            if(ch == ')'){
                while(stack.peek() != '('){
                    queue.add(stack.pop());
                }
                stack.pop();
                while(!queue.isEmpty()){
                    stack.push(queue.poll());
                }
            }
            else{
                stack.push(ch);
            }
        }
        while(!stack.isEmpty()){
            res.append(stack.pop());
        }
        return res.reverse().toString();
    }
}