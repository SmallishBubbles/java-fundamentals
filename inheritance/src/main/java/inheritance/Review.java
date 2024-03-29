package inheritance;

public class Review {
    String author;
    float numStars;
    String body;
    Business linkedBusiness = null;

    public Review(String author, float numStars, String body){
        this.author = author;
        this.numStars = checkStars(numStars);
        this.body = body;
    }

    public Review(float numStars, String body){
        this("Anonymous", numStars, body);
    }

    public Review(float numStars){
        this("Anonymous", numStars, "");
    }

    // limit range
    // https://stackoverflow.com/questions/8420668/setting-a-range-for-an-integer-in-java
    private float checkStars(float numStars){
        if ( numStars >= 0f && numStars <= 5f) {
            return numStars;
        } else {
            throw new IllegalArgumentException("numStars out of range. Please choose a float between 0 and 5");
        }
    }

    public void updateStars(float newNumStars){
        this.numStars = newNumStars;
    }

    public String toString(){
        return String.format("A %.1f star review of %s by %s: %s", numStars, linkedBusiness.getName(), author, body);
    }
}
