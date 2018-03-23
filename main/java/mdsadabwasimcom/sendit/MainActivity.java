package mdsadabwasimcom.sendit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText message;
    private  EditText subject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onSendMessage(View view){
        message = (EditText) findViewById(R.id.editText);
        subject = (EditText) findViewById(R.id.editText2);
        String messageText=message.getText().toString();
        String subjectText = subject.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        //action type is text/plain
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, messageText);
        intent.putExtra(Intent.EXTRA_SUBJECT, subjectText);
        String chooserTitle=getString(R.string.chooser_title);
        Intent chosenIntent= Intent.createChooser(intent, chooserTitle);

        startActivity(chosenIntent);

    }
}
