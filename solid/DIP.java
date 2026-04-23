package solid;
//high level module should not depend on low level module , they both should depend on abstractions. abstractions should not depend on details. details should depend on abstraction


//netflix recommendation engine based on dip


interface RecommendationStrategy{
    public void getRecommendation();
}

class RecentlyAdded implements  RecommendationStrategy{

    @Override
    public void getRecommendation(){
        System.out.println("showing recently added recommendations....");
    }
}

class GenreBased implements RecommendationStrategy{
    
    @Override
    public void getRecommendation(){
        System.out.println("showing genre based recommendations......");
    }
}

class RecommendationEngine{

    public RecommendationEngine(RecommendationStrategy strategy){
    }

    public void fetchRecommendations(RecommendationStrategy strategy){
        strategy.getRecommendation();
    }
}
public class DIP {
    public static void main(String[] args) {
        RecommendationStrategy strategy = new RecentlyAdded();
        RecommendationStrategy strategy2 = new GenreBased();
        RecommendationEngine engine = new RecommendationEngine(strategy);
        RecommendationEngine engine2 = new RecommendationEngine(strategy2);

        engine.fetchRecommendations(strategy);
        engine2.fetchRecommendations(strategy2);


    }
}
