package creational_pattern.singleton_pattern;

class JudgeAnalytics{
    private static final JudgeAnalytics judgeAnalytics  = new JudgeAnalytics();

    private JudgeAnalytics(){}

    public static JudgeAnalytics getInstance(){
        return judgeAnalytics;
    }
}
public class EagerLoading {
    public static void main(String[] args) {
        JudgeAnalytics judgeAnalytics = JudgeAnalytics.getInstance();
        JudgeAnalytics judgeAnalytics1 = JudgeAnalytics.getInstance();

        System.out.println(judgeAnalytics);
        System.out.println(judgeAnalytics1);
    }
}
