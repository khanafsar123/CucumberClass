package Api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;

public class HardcodedExamples {


static String employee_id;
    //one thing to remember
    //base URI - base URL
    //end then using when keyword, we will send the end point

    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";

    String token="Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2NzQzMTM5OTQsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY3NDM1NzE5NCwidXNlcklkIjoiNDc4MiJ9.T9wOyfgehVbs8lpwtx8Rn-Qdf0DgIt-vLjkDhOurkvU";

    @Test
    public void getOneEmployee(){
        //prepare the request
        //to prepare the request, we use request specification
        RequestSpecification request = given().header("Authorization", token)
                .header("Content-Type", "application/json")
                .queryParam("employee_id", "46202A");

        //to hit the end point/ to make the request which will return response
        Response response = request.when().get("/getOneEmployee.php");

        // System.out.println(response.asString());
        response.prettyPrint();
        //verifying the status code
        response.then().assertThat().statusCode(200);

        //using jsonpath method, we are extracting the value from the response body
        String firstName = response.jsonPath().getString("employee.emp_firstname");
        System.out.println(firstName);
        //first way of assertion
        Assert.assertEquals(firstName, employee_id);

        //second way of assertion to verify the value in response body using hamcrest matchers
        response.then().assertThat().body("employee.emp_firstname", equalTo("sohel"));


    }

    @Test
    public void createEmployee(){
        RequestSpecification request = given().header("Authorization", token)
                .header("Content-Type", "application/json").
                body("{\n" +
                        "        \"employee_id\": \"46091A\",\n" +
                        "        \"emp_firstname\": \"Ab\",\n" +
                        "        \"emp_middle_name\": \"Khan\",\n" +
                        "        \"emp_lastname\": \"Develiers\",\n" +
                        "        \"emp_birthday\": \"2021-01-14\",\n" +
                        "        \"emp_job_title\": \"developer\",\n" +
                        "        \"emp_status\": \"not Employed\"\n" +
                        "    }");
        Response response = request.when().post("/createEmployee.php");
        response.prettyPrint();
        //verfying the statuys code which is 201
        response.then().assertThat().statusCode(201);
        //getting the employee id from the response and use it as static one
        employee_id = response.jsonPath().getString("Employee.employee_id");
        System.out.println(employee_id);

        response.then().assertThat().body("Employee.emp_lastname", equalTo("bou"));
        response.then().assertThat().body("Employee.emp_middle_name", equalTo("ms"));
        //verify console header
        response.then().assertThat().header("Server", "Apache/2.4.39 (Win64) PHP/7.2.18");
    }


    public void updateEmployee(){
        RequestSpecification request = given().header("Authorization", token)
                .header("Content-Type", "application/json").
                body("{\n" +
                        "        \"employee_id\": \"\"+ employee_id +\"\",\n" +
                        "        \"emp_firstname\": \"Ab\",\n" +
                        "        \"emp_middle_name\": \"Khan\",\n" +
                        "        \"emp_lastname\": \"Develiers\",\n" +
                        "        \"emp_birthday\": \"2021-01-14\",\n" +
                        "        \"emp_job_title\": \"developer\",\n" +
                        "        \"emp_status\": \"not Employed\"\n" +
                        "    }");

        Response response = request.when().put("/updateEmployee.php");

        //verification
        response.then().assertThat().statusCode(200);
        response.then().assertThat().body("Message", equalTo("Employee record Updated"));
    }

    public void getUpdatedCode(){
        RequestSpecification request = given().header("Authorization", token)
                .header("Content-Type", "application/json")
                .queryParam("employee_id", employee_id);

        //to hit the end point/ to make the request which will return response
        Response response = request.when().get("/getOneEmployee.php");

        // System.out.println(response.asString());
        response.prettyPrint();
        //verifying the status code
        response.then().assertThat().statusCode(200);
        response.then().assertThat().body("employee.emp_job_title", equalTo("qa"));
    }







}
