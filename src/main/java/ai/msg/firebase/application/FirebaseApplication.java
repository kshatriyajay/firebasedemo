package ai.msg.firebase.application;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;

@SpringBootApplication
public class FirebaseApplication {

    public static void main(String[] args) {
        FileInputStream serviceAccount = null;
        try {
            serviceAccount = new FileInputStream("/Users/jayshaktawat/Downloads/fir-demoapplication-4b104-firebase-adminsdk-lsj9p-3fae690c96.json");


            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://fir-demoapplication-4b104.firebaseio.com")
                    .build();

            FirebaseApp.initializeApp(options);
//            SpringApplication.run(FirebaseApplication.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
