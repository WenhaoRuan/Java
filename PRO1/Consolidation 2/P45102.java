import java.io.*;

class Main{
    private static BufferedInputStream bis = new BufferedInputStream(System.in);
    
    public static int nextChar()throws IOException{
        int n;
        while((n = bis.read()) <= ' ' && n != -1);
        return n;
    }
        
    public static int evaluate()throws IOException{
        int n = nextChar();
        if(n == -1) return n;
        if(n >= '0' && n <= '9') return n - '0';
        else if(n == '('){
            int left = evaluate();
            int op = nextChar();
            int right = evaluate();
            nextChar();
            return switch(op){
                case '-' -> left - right;
                case '+' -> left + right;
                case '*' -> left * right;
                default -> 0;
            };
        }
        return 0;
    }
   
    public static void main(String[] args)throws IOException{
        System.out.println(evaluate());
    }
}
