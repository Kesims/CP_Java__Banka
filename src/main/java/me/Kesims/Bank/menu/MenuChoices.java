package me.Kesims.Bank.menu;

public enum MenuChoices {
    HELP, CREATE_PERSON, DETAIL, ACCOUNTS, CREDIT, SAVING, LOAD, SAVE, EXIT, INVALID_CHOICE;

    public static MenuChoices getChoiceFromInt(int choice) {
        return switch (choice) {
            case 1 -> HELP;
            case 2 -> CREATE_PERSON;
            case 3 -> DETAIL;
            case 4 -> ACCOUNTS;
            case 5 -> CREDIT;
            case 6 -> SAVING;
            case 7 -> LOAD;
            case 8 -> SAVE;
            case 0 -> EXIT;
            default -> INVALID_CHOICE;
        };
    }

    public static void help() {
        System.out.println("MENU:");

        System.out.println(":: HELP: 1");
        System.out.println(":: CREATE_PERSON: 2");
        System.out.println(":: DETAIL: 3");
        System.out.println(":: ACCOUNTS: 4");
        System.out.println(":: CREDIT: 5");
        System.out.println(":: SAVING: 6");
        System.out.println(":: LOAD: 7");
        System.out.println(":: SAVE: 8");
        System.out.println(":: EXIT: 0");
    }
}
