package br.com.starwars.service;

import br.com.starwars.exception.IntegrationException;
import br.com.starwars.exception.ResourceNotFoundException;
import java.io.IOException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Response;

@Component
public class CallExecutor {

    protected <T> Response<T> verifyStatus(Call<T> call) {
        Response<T> response;
        try {
            response = call.execute();
            if (!response.isSuccessful()) {
                if (HttpStatus.NOT_FOUND.equals(HttpStatus.valueOf(response.code()))) {
                    throw new ResourceNotFoundException();
                }
                throw new IntegrationException();
            }
            return response;
        } catch (IOException e) {
            throw new IntegrationException();
        }
    }
}
