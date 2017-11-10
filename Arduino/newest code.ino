/*
Sign Language Translator, Made with Arduino, Inspired by Jeremy Blum
http://romanakozak.com/sign-language-translator/
Project by: Roman Kozak
Spring 2013
*/

// These constants won't change:
const int sensorPinTHUMB = A0;    // pin that the THUMB flex sensor is attached to
const int sensorPinINDEX = A1;    // pin that the INDEX flex sensor is attached to
const int sensorPinMIDDLE = A2;    // pin that the MIDDLE flex sensor is attached to
const int sensorPinRING = A3;    // pin that the RING flex sensor is attached to
const int sensorPinPINKEY = A4;    // pin that the PINKEY flex sensor is attached to
const int xPin = 2;    // X output of the accelerometer
const int yPin = 3;   // y output of the accelerometer
const int button = 7;
const int ledPinBLUE = 4;        // pin that the LED is attached to
const int ledPinGREEN = 5;        // pin that the LED is attached to

// variables:
int sensorValueTHUMB = 0;         // the sensor value
int sensorValueINDEX = 0;         // the sensor value
int sensorValueMIDDLE = 0;         // the sensor value
int sensorValueRING = 0;         // the sensor value
int sensorValuePINKEY = 0;         // the sensor value

int sensorMinTHUMB = 1023;        // minimum sensor value
int sensorMinINDEX = 1023;        // minimum sensor value
int sensorMinMIDDLE = 1023;        // minimum sensor value
int sensorMinRING = 1023;        // minimum sensor value
int sensorMinPINKEY = 1023;        // minimum sensor value

int sensorMaxTHUMB = 0;           // maximum sensor value
int sensorMaxINDEX = 0;           // maximum sensor value
int sensorMaxMIDDLE = 0;           // maximum sensor value
int sensorMaxRING = 0;           // maximum sensor value
int sensorMaxPINKEY = 0;           // maximum sensor value


