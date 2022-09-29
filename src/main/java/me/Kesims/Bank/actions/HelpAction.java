package me.Kesims.Bank.actions;

import me.Kesims.Bank.menu.MenuChoices;

public class HelpAction implements Action {
    @Override
    public void processAction() {
        MenuChoices.help();
    }
}
