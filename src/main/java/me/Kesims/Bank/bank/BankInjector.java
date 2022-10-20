package me.Kesims.Bank.bank;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.MapBinder;
import me.Kesims.Bank.ui.actions.*;
import me.Kesims.Bank.ui.menu.MenuChoices;
import me.Kesims.Bank.storage.GsonSerializationService;
import me.Kesims.Bank.storage.IOFileStorageService;
import me.Kesims.Bank.storage.Storage;
import me.Kesims.Bank.storage.StringSerialization;

public class BankInjector extends AbstractModule {

    @Override
    protected void configure() {
        this.bind(Storage.class).to(IOFileStorageService.class);
        this.bind(StringSerialization.class).to(GsonSerializationService.class);

        MapBinder<MenuChoices, Action> uriBinder = MapBinder.newMapBinder(binder(), MenuChoices.class, Action.class);

        uriBinder.addBinding(MenuChoices.LOAD).to(LoadBankAction.class);
        uriBinder.addBinding(MenuChoices.HELP).to(HelpAction.class);
        uriBinder.addBinding(MenuChoices.DETAIL).to(DetailAction.class);
        uriBinder.addBinding(MenuChoices.SAVE).to(SaveBankAction.class);
        uriBinder.addBinding(MenuChoices.CREATE_PERSON).to(CreatePersonAction.class);
    }
}
