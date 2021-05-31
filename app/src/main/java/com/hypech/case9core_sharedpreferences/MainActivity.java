package com.hypech.case9core_sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    private EditText editText;
    private TextView textView;

    SharedPreferences sp;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=   findViewById(R.id.Edit_Test);
        textView=   findViewById(R.id.Text_Test);

        sp     = this.getSharedPreferences("data",MODE_PRIVATE);
        editor = sp.edit();
    }

    public void clickSave(View v) {
        String some = editText.getText().toString();
        editor.putString("Content", some);
        editor.commit();
        Toast.makeText(this, some + " saved!", Toast.LENGTH_LONG).show();
        editText.setText("click retrieve to read just saved.");
    }

    public void clickRetrieve(View v) {
        String name = sp.getString("Content","");
        textView.setText(name);
        Toast.makeText(this, "we read: "+name , Toast.LENGTH_LONG).show();
    }
}