package android.example.hw_database.activities.activities;

import android.content.Intent;
import android.example.hw_database.R;
import android.example.hw_database.activities.database.DBHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button add_btn,update_btn,delete_btn;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init(){
        add_btn=findViewById(R.id.add_button);
        update_btn=findViewById(R.id.update_button);
        delete_btn=findViewById(R.id.delete_button);

        add_btn.setOnClickListener(this);
        update_btn.setOnClickListener(this);
        delete_btn.setOnClickListener(this);

        dbHelper=new DBHelper(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_button:
                Intent intent=new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
                break;
            case R.id.update_button:
                startActivity(new Intent(MainActivity.this, UpdateActivity.class));
                break;
            case R.id.delete_button:
                startActivity(new Intent(MainActivity.this, DeleteActivity.class));
                break;
        }
    }
}

