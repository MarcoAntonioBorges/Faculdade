/*
   ARDUINO => micro-controlador

   MICRO-CONTROLADOR => Processamento de dados, RAM, ROM, Flash, Perifericos.

   MICRO-PROCESSADOR => Processamento de dados (Instruções).


   O ARDUINO é reconhecido como uma porta serial pelo computador.


   FTDI => Entra USB e Sai SERIAL
   GPIO => General Purpose Input Output

*/


/* Executa assim que o programa buildar */
void setup() {
  /* Defina a velocidade da taxa de transferencia */
  Serial.begin(9600);
  
}

void loop() {
  Serial.println("Hello World!");
  delay(3000);
}

void ledState(){
  
}
