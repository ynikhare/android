package com.example.clocktest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class ClockSurfaceView extends SurfaceView implements Runnable {
    private Context c;
    private int length;
    private int[] numbers = {1,2,3,4,5,6,7,8,9,10,11,12};

    private boolean running = false;
    private SurfaceHolder holder=null;
    private Thread thread=null;

    public ClockSurfaceView(Context context, int length) {
        super(context);

        this.c = context;
        this.length = length;

        thread= new Thread(this);
        thread.start();
        holder=this.getHolder();
        running=true;
    }
    public void onResume(){
        thread = new Thread(this);
        running=true;
        thread.start();
    }
    public void onPause(){
        running=false;
        boolean reentry=true;
        while (reentry){
            try {
                thread.join();
                reentry=false;
            }catch (Exception e){}

        }
    }



    @Override
    public void run(){
        int sec=0;
        int min=0;
        int hr=0;
        int radius= Math.min(getWidth(),getHeight());
        while (running){
            //test surface valid
            if (holder.getSurface().isValid()){
                //draw within canvas from holder
                Canvas canvas=holder.lockCanvas();
                Paint paint= new Paint();
                Paint p= new Paint();
                paint.setColor(Color.WHITE);
                canvas.drawPaint(paint);
                paint.setColor(Color.BLACK);
                paint.setStrokeWidth(5);

                RegPoly secMarks=new RegPoly(60,this.length-60,this.getWidth()/2,this.getHeight()/2,canvas,paint);
                RegPoly hrMarks=new RegPoly(12,this.length-90,this.getWidth()/2,this.getHeight()/2,canvas,paint);


                RegPoly secHand=new RegPoly(60,this.length-120,this.getWidth()/2,this.getHeight()/2,canvas,paint);
                RegPoly minHand=new RegPoly(60,this.length-160,this.getWidth()/2,this.getHeight()/2,canvas,paint);
                RegPoly hrHand=new RegPoly(60,this.length-210,this.getWidth()/2,this.getHeight()/2,canvas,paint);

                secMarks.drawPoints();

                hrMarks.drawPoints();



                secHand.drawRadius(sec+45);
                minHand.drawRadius(min+60);
                hrHand.drawRadius(hr+75);
                p.setTextSize(30);
                p.setColor(Color.BLACK);
                for (int number:numbers){
                    double separateAngle = Math.PI/6 *(number-3);
                    int x = (int)(this.getWidth()/2-10 +Math.cos(separateAngle)*this.getWidth()/2.5);
                    int y = (int)(this.getHeight()/2+10+Math.sin(separateAngle)*this.getWidth()/2.5);
                    String cl = String.valueOf(number);
                    canvas.drawText(cl,x,y,p);
                }
                holder.unlockCanvasAndPost(canvas);
            }
            try {
                Thread.sleep(1000);sec++;
                if(sec%60==0 &&sec!=0){min++;}
                if (min%60==0&&min!=0){hr++;}
            }catch (Exception e){}

        }

    }
}
