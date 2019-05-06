int motorA1 = 6;
int motorA2 = 7;
int echo = 11;
int trig = 12;
int cnt = 0;

int distance(int e, int t){ // 거리재기
  int d = 10000;
  digitalWrite(t,HIGH);
  delayMicroseconds(2);
  digitalWrite(t,LOW);

  unsigned long duration = pulseIn(e,HIGH);
  d = duration / 29.0 / 2.0;
  
  Serial.print(d);
  Serial.println("cm\n");

  //delay(500);
  
  return d;
}

void openDoor(int m1, int m2,int n){
  analogWrite(m1,200);
  digitalWrite(m2,LOW);
}

void closeDoor(int m1,int m2,int n){
  digitalWrite(m1,LOW);
  digitalWrite(m2,150);
}

void holdo(int m1,int m2, int t){
  digitalWrite(m1,LOW);
  digitalWrite(m2,LOW);
  delay(t);
}

void setup() 
{ 
 Serial.begin(9600);
 pinMode(motorA1,OUTPUT);
 pinMode(motorA2,OUTPUT);
 pinMode(echo,INPUT);
 pinMode(trig,OUTPUT);
}

void loop() 
{
  int dis;

    dis = distance(echo,trig);

    if(dis<=10){
      while(cnt<10){
      openDoor(motorA1,motorA2,cnt);
      cnt++; delay(60);// 다여는데 1초요
      Serial.println(cnt);
      }
    }else if(dis>10){
      while(cnt>0){
        closeDoor(motorA1,motorA2,cnt);
        cnt--; delay(40); //닫는데도 1초요
        Serial.println(cnt);
        dis = distance(echo,trig); //닫으면서 중간에 확인요
        if(dis<=10) break;
      }
    }
      holdo(motorA1,motorA2,500); // 닫다가 빠져나오면서 잠깐 홀드

   delay(500);
  
 // holdo(motorA1,motorA2,1000);

}