void setup() {
  
  // turn on LED to signal the start of the calibration period:
  pinMode(6, OUTPUT);
  pinMode(9, OUTPUT);
  pinMode(18, OUTPUT);
  pinMode(xPin, INPUT);
  pinMode(yPin, INPUT);
  pinMode(button, INPUT);
  
  digitalWrite(ledPinBLUE, HIGH);
  
  Serial.begin (9600);

  // calibrate during the first five seconds 
  while (millis() < 5000) {
      sensorValueTHUMB = analogRead(sensorPinTHUMB);
      sensorValueINDEX = analogRead(sensorPinINDEX);
      sensorValueMIDDLE = analogRead(sensorPinMIDDLE);
      sensorValueRING = analogRead(sensorPinRING);
      sensorValuePINKEY = analogRead(sensorPinPINKEY);
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
    // record the minimum sensor value
    if (sensorValueRING < sensorMinRING) {
      sensorMinRING = sensorValueRING;
    }
     // record the maximum sensor value
    if (sensorValuePINKEY > sensorMaxPINKEY) {
      sensorMaxPINKEY = sensorValuePINKEY;
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
  }

  // signal the end of the calibration period
  digitalWrite(ledPinBLUE, LOW);
 
  
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
  
  Serial.println ("             ");*/
  
  delay (1000);
}

void loop()
{
   int switchstate = digitalRead(button);
    if (switchstate == HIGH) 
    {
      clickEvent();
    } 
 }

void clickEvent() 
{
  
  // variables to read the pulse widths:
  int pulseX, pulseY;
  // variables to contain the resulting accelerations
  int accelerationX, accelerationY;
  
  // read pulse from x- and y-axes:
  pulseX = pulseIn(xPin,HIGH);  
  pulseY = pulseIn(yPin,HIGH);    
  // convert the pulse width into acceleration
  // accelerationX and accelerationY are in milli-g's: 
  // earth's gravity is 1000 milli-g's, or 1g.
  accelerationX = ((pulseX / 10) - 500) * 8;
  accelerationY = ((pulseY / 10) - 500) * 8;
  
  // read the sensor:
  sensorValueTHUMB = analogRead(sensorPinTHUMB);
  sensorValueINDEX = analogRead(sensorPinINDEX);
  sensorValueMIDDLE = analogRead(sensorPinMIDDLE);
  sensorValueRING = analogRead(sensorPinRING);
  sensorValuePINKEY = analogRead(sensorPinPINKEY);

  // apply the calibration to the sensor reading
  sensorValueTHUMB = map(sensorValueTHUMB, sensorMinTHUMB, sensorMaxTHUMB, 1, 255);
  sensorValueINDEX = map(sensorValueINDEX, sensorMinINDEX, sensorMaxINDEX, 1, 255);
  sensorValueMIDDLE = map(sensorValueMIDDLE, sensorMinMIDDLE, sensorMaxMIDDLE, 1, 255);
  sensorValueRING = map(sensorValueRING, sensorMinRING, sensorMaxRING, 1, 255);
  sensorValuePINKEY = map(sensorValuePINKEY, sensorMinPINKEY, sensorMaxPINKEY, 1, 255);

  // in case the sensor value is outside the range seen during calibration
  sensorValueTHUMB = constrain(sensorValueTHUMB, 1, 255);
  sensorValueINDEX = constrain(sensorValueINDEX, 1, 255);
  sensorValueMIDDLE = constrain(sensorValueMIDDLE, 1, 255);
  sensorValueRING = constrain(sensorValueRING, 1, 255);
  sensorValuePINKEY = constrain(sensorValuePINKEY, 1, 255);
  
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
  
  Serial.print ("acceleration-X = ");
  Serial.println(accelerationX);
  
  Serial.print ("acceleration-y = ");
  Serial.println(accelerationY);
  
  Serial.println ("   ");
   Serial.println (" ");*/
  
 
//if the glove is tilted up turn on the green led
  
  if (accelerationX > 650) {
    
    digitalWrite (ledPinGREEN, HIGH);
  }
  
  else {
   digitalWrite (ledPinGREEN, LOW); 
  }
  
  //if the glove is tilted to the right turn on the blue led
  
  if (accelerationY > 500) {
    
    digitalWrite (ledPinBLUE, HIGH);
  }
  
  else {
   digitalWrite (ledPinBLUE, LOW); 
  }
  
    // if the glove is tilted to the left turn on the blue led
    
   if (accelerationY < -500) {
    
    digitalWrite (ledPinBLUE, HIGH);
  }
  
  else {
   digitalWrite (ledPinBLUE, LOW); 
  }

  
  //--------------------------------LetterA-----------------------------
  
  if (sensorValueTHUMB < 65 && sensorValueINDEX > 200 && sensorValueMIDDLE > 200 && sensorValueRING > 200 ) {
    
    Serial.write('A');
    
  }
  
  else {
    
  }
  
  //--------------------------------LetterB-----------------------------
  
  if (sensorValueTHUMB > 120 && sensorValueINDEX < 30 && sensorValueMIDDLE < 30 && sensorValueRING < 30) {
    
    Serial.write('B');
    
  }
  
  else {
    
  }
  
  //--------------------------------LetterC-----------------------------
  
  
  if (sensorValueTHUMB < 120 && sensorValueINDEX < 120  && sensorValueMIDDLE < 120 && sensorValueRING < 120 ) {
    
    Serial.write('C');
   
  }
  
  else {
   
  }
  
  //--------------------------------LetterD-----------------------------
  
  
  if (sensorValueINDEX < 30 && sensorValueTHUMB > 100 && sensorValueMIDDLE > 100 && sensorValueRING > 100) {
    
   Serial.write('D');
    
  }
  
  else {
   
  }
  
  //--------------------------------LetterE-----------------------------
  
  
  if (sensorValueTHUMB >100 && sensorValueINDEX > 100  && sensorValueMIDDLE > 100 && sensorValueRING > 100 ) {
    
    Serial.write('E');
    
  }
  
  else {
   
  }
  
  //--------------------------------LetterF-----------------------------
  
  
  if (sensorValueTHUMB >100 && sensorValueINDEX >100 && sensorValueMIDDLE < 30 && sensorValueRING <30) {
    
   Serial.write('F');
    
  }
  
  else {
   
  } 
  }
  

