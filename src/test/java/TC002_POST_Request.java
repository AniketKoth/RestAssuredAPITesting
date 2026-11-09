import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC002_POST_Request {

    @Test
    void putRegistrationDetails(){
        RestAssured.baseURI="https://api.qaautomationlabs.com/v1";

        RequestSpecification httprequest = RestAssured.given();

        JSONObject reqparam = new JSONObject();

        reqparam.put("firstName","Alex");
        reqparam.put("lastName","Kothawade");
        reqparam.put("email","ank@gmail.com");
        reqparam.put("role","SDET");

        httprequest.header("Content-Type","application/json");
        httprequest.body(reqparam.toJSONString());

        Response response=httprequest.request(Method.POST,"/users");

        String reqbod = response.getBody().asString();
        System.out.println("Body is :"+reqbod);

        int statusCode = response.getStatusCode();
        System.out.println("Status Code is :"+statusCode);
        Assert.assertEquals(statusCode,201);

        String scode = response.jsonPath().get("SuccessCode");
        System.out.println(scode);


    }
}
