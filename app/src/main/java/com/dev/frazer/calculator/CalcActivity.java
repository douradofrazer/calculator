package com.dev.frazer.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class CalcActivity extends Activity {
    TextView resultsText;
    Button oneBtn,twoBtn,threeBtn,fourBtn,fiveBtn,sixBtn,sevenBtn,eightBtn,nineBtn,zeroBtn,clearBtn;
    ImageButton calcBtn,divideBtn,multiplyBtn,subtractBtn,addBtn;
    String runningNumber = "";
    String rightValueStr = "";
    String leftValueStr= "";
    int result = 0;

    Operation currentOperation;

    public enum Operation{
        ADD,SUBTRACT,DIVIDE,EQUAL,MULTIPLY
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_calc);

        resultsText = (TextView) findViewById(R.id.resultsText);

        zeroBtn = (Button) findViewById(R.id.zeroBtn);
        oneBtn = (Button) findViewById(R.id.oneBtn);
        twoBtn = (Button) findViewById(R.id.twoBtn);
        threeBtn = (Button) findViewById(R.id.threeBtn);
        fourBtn= (Button) findViewById(R.id.fourBtn);
        fiveBtn= (Button) findViewById(R.id.fiveBtn);
        sixBtn= (Button) findViewById(R.id.sixBtn);
        sevenBtn= (Button) findViewById(R.id.sevenBtn);
        eightBtn = (Button) findViewById(R.id.eightBtn);
        nineBtn= (Button) findViewById(R.id.nineBtn);

        divideBtn= (ImageButton) findViewById(R.id.divideBtn);
        multiplyBtn= (ImageButton) findViewById(R.id.multiplyBtn);
        subtractBtn= (ImageButton) findViewById(R.id.subtractBtn);
        addBtn= (ImageButton) findViewById(R.id.addBtn);
        calcBtn= (ImageButton) findViewById(R.id.calcBtn);

        clearBtn= (Button) findViewById(R.id.clearBtn);

        resultsText.setText("");

        //one
        oneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               numberPressed(1);
            }
        });

        //two
        twoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(2);
            }
        });

        //three
        threeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(3);
            }
        });

        //four
        fourBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(4);
            }
        });

        //five
        fiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(5);
            }
        });

        //six
        sixBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(6);
            }
        });

        //seven
        sevenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(7);
            }
        });

        //eight
        eightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(8);
            }
        });

        //nine
        nineBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(9);
            }
        });

        //zero
        zeroBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(0);
            }
        });

        //divide
        divideBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processOperation(Operation.DIVIDE);

            }
        });

        //multiply
        multiplyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processOperation(Operation.MULTIPLY);
            }
        });

        //subtract
        subtractBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processOperation(Operation.SUBTRACT);
            }
        });

        //add
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processOperation(Operation.ADD);
            }
        });

        //clear
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result=0;
                rightValueStr="";
                leftValueStr="";
                runningNumber="";
                resultsText.setText("0");
                currentOperation=null;
            }
        });

        //results
        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processOperation(Operation.EQUAL);
            }
        });


    }


    void numberPressed(int number){
        runningNumber += String.valueOf(number);
        resultsText.setText(runningNumber);
    }


    // logic for performing the mathematical operations

    void processOperation(Operation operation){

        if(currentOperation != null){
            if(runningNumber != ""){
                leftValueStr = runningNumber;
                runningNumber="";

                switch (currentOperation){
                    case ADD :
                        result = Integer.parseInt(rightValueStr)+Integer.parseInt(leftValueStr);
                        break;
                    case SUBTRACT:
                        result = Integer.parseInt(rightValueStr)-Integer.parseInt(leftValueStr);
                        break;
                    case MULTIPLY:
                        result = Integer.parseInt(rightValueStr)*Integer.parseInt(leftValueStr);
                        break;
                    case DIVIDE:
                        result = Integer.parseInt(rightValueStr)/Integer.parseInt(leftValueStr);
                        break;

                }
                rightValueStr=String.valueOf(result);
                resultsText.setText(rightValueStr);

            }
        } else {
            rightValueStr =runningNumber;
            runningNumber = "";
        }
        currentOperation = operation;
    }


}
