package com.bitweb.votingapp.worker.service;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * This is a wrapper class for JSON serialization/deserialization
 */
@Service
@RequiredArgsConstructor
public class JSONService {

    private final Gson gson;

    private final GsonJsonParser gsonJsonParser;

    public final String toJson(final Map<String, Object> map) {
        return gson.toJson(map);
    }

    public final String toJson(final Object src) {
        return gson.toJson(src);
    }

    public final String toJson(final Object src, final Gson gsonObj) {
        return gsonObj.toJson(src);
    }

    public final Map<String, Object> fromJson(final String json) {
        return gsonJsonParser.parseMap(json);
    }

    public final <T> T fromJsonToObj(final String json, final Class<T> cls) {
        return gson.fromJson(json, cls);
    }
}
