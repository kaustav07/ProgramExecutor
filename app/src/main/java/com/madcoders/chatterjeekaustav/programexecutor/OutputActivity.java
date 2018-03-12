package com.madcoders.chatterjeekaustav.programexecutor;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.github.ybq.android.spinkit.SpinKitView;
import com.madcoders.chatterjeekaustav.programexecutor.Model.ProgramRequest;
import com.madcoders.chatterjeekaustav.programexecutor.Model.ProgramResponse;
import com.madcoders.chatterjeekaustav.programexecutor.Network.JDoodleService;

import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class OutputActivity extends AppCompatActivity {

    TextView textView;
    SpinKitView mSpinKitView;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);
        textView = findViewById(R.id.programoutput);
        mSpinKitView = findViewById(R.id.spin_kit);
        mSpinKitView.setVisibility(View.INVISIBLE);


    }

    public void runProgram(View view){
        mSpinKitView.setIndeterminate(true);
        mSpinKitView.setVisibility(View.VISIBLE);
        textView.setText(R.string.outputPlaceHolder);
        try {
            executeProgram(textView);
        } catch (IOException e) {
            textView.setText("Error - " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void executeProgram(final TextView textView) throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(JDoodleService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JDoodleService jDoodleService = retrofit.create(JDoodleService.class);

        ProgramRequest programRequest = new ProgramRequest();
        programRequest.setClientId("863c93d8d6be56e65a430517207ecf1b");
        programRequest.setClientSecret("3eae51c09e2e795b2451829dc4e7a8415aed52bfc92f204287d40a5147f3b94d");
        programRequest.setLanguage("c");
        programRequest.setVersionIndex("0");
       /* programRequest.setScript("#include <stdio.h>\n" +
                "int main(void)\n" +
                "{\n" +
                "printf(\"Hello World\\ngo\");\n" +
                "return 0;\n" +
                "}");*/
       programRequest.setScript(getProgram());

        Call<ProgramResponse> responseCall = jDoodleService.executeProgram(programRequest);

        responseCall.enqueue(new Callback<ProgramResponse>() {
            @Override
            public void onResponse(Call<ProgramResponse> call, Response<ProgramResponse> response) {
                mSpinKitView.setIndeterminate(false);
                mSpinKitView.setVisibility(View.INVISIBLE);
                textView.setText(response.body().getOutput());
            }

            @Override
            public void onFailure(Call<ProgramResponse> call, Throwable t) {
                mSpinKitView.setIndeterminate(false);
                mSpinKitView.setVisibility(View.INVISIBLE);
                textView.setText(t.getMessage());
            }
        });
    }

    private String getProgram() throws IOException {
        InputStream stream = this.getResources().openRawResource(R.raw.program);
        String program = IOUtils.toString(stream);
        IOUtils.closeQuietly(stream);
        return program;
    }

}

