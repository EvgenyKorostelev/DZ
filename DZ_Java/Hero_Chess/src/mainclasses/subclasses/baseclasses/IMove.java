package mainclasses.subclasses.baseclasses;

import java.util.ArrayList;

public interface IMove {
    //Метод порядка действий юнита за один раунд
    void step(ArrayList<BaseClass> enemy, ArrayList<BaseClass> allies);
}
