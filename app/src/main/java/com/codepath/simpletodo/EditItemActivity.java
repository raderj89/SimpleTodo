package com.codepath.simpletodo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

public class EditItemActivity extends AppCompatActivity {
    EditText itemText;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        itemText = (EditText) findViewById(R.id.itemEditText);
        String todoBody = getIntent().getStringExtra("body");
        position = getIntent().getIntExtra("position", 0);

        itemText.setText(todoBody);
        itemText.setSelection(itemText.getText().length());
    }

    public void onUpdateItem(View view) {
        itemText = (EditText) findViewById(R.id.itemEditText);
        Intent data = new Intent();
        data.putExtra("body", itemText.getText().toString());
        data.putExtra("position", position);
        setResult(RESULT_OK, data);
        finish();
    }
}
