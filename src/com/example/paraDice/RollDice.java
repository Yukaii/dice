/**
 *	roll dice example
 *	@author Yukai Huang
 */

package com.example.paraDice;

import com.example.paradice.R;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.*;

public class RollDice extends Activity{
	
	int diceNum;
	
	Button rollButton;
	TextView diceNumText;
	ImageView diceImage;
	
	Bitmap dices[] = new Bitmap[6];
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState); 
		setContentView(R.layout.activity_roll_dice);
				
		rollButton = (Button)findViewById(R.id.btn_roll);
		diceNumText = (TextView) findViewById(R.id.dice_num);
		diceImage = (ImageView) findViewById(R.id.img_dice);
		
		dices[0] = BitmapFactory.decodeResource(getResources(), R.drawable.dice1);
		dices[1] = BitmapFactory.decodeResource(getResources(), R.drawable.dice2);
		dices[2] = BitmapFactory.decodeResource(getResources(), R.drawable.dice3);
		dices[3] = BitmapFactory.decodeResource(getResources(), R.drawable.dice4);
		dices[4] = BitmapFactory.decodeResource(getResources(), R.drawable.dice5);
		dices[5] = BitmapFactory.decodeResource(getResources(), R.drawable.dice6);
		
		rollButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				diceNum = (int)(Math.random() * 6 + 1);
				diceNumText.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						diceNumText.setText(new Integer(diceNum).toString());
					}
				});
				
				diceImage.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						diceImage.setImageBitmap(dices[diceNum-1]);
					}
				});
				
			}
		});
		
	}
}
