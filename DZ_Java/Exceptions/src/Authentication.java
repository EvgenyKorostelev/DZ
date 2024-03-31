import repository.UsersRepository;
import service.DefaultUserService;
import service.ValidationChecking;

public class Authentication {

    public static void main(String[] args) {

        new UsersRepository().
                saveInFile(new ValidationChecking().
                    check(new DefaultUserService().
                        createUser()));

    }

}
