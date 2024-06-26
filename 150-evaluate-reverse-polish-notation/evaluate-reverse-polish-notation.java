class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String op: tokens){
            if(op.equals("+")){
                stack.push(stack.pop() + stack.pop());
            }
            else if(op.equals("-")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b-a);
            }
            else if(op.equals("*")){
                stack.push(stack.pop() * stack.pop());
            }
            else if(op.equals("/")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b/a);
            }
            else
                stack.push(Integer.parseInt(op));
        }
        return stack.pop();
    }
}