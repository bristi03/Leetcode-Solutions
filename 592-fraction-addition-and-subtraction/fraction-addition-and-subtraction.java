class Solution {
    public String fractionAddition(String expression) {  
    int numerator = 0, denominator = 1;
        
        // Parse the expression
        int i = 0, n = expression.length();
        while (i < n) {
            // Read sign if any
            int sign = 1;
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-') {
                sign = expression.charAt(i) == '+' ? 1 : -1;
                i++;
            }
            
            // Read numerator
            int num = 0;
            while (i < n && Character.isDigit(expression.charAt(i))) {
                num = num * 10 + (expression.charAt(i) - '0');
                i++;
            }
            
            // Skip '/'
            i++;
            
            // Read denominator
            int denom = 0;
            while (i < n && Character.isDigit(expression.charAt(i))) {
                denom = denom * 10 + (expression.charAt(i) - '0');
                i++;
            }
            
            // Update the overall numerator and denominator
            numerator = numerator * denom + sign * num * denominator;
            denominator *= denom;
            
            // Reduce the fraction after each operation
            int gcd = gcd(Math.abs(numerator), denominator);
            numerator /= gcd;
            denominator /= gcd;
        }
        
        // If denominator is negative, move the negative sign to the numerator
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
        
        return numerator + "/" + denominator;
    }
    
    // Helper method to calculate the greatest common divisor (GCD)
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}