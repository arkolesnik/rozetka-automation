import org.json.JSONObject;
import org.junit.Test;
import org.junit.Assert;

public class NoSeleniumTest {

    public static final String ARTICLE_NUMBER = "5000299223017";
    public static final String COMMENTS_KEY = "count_comments";

    public static final int EXPECTED_COMMENTS_NUMBER = 50;
    public static final int EXPECTED_RATING = 5;

    @Test
    public void testProductByArticleNumber() {
        NoSeleniumDataProvider dataProvider = new NoSeleniumDataProvider();
        JSONObject jsonObject = dataProvider.getJsonDataForProductByArticleNumber(ARTICLE_NUMBER);

        int commentsNumber = Integer.valueOf(jsonObject.getString(COMMENTS_KEY));
        int rating = jsonObject.getInt("users_rating");
        String usdPrice = jsonObject.getString("price_usd");

        System.out.println("Price for this product in USD is: " + usdPrice);
        StringBuilder error = new StringBuilder();
        if (EXPECTED_COMMENTS_NUMBER != commentsNumber) {
            error.append("Number of comments is not as expected! \n");
        }
        if (EXPECTED_RATING != rating) {
            error.append("Number of stars is not as expected! \n");
        }
        Assert.assertTrue(error.toString(), error.toString().isEmpty());
    }
}
