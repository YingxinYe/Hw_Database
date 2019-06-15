package android.example.hw_database.activities.activities;

import android.example.hw_database.R;
import android.example.hw_database.activities.database.DBHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText add_name,add_id,add_phone,add_address;
    Button add_action;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        init();
    }

    private void init(){
        add_id=findViewById(R.id.add_id);
        add_name=findViewById(R.id.add_name);
        add_phone=findViewById(R.id.add_phone);
        add_address=findViewById(R.id.add_address);
        add_action=findViewById(R.id.add_page_button_add);
        MainActivity activity=new MainActivity();
        //dbHelper=new DBHelper(activity); //null pointer error
        dbHelper=new DBHelper(this);

        add_action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id=Integer.parseInt(add_id.getText().toString());
                String name=add_name.getText().toString();
                String phone=add_phone.getText().toString();
                String address=add_address.getText().toString();
                dbHelper.addData(id,name,phone,address);
            }
        });
    }
}
