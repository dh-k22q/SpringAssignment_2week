package SpringAssignment;

import java.util.*;


public class PublicTransport {
  String number = "";//번호
  int MaxPassenger= 0;//최대승객수
  int passenger = 0;//새로 태울 승객수
  int passengersum = 0;//현재 탄 총 승객수
  int RemainingSeats = 0;//잔여좌석
  int speed =0;//속도
  int FuelVolume = 100;//연료량
  String AbleToBoard= "";//탑승가능여부
  String status= "";//현재상태
  int price = 0;//기본요금
  int pricesum = 0;//이번에 받아야할 총요금
  String destination = "";//목적지
  int DistanceToDestination = 0;//목적지까지의 거리
 
  

    public UUID numbering(){ //차번호 생성부여

      UUID number = UUID.randomUUID();//차번호 고유값 랜덤생성  // 고정값UUID number = UUID.nameUUIDFromBytes("bus01".getBytes());
      System.out.println("차번호:"+number);
      return number;
    }

    public void run(){                //운행시작
      //운행 시작전 주유상태를 체크 하고 주유량이 10 이상이어야 운행 가능
      String msg = "";

      if (FuelVolume< 10){
        msg = "주유량을 확인해주세요.";
      }else{
        msg = "운행시작";

      }System.out.println(msg);
      System.out.println("주유량:"+FuelVolume);
    
     }
    public void CarOiling(){
      Scanner oiling = new Scanner(System.in);
      System.out.print("주유량:");
      FuelVolume += Integer.parseInt(oiling.next());
      System.out.println("현재 주유량:"+FuelVolume);
    }
     
    public void SpeedChange(){        //속도변경
      //변경할 속도를 입력 받아 현재 속도에 추가 하거나 뺄 수 있어야 합니다.


      if (FuelVolume<10){//연료가 10이하면 운행하지 않기때문에 speed0
        speed = 0;
      }
      Scanner InputSpeed = new Scanner(System.in);//스피드 변경값을 받아옴
      System.out.print("변경할 속도를 입력해주세요:");
      speed += Integer.parseInt(InputSpeed.next());//스피드 변경값을 현재 스피드에 추가
     

      if (speed<0){        //만약 총 스피드가 0 이하면 0으로 바꿈
        speed = 0;
      }
      Integer.toString(speed);//speed를 문자열로 바꿈
      System.out.println("현재 속도:"+speed);
      
    }

    public int InputStateChange(){         //상태변경 직접입력
      Scanner statuschange = new Scanner(System.in);
      System.out.print("변경할 상태를 입력해주세요:");
      status = statuschange.next();

      System.out.println("현재상태:"+status);
      return passengersum;
    }
    
    public void StateChange(){         //상태변경
      String alert = "";
      if (FuelVolume<10){
        alert = "주유 필요";
        System.out.println(alert);
      }
      
      
    }


    public void PassengerBoarding(){ 

      
    }

    public int payment(){         //요금확인

      return pricesum;
    }
    public void Destination(){ //목적지,목적지까지의 거리


    }

}

