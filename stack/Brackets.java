
// This program checks whether an expression is valid with respect to brackets.
// usage: java Brackets "your expression here"
// e.g. java Brackets "if((a && b) && c))"
// sample result: The brackets are not balanced (invalid).

class Brackets{

    static boolean isValid(String expr){

        Stack<Character> bracketStack = new Stack<Character>();

        for(int i = 0; i < expr.length(); i++){

            char c = expr.charAt(i);

            if(c == '{' || c == '[' || c == '('){
                bracketStack.push(c);
            } else if(c == '}' || c == ']' || c == ')'){
                if(bracketStack.isEmpty()){
                    return false;
                }

                char d = bracketStack.pop();
                
                if(!((c == '}' && d == '{') || (c == ']' && d == '[') || 
                (c == ')' && d == '('))){
                    return false;
                }
            }
        }

        if(bracketStack.isEmpty()){
            return true;
        }
        
        return false;
    }

    public static void main(String[] args){
        if(args.length == 0){
            return;
        }

        if(isValid(args[0])){
            System.out.println("The brackets in this string are balanced (valid).");
        } else{
            System.out.println("The brackets are not balanced (invalid).");
        }
        
    }
}

