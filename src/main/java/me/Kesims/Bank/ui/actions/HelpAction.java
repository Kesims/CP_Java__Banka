package me.Kesims.Bank.ui.actions;

import me.Kesims.Bank.ui.menu.MenuChoices;

public class HelpAction implements Action {
    @Override
    public void processAction() {
        MenuChoices.help();
    }
}
