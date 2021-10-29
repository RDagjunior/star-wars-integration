package br.com.starwars.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.concurrent.TimeUnit;
import lombok.RequiredArgsConstructor;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@RequiredArgsConstructor
@Service
public class CallIntegratorGenerator {

    @Value("${external-api.swapi}")
    private String urlSwapi;

    public <T> T createCall(Class<T> clientClass) {
        final var okHttpClient = new OkHttpClient.Builder()
                .readTimeout(2, TimeUnit.MINUTES).writeTimeout(2, TimeUnit.MINUTES)
                .connectTimeout(2, TimeUnit.MINUTES)
                .build();
        var retrofit = new Retrofit.Builder().baseUrl(urlSwapi).client(okHttpClient)
                .addConverterFactory(JacksonConverterFactory.create(new ObjectMapper())).build();
        return retrofit.create(clientClass);
    }
}
