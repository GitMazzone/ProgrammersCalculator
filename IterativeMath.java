public class IterativeMath implements Math {

    public int inc(int n) {
        return n + 1;
    } // inc

    public int dec(int n) {
        return n - 1;
    } // dec

    public int add(int lhs, int rhs) {
        int sum = lhs;
        if(rhs == 0) return lhs;
        while(rhs > 0) {
            sum = inc(sum);
            rhs = dec(rhs);
        }
        return sum;
    } // add

    public int sub(int lhs, int rhs) {
        int diff = lhs;
        if(rhs == 0) return lhs;
        while(rhs > 0) {
            diff = dec(diff);
            rhs = dec(rhs);
        }
        return diff;
    } // sub

    public int mul(int lhs, int rhs) {
        int product = lhs;
        if(rhs == 0) return 0;
        if(rhs == 1) return lhs;
        while(rhs > 1) {
            product = add(product, lhs);
            rhs = dec(rhs);
        }
        return product;
    } // mul

    public int div(int lhs, int rhs) {
        int quotient = 0;
        //If dividing by 0, just return 0
        if(rhs == 0) return 0;
        if(rhs == 1) return lhs;
        while(sub(lhs, rhs) >= 0) {
            lhs = sub(lhs, rhs);
            quotient = inc(quotient);
        }
        return quotient;
    } // div

    public int fac(int n) {
        int factorial = 1;
        int i = n;

        while(i > 0) {
            factorial = mul(factorial, i);
            i = dec(i);
        }
        return factorial;
    } // fac

    public int pow(int lhs, int rhs) {
        int result = lhs;
        if(rhs == 0) return 1;
        if(rhs == 1) return lhs;
        while(rhs > 1) {
            result = mul(result, lhs);
            rhs = dec(rhs);
        }
        return result;
    } // pow

    public int lshift(int lhs, int rhs) {
        if(rhs == 0) return lhs;
        while(rhs > 0) {
            lhs = mul(lhs, 2);
            rhs = dec(rhs);
        }
        return lhs;
    }

    public int rshift(int lhs, int rhs) {
        if(rhs == 0) return lhs;
        while(rhs > 0) {
            lhs = div(lhs, 2);
            rhs = dec(rhs);
        }
        return lhs;
    }

} // IterativeMath
