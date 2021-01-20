import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 输出有效括号
 */
public class CorrectBracket {
    public boolean isVlaid(String s){
        Map<Character, Character> map = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
      if(s.length()%2!=0){
          return false;
      }
        Deque<Character> stack=new LinkedList<>();
      for(int i=0;i<s.length();i++){
          char ch= s.charAt(i);
          if(map.containsKey(ch)){
              if(stack.isEmpty()||stack.peek()!=map.get(ch)) {
            return false;
              }
              stack.pop();
          } else {
              stack.push(ch);
          }
      }
      return stack.isEmpty();
    }

    public static void main(String[] args) {
        String str="[}";
        CorrectBracket correctBracket = new CorrectBracket();
        System.out.println(correctBracket.isVlaid(str));

    }
}

