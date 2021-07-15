package ui;

import java.util.Scanner;
import java.util.Vector;

import model.BankAccount;
import model.Car;
import model.Gold;
import model.House;
import model.Land;
import model.Motorcycle;
import controller.invalidValueException;

public interface AssetManagementSystem {
	
	//Vector<Exception> exceptions = new Vector<>();
	
	public double calculateMonetaryValue();
	
	public static void main(String args[]){
	
		invalidValueException e = new invalidValueException();
		
		Scanner scanner = new Scanner(System.in);
		
		int choice =1;
		
		Vector<Land> lands = new Vector<>();
		Vector<House> houses = new Vector<>();
		Vector<Car> cars = new Vector<>();
		Vector<Motorcycle> motorcycles = new Vector<>();
		Vector<Gold> golds = new Vector<>();
		Vector<BankAccount> bankAccounts = new Vector<>();
		
		while(choice != 0) {
			System.out.println("Manage Asset");
			System.out.println("--------------------------------------------");
			System.out.println("1-  Add Land");
			System.out.println("2-  Add House");
			System.out.println("3-  Add Car");
			System.out.println("4-  Add Motorcycle");
			System.out.println("5-  Add Gold");
			System.out.println("6-  Add Money");
			System.out.println("7- Display All Assets");
			System.out.println("0-  Exit");
		
			choice = scanner.nextInt();
		
			if(choice == 1) 
			{
				scanner.nextLine();
		
				System.out.println("Please enter the land details: ");
				
				System.out.println("Area of the Land: ");
				double landArea = scanner.nextDouble();
				
				System.out.println("Price Per Meter Squared: ");
				double landPriceM2 = scanner.nextDouble();
				
				
				if(e.invalidValueException(landArea) && e.invalidValueException(landPriceM2))
				{
					
					Land land = new Land(landArea,landPriceM2);
					System.out.println(land.getPricePerM2());
					lands.add(land);
					
					System.out.println("Success to update");
				}
				else System.out.println("Fail to update");
					
			}
			else if (choice == 2) 
			{
				scanner.nextLine();

				System.out.println("Please enter the House details: ");
				System.out.println("Area of the House: ");
				double houseArea = scanner.nextDouble();
				
				System.out.println("Number of floor: ");
				int numOfFloor = scanner.nextInt();
				
				System.out.println("Address of the house: ");
				String address = scanner.nextLine();
				
				System.out.println("Market Value of the house: ");
				double houseMarketValue = scanner.nextDouble();
				
				if(e.invalidValueException(houseArea) && e.invalidValueException(numOfFloor))
				{
					
					House house = new House(houseArea,numOfFloor,address,houseMarketValue);
					
					houses.add(house);
					
					System.out.println("Success to update");
				}
				else System.out.println("Fail to update");
					
			}
			else if (choice == 3) 
			{
				scanner.nextLine();

				System.out.println("Please enter the Car details: ");
				
				System.out.println("Car Plate No: ");
				String carPlateNo = scanner.nextLine();
				
				System.out.println("Car Model: ");
				String carModel = scanner.nextLine();
				
				System.out.println("Car Market Value: ");
				double carMarketValue = scanner.nextDouble();
				
				if(e.invalidValueException(carMarketValue))
				{
					Car car = new Car(carPlateNo,carModel,carMarketValue);
					
					cars.add(car);
					
					System.out.println("Success to update");
				}
				else System.out.println("Fail to update");
							
			}
			else if (choice == 4) 
			{
				scanner.nextLine();

				System.out.println("Please enter the Motorcycle details: ");
				
				System.out.println("Motorcycle Plate No: ");
				String motorcyclePlateNo = scanner.nextLine();
				
				System.out.println("Motorcycle Model: ");
				String motorcycleModel = scanner.nextLine();
				
				System.out.println("Motorcycle Market Value: ");
				double motorcycleMarketValue = scanner.nextDouble();
				
				if(e.invalidValueException(motorcycleMarketValue))
				{
					Motorcycle motorcycle = new Motorcycle(motorcyclePlateNo,motorcycleModel,motorcycleMarketValue);
					
					motorcycles.add(motorcycle);
					
					System.out.println("Success to update");
				}
				else System.out.println("Fail to update");
					
					
			}
			else if (choice == 5) 
			{
				scanner.nextLine();

				System.out.println("Please enter the Gold details: ");
				
				System.out.println("Gold's Karat: ");
				int karat = scanner.nextInt();
				
				System.out.println("Gold's Weight: ");
				double weight = scanner.nextDouble();
				
				System.out.println("Gold's Price: ");
				double price = scanner.nextDouble();
				
				if(e.invalidValueException(price) && e.invalidValueException(weight) && e.invalidValueException(karat))
				{
					Gold gold = new Gold(karat,weight,price);
					
					golds.add(gold);
					
					System.out.println("Success to update");
				}
				else System.out.println("Fail to update");
			
			}
			
			else if (choice == 6) 
			{
				scanner.nextLine();

				System.out.println("Please enter the Bank Account details: ");
				
				System.out.println("Bank Account No: ");
				String accountNo = scanner.nextLine();
				
				System.out.println("Bank Account Name: ");
				String bankName = scanner.nextLine();
				
				System.out.println("Bank Account Balance: ");
				double balance = scanner.nextDouble();
				
				System.out.println("Bank Account Interest Rate: ");
				double interestRate = scanner.nextDouble();
				
				if(e.invalidValueException(balance) && e.invalidValueException(interestRate))
				{
					BankAccount bankAccount = new BankAccount(accountNo,bankName,balance,interestRate);
					
					bankAccounts.add(bankAccount);
					
					System.out.println("Success to update");
				}
				else System.out.println("Fail to update");
			}
			
			else if (choice == 7)
			{	
				
				double part_value = 0;
				double value = 0;

				
				
				if(lands.isEmpty() == false)
				{
					int index = 1;
					System.out.println("Land*****************************************************************");
					
					for(Land land : lands)
					{
						System.out.println("Land Area            : " + land.getArea());
						System.out.println("Land Price Per Area  : " + land.getPricePerM2());
						System.out.println("Land Monetary Value  : " + land.calculateMonetaryValue());
						System.out.println("*****************************************");
						
						part_value += land.calculateMonetaryValue();
						value += land.calculateMonetaryValue();
						index++;
					}
					System.out.println("Asset of this part : " + part_value);
					System.out.println("*********************************************************************\n");
				}
				
				if(houses.isEmpty() == false)
				{
					part_value = 0;
					int index = 1;
					
					System.out.println("House****************************************************************");
					
					for(House house : houses)
					{
						System.out.println("House Area        : " + house.getArea());
						System.out.println("Number of Floor   : " + house.getNumOfFloors());
						System.out.println("House Address     : " + house.getAddress());
						System.out.println("House Market Value: " + house.getMarketValue());
						System.out.println("*****************************************");
						
						part_value += house.calculateMonetaryValue();
						value += house.calculateMonetaryValue();
						index++;
					}
					System.out.println("Asset of this part : " + part_value);
					System.out.println("*********************************************************************\n");
				}
				
				if(cars.isEmpty() == false)
				{	
					part_value = 0;
					int index = 1;
					
					System.out.println("Car******************************************************************");
					
					for(Car car : cars)
					{
						System.out.println("Car Plate No: " + car.getPlateNo());
						System.out.println("Car Model: " + car.getModel());
						System.out.println("Car Market Value: " + car.getMarketValue());
						System.out.println("Car Monetary Value: " + car.calculateMonetaryValue());
						System.out.println("*****************************************");
						
						part_value += car.calculateMonetaryValue();
						value += car.calculateMonetaryValue();
						index++;
					}
					System.out.println("Asset of this part : " + part_value);
					System.out.println("*********************************************************************\n");
				}
				
				if(motorcycles.isEmpty() == false)
				{
					part_value = 0;
					int index = 1;
					
					System.out.println("Motorcycle***********************************************************");
					
					for(Motorcycle motorcycle : motorcycles)
					{
						System.out.println("Motorcycle Plate No       : " + motorcycle.getPlateNo());
						System.out.println("Motorcycle Model          : " + motorcycle.getModel());
						System.out.println("Motorcycle Market Value   : " + motorcycle.getMarketValue());
						System.out.println("Motorcycle Monetary Value :" + motorcycle.calculateMonetaryValue());
						System.out.println("*****************************************");
						
						part_value += motorcycle.calculateMonetaryValue();
						value += motorcycle.calculateMonetaryValue();
						index++;
					}
					System.out.println("Asset of this part : " + part_value);
					System.out.println("*********************************************************************\n");
				}
				
				if(golds.isEmpty() == false)
				{
					part_value = 0;
					int index = 1;
					
					System.out.println("Golds****************************************************************");
					
					for(Gold gold : golds)
					{
						System.out.println("Gold Karat         : " + gold.getKarat());
						System.out.println("Gold Weight        : " + gold.getWeight());
						System.out.println("Gold Price         : " + gold.getPrice());
						System.out.println("Gold Monetary Value: " + gold.calculateMonetaryValue());
						System.out.println("*****************************************");
						
						part_value += gold.calculateMonetaryValue();
						value += gold.calculateMonetaryValue();
						index++;
					}
					System.out.println("Asset of this part : " + part_value);
					System.out.println("*********************************************************************\n");
				}
				
				if(bankAccounts.isEmpty() == false)
				{
					part_value = 0;
					int index = 1;
					
					System.out.println("*BankAccount**********************************************************");
					
					for(BankAccount bankAccount : bankAccounts)
					{
						System.out.println("Bank Account Number: " + bankAccount.getAccountNo());
						System.out.println("Bank Name          : " + bankAccount.getBankName());
						System.out.println("Bank Balance       : " + bankAccount.getBalance());
						System.out.println("Bank Interest Rate : " + bankAccount.getInterestRate());
						System.out.println("Bank Monetary Value: " + bankAccount.calculateMonetaryValue());
						System.out.println("*****************************************");
						
						part_value += bankAccount.calculateMonetaryValue();
						value += bankAccount.calculateMonetaryValue();
						index++;
					}
					System.out.println("Asset of this part : " + part_value);
					System.out.println("*********************************************************************\n");
				}
				
				System.out.println("********************************************************************************");
				System.out.println("Your Overall Asset Is: " + value);
				System.out.println("********************************************************************************\n");
			}
			
		}
		
	}	
		
		

}

