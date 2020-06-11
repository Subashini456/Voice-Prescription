package com.example.prescription;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.speech.RecognizerIntent;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    ImageButton voice_btn1;
    ImageButton voice_btn2;
    ImageButton voice_btn3;
    ImageButton voice_btn4;
    ImageButton voice_btn5;
    ImageButton voice_btn6;
    ImageButton voice_btn7;
    final int VOICE_CODE1 = 100;
    final int VOICE_CODE2 = 101;
    final int VOICE_CODE3 = 102;
    final int VOICE_CODE4 = 103;
    final int VOICE_CODE5 = 104;
    final int VOICE_CODE6 = 105;
    final int VOICE_CODE7 = 106;


    private RadioGroup radioGroup;
    private RadioButton radioButton;

    private TextView myTextView1;
    private TextView myTextView4;
    private TextView myTextView5;
    private TextView myTextView6;
    private TextView myTextView2;
    private TextView myTextView3;
    private TextView myTextView7;
    private TextView myTextView8;
    private TextView myTextView9;
    private TextView myTextView10;
    private TextView myTextView11;
    private TextView myTextView12;
    private TextView myTextView13;
    private TextView myTextView14;
    private TextView myTextViewdate;
    private EditText myEditView1;
    private EditText myEditView2;
    private EditText myEditView3;
    private EditText myEditView4;
    private EditText myEditView5;
    private EditText myEditView6;
    private EditText myEditView7;
    private EditText myEditView8;




    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListenerOnButton();

        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance().format(calendar.getTime());
        TextView textViewDate = findViewById(R.id.textViewdate);
        textViewDate.setText(currentDate);




        voice_btn1 = (ImageButton)findViewById(R.id.voice_btn1);
        voice_btn2 = (ImageButton)findViewById(R.id.voice_btn2);
        voice_btn3 = (ImageButton)findViewById(R.id.voice_btn3);
        voice_btn4 = (ImageButton)findViewById(R.id.voice_btn4);
        voice_btn5 = (ImageButton)findViewById(R.id.voice_btn5);
        voice_btn6 = (ImageButton)findViewById(R.id.voice_btn6);
        voice_btn7 = (ImageButton)findViewById(R.id.voice_btn7);

        voice_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                voice_to_text1();
            }
        });

        voice_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                voice_to_text2();
            }
        });

        voice_btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                voice_to_text3();
            }
        });

        voice_btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                voice_to_text4();
            }
        });

        voice_btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                voice_to_text5();
            }
        });

        voice_btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                voice_to_text6();
            }
        });

        voice_btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                voice_to_text7();
            }
        });

        myTextView1 = findViewById(R.id.textView1);
        myTextView4 = findViewById(R.id.textView4);
        myTextView5 = findViewById(R.id.textView5);
        myTextView6 = findViewById(R.id.textView6);
        myTextView2 = findViewById(R.id.textView2);
        myTextViewdate = findViewById(R.id.textViewdate);
        myTextView3 = findViewById(R.id.textView3);
        myTextView7 = findViewById(R.id.textView7);
        myTextView8 = findViewById(R.id.textView8);
        myTextView9 = findViewById(R.id.textView9);
        myTextView10 = findViewById(R.id.textView10);
        myTextView11 = findViewById(R.id.textView11);
        myTextView12 = findViewById(R.id.textView12);
        myTextView13 = findViewById(R.id.textView13);
        myTextView14 = findViewById(R.id.textView14);

        myEditView1 = findViewById(R.id.editText1);
        myEditView2 = findViewById(R.id.editText2);
        myEditView3 = findViewById(R.id.editText3);
        myEditView4 = findViewById(R.id.editText4);
        myEditView5 = findViewById(R.id.editText5);
        myEditView6 = findViewById(R.id.editText6);
        myEditView7 = findViewById(R.id.editText7);
        myEditView8 = findViewById(R.id.editText8);



        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);
    }



    public void addListenerOnButton() {
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup1);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                radioButton = (RadioButton) findViewById(checkedId);
                myEditView4.setText(radioButton.getText());
            }
        });
    }


    private void voice_to_text1() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Hello Doctor \n !!");
        try{
            startActivityForResult(intent,VOICE_CODE1);
        }catch(ActivityNotFoundException e){

        }
    }

    private void voice_to_text2() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Hello Doctor \n !!");
        try{
            startActivityForResult(intent,VOICE_CODE2);
        }catch(ActivityNotFoundException e){

        }
    }

    private void voice_to_text3() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Hello Doctor \n !!");
        try{
            startActivityForResult(intent,VOICE_CODE3);
        }catch(ActivityNotFoundException e){

        }
    }

    private void voice_to_text4() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Hello Doctor \n !!");
        try{
            startActivityForResult(intent,VOICE_CODE4);
        }catch(ActivityNotFoundException e){

        }
    }

    private void voice_to_text5() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Hello Doctor \n !!");
        try{
            startActivityForResult(intent,VOICE_CODE5);
        }catch(ActivityNotFoundException e){

        }
    }

    private void voice_to_text6() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Hello Doctor \n !!");
        try{
            startActivityForResult(intent,VOICE_CODE6);
        }catch(ActivityNotFoundException e){

        }
    }

    private void voice_to_text7() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Hello Doctor \n !!");
        try{
            startActivityForResult(intent,VOICE_CODE7);
        }catch(ActivityNotFoundException e){

        }
    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        switch(requestCode){
            case VOICE_CODE1: {
                if((resultCode == RESULT_OK) && (null != data)) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    myEditView1.setText(result.get(0));
                }
                break ;
            }
            case VOICE_CODE2: {
                if((resultCode == RESULT_OK) && (null != data)) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    myEditView2.setText(result.get(0));
                }
                break ;
            }
            case VOICE_CODE3: {
                if((resultCode == RESULT_OK) && (null != data)) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    myEditView3.setText(result.get(0));
                }
                break ;
            }
            case VOICE_CODE4: {
                if((resultCode == RESULT_OK) && (null != data)) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    myEditView5.setText(result.get(0));
                }
                break ;
            }
            case VOICE_CODE5: {
                if((resultCode == RESULT_OK) && (null != data)) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    myEditView6.setText(result.get(0));
                }
                break ;
            }
            case VOICE_CODE6: {
                if((resultCode == RESULT_OK) && (null != data)) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    myEditView7.setText(result.get(0));
                }
                break ;
            }
            case VOICE_CODE7: {
                if((resultCode == RESULT_OK) && (null != data)) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    myEditView8.setText(result.get(0));
                }
                break ;
            }

            default:
                throw new IllegalStateException("Unexpected value: " + requestCode);
        }
    }

    public void reload(View view) {
        Intent i = new Intent(MainActivity.this, MainActivity.class);
        finish();
        overridePendingTransition(0, 0);
        startActivity(i);
        overridePendingTransition(0, 0);
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void createMyPDF(View view){
        PdfDocument myPdfDocument = new PdfDocument();
        PdfDocument.PageInfo myPageInfo = new PdfDocument.PageInfo.Builder(500,1000,1).create();
        PdfDocument.Page myPage = myPdfDocument.startPage(myPageInfo);

        Paint myPaint = new Paint();
        String myString1 = myTextView1.getText().toString();
        String myString4 = myTextView4.getText().toString();
        String myString5 = myTextView5.getText().toString();
        String myString6 = myTextView6.getText().toString();
        String myString2 = myTextView2.getText().toString();
        String myString3 = myTextView3.getText().toString();
        String myString10 = myTextView7.getText().toString();
        String myString11 = myTextView8.getText().toString();
        String myString13 = myTextView9.getText().toString();
        String myString15 = myTextView10.getText().toString();
        String myStringdate = myTextViewdate.getText().toString();
        String myString7 = myEditView1.getText().toString();
        String myString8 = myEditView2.getText().toString();
        String myString9 = myEditView3.getText().toString();
        String myString12= myEditView4.getText().toString();
        String myString14= myEditView5.getText().toString();
        String myString16 = myTextView11.getText().toString();
        String myString17= myEditView6.getText().toString();
        String myString18 = myTextView12.getText().toString();
        String myString19 = myTextView13.getText().toString();
        String myString20 = myTextView14.getText().toString();
        String myString21= myEditView7.getText().toString();
        String myString22= myEditView8.getText().toString();

        int x1 = 170, y1=50;
        myPage.getCanvas().drawText(myString1, x1, y1, myPaint);
        int x2 = 180, y2=75;
        myPage.getCanvas().drawText(myString4, x2, y2, myPaint);
        int x3 = 230, y3=75;
        myPage.getCanvas().drawText(myString5, x3, y3, myPaint);
        int x4 = 190, y4=100;
        myPage.getCanvas().drawText(myString6, x4, y4, myPaint);
        int x5 = 220 , y5=100;
        myPage.getCanvas().drawText(myStringdate, x5, y5, myPaint);
        int x6 = 50 , y6 = 150;
        myPage.getCanvas().drawText(myString2, x6, y6, myPaint);
        int x7 = 155 , y7 = 150;
        myPage.getCanvas().drawText(myString7, x7, y7, myPaint);
        int x8 = 50 , y8 = 175;
        myPage.getCanvas().drawText(myString3, x8, y8, myPaint);
        int x9 = 155 , y9 = 175;
        myPage.getCanvas().drawText(myString8, x9, y9, myPaint);
        int x10 = 50 , y10 = 200;
        myPage.getCanvas().drawText(myString10, x10, y10, myPaint);
        int x11 = 155 , y11 = 200;
        myPage.getCanvas().drawText(myString9, x11, y11, myPaint);
        int x12 = 50 , y12 = 225;
        myPage.getCanvas().drawText(myString11, x12, y12, myPaint);
        int x13 = 155 , y13 = 225;
        myPage.getCanvas().drawText(myString12, x13, y13, myPaint);
        int x14 = 50 , y14 = 250;
        myPage.getCanvas().drawText(myString13, x14, y14, myPaint);
        int x16 = 50 , y16 = 275;
        myPage.getCanvas().drawText(myString15, x16, y16, myPaint);
        int x15 = 155 , y15 = 275;
        myPage.getCanvas().drawText(myString14, x15, y15, myPaint);
        int x17 = 50 , y17 = 300;
        myPage.getCanvas().drawText(myString16, x17, y17, myPaint);
        int x18 = 155 , y18 = 300;
        myPage.getCanvas().drawText(myString17, x18, y18, myPaint);

        int x19 = 50 , y19 = 350;
        myPage.getCanvas().drawText(myString18, x19, y19, myPaint);
        int x20 = 50 , y20 = 375;
        myPage.getCanvas().drawText(myString19, x20, y20, myPaint);
        int x21 = 155 , y21 = 375;
        myPage.getCanvas().drawText(myString21, x21, y21, myPaint);
        int x22 = 50 , y22 = 400;
        myPage.getCanvas().drawText(myString20, x22, y22, myPaint);
        int x23 = 155 , y23 = 400;
        myPage.getCanvas().drawText(myString22, x23, y23, myPaint);


        myPdfDocument.finishPage(myPage);
        String myFilePath = Environment.getExternalStorageDirectory().getPath() + "/myPDFFile.pdf" ;
        File myFile = new File(myFilePath);
        try {
            myPdfDocument.writeTo(new FileOutputStream(myFile));
        }
        catch (Exception e){
            e.printStackTrace();
            Toast.makeText(this, "Something wrong: " + e.toString(), Toast.LENGTH_LONG).show();
        }
        myPdfDocument.close();
        Toast.makeText(this, "PDF is created!!!", Toast.LENGTH_SHORT).show();
        openGeneratedPDF();

    }

    private void openGeneratedPDF(){
        File file = new File(Environment.getExternalStorageDirectory().getPath() + "/myPDFFile.pdf");
        if (file.exists())
        {
            Intent intent=new Intent(Intent.ACTION_VIEW);
            Uri uri = Uri.fromFile(file);
            intent.setDataAndType(uri, "application/pdf");
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            try
            {
                startActivity(intent);
            }
            catch(ActivityNotFoundException e)
            {
                Toast.makeText(MainActivity.this, "No Application available to view pdf", Toast.LENGTH_LONG).show();
            }
        }
    }
}