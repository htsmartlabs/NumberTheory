package com.tapasmandal.tapas.numbertheory;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

/**
 * Created by anami on 1/19/2018.
 */

public class NumberActivity extends Activity implements View.OnClickListener,View.OnTouchListener {

    Button an_bt_number,an_bt_prime,an_bt_lcm,an_bt_gcd,an_bt_factor;
    TextView an_tv_result,an_tv_label;
    ImageButton an_ib_back,an_ib_ok,an_ib_space,an_ib_x;
    final Context mContext = this;
    String inputNumber="";
    static int choose=0,addcount=0;
    String inputMessage[] = {"Enter a number","Enter an integer to check prime or composite",
            "Enter a number to find its prime factorization","Enter numbers to calculate LCM seperated by space ",
            "Enter numbers to calculate GCD seperated by space","Enter the number with missing digits as x and divisor seperated by space "};

    private InterstitialAd mInterstitialAd;
    TextView an_tv_[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);

        an_bt_number = (Button) findViewById(R.id.an_bt_number);
        an_bt_prime = (Button) findViewById(R.id.an_bt_prime);
        an_bt_lcm = (Button) findViewById(R.id.an_bt_lcm);
        an_bt_gcd = (Button) findViewById(R.id.an_bt_gcd);
        an_bt_factor = (Button) findViewById(R.id.an_bt_factor);


        an_bt_number.setOnClickListener(this);
        an_bt_prime.setOnClickListener(this);
        an_bt_lcm.setOnClickListener(this);
        an_bt_gcd.setOnClickListener(this);
        an_bt_factor.setOnClickListener(this);

        an_bt_number.setOnTouchListener(this);
        an_bt_prime.setOnTouchListener(this);
        an_bt_lcm.setOnTouchListener(this);
        an_bt_gcd.setOnTouchListener(this);
        an_bt_factor.setOnTouchListener(this);

        an_ib_back = (ImageButton) findViewById(R.id.an_ib_back);
        an_tv_result = (TextView)findViewById(R.id.an_tv_result);
        an_tv_label = (TextView)findViewById(R.id.an_tv_label);
        an_ib_ok = (ImageButton)findViewById(R.id.an_ib_ok);
        an_ib_space = (ImageButton)findViewById(R.id.an_ib_space);
        an_ib_x = (ImageButton)findViewById(R.id.an_ib_x);

        an_ib_back.setOnClickListener(this);
        an_ib_ok.setOnClickListener(this);
        an_ib_space.setOnClickListener(this);
        an_ib_x.setOnClickListener(this);

        an_ib_back.setOnTouchListener(this);
        an_ib_ok.setOnTouchListener(this);
        an_ib_space.setOnTouchListener(this);
        an_ib_x.setOnTouchListener(this);

        an_tv_ = new TextView[10];

        an_tv_[0] = (TextView)findViewById(R.id.an_tv_0);
        an_tv_[1] = (TextView)findViewById(R.id.an_tv_1);
        an_tv_[2] = (TextView)findViewById(R.id.an_tv_2);
        an_tv_[3] = (TextView)findViewById(R.id.an_tv_3);
        an_tv_[4] = (TextView)findViewById(R.id.an_tv_4);
        an_tv_[5] = (TextView)findViewById(R.id.an_tv_5);
        an_tv_[6] = (TextView)findViewById(R.id.an_tv_6);
        an_tv_[7] = (TextView)findViewById(R.id.an_tv_7);
        an_tv_[8] = (TextView)findViewById(R.id.an_tv_8);
        an_tv_[9] = (TextView)findViewById(R.id.an_tv_9);

        for(int i=0;i<10;i++){
            an_tv_[i].setOnTouchListener(this);
            an_tv_[i].setOnClickListener(this);
        }

        inputKeysEnable(false);

        // Create the InterstitialAd and set the adUnitId (defined in values/strings.xml).
        mInterstitialAd = newInterstitialAd();
        loadInterstitial();

