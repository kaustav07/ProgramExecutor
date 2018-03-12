package com.madcoders.chatterjeekaustav.programexecutor.Network;

import com.madcoders.chatterjeekaustav.programexecutor.Model.ProgramRequest;
import com.madcoders.chatterjeekaustav.programexecutor.Model.ProgramResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Kaustav on 06-03-2018.
 */

public interface JDoodleService {

    String BASE_URL = "https://api.jdoodle.com/v1/";

    @POST("execute")
    Call<ProgramResponse> executeProgram(@Body ProgramRequest request);
}
