package android.example.hw_database.activities.activities;

import android.example.hw_database.R;
import android.example.hw_database.activities.database.DBHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DeleteActivity extends AppCompatActivity {

    EditText delete_id;
    Button delete_btn;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        init();
    }

    private void init(){
        delete_id=findViewById(R.id.delete_id);
        delete_btn=findViewById(R.id.delete_action_button);
        dbHelper=new DBHelper(this);
        delete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.deleteID(Integer.parseInt(delete_id.getText().toString()));
            }
        });
    }
}
