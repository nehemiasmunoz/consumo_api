package com.marvic.services.conversor;

public interface IDataConversor {
    <T> T getData(String json, Class<T> clazz);
}
