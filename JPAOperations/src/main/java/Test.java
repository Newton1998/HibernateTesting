import util.JPAOperations;

public class Test {
    public static void main(String[] args) {
        JPAOperations.createEmployee();
        JPAOperations.findEmployee();
        JPAOperations.updateEmployee();
        JPAOperations.deleteEmployee();
    }
}
