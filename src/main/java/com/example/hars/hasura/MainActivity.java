package com.example.hars.hasura;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {

TextView textView;
EditText editText;
Button button;
    private static final String TAG="MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         textView=(TextView)findViewById(R.id.textView2);
        editText=(EditText)findViewById(R.id.editText2);
        button=(Button)findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String enteredText=editText.getText().toString();
                if (enteredText.isEmpty()) {
                    showAlert();
                }else{
//replace text in textView
                    replaceText(enteredText);
                }
            }
        });

        Log.i(TAG,"Inside On Create");
    }
//    lets make the method to replaceText
    private void replaceText(String newText){
        textView.setText(newText);

        editText.setText("");
    }
private void showAlert(){
//    Building the Dialog
    AlertDialog.Builder builder=new AlertDialog.Builder(this);
    builder.setTitle("Empty");
    builder.setMessage("No string to replace");
//    also access neutra button
    builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            dialog.dismiss();
        }
    });
//    show the dilaog
    builder.show();
}


}
