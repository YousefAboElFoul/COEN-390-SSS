
// These constants won't change:
const int sensorPinTHUMB = A0;    // pin that the THUMB flex sensor is attached to
const int sensorPinINDEX = A1;    // pin that the INDEX flex sensor is attached to
const int sensorPinMIDDLE = A2;    // pin that the MIDDLE flex sensor is attached to
const int sensorPinRING = A3;    // pin that the RING flex sensor is attached to
const int sensorPinPINKEY = A4;    // pin that the PINKEY flex sensor is attached to
const int sensorPinWRIST = A5;

// variables:
int sensorValueTHUMB = 0;         // the sensor value
int sensorValueINDEX = 0;         // the sensor value
int sensorValueMIDDLE = 0;         // the sensor value
int sensorValueRING = 0;         // the sensor value
int sensorValuePINKEY = 0;         // the sensor value
int sensorValueWRIST = 0;

int sensorMinTHUMB = 1023;        // minimum sensor value
int sensorMinINDEX = 1023;        // minimum sensor value
int sensorMinMIDDLE = 1023;        // minimum sensor value
int sensorMinRING = 1023;        // minimum sensor value
int sensorMinPINKEY = 1023;        // minimum sensor value
int sensorMinWRIST = 1023;

int sensorMaxTHUMB = 0;           // maximum sensor value
int sensorMaxINDEX = 0;           // maximum sensor value
int sensorMaxMIDDLE = 0;           // maximum sensor value
int sensorMaxRING = 0;           // maximum sensor value
int sensorMaxPINKEY = 0;           // maximum sensor value
int sensorMaxWRIST = 0;

    
extern volatile unsigned long timer0_millis;

char appinput;
void setup()
{
  
  sensorValueTHUMB = 0;         // the sensor value
  sensorValueINDEX = 0;         // the sensor value
  sensorValueMIDDLE = 0;         // the sensor value
  sensorValueRING = 0;         // the sensor value
  sensorValuePINKEY = 0;         // the sensor value
  sensorValueWRIST = 0;

    sensorMinTHUMB = 1023;        // minimum sensor value
    sensorMinINDEX = 1023;        // minimum sensor value
    sensorMinMIDDLE = 1023;        // minimum sensor value
    sensorMinRING = 1023;        // minimum sensor value
    sensorMinPINKEY = 1023;        // minimum sensor value
    sensorMinWRIST = 1023;

    sensorMaxTHUMB = 0;           // maximum sensor value
    sensorMaxINDEX = 0;           // maximum sensor value
    sensorMaxMIDDLE = 0;           // maximum sensor value
    sensorMaxRING = 0;           // maximum sensor value
    sensorMaxPINKEY = 0;           // maximum sensor value
    sensorMaxWRIST = 0;
  
  Serial.begin (9600);

  noInterrupts ();
  timer0_millis = 0;
  interrupts ();

  // calibrate during the first five seconds 
  while (millis() < 5000) {
      sensorValueTHUMB = analogRead(sensorPinTHUMB);
      sensorValueINDEX = analogRead(sensorPinINDEX);
      sensorValueMIDDLE = analogRead(sensorPinMIDDLE);
      sensorValueRING = analogRead(sensorPinRING);
      sensorValuePINKEY = analogRead(sensorPinPINKEY);
      sensorValueWRIST = analogRead(sensorPinWRIST);

      
//--------------------------------------------------
    // record the maximum sensor value
    if (sensorValueTHUMB > sensorMaxTHUMB) {
      sensorMaxTHUMB = sensorValueTHUMB;
    }
       // record the maximum sensor value
    if (sensorValueINDEX > sensorMaxINDEX) {
      sensorMaxINDEX = sensorValueINDEX;
    }
   // record the maximum sensor value
    if (sensorValueMIDDLE > sensorMaxMIDDLE) {
      sensorMaxMIDDLE = sensorValueMIDDLE;
    }
    // record the maximum sensor value
    if (sensorValueRING > sensorMaxRING) {
      sensorMaxRING = sensorValueRING;
    }
     // record the maximum sensor value
    if (sensorValuePINKEY > sensorMaxPINKEY) {
      sensorMaxPINKEY = sensorValuePINKEY;
    }

      // record the maximum sensor value
    if (sensorValueWRIST > sensorMaxWRIST) {
      sensorMaxWRIST = sensorValueWRIST;
    }
 
    //--------------------------------------------------------

    // record the minimum sensor value
    if (sensorValueTHUMB < sensorMinTHUMB) {
      sensorMinTHUMB = sensorValueTHUMB;
    }
    
       // record the minimum sensor value
    if (sensorValueINDEX < sensorMinINDEX) {
      sensorMinINDEX = sensorValueINDEX;
    }
        // record the minimum sensor value
    if (sensorValueMIDDLE < sensorMinMIDDLE) {
      sensorMinMIDDLE = sensorValueMIDDLE;
    }
    // record the minimum sensor value
    if (sensorValueRING < sensorMinRING) {
      sensorMinRING = sensorValueRING;
    }
    // record the minimum sensor value
    if (sensorValuePINKEY < sensorMinPINKEY) {
      sensorMinPINKEY = sensorValuePINKEY;
    }
     if (sensorValueWRIST < sensorMinWRIST) {
      sensorMinWRIST = sensorValueWRIST;
    }
  }
  
  /*Serial.print ("LowTHUMB = ");
  Serial.println (sensorMinTHUMB);
  Serial.print ("HighTHUMB = ");
  Serial.println (sensorMaxTHUMB);
  
  Serial.println ("             ");
  
  Serial.print ("LowINDEX = ");
  Serial.println (sensorMinINDEX);
  Serial.print ("HighINDEX = ");
  Serial.println (sensorMaxINDEX);
  
  Serial.println ("             "); 
  
  Serial.print ("LowMIDDLE = ");
  Serial.println (sensorMinMIDDLE);
  Serial.print ("HighMIDDLE = ");
  Serial.println (sensorMaxMIDDLE);
  
  Serial.println ("             "); 
  
   Serial.print ("LowRING = ");
  Serial.println (sensorMinRING);
  Serial.print ("HighRING = ");
  Serial.println (sensorMaxRING);
  
  Serial.println ("             "); 
  
  Serial.print ("LowPINKEY = ");
  Serial.println (sensorMinPINKEY);
  Serial.print ("HighPINKEY = ");
  Serial.println (sensorMaxPINKEY);

  Serial.print ("LowWRIST = ");
  Serial.println (sensorMinWRIST);
  Serial.print ("HighWRIST = ");
  Serial.println (sensorMaxWRIST);
  
  Serial.println ("             ");*/
}

