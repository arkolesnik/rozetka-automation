import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import org.json.JSONObject;

public class NoSeleniumDataProvider {

    protected static final String URL = "http://rozetka.com.ua";

    public JSONObject getJsonDataForProductByArticleNumber(String articleNumber) {
        try {
            HttpResponse<JsonNode> firstResponse = Unirest.post(URL + "/search/autocomplete/")
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .field("text", articleNumber)
                    .asJson();

            JSONObject jsonRootObject = firstResponse
                    .getBody()
                    .getObject()
                    .getJSONObject("content")
                    .getJSONObject("records")
                    .optJSONArray("goods")
                    .getJSONObject(0);
            Integer productId = jsonRootObject.getInt("id");

            HttpResponse<JsonNode> secondResponse = Unirest.get(
                    URL + "/recent_goods_sync/action=getRecentGoods;goods_ids=" + productId.toString() + "/")
                    .asJson();

            JSONObject jsonChildObject = secondResponse
                    .getBody()
                    .getObject()
                    .getJSONArray("content")
                    .getJSONObject(0);
            return jsonChildObject;

        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }
}
