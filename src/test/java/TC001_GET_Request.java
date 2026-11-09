import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC001_GET_Request {
    //    public static void main(String args[]){
//        System.out.println("Hey");
//    }
    @Test
    void getWeatherDetails() {
        //Specify the Base URI
        RestAssured.baseURI = "https://api.qaautomationlabs.com/v1";
        //Request Object
        RequestSpecification httprequest = RestAssured.given();
        //Response object
        Response response = httprequest.request(Method.GET, "/users");
        String resbody = response.body().asString();

        System.out.println("Response body is: " + resbody);

        int statusCode = response.getStatusCode();
        System.out.println("Status code is:" + statusCode);
        Assert.assertEquals(statusCode, 200);

        System.out.println("Status line is : " + response.getStatusLine());

    }
}
