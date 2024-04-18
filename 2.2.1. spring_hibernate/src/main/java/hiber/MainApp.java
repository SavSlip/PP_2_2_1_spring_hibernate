package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        userService.addUser(new User("User1", "Lastname1", "user1@mail.ru"
                , new Car("Car1", 1)));
        userService.addUser(new User("User2", "Lastname2", "user2@mail.ru"
                , new Car("Car2", 2)));
        userService.addUser(new User("User3", "Lastname3", "user3@mail.ru"
                , new Car("Car3", 3)));
        userService.addUser(new User("User4", "Lastname4", "user4@mail.ru"
                , new Car("Car4", 4)));

        List<User> users = userService.getAllUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Model car = " + user.getCar().getModel());
            System.out.println("Number series = " + user.getCar().getModel());
            System.out.println();
        }

        User user = userService.findByCar("Car3", 3);
        System.out.println("Id = " + user.getId());
        System.out.println("First Name = " + user.getFirstName());
        System.out.println("Last Name = " + user.getLastName());
        System.out.println("Email = " + user.getEmail());

        context.close();
    }
}
