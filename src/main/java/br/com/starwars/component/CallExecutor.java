package br.com.starwars.component;

import br.com.starwars.client.SwApiIntegration;
import br.com.starwars.exception.IntegrationException;
import br.com.starwars.exception.ResourceNotFoundException;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Response;

@Component
@RequiredArgsConstructor
public class CallExecutor {

    CallIntegratorGenerator callGenerator;

    public SwApiIntegration createCall() {
        return callGenerator.createCall(SwApiIntegration.class);
    }

    public <T> Response<T> verifyStatus(Call<T> call) {
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
