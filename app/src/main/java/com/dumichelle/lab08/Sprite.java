package com.dumichelle.lab08;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

class Sprite extends RectF {
    private static final int COLUMNS = 4;
    private static final int ROWS = 4;

    private static final int DOWN = 0, LEFT = 1, RIGHT = 2, UP = 3;

    private int dX, dY, x, y, color;
    private Bitmap bitmap;

    private int currentFrame=0, width, height;

    //constructors
    public Sprite() {
        this(1,2, Color.WHITE);
        this.offsetTo(left, 800);
    }
    public Sprite(int dX, int dY, int color) {
        this(1,1,200,200,dX,dY, color);
        this.offsetTo(left, 800);
    }

    public Sprite(float left, float top, float right, float bottom, double dX, double dY, int color) {
        super(left, top, right, bottom);
        this.dX = (int) dX;
        this.dY = (int) dY;
        this.color = color;
        System.out.print(color);
    }

    public void update(Canvas canvas){
        //move based on position

        if(left + dX < 0 || right + dX > canvas.getWidth())
            dX *=- 1;

        if (top + dY >canvas.getHeight())
            offsetTo(left,-height());

        if (bottom + dY < 0)
            offsetTo(left,canvas.getHeight());

        offset(dX,dY); //moves right and downwards
    }

    public void draw(Canvas canvas) {

        Paint paint = new Paint();
        paint.setColor(color);
        canvas.drawCircle(centerX(), centerY(), width() / 2, paint);
        if (bitmap == null) { // in case it doesn't exist
            paint.setColor(color);
            canvas.drawCircle(centerX(), centerY(), width() / 2, paint);
        }
        else {
            width = bitmap.getWidth() / COLUMNS;
            height = bitmap.getHeight() / ROWS;
            int X = currentFrame * width;
            int Y = getAnimationRow() * height;
            Rect src = new Rect(X, Y, X + width, Y + height);
            canvas.drawBitmap(bitmap,src, this,null);
        }
    }

    //get which row in the png
    private int getAnimationRow() {

        if (Math.abs(dX) > Math.abs(dY)) {
            if (Math.abs(dX) == dX) {
                return RIGHT; //abs value equals the value
            }
            else {
                return LEFT;
            }
        } else if (Math.abs(dY) == dY) {
            return DOWN;
        }
        else return UP;

    }

    public int getdX() {
        return dX;
    }

    public void setdX(int dX) {
        this.dX = dX;
    }

    public int getdY() {
        return dY;
    }

    public void setdY(int dY) {
        this.dY = dY;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void getX() {
        this.x = x;
    }

    public void getY() {
        this.y = y;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }


}