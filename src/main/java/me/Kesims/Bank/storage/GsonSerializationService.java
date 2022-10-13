package me.Kesims.Bank.storage;

import com.google.gson.Gson;

import javax.inject.Singleton;

@Singleton
public class GsonSerializationService implements StringSerialization{
    Gson gson = new Gson();

    @Override
    public String serialize(Object objectToSerialize) {
        return gson.toJson(objectToSerialize);
    }

    @Override
    public <T> T deserialize(String stringToDeserialize, Class<T> classOf) {
        return gson.fromJson(stringToDeserialize, classOf);
    }
}
