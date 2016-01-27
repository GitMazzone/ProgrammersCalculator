public class RecursiveMath implements Math {

    public int inc(int n) {
        return n + 1;
    } // inc

    public int dec(int n) {
        return n - 1;
    } // dec

    public int add(int lhs, int rhs) {
        if(rhs == 0) return lhs;
        return add(inc(lhs), dec(rhs));
    } // add

    public int sub(int lhs, int rhs) {
        if(rhs == 0) return lhs;
        if(rhs > lhs) return 0;
        return sub(dec(lhs), dec(rhs));
    } // sub

    public int mul(int lhs, int rhs) {
        if(rhs == 0) return 0;
        return mul_acc(lhs, lhs, rhs);
    } // mul

    private int mul_acc(int sum, int lhs, int rhs) {
        if(rhs == 1) return sum;
        return mul_acc(add(sum, lhs), lhs, dec(rhs));
    } // mul_acc

    public int div(int lhs, int rhs) {
        //If dividing by 0, just return 0
        if(rhs <= 0) return 0;
	return div_acc(0, lhs, rhs);
    } // div

    private int div_acc(int counter, int lhs, int rhs) {
        if(lhs < rhs) return counter;
        return div_acc(inc(counter), sub(lhs, rhs), rhs);
    } // div_acc

    public int fac(int n) {
        if(n == 0) return 1;
        return fac_acc(1, n);
    } // fac

    private int fac_acc(int acc, int n) {
        if(n == 1) return acc;
        return fac_acc(mul(n, acc), dec(n));
    } // fac_acc
    

    public int pow(int lhs, int rhs) {
        if(rhs == 0) return 1;
        if(rhs == 1) return lhs;
        return pow_acc(1, lhs, rhs);
    } // pow
    
    private int pow_acc(int result, int lhs, int rhs) {
        if(rhs == 0) return result;
        return pow_acc(mul(result, lhs), lhs, dec(rhs));
    } // pow_acc

    public int lshift(int lhs, int rhs) {
        return lshift(lhs, lhs, rhs);
    }
    public int lshift(int acc, int lhs, int rhs) {
        if(rhs == 0) return acc;
        return lshift(mul(acc, 2), lhs, dec(rhs));
    }

    public int rshift(int lhs, int rhs) {
        return rshift(lhs, lhs, rhs);
    }
    public int rshift(int acc, int lhs, int rhs) {
        if(rhs == 0) return acc;
        return rshift(div(acc, 2), lhs, dec(rhs));
    }

} // RecursiveMath
