package creational_pattern.singleton_pattern;


//Lazy Loading (Not thread safe)
// class JudgeAnalayzer{
//     private static JudgeAnalayzer judgeAnalyzer;

//     private JudgeAnalayzer(){}

//     public static JudgeAnalayzer getInstance(){
//         if(judgeAnalyzer == null){
//             judgeAnalyzer = new JudgeAnalayzer();
//         }
//         return judgeAnalyzer;
//     }
// }

//Thread Safe Implementations
//1. Synchronized method
// class JudgeAnalayzer{
//     private static JudgeAnalayzer judgeAnalyzer;

//     private JudgeAnalayzer(){}

//     public static synchronized  JudgeAnalayzer getInstance(){
//         if(judgeAnalyzer == null){
//             judgeAnalyzer = new JudgeAnalayzer();
//         }
//         return judgeAnalyzer;
//     }
// }

//2. Double checking
// class JudgeAnalayzer{
//     private static volatile JudgeAnalayzer judgeAnalyzer;

//     private JudgeAnalayzer(){}

//     public static JudgeAnalayzer getInstance(){
//         if(judgeAnalyzer == null){
//             synchronized(JudgeAnalayzer.class){
//                 if(judgeAnalyzer == null){
//                     judgeAnalyzer = new JudgeAnalayzer();
//                 }
//             }
//         }
//         return judgeAnalyzer;
//     }
// }

//3.Bill Pugh Singleton (Best Practice for Lazy Loading)
class JudgeAnalayzer{
    private JudgeAnalayzer(){}

    private static class Holder{
        private static final JudgeAnalayzer judgeAnalayzer = new JudgeAnalayzer();
    }
    public static JudgeAnalayzer getInstance(){
        return Holder.judgeAnalayzer;
    }
}
public class LazyLoading {
    public static void main(String[] args) {
        JudgeAnalayzer j1 = JudgeAnalayzer.getInstance();
        JudgeAnalayzer j2 = JudgeAnalayzer.getInstance();

        System.out.println(j1);
        System.out.println(j2);
    }
}
