package com.rachel.attendance.Auth;

import static androidx.fragment.app.FragmentManager.TAG;

import androidx.appcompat.app.AppCompatActivity;
import com.google.gson.annotations.SerializedName;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.rachel.attendance.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public class LoginActivity extends AppCompatActivity {
    private EditText etIdNumber, etPassword;
    private Button btnLogin;
    private ApiInterface apiInterface;




    public class User {
        public String forename;
        public String surname;
        public String tscNumber;
        public String idNumber;
        public String employer;
        public String employerType;
        public String password;
        public String department;
        public String phoneNumber;

        public User(String forename, String surname, String tscNumber, String idNumber, String employer, String employerType, String password, String department, String phoneNumber) {
            this.forename = forename;
            this.surname = surname;
            this.tscNumber = tscNumber;
            this.idNumber = idNumber;
            this.employer = employer;
            this.employerType = employerType;
            this.password = password;
            this.department = department;
            this.phoneNumber = phoneNumber;
        }

        public String getForename() {
            return forename;
        }

        public void setForename(String forename) {
            this.forename = forename;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public String getTscNumber() {
            return tscNumber;
        }

        public void setTscNumber(String tscNumber) {
            this.tscNumber = tscNumber;
        }

        public String getIdNumber() {
            return idNumber;
        }

        public void setIdNumber(String idNumber) {
            this.idNumber = idNumber;
        }

        public String getEmployer() {
            return employer;
        }

        public void setEmployer(String employer) {
            this.employer = employer;
        }

        public String getEmployerType() {
            return employerType;
        }

        public void setEmployerType(String employerType) {
            this.employerType = employerType;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }
    }


    public interface ApiInterface {
        @FormUrlEncoded
        @POST("api//Authentication/teacher/login") // Replace with the endpoint for login
        Call<User> login(
                @Field("forename") String forename,
                @Field("surname") String surname,
                @Field("tscNumber") String tscNumber,
                @Field("idNumber") String idNumber,
                @Field("employer") String employer,
                @Field("employerType") String employerType,
                @Field("password") String password,
                @Field("department") String department,
                @Field("phoneNumber") String phoneNumber
        );
    }
    public static Retrofit retrofit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize the Retrofit instance
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://172.27.192.1:5278/") // Replace with your API base URL
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }




        // Find views by their IDs
        etIdNumber = findViewById(R.id.editTextIdNumber);
        etPassword = findViewById(R.id.editTextPassword);
        btnLogin = findViewById(R.id.signin);

        // Set click listener for the login button
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               signIn();
            }
        });
    }

    private void signIn() {
        // Create an instance of the API interface
        apiInterface = retrofit.create(ApiInterface.class);
        // Get the input values
        String idNumber = etIdNumber.getText().toString();
        String password = etPassword.getText().toString();

        // Make the API call
        Call<User> call = apiInterface.login("","","",idNumber,"","" ,password,"","");
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.e("","OnResponse: " + response.code());
                Log.e("","OnResponse: " + response.body().getForename());
                Log.e("","OnResponse: " + response.body().getSurname());
                Log.e("","OnResponse: " + response.body().getDepartment());
                Log.e("","OnResponse: " + response.body().getPhoneNumber());
                Log.e("","OnResponse: " + response.body().getPassword());
                Log.e("","OnResponse: " + response.body().getEmployer());

//                if (response.isSuccessful()) {
//                    // Handle successful login
//                    User user = response.body();
//                    // TODO: Implement your logic here
//                    Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
//                } else {
//                    // Handle failed login
//                    Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
//                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                // Handle API call failure
                Toast.makeText(LoginActivity.this, "API Call Failed", Toast.LENGTH_SHORT).show();
            }


        });
    }
}
