package android.example.hw_database.activities.activities;

import android.example.hw_database.R;
import android.example.hw_database.activities.database.DBHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UpdateActivity extends AppCompatActivity {

    EditText update_name,update_id,update_phone,update_address;
    Button update_action;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        init();
    }

    private void init(){
        update_id=findViewById(R.id.update_id);
        update_name=findViewById(R.id.update_name);
        update_phone=findViewById(R.id.update_phone);
        update_address=findViewById(R.id.update_address);
        update_action=findViewById(R.id.update_action_button);

        dbHelper=new DBHelper(this);
        update_action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.updateTable(Integer.parseInt(update_id.getText().toString()),update_address.getText().toString());
            }
        });
    }
}
