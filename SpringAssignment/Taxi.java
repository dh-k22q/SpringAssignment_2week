package SpringAssignment;
import java.util.*;
public class Taxi extends PublicTransport {
    int MaxPassenger = 4;//택시 최대 승객수
    int price = 3000;//택시 기본 요금
    int PriceForDistance = 1000;//거리당요금
    int pricesum = 0;//이번에 받아야할 총요금
    String destination = "";//목적지
    int DistanceToDestination = 0;//목적지까지의 거리
    int accumulatedprice = 0;//누적요금
    String parking = "운행불가";
    String operation = "운행중";
    String Normal = "일반";



    public static void main(String[] args) {
        Taxi taxi = new Taxi();
        Taxi taxi2 = new Taxi();
        taxi.numbering();
        taxi2.numbering();
        taxi.run();
        taxi.StateChange();
        taxi.PassengerBoarding();
        taxi.Destination();
        taxi.payment();
        taxi.StateChange();
        taxi.CarOiling();
        taxi.AccumulatedPrice();
        taxi.PassengerBoarding();
        taxi.PassengerBoarding();
        taxi.Destination();
        taxi.payment();
        taxi.CarOiling();
        taxi.StateChange();
        taxi.AccumulatedPrice();

      }


    public void StateChange(){         //상태변경
      //운행/일반 run메소드에서 운행시작 메시지가 뜨는 경우 운행상태로 변경
      //차고지행/운행중 run메소드 운행시작이 아닌경우 이상태
      
      if (FuelVolume<10){ //연료량이 10 이하
        status = "운행불가";
      }else if(passengersum >= 1){
        status = "운행중";
      }else {
        status = "일반";
      }
      System.out.println("상태:"+status);
     
      
    }

    public void PassengerBoarding(){        //승객탑승 <택시> 승객수(한번에 받음) 
        //함수를 다 돌고 나서 초기화를 시켜줘야한다
        Scanner passengerinput = new Scanner(System.in);
        System.out.print("탑승할 승객수를 입력해주세요:");
        passenger = Integer.parseInt(passengerinput.next());

        if (FuelVolume<10 || status.equals("운행정지")){ //연료량이 10이하면 운행불가
            passengersum = 0;//운행불가일땐 현재승객수 0
        }
        
        if (status != parking&&status != operation && passenger < MaxPassenger){//택시 상태가 "일반"일때 탑승가능
            AbleToBoard = "탑승가능";
            passengersum = passenger;//탑승 가능 상태면 새로 온 승객을 태우고 현재 승객수에 더해줌
            RemainingSeats = MaxPassenger-passengersum;
            System.out.println("현재 승객수:"+passengersum);
            System.out.println("잔여 승객수:"+RemainingSeats);
            System.out.println("기본요금 확인:"+price);
              
        }else if(passenger > MaxPassenger){
            System.out.println("최대 승객 수 초과");
            passengersum = 0;
            passenger = 0;
        }
        else{
            AbleToBoard = "탑승불가";
            }

        
        
        
            

            
    }

    public int payment(){         //요금확인
      //기본요금+ 거리당요금*목적지까지의 거리
      pricesum = PriceForDistance * (DistanceToDestination-1) +price;

      System.out.println("지불할 요금:"+pricesum);
      return pricesum;
    }

    public void Destination(){ //목적지,목적지까지의 거리
      Scanner Destinations = new Scanner(System.in);
      System.out.print("목적지를 입력해주세요:");
      destination = Destinations.next();
            
      Scanner DistanceToDestinations = new Scanner(System.in);
      System.out.print("목적지까지 거리를 입력해주세요:");
      DistanceToDestination = Integer.parseInt(DistanceToDestinations.next());

      System.out.println("목적지:"+destination);
      System.out.println("목적지까지 거리:"+DistanceToDestination+"km");

    }

    public void AccumulatedPrice(){ //누적요금
      accumulatedprice += pricesum;
      System.out.println("누적요금:"+accumulatedprice);
      super.StateChange();

    }

}

