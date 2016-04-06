package com.cc.infiniteunitcircle;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import com.smaato.soma.BannerView;
import com.smaato.soma.interstitial.Interstitial;
import com.smaato.soma.interstitial.InterstitialAdListener;
import io.fabric.sdk.android.Fabric;
import com.crashlytics.android.Crashlytics;


public class MyActivity extends Activity implements InterstitialAdListener {
    private final int PUBLISHER_ID = 1100004597;
    private final int BANNER_ID = 130019197;
    private final int INTERSTETIAL_ID = 130022937;
    private Interstitial interstitial;
    private Point[] coords = new Point[16];
    FrameLayout f1;
    RelativeLayout rl;
    Switch toggle;
    private double delta;
    private int width;
    private int height;
    private int position=10;
    private int np, lastQuad, lastQuad1;
    private int revolutions=1,revolutions1=1;
    private static int parts=0;
    private double xCoord,xCoord1,yCoord,yCoord1;
    private double outerRadious,innerRadious;
    static String corner = "hHwdNrqNbs2Ael1PrufmSuTicWbcDNUg5+yS90eCGzZQiiZ0oRE8/a3R2pfk9Q4NoZ4sTrEZA5IK2PtTeFTQqcK+GlS29HscPvDGjAepJEqX66cmBmD0/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        interstitial = new Interstitial(this); //this, supposed to be your activity
        interstitial.setInterstitialAdListener(this); // your activity need to implements InterstitialAdListener interface
        interstitial.getAdSettings().setPublisherId(PUBLISHER_ID);
        interstitial.getAdSettings().setAdspaceId(INTERSTETIAL_ID);
        interstitial.asyncLoadNewBanner();
        Fabric.with(this, new Crashlytics());
        getActionBar().hide();
        BannerView mBanner = new BannerView (this);
        setContentView(R.layout.activity_my);
        f1 = (FrameLayout) findViewById(R.id.frame);
        rl = (RelativeLayout) findViewById(R.id.relative);
        rl.addView(mBanner, new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, 70));
        mBanner.getAdSettings().setPublisherId(PUBLISHER_ID);
        mBanner.getAdSettings().setAdspaceId(BANNER_ID);
        mBanner.asyncLoadNewBanner();
        mBanner.setLocationUpdateEnabled(true);
        mBanner.getUserSettings().setKeywordList("Geometry,Trigonometry,High School,Games,Tumblr,Flickr");
        mBanner.getUserSettings().setAge(17);
        mBanner.setAutoReloadFrequency(10);
        toggle = (Switch) findViewById(R.id.switch1);
        toggleListen();
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        width = size.x;
        height = size.y;
        if (width > height) delta = .035 * width;
        else delta = .035 * height;
        points();
        UCListener();
        startUp();
    }


    private void UCListener(){
        rl.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if((Math.abs(motionEvent.getX()- .88*width)<delta && (Math.abs(motionEvent.getY()- .362*height))<delta)){
                    np=0;

                }
                else if((Math.abs(motionEvent.getX()- .83*width)<delta && (Math.abs(motionEvent.getY()- .228*height))<delta)){

                    np=1;
                }
                else if((Math.abs(motionEvent.getX()- .769*width)<delta && (Math.abs(motionEvent.getY()- .172*height))<delta)){

                    np=2;
                }
                else if((Math.abs(motionEvent.getX()- .689*width)<delta && (Math.abs(motionEvent.getY()- .129*height))<delta)){

                    np=3;
                }
                else if((Math.abs(motionEvent.getX()- .502*width)<delta && (Math.abs(motionEvent.getY()- .094*height))<delta)){

                    np=4;
                }
                else if((Math.abs(motionEvent.getX()- .313*width)<delta && (Math.abs(motionEvent.getY()- .129*height))<delta)){

                    np=5;
                }
                else if((Math.abs(motionEvent.getX()- .234*width)<delta && (Math.abs(motionEvent.getY()- .172*height))<delta)){

                    np=6;
                }
                else if((Math.abs(motionEvent.getX()- .173*width)<delta && (Math.abs(motionEvent.getY()- .228*height))<delta)){

                    np=7;
                }
                else if((Math.abs(motionEvent.getX()- .123*width)<delta && (Math.abs(motionEvent.getY()- .362*height))<delta)){

                    np=8;
                }
                else if((Math.abs(motionEvent.getX()- .173*width)<delta && (Math.abs(motionEvent.getY()- .499*height))<delta)){

                    np=9;
                }
                else if((Math.abs(motionEvent.getX()- .234*width)<delta && (Math.abs(motionEvent.getY()- .55*height))<delta)){

                    np=10;
                }
                else if((Math.abs(motionEvent.getX()- .313*width)<delta && (Math.abs(motionEvent.getY()- .593*height))<delta)){

                    np=11;
                }
                else if((Math.abs(motionEvent.getX()- .502*width)<delta && (Math.abs(motionEvent.getY()- .628*height))<delta)){

                    np=12;
                }
                else if((Math.abs(motionEvent.getX()- .689*width)<delta && (Math.abs(motionEvent.getY()- .593*height))<delta)){

                    np=13;
                }
                else if((Math.abs(motionEvent.getX()- .769*width)<delta && (Math.abs(motionEvent.getY()- .55*height))<delta)){

                    np=14;
                }
                else if((Math.abs(motionEvent.getX()- .83*width)<delta && (Math.abs(motionEvent.getY()- .499*height))<delta)){

                    np=15;
                }
                animateJumps();
                return true;
            }
        });
        //canvas.drawLine(0,400,480,400,x);
        //canvas.drawLine(240,0,240,800,y);
        //canvas.drawCircle(440, 400, 10, black);
        //Paint outline = new Paint();
        //outline.setColor(Color.BLACK);
        //outline.setStyle(Paint.Style.STROKE);
        //canvas.drawCircle(240,400,200,outline);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void UCDrawings(double xCoord, double yCoord){
        Paint hyp = new Paint();
        hyp.setStrokeWidth(10);
        hyp.setColor(Color.GREEN);
        Paint x = new Paint();
        x.setStrokeWidth(10);
        x.setColor(Color.RED);
        x.setTextAlign(Paint.Align.CENTER);
        Paint y = new Paint();
        y.setStrokeWidth(10);
        y.setColor(Color.BLUE);
        y.setTextAlign(Paint.Align.CENTER);
        Paint black = new Paint();
        black.setColor(Color.BLACK);
        Bitmap bg = Bitmap.createBitmap(width,height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bg);
        black.setTextSize(42);
        x.setTextSize(45);
        y.setTextSize(45);
        if(revolutions>0)canvas.drawText("CCW = "+revolutions,(float).374*width,(float).91*height,black);
        else if(revolutions<0)canvas.drawText("CW = "+revolutions,(float).374*width,(float).91*height,black);
        black.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(UnitCircle.xCoordTop(position)+UnitCircle.xCoordBot(position),(float).73*width,(float).793*height,x);
        canvas.drawText(UnitCircle.yCoordTop(position)+UnitCircle.yCoordBot(position),(float).91*width,(float).793*height,y);
        canvas.drawText(UnitCircle.yCoordTop(position)+UnitCircle.yCoordBot(position),(float).23*width,(float).73*height,y);//sinTop
        canvas.drawText(UnitCircle.xCoordTop(position)+UnitCircle.xCoordBot(position),(float).23*width,(float).793*height,x);//cosTop
        canvas.drawText(UnitCircle.tanTop(position)+UnitCircle.tanBot(position),(float).23*width,(float).859*height,black);
        canvas.drawText(UnitCircle.cscTop(position)+UnitCircle.cscBot(position),(float).54*width,(float).729*height,black);
        canvas.drawText(UnitCircle.secTop(position)+UnitCircle.secBot(position),(float).54*width,(float).795*height,black);
        canvas.drawText(UnitCircle.cotTop(position)+UnitCircle.cotBot(position),(float).54*width,(float).86*height,black);
        black.setTextAlign(Paint.Align.RIGHT);
        canvas.drawText(UnitCircle.radTop(position, revolutions) + UnitCircle.radBot(position), (float) .99 * width, (float) .115 * height, black);
        black.setTextAlign(Paint.Align.LEFT);
        canvas.drawText(UnitCircle.degrees(position,revolutions),(float) .02*width,(float).115*height, black);

        canvas.drawCircle((int)(xCoord/1000*width),(int)(yCoord/1000*height),(int)(.01*height), black);
        canvas.drawLine((float).502*width,(float).362*height,(float)xCoord/1000*width,(float).362*height,x);
        canvas.drawLine((float)xCoord/1000*width,(float).362*height,(float)xCoord/1000*width,(float)yCoord/1000*height,y);
        canvas.drawLine((float).502*width,(float).362*height,(float)xCoord/1000*width,(float)yCoord/1000*height,hyp);
        f1.setForeground(new BitmapDrawable(bg));
    }

    private void startUp(){
        new CountDownTimer(3200, 100) {
            public void onTick(long millisUntilFinished) {
                UCDrawings(coords[position].x, coords[position].y);
                position = (position+1) % 16;
            }

            public void onFinish() {
                position = 0;
                parts=0;
                revolutions=0;
                UCDrawings(coords[0].x, coords[0].y);
            }
        }.start();
    }

    private void points(){
        coords[0]=(new Point(880,362));
        coords[1]=(new Point(830,228));
        coords[2]=(new Point(769,172));
        coords[3]=(new Point(689,129));
        coords[4]=(new Point(502,94));
        coords[5]=(new Point(313,129));
        coords[6]=(new Point(234,172));
        coords[7]=(new Point(173,228));
        coords[8]=(new Point(123,362));
        coords[9]=(new Point(173,499));
        coords[10]=(new Point(234,550));
        coords[11]=(new Point(313,593));
        coords[12]=(new Point(502,628));
        coords[13]=(new Point(689,593));
        coords[14]=(new Point(769,550));
        coords[15]=(new Point(830,499));
    }

    private void animateJumps() {
        if(Math.abs(position-np)<=1&& position>np){
            position = np;
            parts--;
            UCDrawings(coords[position].x, coords[position].y);
        }
        else if(Math.abs(position-np)<=1&& position<np){
            position = np;
            parts++;
            UCDrawings(coords[position].x, coords[position].y);
        }
        else {
            new CountDownTimer(600, 1) {
                public void onTick(long millisUntilFinished) {
                    if (Math.abs(position - np) < 8 && position > np) {
                        position--;
                        parts--;
                        if (position < 0) position = 15;
                        UCDrawings(coords[position].x, coords[position].y);
                    } else if (Math.abs(position - np) < 9 && position < np) {
                        position++;
                        parts++;
                        position = position % 16;
                        UCDrawings(coords[position].x, coords[position].y);
                    } else if (Math.abs(position - np) >= 8 && position > np) {
                        position++;
                        parts++;
                        position = position % 16;
                        UCDrawings(coords[position].x, coords[position].y);
                    } else if (Math.abs(position - np) >= 9 && position < np) {
                        position--;
                        parts--;
                        if (position < 0) position = 15;
                        UCDrawings(coords[position].x, coords[position].y);
                    }
                }

                public void onFinish() {
                    UCDrawings(coords[position].x, coords[position].y);
                    revolutions = parts / 16;
                    if (position != np) animateJumps();
                }
            }.start();
        }
    }
    public static int getParts(){
        return parts;
    }

    private void toggleListen(){
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    rl.setBackgroundResource(0);
                    xCoord1=.71*width;
                    yCoord1=.27*height;
                    xCoord=(coords[8].x-80) / 1000.0 * width;
                    yCoord=coords[8].y/1000.0 * height;
                    outerRadious = Math.sqrt(Math.pow((coords[0].x+80) / 1000.0 * width - .502 * width, 2) + Math.pow(coords[0].y/1000.0 * height - .362 * height, 2));
                    innerRadious = Math.sqrt(Math.pow((coords[0].x-125)/1000.0 * width - .502 * width, 2) + Math.pow(coords[0].y/1000.0 * height - .362 * height, 2));
                    revolutions = 1;
                    revolutions1 = 1;
                    lastQuad=2;
                    lastQuad1=1;
                    CAListener();
                    CADrawings(true);
                }
                else {
                    rl.setBackgroundResource(R.mipmap.unitcircle);
                    f1.setForeground(new BitmapDrawable());
                    revolutions=0;
                    parts=0;
                    UCListener();
                }
            }
        });
    }

    private void CADrawings(boolean line0){
        Paint red = new Paint();
        red.setStrokeWidth(10);
        red.setColor(Color.RED);
        red.setPathEffect(new DashPathEffect(new float[]{10, 10}, 0));
        Paint blue = new Paint();
        blue.setStrokeWidth(10);
        blue.setColor(Color.BLUE);
        Paint black = new Paint();
        black.setColor(Color.BLACK);
        black.setStrokeWidth(3);
        Bitmap bg = Bitmap.createBitmap(width,height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bg);
        //draw background
        Paint outline = new Paint();
        outline.setColor(Color.BLACK);
        outline.setStyle(Paint.Style.STROKE);
        outline.setStrokeWidth(8);
        double diameter = .46*width;
        canvas.drawCircle((float).502*width,(float).362*height,(float)diameter,outline);
        canvas.drawLine((float) (coords[8].x-80)/1000 * width, (float) (coords[8].y)/1000 * height, (float) (coords[0].x+80) / 1000 * width, (float) coords[0].y/1000 * height, black);
        canvas.drawLine((float) (coords[4].x)/1000 * width, (float) (coords[4].y-40)/1000 * height, (float) (coords[12].x) / 1000 * width, (float) (coords[12].y+40)/1000 * height, black);
        black.setTextSize(42);
        red.setTextSize(45);
        blue.setTextSize(45);
        black.setTextAlign(Paint.Align.RIGHT);
        canvas.drawText("Rad", (float) .98 * width, (float) .7 * height, black);
        black.setTextAlign(Paint.Align.LEFT);
        canvas.drawText("Deg",(float) .02*width,(float).7*height,black);
        black.setTextAlign(Paint.Align.CENTER);
        canvas.drawText("Revolutions",(float).502*width,(float).7*height,black);
        red.setTextAlign(Paint.Align.CENTER);
        blue.setTextAlign(Paint.Align.CENTER);
        if (revolutions-1 > 0)
            canvas.drawText("CCW = " + (revolutions-1), (float) .502 * width, (float) .733 * height, red);
        else if (revolutions < 0)
            canvas.drawText("CW = " + revolutions, (float) .502 * width, (float) .733 * height, red);
        if (revolutions1-1 > 0)
            canvas.drawText("CCW = " + (revolutions1-1), (float) .502 * width, (float) .77 * height, blue);
        else if (revolutions1 < 0)
            canvas.drawText("CW = " + revolutions1, (float) .502 * width, (float) .77 * height, blue);
        black.setTextSize(50);
        if(line0) {

            //canvas.drawText(UnitCircle.radTop(position, revolutions), (float) .88 * width, (float) .055 * height, red);
            //canvas.drawText(UnitCircle.radBot(position), (float) .922 * width, (float) .095 * height, red);
            //canvas.drawText(UnitCircle.degrees(position, revolutions), (float) .031 * width, (float) .055 * height, red);
            //snapTo(true);
            canvas.drawText(coTerm(),(float).502*width,(float).85*height,black);
            red.setTextAlign(Paint.Align.LEFT);
            canvas.drawText(Math.round((float) Math.toDegrees(rads(xCoord, yCoord, outerRadious)) + (360 * (revolutions - 1))) + "\u00b0", (float) .02 * width, (float) .733 * height, red);
            red.setTextAlign(Paint.Align.RIGHT);
            canvas.drawText(String.format("%.2f", (float) rads(xCoord, yCoord, outerRadious) + 6.28 * (revolutions - 1)) + "r", (float) .98 * width, (float) .733 * height, red);
            blue.setTextAlign(Paint.Align.LEFT);
            canvas.drawText(Math.round((float)Math.toDegrees(rads(xCoord1,yCoord1,innerRadious))+(360*(revolutions1-1)))+"\u00b0",(float).02*width,(float).77*height,blue);
            blue.setTextAlign(Paint.Align.RIGHT);
            canvas.drawText(String.format("%.2f",(float)rads(xCoord1,yCoord1,innerRadious)+(6.28*(revolutions1-1)))+"r",(float).98*width,(float).77*height,blue);
            canvas.drawLine((float) .502 * width, (float) .362 * height, (float) (coords[0].x+80) / 1000 * width, (float) coords[0].y/1000 * height, red);
            canvas.drawLine((float) .502 * width, (float) .362 * height, (float) xCoord1, (float) yCoord1, blue);
            canvas.drawLine((float) .502 * width, (float) .362 * height, (float) xCoord, (float) yCoord, red);
            canvas.drawCircle((float)xCoord,(float)yCoord, (float) (.01 * height), black);
            canvas.drawCircle((float) xCoord1, (float)yCoord1, (float) (.01 * height), black);
        }
        else{

            //canvas.drawText(UnitCircle.radTop(position, revolutions), (float) .88 * width, (float) .055 * height, blue);
            //canvas.drawText(UnitCircle.radBot(position), (float) .922 * width, (float) .095 * height, blue);
            //canvas.drawText(UnitCircle.degrees(position, revolutions), (float) .031 * width, (float) .055 * height, blue);
            //snapTo(false);
            canvas.drawText(coTerm(),(float).502*width,(float).85*height,black);
            red.setTextAlign(Paint.Align.LEFT);
            canvas.drawText(Math.round((float)Math.toDegrees(rads(xCoord,yCoord,outerRadious))+(360*(revolutions-1)))+"\u00b0",(float).02*width,(float).733*height,red);
            red.setTextAlign(Paint.Align.RIGHT);
            canvas.drawText(String.format("%.2f",(float)rads(xCoord,yCoord,outerRadious)+6.28*(revolutions-1))+"r",(float).98*width,(float).733*height,red);
            blue.setTextAlign(Paint.Align.LEFT);
            canvas.drawText(Math.round((float)Math.toDegrees(rads(xCoord1,yCoord1,innerRadious))+(360*(revolutions1-1)))+"\u00b0",(float).02*width,(float).77*height,blue);
            blue.setTextAlign(Paint.Align.RIGHT);
            canvas.drawText(String.format("%.2f",(float)rads(xCoord1,yCoord1,innerRadious)+(6.28*(revolutions1-1)))+"r",(float).98*width,(float).77*height,blue);
            canvas.drawLine((float) .502 * width, (float) .362 * height, (float) (coords[0].x+80) / 1000 * width, (float) coords[0].y/1000 * height, blue);
            canvas.drawLine((float) .502 * width, (float) .362 * height, (float) xCoord1, (float) yCoord1, blue);
            canvas.drawLine((float) .502 * width, (float) .362 * height, (float) xCoord, (float) yCoord, red);
            canvas.drawCircle((float) xCoord1, (float) yCoord1, (int) (.01 * height), black);
            canvas.drawCircle((float) xCoord, (float) yCoord, (float) (.01 * height), black);
        }
        canvas.drawCircle((float) ((coords[0].x+80) / 1000.0 * width), (float) (coords[0].y / 1000.0 * height), (float) (.01 * height), black);
        f1.setForeground(new BitmapDrawable(bg));
    }

    private String coTerm() {
        if(Math.abs(rads(xCoord,yCoord,outerRadious)-rads(xCoord1,yCoord1,innerRadious))<.01){
            return "The angles are COTERMINAL";
        }
        else return "";
    }

    private void snapTo(boolean isRed) {
        if(Math.abs(rads(xCoord,yCoord,outerRadious)-rads(xCoord1,yCoord1,innerRadious))<.2){
            if(isRed){
                xCoord = xCoord1;
                yCoord = yCoord1;
                double touchRadious;
                touchRadious = Math.sqrt(Math.pow(xCoord - .502 * width, 2) + Math.pow(yCoord - .362 * height, 2));
                while(Math.abs(touchRadious-outerRadious)>2 && Math.abs(rads(xCoord,yCoord,outerRadious)-rads(xCoord1,yCoord1,innerRadious))>.01){
                    if(xCoord>.502*width)xCoord+=1;
                    else xCoord-=1;
                    if(yCoord>.362*height)yCoord+=1;
                    else yCoord-=1;
                    touchRadious = Math.sqrt(Math.pow(xCoord - .502 * width, 2) + Math.pow(yCoord - .362 * height, 2));
                }
            }
            else{
                xCoord1 = xCoord;
                yCoord1 = yCoord;
                double touchRadious;
                touchRadious = Math.sqrt(Math.pow(xCoord1 - .502 * width, 2) + Math.pow(yCoord1 - .362 * height, 2));
                while(Math.abs(touchRadious-innerRadious)>2 && Math.abs(rads(xCoord,yCoord,outerRadious)-rads(xCoord1,yCoord1,innerRadious))>.01){
                    if(xCoord1>.502*width)xCoord1-=1;
                    else xCoord1+=1;
                    if(yCoord1>.362*height)yCoord1-=1;
                    else yCoord1+=1;
                    touchRadious = Math.sqrt(Math.pow(xCoord1 - .502 * width, 2) + Math.pow(yCoord1 - .362 * height, 2));
                }
            }
        }
    }

    private double rads(double x,double y,double radious) {
        Double rad1;
        if((.362*height-y)/radious>=0 && (x-.502*width)/radious>=0){//first quadrant
            if((x-.502*width)/radious>=1){
                rad1=Math.acos((1));
            }
            else{
                rad1 = Math.acos((x - .502 * width) / radious);
            }
        }
        else if((.362*height-y)/radious>=0 && (x-.502*width)/radious<0){//second quadrant
            if((x-.502*width)/radious<=-1){
                rad1=Math.acos((-1));
            }
            else{
                rad1 = Math.acos((x - .502 * width) / radious);
            }
        }
        else if((.362*height-y)/radious<0 && (x-.502*width)/radious<0){//third quadrant
            if((x-.502*width)/radious<=-1){
                rad1=6.28-Math.acos((-1));
            }
            else{
                rad1=6.28-Math.acos((x-.502*width)/radious);
            }
        }
        else{//fourth quadrant
            if((x-.502*width)/radious>=1){
                rad1=6.28-Math.acos((1));
            }
            else{
                rad1=6.28-Math.acos((x-.502*width)/radious);
            }
        }
        return rad1;
    }

    private void CAListener(){
        rl.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                //TextView test = (TextView)findViewById(R.id.textView);
                double x=motionEvent.getX(),y=motionEvent.getY();
                //test.setText("Touch coordinates : " + String.valueOf(x) + "x" + String.valueOf(y));
                double touchRadious;
                touchRadious = Math.sqrt(Math.pow(x - .502 * width, 2) + Math.pow(y - .362 * height, 2));

                if((Math.abs(touchRadious-outerRadious))<delta) {
                    double temp = touchRadious;
                    while(Math.abs(temp-outerRadious)>1){
                        if(temp>outerRadious){
                            if(x>.502*width)x-=1;
                            else x+=1;
                            if(y>.362*height)y-=1;
                            else y+=1;
                        }
                        else{
                            if(x>.502*width)x+=1;
                            else x-=1;
                            if(y>.362*height)y+=1;
                            else y-=1;
                        }
                        temp = Math.sqrt(Math.pow(x - .502 * width, 2) + Math.pow(y - .362 * height, 2));
                    }
                    xCoord=x;
                    yCoord=y;
                    CADrawings(true);
                }
                else if((Math.abs(touchRadious-innerRadious))<delta){
                    double temp = touchRadious;
                    while(Math.abs(temp-innerRadious)>1){
                        if(temp>innerRadious){
                            if(x>.502*width)x-=1;
                            else x+=1;
                            if(y>.362*height)y-=1;
                            else y+=1;
                        }
                        else{
                            if(x>.502*width)x+=1;
                            else x-=1;
                            if(y>.362*height)y+=1;
                            else y-=1;
                        }
                        temp = Math.sqrt(Math.pow(x - .502 * width, 2) + Math.pow(y - .362 * height, 2));
                    }
                    xCoord1=x;
                    yCoord1=y;
                    CADrawings(false);
                }
                CARevolutions();
                return true;
            }
        });
    }

    private void CARevolutions(){
        int newQuad,newQuad1;
        if((.362*height-yCoord)>=0 && (xCoord-.502*width)>=0)newQuad=1;
        else if((.362*height-yCoord)>=0 && (xCoord-.502*width)<0)newQuad=2;
        else if((.362*height-yCoord)<0 && (xCoord-.502*width)<0)newQuad=3;
        else newQuad=4;

        if(newQuad==1 && lastQuad==4){
            revolutions++;
        }
        else if(newQuad==4 && lastQuad==1){
            revolutions--;
        }
        lastQuad = newQuad;

        if((.362*height-yCoord1)>=0 && (xCoord1-.502*width)>=0)newQuad1=1;
        else if((.362*height-yCoord1)>=0 && (xCoord1-.502*width)<0)newQuad1=2;
        else if((.362*height-yCoord1)<0 && (xCoord1-.502*width)<0)newQuad1=3;
        else newQuad1=4;

        if(newQuad1==1 && lastQuad1==4){
            revolutions1++;
        }
        else if(newQuad1==4 && lastQuad1==1){
            revolutions1--;
        }
        lastQuad1 = newQuad1;
    }

    public void doButtonClick(View e){
        Intent goToNextActivity = new Intent(this, DonationPage.class);
        startActivity(goToNextActivity);
    }

    @Override
    public void onReadyToShow() {
        interstitial.show();
    }

    @Override
    public void onWillShow() {

    }

    @Override
    public void onWillOpenLandingPage() {

    }

    @Override
    public void onWillClose() {

    }

    @Override
    public void onFailedToLoadAd() {

    }
}