void loop()
  {
     appinput = Serial.read();

    if(appinput == '0')
    
    {
      setup();
    }
  
  // read the sensor:
  sensorValueTHUMB = analogRead(sensorPinTHUMB);
  sensorValueINDEX = analogRead(sensorPinINDEX);
  sensorValueMIDDLE = analogRead(sensorPinMIDDLE);
  sensorValueRING = analogRead(sensorPinRING);
  sensorValuePINKEY = analogRead(sensorPinPINKEY);
  sensorValueWRIST = analogRead(sensorPinWRIST);

  delay(1000);
  
  // apply the calibration to the sensor reading
  sensorValueTHUMB = map(sensorValueTHUMB, sensorMinTHUMB, sensorMaxTHUMB, 1, 255);
  sensorValueINDEX = map(sensorValueINDEX, sensorMinINDEX, sensorMaxINDEX, 1, 255);
  sensorValueMIDDLE = map(sensorValueMIDDLE, sensorMinMIDDLE, sensorMaxMIDDLE, 1, 255);
  sensorValueRING = map(sensorValueRING, sensorMinRING, sensorMaxRING, 1, 255);
  sensorValuePINKEY = map(sensorValuePINKEY, sensorMinPINKEY, sensorMaxPINKEY, 1, 255);
  sensorValueWRIST = map(sensorValueWRIST, sensorMinWRIST, sensorMaxWRIST, 1, 255);
  

  // in case the sensor value is outside the range seen during calibration
  sensorValueTHUMB = constrain(sensorValueTHUMB, 1, 255);
  sensorValueINDEX = constrain(sensorValueINDEX, 1, 255);
  sensorValueMIDDLE = constrain(sensorValueMIDDLE, 1, 255);
  sensorValueRING = constrain(sensorValueRING, 1, 255);
  sensorValuePINKEY = constrain(sensorValuePINKEY, 1, 255);
  sensorValueWRIST = constrain(sensorValueWRIST, 1, 255);


    /*Serial.println ("-------------------");
    Serial.print ("sensorValue-THUMB = ");
    Serial.println (sensorValueTHUMB);

    Serial.print ("sensorValue-INDEX = ");
    Serial.println (sensorValueINDEX);

    Serial.print ("sensorValue-MIDDLE = ");
    Serial.println (sensorValueMIDDLE);

    Serial.print ("sensorValue-RING = ");
    Serial.println (sensorValueRING);

    Serial.print ("sensorValue-PINKEY = ");
    Serial.println (sensorValuePINKEY);

    Serial.print ("sensorValue-WRIST = ");
    Serial.println (sensorValueWRIST);

    Serial.println ("   ");
    Serial.println (" ");
    Serial.println(appinput);*/
    
if(appinput == '1')
{

    //--------------------------------LetterA-----------------------------

  if (sensorValueTHUMB < 60 && sensorValueINDEX > 120 && sensorValueMIDDLE > 120 && sensorValueRING > 180 && sensorValuePINKEY > 120 && sensorValueWRIST < 100)
  {

    Serial.write("A");
    
    
  }

  

  //--------------------------------LetterB-----------------------------

  else if (sensorValueTHUMB > 100 && sensorValueINDEX < 60 && sensorValueMIDDLE < 60 && sensorValueRING < 60 && sensorValuePINKEY < 60 && sensorValueWRIST < 100)
  {

    Serial.write("B");

  }


  //--------------------------------LetterC-----------------------------


 else if (sensorValueTHUMB < 150 && sensorValueTHUMB < 150 && sensorValueINDEX < 150  && sensorValueMIDDLE < 150 && sensorValueRING < 100 && sensorValuePINKEY < 150  && sensorValueWRIST < 100 )
  {

    Serial.write("C");
    
  }

 

else  if (sensorValueINDEX < 50 && sensorValueTHUMB > 150 && sensorValueMIDDLE > 150 && sensorValueRING > 150 && sensorValuePINKEY > 150 && sensorValueWRIST < 100) 
  {

    Serial.write("D");

  }



  //--------------------------------LetterE-----------------------------


 else if (sensorValueTHUMB > 170 && sensorValueTHUMB < 220 && sensorValueINDEX > 100  && sensorValueINDEX < 180  && sensorValueMIDDLE > 170 && sensorValueMIDDLE < 220 && sensorValueRING > 180 && sensorValueRING < 220 && sensorValuePINKEY > 170 && sensorValuePINKEY < 220 && sensorValueWRIST < 100 )
  {

    Serial.write("E");

  }


  //--------------------------------LetterF-----------------------------


 else if (sensorValueTHUMB > 200 && sensorValueINDEX > 200 && sensorValueMIDDLE < 30 && sensorValueRING < 30 && sensorValuePINKEY < 30 && sensorValueWRIST < 100)
  {

    Serial.write("F");

  }
  else if (sensorValueTHUMB > 30 && sensorValueTHUMB < 100 && sensorValueINDEX > 30 && sensorValueINDEX < 100 && sensorValueMIDDLE > 200 && sensorValueRING > 200 && sensorValuePINKEY < 150 && sensorValueWRIST < 100)

  {

 

    Serial.write("G");

 

  }
   else if (sensorValueTHUMB > 200 &&  sensorValueINDEX > 30 &&  sensorValueMIDDLE < 60 && sensorValueRING > 200  && sensorValuePINKEY > 150 && sensorValueWRIST > 100 )

  {

 

    Serial.write("H");

 

  }

  else if (sensorValueTHUMB > 200 && sensorValueINDEX > 200 && sensorValueMIDDLE > 200 && sensorValueRING > 200 && sensorValuePINKEY < 30 && sensorValueWRIST < 100)

  {

 

    Serial.write("I");

 

  }

   else if (sensorValueTHUMB > 200 && sensorValueINDEX > 200 && sensorValueMIDDLE > 200 && sensorValueRING > 200 && sensorValuePINKEY < 30 && sensorValueWRIST > 180)

  {

 

    Serial.write("J");

 

  }



else if (sensorValueTHUMB < 30 && sensorValueINDEX < 30 && sensorValueMIDDLE < 100 && sensorValueRING > 200 && sensorValuePINKEY > 150 && sensorValueWRIST < 100)

  {

 

    Serial.write("K");

 

  }




//letter L

 

 else if (sensorValueTHUMB < 30 && sensorValueINDEX < 30 && sensorValueMIDDLE >200 && sensorValueRING > 200 && sensorValuePINKEY > 150 && sensorValueWRIST)

  {

 

    Serial.write("L");

 

  }



//letter M

 

 else if (sensorValueTHUMB > 150  && sensorValueTHUMB < 170  &&  sensorValueINDEX > 100 && sensorValueINDEX < 130 &&  sensorValueMIDDLE > 150 && sensorValueMIDDLE < 170 && sensorValueRING > 160 && sensorValueRING < 190 && sensorValuePINKEY > 160 && sensorValuePINKEY < 190 && sensorValueWRIST < 100)

  {

 

    Serial.write("M");

 

  }


 

 

 

//letter N

 
else if (sensorValueTHUMB > 150  && sensorValueTHUMB < 180  &&  sensorValueINDEX > 80 && sensorValueINDEX < 120 &&  sensorValueMIDDLE > 150 && sensorValueMIDDLE < 170 && sensorValueRING > 180 && sensorValueRING < 220 && sensorValuePINKEY > 160 && sensorValuePINKEY < 190 && sensorValueWRIST < 100)

  {

 

    Serial.write("N");

 

  }

  

 

//letter O

 

  else if (sensorValueTHUMB > 50  && sensorValueTHUMB <100  &&  sensorValueINDEX > 70 && sensorValueINDEX < 120 &&  sensorValueMIDDLE > 120 && sensorValueMIDDLE < 160 && sensorValueRING > 120 && sensorValueRING < 160 && sensorValuePINKEY > 120 && sensorValuePINKEY < 160 && sensorValueWRIST < 100)

  {

 

    Serial.write("O");

 

  }

 

  else if (sensorValueTHUMB < 30 && sensorValueINDEX < 30 && sensorValueMIDDLE < 100 && sensorValueRING > 200 && sensorValuePINKEY > 150 && sensorMaxWRIST > 180)

  {

 

    Serial.write("P");

 

  }
 else if (sensorValueTHUMB > 30 && sensorValueTHUMB < 100 && sensorValueINDEX > 30 && sensorValueINDEX < 100 && sensorValueMIDDLE > 200 && sensorValueRING > 200 && sensorValuePINKEY < 150 && sensorValueWRIST > 180)

  {

 

    Serial.write("Q");

 

  }

  else if (sensorValueTHUMB >120  && sensorValueTHUMB <150&& sensorValueINDEX < 10 && sensorValueMIDDLE < 70 && sensorValueRING > 160 && sensorValueRING <200 && sensorValuePINKEY > 160 && sensorValuePINKEY < 200 && sensorValueWRIST < 100)

  {

 

    Serial.write("R");

 

  }

//letter s

 

  else if (sensorValueTHUMB > 170 && sensorValueTHUMB < 220 && sensorValueINDEX > 100  && sensorValueINDEX < 180  && sensorValueMIDDLE > 170 && sensorValueMIDDLE < 220 && sensorValueRING < 200 && sensorValuePINKEY > 170 && sensorValuePINKEY > 200 && sensorValueWRIST < 100 )
  {

    Serial.write("S");

  }

 

//letter t (after)

 

 else if (sensorValueTHUMB > 100  && sensorValueTHUMB < 150  &&  sensorValueINDEX > 30 && sensorValueINDEX < 90 &&  sensorValueMIDDLE > 160 && sensorValueMIDDLE < 190 && sensorValueRING > 180 && sensorValueRING < 220 && sensorValuePINKEY > 170 && sensorValuePINKEY < 200 && sensorValueWRIST < 100)

  {

 

    Serial.write("T");

 

  }


//letter U

 

  else if (sensorValueTHUMB > 180 &&  sensorValueINDEX < 30 &&  sensorValueMIDDLE < 30 && sensorValueRING > 180  && sensorValuePINKEY > 180 && sensorValueWRIST < 100 )

  {

 

    Serial.write("U");

 

  }

 

 
 

//letter V

 

 else if (sensorValueTHUMB > 180 &&  sensorValueINDEX < 90 && sensorValueINDEX > 40 &&  sensorValueMIDDLE < 100 && sensorValueRING > 180  && sensorValuePINKEY > 180 && sensorValueWRIST < 100 )

  {

 

    Serial.write("V");

 

  }

 



//letter W

 

  else if (sensorValueTHUMB >200  &&  sensorValueINDEX < 50  &&  sensorValueMIDDLE < 50  &&  sensorValueRING < 50 && sensorValuePINKEY > 120 && sensorValueWRIST)

  {

 

    Serial.write("W");

 

  }

 

 

//letter X

 

  else if (sensorValueTHUMB > 100  && sensorValueTHUMB < 150  &&  sensorValueINDEX < 30 &&  sensorValueMIDDLE > 150 && sensorValueMIDDLE < 170 && sensorValueRING > 180 && sensorValueRING < 200 && sensorValuePINKEY > 180 && sensorValuePINKEY < 200 && sensorValueWRIST < 100)

  {

 

    Serial.write("X");

 

  }

 


//letter Y

 

else if (sensorValueTHUMB < 30  &&  sensorValueINDEX > 200 &&  sensorValueMIDDLE > 200 && sensorValueRING > 200 && sensorValuePINKEY < 30 && sensorValueWRIST)

  {

 

    Serial.write("Y");

 

  }
  else  if (sensorValueINDEX < 30 && sensorValueTHUMB > 200 && sensorValueMIDDLE > 200 && sensorValueRING > 200 && sensorValuePINKEY > 150 && sensorValueWRIST > 180) 
  {

    Serial.write("Z");

  }

 
 }  
}


