package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainGame extends AppCompatActivity {
    public static final String FINAL_WINNER = "com.example.tictactoe.FINAL_WINNER";
private Button b1, b2, b3, b4, b5, b6, b7, b8, b9;
int flag=0;
int count=0;
String bn1, bn2, bn3, bn4, bn5, bn6, bn7, bn8, bn9;
String win=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game);
        findIds();
    }
    public void findIds(){
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.b3);
        b4=findViewById(R.id.b4);
        b5=findViewById(R.id.b5);
        b6=findViewById(R.id.b6);
        b7=findViewById(R.id.b7);
        b8=findViewById(R.id.b8);
        b9=findViewById(R.id.b9);
    }
    public void SetChar(View view) {
        Button currBut = (Button) view;
        if (currBut.getText().toString().equals("")) {
            count++;
            if (flag % 2 == 0) {
                currBut.setText("X");
            } else {
                currBut.setText("O");
            }
            flag++;
            if (count >= 5) {
                bn1 = b1.getText().toString();
                bn2 = b2.getText().toString();
                bn3 = b3.getText().toString();
                bn4 = b4.getText().toString();
                bn5 = b5.getText().toString();
                bn6 = b6.getText().toString();
                bn7 = b7.getText().toString();
                bn8 = b8.getText().toString();
                bn9 = b9.getText().toString();

                if (!bn1.equals("") && bn1.equals(bn2) && bn2.equals(bn3)) {
//                    Toast.makeText(this, bn1 + " Won! ", Toast.LENGTH_SHORT).show();
                    win=bn1;
                    openActivity2(view);
                    reset();

                } else if (!bn4.equals("") && bn4.equals(bn5) && bn5.equals(bn6)) {
                    win=bn4;
                    openActivity2(view);
                    reset();

                } else if (!bn7.equals("") && bn7.equals(bn8) && bn8.equals(bn9)) {
                    win=bn7;
                    openActivity2(view);
                    reset();

                } else if (!bn1.equals("") && bn1.equals(bn5) && bn5.equals(bn9)) {
                  win=bn1;
                    openActivity2(view);
                    reset();

                } else if (!bn7.equals("") && bn7.equals(bn5) && bn5.equals(bn3)) {
                    win=bn7;
                    openActivity2(view);
                    reset();
                }
                else if(!bn1.equals("") && bn1.equals(bn4) && bn4.equals(bn7)){
                    win=bn1;
                    openActivity2(view);
                    reset();
                }
                else if(!bn2.equals("") && bn2.equals(bn5) && bn5.equals(bn8)){
                    win=bn2;
                    openActivity2(view);
                    reset();
                }
                else if(!bn3.equals("") && bn3.equals(bn6) && bn6.equals(bn9)){
                    win=bn3;
                    openActivity2(view);
                    reset();
                }
            }
        } else if (count==9) {
            Toast.makeText(this, "Game drawn...Start again!", Toast.LENGTH_SHORT).show();
            reset();
        }
    }
    public void reset(){
        b1.setText("");
        b2.setText("");
        b3.setText("");
        b4.setText("");
        b5.setText("");
        b6.setText("");
        b7.setText("");
        b8.setText("");
        b9.setText("");
        count=0;
        flag=0;
    }

    public void openActivity2(View view){
        Intent intent=new Intent(this, LastPage.class);
        if(win.equals("X"))
        intent.putExtra("FINAL_WINNER", "Player 1");
        else if(win.equals("O"))
            intent.putExtra("FINAL_WINNER", "Player 2");
        else
            intent.putExtra("FINAL_WINNER", "Game drawn!");
        startActivity(intent);
    }
}