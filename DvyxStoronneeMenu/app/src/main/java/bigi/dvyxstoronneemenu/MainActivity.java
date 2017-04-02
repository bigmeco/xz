package bigi.dvyxstoronneemenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClick(View view) {
        if (view instanceof TextView) {
            String title = ((TextView) view).getText().toString();
            if (title.startsWith(" onClick")) {

                Toast.makeText(this, title, Toast.LENGTH_SHORT).show();
            } else if (view.getId() == R.id.menOdin){
                Intent intent;
                intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            } else if (view.getId() == R.id.CERED){
                Intent intent;
                intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        } else if (view.getId() == R.id.userInfo) {
            Intent intent;
            intent = new Intent(MainActivity.this, Main2Activity.class);
            startActivity(intent);
        }
    }
}
