package me.Kesims.Bank.actions;

import me.Kesims.Bank.menu.MenuChoices;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Map;

@Singleton
public class ActionProcessService {
    @Inject
    private Map<MenuChoices, Action> registeredActions;

    public void processAction(MenuChoices menuChoices) {
        Action action = this.registeredActions.get(menuChoices);
        if(action != null) {
            action.processAction();
        }
    }
}
