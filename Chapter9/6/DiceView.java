package com.example.rolldice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import java.util.Random;

public class DiceView extends View {

    private Drawable[] diceDrawables;
    private Random random;

    public DiceView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        // 주사위 이미지를 Drawable 배열에 저장합니다.
        diceDrawables = new Drawable[6];
        diceDrawables[0] = getResources().getDrawable(R.drawable.dice1);
        diceDrawables[1] = getResources().getDrawable(R.drawable.dice2);
        diceDrawables[2] = getResources().getDrawable(R.drawable.dice3);
        diceDrawables[3] = getResources().getDrawable(R.drawable.dice4);
        diceDrawables[4] = getResources().getDrawable(R.drawable.dice5);
        diceDrawables[5] = getResources().getDrawable(R.drawable.dice6);

        random = new Random();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 주사위 이미지를 랜덤하게 그립니다.
        int diceIndex = random.nextInt(6);
        Drawable diceDrawable = diceDrawables[diceIndex];
        diceDrawable.setBounds(0, 0, getWidth(), getHeight());
        diceDrawable.draw(canvas);
    }
}
