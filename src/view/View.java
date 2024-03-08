package view;

import controller.UserController;
import model.User;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;
import java.util.Scanner;

public class View {
    private final static UserController userController = new UserController();

    public static int ui() {
        System.out.println("\n> Welcome to our program.");
        System.out.println("""
       ╔════════════════════════════════════════════════════════════════════════╗
       ║ [1]. Get all users  |  [2]. Search user by ID   |  [3]. Create user    ║
       ║ [4]. Update user    |  [5]. Delete user         |  [6]. Exit           ║
       ╚════════════════════════════════════════════════════════════════════════╝
        """);
        System.out.print("> Chose Option: ");
        return new Scanner(System.in).nextInt();
    }

    public static User readUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter user UUID: ");
        String user_uuid = scanner.nextLine();
        System.out.print("Enter user name: ");
        String user_name = scanner.nextLine();
        System.out.print("Enter user email: ");
        String user_email = scanner.nextLine();
        System.out.print("Enter user password: ");
        String user_password = scanner.nextLine();
        System.out.print("Is deleted (true/false): ");
        boolean is_deleted = scanner.nextBoolean();
        System.out.print("Is verified (true/false): ");
        boolean is_verified = scanner.nextBoolean();
        return new User(user_uuid, user_name, user_email, user_password, is_deleted, is_verified);
    }

    public static void style(){
        System.out.println("""
                 
                 
                 
                 __       __          __                                                __                    ______   ______  ________  ______  _______ \s
                |  \\  _  |  \\        |  \\                                              |  \\                  /      \\ /      \\|        \\/      \\|       \\\s
                | ▓▓ / \\ | ▓▓ ______ | ▓▓ _______  ______  ______ ____   ______       _| ▓▓_    ______      |  ▓▓▓▓▓▓\\  ▓▓▓▓▓▓\\\\▓▓▓▓▓▓▓▓  ▓▓▓▓▓▓\\ ▓▓▓▓▓▓▓\\
                | ▓▓/  ▓\\| ▓▓/      \\| ▓▓/       \\/      \\|      \\    \\ /      \\     |   ▓▓ \\  /      \\     | ▓▓   \\▓▓ ▓▓___\\▓▓  | ▓▓  | ▓▓__| ▓▓ ▓▓  | ▓▓
                | ▓▓  ▓▓▓\\ ▓▓  ▓▓▓▓▓▓\\ ▓▓  ▓▓▓▓▓▓▓  ▓▓▓▓▓▓\\ ▓▓▓▓▓▓\\▓▓▓▓\\  ▓▓▓▓▓▓\\     \\▓▓▓▓▓▓ |  ▓▓▓▓▓▓\\    | ▓▓      \\▓▓    \\   | ▓▓  | ▓▓    ▓▓ ▓▓  | ▓▓
                | ▓▓ ▓▓\\▓▓\\▓▓ ▓▓    ▓▓ ▓▓ ▓▓     | ▓▓  | ▓▓ ▓▓ | ▓▓ | ▓▓ ▓▓    ▓▓      | ▓▓ __| ▓▓  | ▓▓    | ▓▓   __ _\\▓▓▓▓▓▓\\  | ▓▓  | ▓▓▓▓▓▓▓▓ ▓▓  | ▓▓
                | ▓▓▓▓  \\▓▓▓▓ ▓▓▓▓▓▓▓▓ ▓▓ ▓▓_____| ▓▓__/ ▓▓ ▓▓ | ▓▓ | ▓▓ ▓▓▓▓▓▓▓▓      | ▓▓|  \\ ▓▓__/ ▓▓    | ▓▓__/  \\  \\__| ▓▓  | ▓▓  | ▓▓  | ▓▓ ▓▓__/ ▓▓
                | ▓▓▓    \\▓▓▓\\▓▓     \\ ▓▓\\▓▓     \\\\▓▓    ▓▓ ▓▓ | ▓▓ | ▓▓\\▓▓     \\       \\▓▓  ▓▓\\▓▓    ▓▓     \\▓▓    ▓▓\\▓▓    ▓▓  | ▓▓  | ▓▓  | ▓▓ ▓▓    ▓▓
                 \\▓▓      \\▓▓ \\▓▓▓▓▓▓▓\\▓▓ \\▓▓▓▓▓▓▓ \\▓▓▓▓▓▓ \\▓▓  \\▓▓  \\▓▓ \\▓▓▓▓▓▓▓        \\▓▓▓▓  \\▓▓▓▓▓▓       \\▓▓▓▓▓▓  \\▓▓▓▓▓▓    \\▓▓   \\▓▓   \\▓▓\\▓▓▓▓▓▓▓\s
                                                                                                                                                         \s
                                                                                                                                                         \s
      """);
    }

}
