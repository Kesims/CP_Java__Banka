package me.Kesims.Bank.ui.cmd;

import javax.inject.Singleton;
import java.util.Scanner;

@Singleton
public class ScannerService {
    Scanner scanner = new Scanner(System.in);

    public String readString() {
        return scanner.next();
    }

    public int readInt() {
        return scanner.nextInt();
    }

    public float readFloat() {
        return scanner.nextFloat();
    }
}
