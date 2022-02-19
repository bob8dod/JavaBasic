import java.util.*;

public class P11447 {
    public static String[] solution(String[] records) {
        Stack<String> stack = new Stack<>();
        Stack<String> result = new Stack<>();
        for(int i =0; i<records.length; i++){
            String[] scn = records[i].split(" ");
            //share
            if(scn[1].equals("share")) {
                if (stack.isEmpty() || !stack.peek().contains("shared")) {
                    stack.push(scn[0] + " shared your post");
                    continue;
                }


                String[] check = stack.pop().split(" ");
                if (check[1].equals("shared")) {
                    String make = check[0] + " and " + scn[0] + " shared your post";
                    stack.push(make);
                }
                else if (check[1].equals("and")) {
                    if (check[3].equals("others")) {
                        int N = Integer.parseInt(check[2]) + 1;
                        String make = check[0] + " and " + N + " others shared your post";
                        stack.push(make);
                    } else {
                        String make = check[0] + " and " + 2 + " others shared your post";
                        stack.push(make);
                    }
                }
            }

            else if(scn[1].equals("comment")) {
                if (stack.isEmpty() || !stack.peek().contains("commented")) {
                    stack.push(scn[0] + " commented your post");
                    continue;
                }

                String[] check2 = stack.pop().split(" ");
                if (check2[1].equals("commented")) {
                    String make = check2[0] + " and " + scn[0] + " commented your post";
                    stack.push(make);
                }
                else if (check2[1].equals("and")) {
                    if (check2[3].equals("others")) {
                        int N = Integer.parseInt(check2[2]) + 1;
                        String make = check2[0] + " and " + N + " others commented your post";
                        stack.push(make);
                    } else {
                        String make = check2[0] + " and " + 2 + " others commented your post";
                        stack.push(make);
                    }
                }
            }

            //notification
            else{
                result.push(stack.pop());
            }

        }
        return result.stream().toArray(String[]::new);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[] {"john share", "mary comment", "jay share", "check notification", "check notification", "sally comment", "james share", "check notification", "lee share", "laura share", "will share", "check notification", "alice comment", "check notification"})));
    }

}
