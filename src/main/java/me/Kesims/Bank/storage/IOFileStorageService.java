package me.Kesims.Bank.storage;

import me.Kesims.Bank.io.IO;

import javax.inject.Singleton;
import java.io.IOException;

@Singleton
public class IOFileStorageService implements Storage {
    
    @Override
    public void save(String data, String path) {
        try {
            IO.writeFile(path, data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String load(String path) {
        try {
            return IO.readFile(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
