package com.geekbrains.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

public final class ResponseUtils {

    private ResponseUtils() {}

    public static <T> T executeCall(Call<T> call) {

        try {

            Response<T> response = call.execute();

            if (response.isSuccessful()) {
                return response.body();
            }

            ResponseBody errorBody = response.errorBody();

            if (errorBody != null) {
                String errorText = errorBody.string();
                throw new RuntimeException(errorText);
            }

            throw new RuntimeException("Retrofit unknown exception");

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}