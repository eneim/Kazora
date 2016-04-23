package im.ene.lab.kazora;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import im.ene.lab.kazora.presentation.home.HomeActivity;

public class MainActivity extends AppCompatActivity {

  // Setup this Activity's background as a launch splash screen
  // Start at once, then open HomeActivity
  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    startActivity(new Intent(this, HomeActivity.class));
    finish();
  }
}
