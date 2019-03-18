int sensor = A1;
int pin = 7;
int ledVerde = 6;
int ledAmarelo=5;
int valorSensor = 0;
int valorBtn = 0;


void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  pinMode(pin, INPUT_PULLUP);
  pinMode (ledVerde,OUTPUT);
  pinMode (ledAmarelo, OUTPUT);
}

void loop() {
  // put your main code here, to run repeatedly:
  
  valorSensor = analogRead(sensor);

  valorBtn = digitalRead(pin);

  if(valorBtn == 0){
    digitalWrite(ledVerde, HIGH);
    delay(10);
  }else{
    digitalWrite(ledVerde, LOW);
    delay(10);
  }

  
  Serial.println(valorSensor);
  
  analogWrite(ledAmarelo, map(valorSensor, 140, 620, 255, 0));
  delay(50);
  //Serial.println(valorSensor);
  //Serial.println(valorBtn);
  
  //delay(2000);

}
