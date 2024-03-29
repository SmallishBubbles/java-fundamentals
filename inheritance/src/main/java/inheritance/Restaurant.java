package inheritance;

import java.util.LinkedList;

public class Restaurant implements Business {
    String name;
    int priceCategory;
    LinkedList<Review> reviews = new LinkedList<>();

    public Restaurant(String name, int priceCategory){
        this.name = name;
        this.priceCategory = priceCategory;
    }

    public String getName(){
        return this.name;
    }

    public LinkedList<Review> getReviews() {
        return this.reviews;
    }

    public void addReview(Review review){
        if ( review.linkedBusiness == null && review.getClass() != MovieReview.class ){
            review.linkedBusiness = this;
            reviews.add(review);
        } else {
            // this review has already been added to a business or is a movie review, do nothing
        }
    }

    public float calcStars(){
        float stars = 0.0f;

        if (reviews.size() > 0) {
            for (int i = 0; i < reviews.size(); i++) {
                stars += reviews.get(i).numStars;
            }
            stars = stars / reviews.size();
        }

        return stars;
    }

    public String toString(){
        return String.format("%s is a restaurant with %.1f stars, %d reviews, and a price category of %d", name, calcStars(), reviews.size(), priceCategory);
    }

}
