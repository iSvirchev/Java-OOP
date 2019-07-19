public class MathOperation {
    
    public int add(int... args){
        int sum = 0;

        for (int i = 0; i < args.length; i++) {
            sum+=args[i];
        }

        return sum;
    }

}
