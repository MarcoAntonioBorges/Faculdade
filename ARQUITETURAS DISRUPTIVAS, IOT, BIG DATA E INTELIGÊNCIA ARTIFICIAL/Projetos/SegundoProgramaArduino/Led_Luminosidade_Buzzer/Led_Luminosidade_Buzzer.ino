// PORTAS
int btn =8;
int led = 13;
int buzzer = 7;
int pinLuminosidade = 0;
int led1 =2;
int led2 =3;
int led3 =4;

//VALORES
int valorLuminosidade = 0;
int valorBtn = 0;

void setup() {
  // put your setup code here, to run once:
  pinMode(btn,INPUT_PULLUP);  
  pinMode(led, OUTPUT);
  pinMode(led1, OUTPUT);
  pinMode(led2, OUTPUT);
  pinMode(led3, OUTPUT);
  pinMode(buzzer, OUTPUT);
  Serial.begin(9600);
}

void loop() {

  valorLuminosidade = analogRead(pinLuminosidade);
  Serial.println(valorLuminosidade);

    // put your main code here, to run repeatedly:

  valorBtn = digitalRead(btn);
  valorLuminosidade = analogRead(pinLuminosidade);


  Serial.println(valorBtn);
  Serial.println(valorLuminosidade);

  if(valorBtn == 0){
    //Toca musica e acende led
    digitalWrite(led, HIGH);
    tone(buzzer, 200, 100);  
  }else{
    digitalWrite(led, LOW);
    noTone(buzzer);
  }

  if(valorLuminosidade <= 650){
    digitalWrite(led1, HIGH);  
    if(valorLuminosidade <= 300){
      digitalWrite(led2, HIGH);
      if(valorLuminosidade <= 200){
        digitalWrite(led3, HIGH);
        tone(buzzer, 200, 100);
      }else{
        digitalWrite(led3, LOW);
        noTone(buzzer);
      }
    }else{
      digitalWrite(led2, LOW);
    }
  }else{
    digitalWrite(led3, LOW);
  }
  
  delay(100);
}
