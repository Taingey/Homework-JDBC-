package view;
import controller.UserController;
import model.User;
import java.util.Scanner;

public class Main{
    private final static UserController userController = new UserController();
    public static void main(String[] args) {
        View.style();
        while (true) {
            switch (View.ui()) {
                case 1 -> {
                    userController.getAllUsers().forEach(System.out::println);
                }
                case 2 -> {
                    System.out.print("> Insert User ID: ");
                    System.out.println(userController.searchById(new Scanner(System.in).nextInt()));
                }
                case 3 -> {
                    User newUser = View.readUserInput();
                    userController.createUser(newUser);
                    System.out.println("User created successfully!");
                }
                case 4 -> {
                    System.out.print("> Insert User ID to update: ");
                    int userIdToUpdate = new Scanner(System.in).nextInt();
                    User updatedUser = View.readUserInput();
                    updatedUser.setUser_id(userIdToUpdate);
                    userController.updateUser(updatedUser);
                    System.out.println("User updated successfully!");
                }
                case 5 -> {
                    System.out.print("> Insert User ID to delete: ");
                    int userIdToDelete = new Scanner(System.in).nextInt();
                    userController.deleteUser(userIdToDelete);
                    System.out.println("User deleted successfully!");
                }case 6 -> {
                    System.out.print("Exiting.........");
                    return;
                }
                default -> {
                    System.out.println("No Option here");
                }
            }
        }
    }
}