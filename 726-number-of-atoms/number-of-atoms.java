class Solution {
    public String countOfAtoms(String formula) {
        Stack<Map<String, Integer>> stack = new Stack<>();
        stack.push(new TreeMap<>());
        
        int n = formula.length();
        for (int i = 0; i < n;) {
            if (formula.charAt(i) == '(') {
                stack.push(new TreeMap<>());
                i++;
            } else if (formula.charAt(i) == ')') {
                Map<String, Integer> top = stack.pop();
                i++;
                int start = i;
                while (i < n && Character.isDigit(formula.charAt(i))) i++;
                int multiplicity = start < i ? Integer.parseInt(formula.substring(start, i)) : 1;
                for (String name : top.keySet()) {
                    int v = top.get(name);
                    stack.peek().put(name, stack.peek().getOrDefault(name, 0) + v * multiplicity);
                }
            } else {
                int start = i;
                i++; // Uppercase letter
                while (i < n && Character.isLowerCase(formula.charAt(i))) i++;
                String name = formula.substring(start, i);
                start = i;
                while (i < n && Character.isDigit(formula.charAt(i))) i++;
                int multiplicity = start < i ? Integer.parseInt(formula.substring(start, i)) : 1;
                stack.peek().put(name, stack.peek().getOrDefault(name, 0) + multiplicity);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (String name : stack.peek().keySet()) {
            sb.append(name);
            int count = stack.peek().get(name);
            if (count > 1) sb.append(count);
        }
        return sb.toString();
    }
}