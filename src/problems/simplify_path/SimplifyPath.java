//package problems.simplify_path;
//
//import java.util.Stack;
//
//public class SimplifyPath {
//    public static void main(String[] args) {
//        String path = "/home/";
//        SimplifyPath simplifyPath = new SimplifyPath();
//        System.out.println("result: " + simplifyPath.simplifyPath(path));
//    }
//
//    public String simplifyPath(String path) {
//        Stack<Character> stack = new Stack<>();
//        char[] pathChars = path.toCharArray();
//        for(int index = 0; index < pathChars.length; index++){
//            if(pathChars[index]=='/' && pathChars[index+1]=='/'){
//                index++;//skip if slash before (multi-slash)
//            }
//        }
//    }
//}
