package SpringAssignment;
import java.util.*;

public class Bus extends PublicTransport {
    int MaxPassenger = 30;//버스 최대 승객수
    int price = 1000;//버스 기본 요금
    int pricesum = 0;//이번에 받아야할 총요금
    int passengersum = 0;//현재 탄 총 승객수
    String parking = "차고지행";
    String operation = "운행중";


    public static void main(String[] args) {
      Bus bus = new Bus();
      Bus bus2 = new Bus();
      bus.numbering();
      bus2.numbering();
      bus.run();
      bus.PassengerBoarding();
      bus.payment();
      bus.CarOiling();
      bus.InputStateChange();
      bus.CarOiling();
      bus.InputStateChange();
      bus.PassengerBoarding();
      bus.PassengerBoarding();
      bus.payment();
      bus.CarOiling();
      bus.StateChange();


      // bus.SpeedChange();
      
   

    }

      
    public void StateChange(){         //상태변경
      
      String status= "";
      if (FuelVolume<10){ //연료량이 10이하면 운행불가
        status = "차고지행";
      }else {
        status = "운행중";
      }
      System.out.println("상태:"+status);
      super.StateChange();
      
    }

    public void PassengerBoarding(){        //승객탑승
      super.PassengerBoarding();
      Scanner passengerinput = new Scanner(System.in);
      System.out.print("탑승할 승객수를 입력해주세요:");
      passenger = Integer.parseInt(passengerinput.next());
      
      if(passenger < MaxPassenger){//버스 상태가 "운행"이면서 승객 수가 30보다 작을때 탑승가능
        AbleToBoard = "탑승가능";
        passengersum += passenger;//새로온 승객을 현재 승객에 더해줌
        RemainingSeats = MaxPassenger-passengersum;
        System.out.println("현재 승객수:"+passengersum);
        System.out.println("잔여 승객수:"+RemainingSeats);

      }else if (passenger > MaxPassenger){ //현재승객이 30을 초과하면 경고
        System.out.println("최대 승객 수 초과");
        passenger = 0;
        RemainingSeats = MaxPassenger-passengersum;
        AbleToBoard = "탑승불가";
      }
        
      

      
  }
    public int payment(){         //요금확인
      //새로온 승객수 * 요금
      
      if (passenger>=1){
        pricesum = passenger * price;
      }System.out.println("요금확인:"+pricesum);
      return pricesum;
    }

    public int InputStateChange(){         //상태변경 직접입력
      super.InputStateChange();
      if (status!=operation){ //연료량이 10이하면 운행불가
        passengersum = 0;}//차고지에 있을땐 현재승객수 0

      return passengersum;
    }
}
