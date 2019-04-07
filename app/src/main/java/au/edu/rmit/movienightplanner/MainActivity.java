package au.edu.rmit.movienightplanner;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

import au.edu.rmit.movienightplanner.model.AbstractEvent;


public class MainActivity extends AppCompatActivity {

    private final String LOG_TAG = getClass().getName();

    public static final String TAG = "MainActivity";
    public static Context appContext;

    private static Scanner scanner;
    private EventModel eventModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.appContext = getApplicationContext();

        //Singleton reference for EventModel
        this.eventModel = EventModel.getEventModel();
        try {
            this.eventModel.loadData();
            for (Map.Entry<UUID, AbstractEvent> e:
                 this.eventModel.viewEvents().entrySet()) {
                Log.i(TAG, e.getValue().toString());

            }
        } catch (IOException e) {
            Log.e("MainActivity:", e.getMessage());
        }




    }
}
