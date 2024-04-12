import repository.UsersRepository;
import service.DefaultUserService;
import service.ValidationChecking;


public class ServiceApplication {

    public static void main(String[] args) {
        System.out.println("Введите данные пользователя через пробел:");
        new UsersRepository().
                saveInFile(new ValidationChecking().
                        check(new DefaultUserService().
                                createUser()));
    }

}
