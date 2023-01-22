package APISteps;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class GenerateTokenSteps {

    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";

    //TO USE MY TOKEN IN THE PROJECT WE WILL USE STATIC VARIABLE

    public static String token;



    @Given("a JWT is generated")
    public void a_jwt_is_generated() {

        RequestSpecification request=given().header("Content-type", "application/json").body("{\n" +
                "\n" +
                "  \"email\": \"batch14khan@test.com\",\n" +
                "  \"password\": \"Test@123\"\n" +
                "}");

        Response response = request.when().post("/generateToken.php");

        //printing the response body
        // response.prettyPrint();
        token = "Bearer " + response.jsonPath().getString("token");
        System.out.println(token);



    }
}
