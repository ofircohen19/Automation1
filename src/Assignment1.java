public class Assignment1 {

    public Assignment1() {
    }
    public static boolean checkCorrectBinary(String num){
        int length = num.length();
        int dotNum = 0;
        int dot = findDot(num);
        for (int i = 0; i < length; i ++ ) {
            if (num.charAt(i) == '.') {
                dotNum += 1;
                if (dotNum > 1 || dot == 0 || dot == length-1) {
                    return false;
                }
            }
            else if (num.charAt(i) != '1' && num.charAt(i) != '0'){
                return false;
            }
        }
        return true;
    }
    public static int findDot(String num) {
        if (num.contains(".")) {
            int length = num.length();
            for (int i = 0; i <  length; i++){
                if (num.charAt(i) == '.'){
                    return i;
                }
            }
        }
        return -1;
    }

    public static double binaryToDecimal(String num) {
        int length = num.length();
        int dot = findDot(num);
        double ans = 0;
        if (dot == -1) {
            for (int i = length - 1; i >= 0; i--) {
                int numeric = Character.getNumericValue(num.charAt(i));
                double value = Math.pow(2,length - i - 1);
                ans += numeric * value;
            }
            return ans;
        }
        else {
            for (int i = dot - 1; i >= 0; i--) {
                int numeric = Character.getNumericValue(num.charAt(i));
                double value = Math.pow(2, dot-i-1);
                ans += numeric*value;
            }
            for (int j = dot +1; j < length; j++) {
                int numeric = Character.getNumericValue(num.charAt(j));
                double value = Math.pow(2,dot - j);
                ans += numeric * value ;
            }

            }
        return ans;
    }  public static void main(String[] args){
        System.out.println(checkCorrectBinary(".0.001"));
        System.out.println(findDot("1.001"));
        System.out.println(binaryToDecimal("101"));
        System.out.println(binaryToDecimal("1000"));
        System.out.println(binaryToDecimal("1000.01"));
        System.out.println(binaryToDecimal("11010.011"));
    }
}


