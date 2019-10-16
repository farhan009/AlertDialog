package com.example.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button;
    private AlertDialog.Builder alertDialogBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button_id);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder.setCancelable(false);

        // For setting Icon, Title, Message
        alertDialogBuilder.setIcon(R.drawable.question);
        alertDialogBuilder.setTitle(R.string.title_Text);
        alertDialogBuilder.setMessage(R.string.message_Text);

        alertDialogBuilder.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();    // Exit
                    }
                });

        alertDialogBuilder.setNegativeButton("No",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();    // Cancel
                    }
                });

        alertDialogBuilder.setNeutralButton("Cancel",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Stay on this Page", Toast.LENGTH_SHORT).show();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
