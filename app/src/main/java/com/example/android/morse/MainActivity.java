package com.example.android.morse;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.media.MediaPlayer;
import android.media.ToneGenerator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String textFromUser;

    public static Camera cam = null;
    //flag to detect flash is on or off
    private Camera camera;

    Camera.Parameters params;
    /////// variables del sonido
    private int tiempo = 450;
    TextView morse;
    String t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        morse=(TextView)findViewById(R.id.morse1);


        boolean isCameraFlash = getApplicationContext().getPackageManager()
                .hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);

        if (!isCameraFlash) {
            showNoCameraAlert();
        } else {
            camera = Camera.open();
            params = camera.getParameters();
        }
    }

    ////////////codigo flash
    public void focus(View view){

        EditText t=(EditText)findViewById(R.id.editText);
        textFromUser=t.getText().toString();
        startTranslation();
    }


    public void startTranslation () {
        for (int i = 0; i < textFromUser.length(); i++) {

            translateToMorse(textFromUser.charAt(i));

        }
    }
    private void showNoCameraAlert(){
        new AlertDialog.Builder(this)
                .setTitle("Error: No Camera Flash!")
                .setMessage("Camera flashlight not available in this Android device!")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish(); // close the Android app
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
        return;
    }
    private void setFlashlightOn() {
        params = camera.getParameters();
        params.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
        camera.setParameters(params);
        camera.startPreview();
    }

    private void setFlashlightOff() {
        params.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
        camera.setParameters(params);
        camera.stopPreview();
    }
    public void shortFlash(){
        setFlashlightOn();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setFlashlightOff();
    }
    public void longFlash() {
        setFlashlightOn();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setFlashlightOff();
    }

    public void translateToMorse(char c) {
        switch (c) {
            case 'a':
                shortFlash();
                longFlash();
                break;
            case 'b':
                longFlash();
                shortFlash();
                shortFlash();
                shortFlash();
                break;
            case 'c':
                longFlash();
                shortFlash();
                longFlash();
                shortFlash();
                break;
            case 'd':
                longFlash();
                shortFlash();
                shortFlash();
                break;
            case 'e':
                shortFlash();
                break;
            case 'f':
                shortFlash();
                shortFlash();
                longFlash();
                shortFlash();
                break;
            case 'g':
                longFlash();
                longFlash();
                shortFlash();
                break;
            case 'h':
                shortFlash();
                shortFlash();
                shortFlash();
                shortFlash();
                break;
            case 'i':
                shortFlash();
                shortFlash();
                break;
            case 'j':
                shortFlash();
                longFlash();
                longFlash();
                longFlash();
                break;
            case 'k':
                longFlash();
                shortFlash();
                longFlash();
                break;
            case 'l':
                shortFlash();
                longFlash();
                shortFlash();
                shortFlash();
                break;
            case 'm':
                longFlash();
                longFlash();
                break;
            case 'n':
                longFlash();
                shortFlash();
                break;
            case 'o':
                longFlash();
                longFlash();
                longFlash();
                break;
            case 'p':
                shortFlash();
                longFlash();
                longFlash();
                shortFlash();
                break;
            case 'q':
                longFlash();
                longFlash();
                shortFlash();
                longFlash();
                break;
            case 'r':
                shortFlash();
                longFlash();
                shortFlash();
                break;
            case 's':
                shortFlash();
                shortFlash();
                shortFlash();
                break;
            case 't':
                longFlash();
                break;
            case 'u':
                shortFlash();
                shortFlash();
                longFlash();
                break;
            case 'v':
                shortFlash();
                shortFlash();
                shortFlash();
                longFlash();
                break;
            case 'w':
                shortFlash();
                longFlash();
                longFlash();
                break;
            case 'x':
                longFlash();
                shortFlash();
                shortFlash();
                longFlash();
                break;
            case 'y':
                longFlash();
                shortFlash();
                longFlash();
                longFlash();
                break;
            case 'z':
                longFlash();
                longFlash();
                shortFlash();
                shortFlash();
                break;
            default:
                break;
        }
    }


    /////////////codigo flash

    //////////////codigo sonido
    public void traducir(View v) {

        EditText campoTexto = (EditText) findViewById(R.id.editText);
        String letra=campoTexto.getText().toString();
        Character n;
        Log.d("Morse app", "limpiando");
        t="";
        morse.setText("");
        Log.d("Morse app", morse.getText().toString());


        for (int i=0;i<letra.length();i++){
            n=letra.charAt(i);
            if (n.equals('a')){
                punto();
                guion();
                retardo(this.tiempo);
                t+="  ";
            }
            if (n.equals('b')){
                guion();
                punto();
                punto();
                retardo(this.tiempo);
                t+="  ";
            }
            if (n.equals('c')){
                guion();
                punto();
                guion();
                punto();
                retardo(this.tiempo);
                t+="  ";
            }
            if (n.equals('d')){
                guion();
                punto();
                punto();
                retardo(this.tiempo);
                t+="  ";
            }
            if (n.equals('e')){
                punto();
                retardo(this.tiempo);
                t+="  ";
            }
            if (n.equals('f')){
                punto();
                punto();
                guion();
                punto();
                retardo(this.tiempo);
                t+="  ";
            }
            if (n.equals('g')){
                guion();
                guion();
                punto();
                retardo(this.tiempo);
                t+="  ";
            }
            if (n.equals('h')){
                punto();
                punto();
                punto();
                punto();
                retardo(this.tiempo);
                t+="  ";
            }
            if (n.equals('i')){
                punto();
                punto();
                retardo(this.tiempo);
                t+="  ";
            }
            if (n.equals('j')){
                punto();
                guion();
                guion();
                guion();
                retardo(this.tiempo);
                t+="  ";
            }
            if (n.equals('k')){
                guion();
                punto();
                guion();
                retardo(this.tiempo);
                t+="  ";
            }
            if (n.equals('l')){
                punto();
                guion();
                punto();
                punto();
                retardo(this.tiempo);
                t+="  ";
            }
            if (n.equals('m')){
                guion();
                guion();
                retardo(this.tiempo);
                t+="  ";
            }
            if (n.equals('n')){
                guion();
                punto();
                retardo(this.tiempo);
                t+="  ";
            }
            if (n.equals('o')){
                guion();
                guion();
                guion();
                retardo(this.tiempo);
                t+="  ";
            }
            if (n.equals('p')){
                punto();
                guion();
                guion();
                punto();
                retardo(this.tiempo);
                t+="  ";
            }
            if (n.equals('q')){
                guion();
                guion();
                punto();
                guion();
                retardo(this.tiempo);
                t+="  ";
            }
            if (n.equals('r')){
                punto();
                guion();
                punto();
                retardo(this.tiempo);
                t+="  ";
            }
            if (n.equals('s')){
                punto();
                punto();
                punto();
                retardo(this.tiempo);
                t+="  ";
            }
            if (n.equals('t')){
                guion();
                retardo(this.tiempo);
                t+="  ";
            }
            if (n.equals('u')){
                punto();
                punto();
                guion();
                retardo(this.tiempo);
                t+="  ";
            }
            if (n.equals('v')){
                punto();
                punto();
                punto();
                guion();
                retardo(this.tiempo);
                t+="  ";
            }
            if (n.equals('w')){
                punto();
                guion();
                guion();
                retardo(this.tiempo);
                t+="  ";
            }
            if (n.equals('x')){
                guion();
                punto();
                punto();
                guion();
                retardo(this.tiempo);
                t+="  ";
            }
            if (n.equals('y')){
                guion();
                punto();
                guion();
                guion();
                retardo(this.tiempo);
                t+="  ";
            }
            if (n.equals('z')){
                guion();
                guion();
                punto();
                punto();
                retardo(this.tiempo);
                t+="  ";
            }

        }

    }

    public void punto(){
        t+=".";
        morse.setText(t);
        MediaPlayer mp = MediaPlayer.create(this, R.raw.bep);
        mp.start();

        retardo(this.tiempo);
        mp.release();

    }
    public void guion(){
        t+="-";
        morse.setText(t);
        MediaPlayer mp1 = MediaPlayer.create(this, R.raw.beeep);
        mp1.start();
        //morse.setText("-");
        retardo(this.tiempo * 2);
        mp1.release();

    }


    private void retardo(int paramInt)
    {
        try
        {
            System.out.println("RETARDO: " + paramInt + " ms.");
            Thread.sleep(paramInt);
            return;
        }
        catch (InterruptedException localInterruptedException)
        {
            localInterruptedException.printStackTrace();
        }
    }
    /////////codigo sonidp
}