        // Load an ad into the AdMob banner view.
        AdView adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .setRequestAgent("android_studio:ad_template").build();
        adView.loadAd(adRequest);

    }

    public void inputKeysEnable(boolean enable){

        an_ib_back.setEnabled(enable);
        an_ib_ok.setEnabled(enable);
        an_ib_space.setEnabled(enable);
        an_ib_x.setEnabled(enable);

        if(choose == 1 || choose == 2){
            an_ib_space.setEnabled(false);
            an_ib_x.setEnabled(false);
        }else if(choose == 3 || choose == 4) {
            an_ib_x.setEnabled(false);
        }
        for(int i=0;i<10;i++){
            an_tv_[i].setEnabled(enable);
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            v.setBackground(getResources().getDrawable(R.drawable.button_clicked));
            // Do what you want
        }
        if(event.getAction() == MotionEvent.ACTION_UP){
            v.setBackground(getResources().getDrawable(R.drawable.border_settings));
            // Do what you want
        }
        return false;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.an_bt_number:
                addcount++;
                if(addcount % 3 == 0){
                    showInterstitial();
                }
                choose = 1;
                getInput();
                break;
            case R.id.an_bt_prime:
                addcount++;
                if(addcount % 3 == 0){
                    showInterstitial();
                }
                choose = 2;
                getInput();
                break;
            case R.id.an_bt_lcm:
                addcount++;
                if(addcount % 3 == 0){
                    showInterstitial();
                }
                choose = 3;
                getInput();
                break;
            case R.id.an_bt_gcd:
                addcount++;
                if(addcount % 3 == 0){
                    showInterstitial();
                }
                choose = 4;
                getInput();
                break;
            case R.id.an_bt_factor:
                addcount++;
                if(addcount % 3 == 0){
                    showInterstitial();
                }
                choose = 5;
                getInput();
                break;
            case R.id.an_tv_0:
                setDigits("0");
                break;
            case R.id.an_tv_1:
                setDigits("1");
                break;
            case R.id.an_tv_2:
                setDigits("2");
                break;
            case R.id.an_tv_3:
                setDigits("3");
                break;
            case R.id.an_tv_4:
                setDigits("4");
                break;
            case R.id.an_tv_5:
                setDigits("5");
                break;
            case R.id.an_tv_6:
                setDigits("6");
                break;
            case R.id.an_tv_7:
                setDigits("7");
                break;
            case R.id.an_tv_8:
                setDigits("8");
                break;
            case R.id.an_tv_9:
                setDigits("9");
                break;
            case R.id.an_ib_back:
                inputNumber=an_tv_result.getText().toString();
                if(inputNumber.length()>= 2){
                    an_tv_result.setText(inputNumber.substring(0,inputNumber.length()-1));
                }else {
                    an_tv_result.setText("");
                }
                break;
            case R.id.an_ib_space:
                inputNumber=an_tv_result.getText().toString();
                if(inputNumber.length()>0){
                    if(inputNumber.charAt(inputNumber.length()-1) == ' '){
                        setDigits("");
                    }else{
                        setDigits(" ");
                    }
                }
                break;
            case R.id.an_ib_x:
                setDigits("x");
                break;
            case R.id.an_ib_ok:
                inputKeysEnable(false);
                inputNumber=an_tv_result.getText().toString();
                executeProgram(choose);
                break;
        }
    }

    public void executeProgram(int choice){
        String[] strNumbers;
        int[] numbers;
        int result,hcf;
        switch(choice){
            case 1:
                if(primeNumberCheck()){
                    an_tv_result.setText("The number "+inputNumber+" is prime");
                }else{
                    an_tv_result.setText("The number "+inputNumber+" is composite");
                }
                break;
            case 2:
                an_tv_result.setText("The prime factors of "+inputNumber+" is \n"+calculatePrimeFactor(inputNumber));
                break;
            case 3:
                strNumbers = inputNumber.split(" ");
                numbers = new int[strNumbers.length];
                result = 1;
                for(int i =0;i<strNumbers.length;i++){
                    numbers[i] = Integer.parseInt(strNumbers[i]);
                }
                if(numbers.length > 1){
                    hcf = numbers[0];
                    result = numbers[0];
                    for(int i = 1;i < numbers.length; i++){
                        hcf = gcd(hcf,numbers[i]);
                        result = (result * numbers[i]) / hcf;
                    }
                    an_tv_result.setText("The LCM of "+inputNumber+" is \n"+result);
                }
                else{
                    an_tv_result.setText("The LCM of "+inputNumber+" is \n"+inputNumber);
                }
                break;
            case 4:
                strNumbers = inputNumber.split(" ");
                numbers = new int[strNumbers.length];
                for(int i =0;i<strNumbers.length;i++){
                    numbers[i] = Integer.parseInt(strNumbers[i]);
                }
                if(numbers.length > 1){
                    result = numbers[0];
                    for(int i = 1;i < numbers.length; i++){
                        result = gcd(result,numbers[i]);
                    }
                    an_tv_result.setText("The GCD of "+inputNumber+" is \n"+result);
                }
                else{
                    an_tv_result.setText("The GCD of "+inputNumber+" is \n"+inputNumber);
                }
                Log.d("The num",strNumbers[0]);
                break;
            case 5:
                strNumbers = inputNumber.split(" ");
                numbers = new int[strNumbers.length];
                int tempi,temp,count = 0;
                String tempStr,resultString="",resultNumbers="";
                numbers[1] = Integer.parseInt(strNumbers[1]);

                for(int i =0;i<strNumbers[0].length();i++){
                    if(strNumbers[0].charAt(i) == 'x'){
                        count = count + 1;
                    }
                }
                for(int i = 0;i<Math.pow(10,count);i++) {
                    tempi = i;
                    tempStr = strNumbers[0];
                    boolean check=false;
                    for (int j = 0; j < count; j++) {
                        temp = tempi % 10;
                        tempi = tempi / 10;
                        tempStr = tempStr.replaceFirst("x", "" + temp);
                    }
                    Log.d("The num", tempStr);
                    if (Integer.parseInt(tempStr) % Integer.parseInt(strNumbers[1]) == 0){
                        check = true;
                        for(int j = 2;j<strNumbers.length;j++){
                            check = check && Integer.parseInt(tempStr) % Integer.parseInt(strNumbers[j]) == 0;
                        }
                        if(check){
                            resultString = resultString +tempStr+" ";
                        }
                    }
                }
                for(int i =1;i<strNumbers.length;i++){
                    resultNumbers = resultNumbers + strNumbers[i]+" ";
                }
                an_tv_result.setText("The divisible numbers for "+strNumbers[0]+" by "+resultNumbers+"is\n"+resultString);
                break;
        }

    }

    public int gcd(int a,int b){
        if(b == 0) return a;
        else return(gcd(b,a % b));
    }

    public String calculatePrimeFactor(String choice){
        long mainNumber = Long.parseLong(choice);
        long number = mainNumber;
        String result="";
        for(long i=2;i<=mainNumber;i++){
            if(primeNumberCheck(i)){
                if(number % i == 0){
                    while(number % i == 0){
                        number = number / i;
                        result = result + i;
                        if(number != 1){
                            result = result +" X ";
                        }
                    }
                }
            }
        }
        return result;
    }

    public Boolean primeNumberCheck(){
        long givenNumber = Long.parseLong(inputNumber);
        int count = 0;
        if(givenNumber > 1){
            int sqrtNumber = (int)Math.sqrt(givenNumber) + 1;
            for(int i =1;i<=sqrtNumber;i++){
                if(givenNumber % i == 0 ){
                    count = count + 1;
                }
            }
            if(count == 1){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    public Boolean primeNumberCheck(long number){
        long givenNumber = number;
        int count = 0;
        if(givenNumber > 1){
            int sqrtNumber = (int)Math.sqrt(givenNumber) + 1;
            for(int i =1;i<sqrtNumber;i++){
                if(givenNumber % i == 0 ){
                    count = count + 1;
                }
            }
            if(count == 1 ){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    public void setDigits(String digit){
        inputNumber=an_tv_result.getText().toString();
        inputNumber=inputNumber+digit;
        an_tv_result.setText(inputNumber);
    }

    private void getInput(){
        an_tv_label.setText(inputMessage[choose]);
        an_tv_result.setText("");
        inputKeysEnable(true);
    }

    private InterstitialAd newInterstitialAd() {
        InterstitialAd interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId(getString(R.string.interstitial_ad_unit_id));
        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
//                mNextLevelButton.setEnabled(true);
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
//                mNextLevelButton.setEnabled(true);
            }

            @Override
            public void onAdClosed() {
                // Proceed to the next level.
                goToNextLevel();
            }
        });
        return interstitialAd;
    }

    private void showInterstitial() {
        // Show the ad if it's ready. Otherwise toast and reload the ad.
        if (mInterstitialAd != null && mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Toast.makeText(this, "Ad did not load", Toast.LENGTH_SHORT).show();
            goToNextLevel();
        }
    }

    private void loadInterstitial() {
        // Disable the next level button and load the ad.
        AdRequest adRequest = new AdRequest.Builder()
                .setRequestAgent("android_studio:ad_template").build();
        mInterstitialAd.loadAd(adRequest);
    }

    private void goToNextLevel() {
        // Show the next level and reload the ad to prepare for the level after.
//        mLevelTextView.setText("Level " + (++mLevel));
        mInterstitialAd = newInterstitialAd();
        loadInterstitial();
    }
}