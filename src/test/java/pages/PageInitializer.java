package pages;

public class PageInitializer {
    public static LoginPage login;
    public static DashboardPage dashboard;

    public static AddEmployeePage addEmployee;



    // we need method to initialize

    public static void intializePageObjects(){
        login = new LoginPage();
        dashboard = new DashboardPage();
        addEmployee = new AddEmployeePage();
    }







}
