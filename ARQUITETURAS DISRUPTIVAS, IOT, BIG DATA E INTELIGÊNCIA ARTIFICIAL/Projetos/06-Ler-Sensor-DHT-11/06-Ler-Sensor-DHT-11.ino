

#include "DHT.h"
#define DHTPIN A1
#define DHTYPE DHT11
DHT dht(DHTPIN, DHTYPE);
sensor
void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  dht.begin();
}

void loop() {
  // put your main code here, to run repeatedly:
  float h = dht.readHumidity();
  float t = dht.readTemperature();

  if(isnan(t) || isnan(h)){
    Serial.println("Erro ao ler do DHT");
  }
  


}
