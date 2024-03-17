package ui;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        double maxFee []=new double[10];
        double max=0.0;
        System.out.println("Welcome to the Flight calculator, lets start!!");
        Scanner lector = new Scanner(System.in);
        for (int totalCount = 0; totalCount < 10; totalCount++) {
			System.out.println("Hello user number:" + (totalCount+1));
            System.out.println("Will you travel alone or accompanied?");
            String trip = lector.nextLine().toLowerCase();
            if (trip.equals("accompanied")) {
                double accompaniedFee = accompaniedFee(lector);
                
                System.out.println("The total price of the users was : " + accompaniedFee);
                maxFee[totalCount]=accompaniedFee;
                if (maxFee[totalCount]>max){
                max=maxFee[totalCount];
                }
            } else if (trip.equals("alone")) {
                double aloneFee = aloneFee(lector);
                System.out.println("The total price of user is:" + aloneFee);
            } else {
                System.out.println("Please enter a value that appears in the menu");
                totalCount = 15;
            }
        }
        System.out.println("The maximun total price of users is: "+ max);
        lector.close();
    }
    /*
     * Method1: accompaniedFee
     * @param lector is use for read the questions that I do for the user
     * @param feePrice helps like a constant for the method
     * @param fee is the request of the user for what fee he chose
     * @param seat is the request of the user if he want choose the seat before the check-in
     * @param placeSeat is the request of the user for where he is going to choose
     * @return accompaniedFee its the value of the total of the user and his company
     */
    public static double accompaniedFee(Scanner lector) { 
		double feePrice = 175000.0;
		double accompaniedFee = 0.0;
		double[] individualFee = new double[2];
		double[] additionalBag = new double[2];
	
		for (int i = 0; i < 2; i++) {
			System.out.println("Hi user number : " + (i+1));
			System.out.println("How much does your luggage weigh?");
			int luggage = lector.nextInt();
			lector.nextLine();
			if (luggage<=3){
				System.out.println("Excellent,then I can show you these options");
				System.out.println("XS=175.000 with the benefit of a personal backpack");
				System.out.println("S=218.750 with the benefit of a backpack of 10kg");
				System.out.println("M=227.500 with the benefit of a backpack of 10kg and another of 23kg and a choice of seat before check-in");
				System.out.println("¿What option do you want: XS-S-M?");
				String fee=lector.nextLine().toUpperCase();
				switch (fee) {
					case "xs":
						individualFee[i]=feePrice;
                         System.out.println("Do you want to choose your seat before the check-in for an additional value?");
                        String seat = lector.nextLine().toLowerCase();
                        if (seat.equals("yes")) {
                            individualFee[i] = feePrice + 50000.0;
                        }
                        // Ask for the seat location regardless of the user's choice
                        System.out.println("Please choose your seat");
                        System.out.println("What part of the plane would you like to sit in?");
                        System.out.println("Remember that the seat place of Window or Hallway has an additional cost");
                        System.out.println("Window-Hallway-Middle");
                        String placeSeat = lector.nextLine().toLowerCase();
                        if (placeSeat.equals("window") || placeSeat.equals("hallway")) {
                            individualFee[i] += 12000;
                            } else if (placeSeat.equalsIgnoreCase("middle")) {
                            // Handle the middle seat case if needed
                            } else {
                            System.out.println("Please choose a valid value");
                            }
                    
					break;
					case "s":
					individualFee[i]=feePrice*0.25;
						System.out.println("Do you want to choose your seat before the check-in for an additional value");
						seat=lector.nextLine().toLowerCase();
						if (seat.equals("yes")){
							individualFee[i]=feePrice+50000.0;
							System.out.println("Please choose your seat");
							System.out.println("What part of the plane would you like to sit in?");
							System.out.println("Remember that the seat place of Window or Hallway has an additional cost");
							System.out.println("Window-Hallway-Middle");
							placeSeat=lector.nextLine().toLowerCase();
							if (placeSeat.equals("Window") || placeSeat.equals("Hallway")){
								individualFee[i]=feePrice+12000;
							} else if(placeSeat.equalsIgnoreCase("window")|| placeSeat.equalsIgnoreCase("hallway")|| placeSeat.equalsIgnoreCase("middle")){
								System.out.println("Please choose a valid value");
							}
						    } else if(seat.equals("no")){
							System.out.println("Okey,you are a person without complications");
						    } else if (!seat.equals("yes") || !seat.equals("no")){
							System.out.println("Please enter a value that appear in the options");
						    }
					break; 
					case "m":
						individualFee[i]=feePrice*0.30;
						System.out.println("Please choose your seat");
						System.out.println("What part of the plane would you like to sit in?");
						System.out.println("Remember that the seat place of Window or Hallway has an additional cost");
						System.out.println("Window-Hallway-Middle");
						placeSeat=lector.nextLine().toLowerCase();
						if (placeSeat.equals("Window") || placeSeat.equals("Hallway")){
							individualFee[i]=feePrice+12000;
						    } else if(placeSeat.equalsIgnoreCase("window")|| placeSeat.equalsIgnoreCase("hallway")|| placeSeat.equalsIgnoreCase("middle")){
							System.out.println("Please choose a valid value");
						    }
	
	
					break;
					default:
						break;
				}
	
			}else if (luggage<=10){
				System.out.println("Excellent,then I can show you these options");
				System.out.println("S=218.750 with the benefit of a backpack of 10kg");
				System.out.println("M=227.500 with the benefit of a backpack of 10kg and another of 23kg and a choice of seat before check-in");
				System.out.println("¿What option do you want: S-M?");
				String fee=lector.nextLine().toUpperCase();
				switch (fee) {
					case "s":
						individualFee[i]=feePrice*0.25;
						System.out.println("Do you want to choose your seat before the check-in for an additional value");
						String seat=lector.nextLine().toLowerCase();
						if (seat.equals("yes")){
							individualFee[i]=feePrice+50000.0;
							System.out.println("Please choose your seat");
							System.out.println("What part of the plane would you like to sit in?");
							System.out.println("Remember that the seat place of Window or Hallway has an additional cost");
							System.out.println("Window-Hallway-Middle");
							String placeSeat=lector.nextLine().toLowerCase();
							if (placeSeat.equals("Window") || placeSeat.equals("Hallway")){
								individualFee[i]=feePrice+12000;
							} if(placeSeat.equalsIgnoreCase("window")|| placeSeat.equalsIgnoreCase("hallway")|| placeSeat.equalsIgnoreCase("middle")){
								System.out.println("Please choose a valid value");
							}
						    } else if(seat.equals("no")){
							System.out.println("Okey,you are a person without complications");
						    } else if (!seat.equals("yes") || !seat.equals("no")){
							System.out.println("Please enter a value that appear in the options");
						    }
					break; 
					case "m":
						individualFee[i]=feePrice*0.30;
						System.out.println("Please choose your seat");
						System.out.println("What part of the plane would you like to sit in?");
						System.out.println("Remember that the seat place of Window or Hallway has an additional cost");
						System.out.println("Window-Hallway-Middle");
						String placeSeat=lector.nextLine().toLowerCase();
						if (placeSeat.equals("window") || placeSeat.equals("hallway")){
							individualFee[i]=feePrice+12000;
						} if(placeSeat.equalsIgnoreCase("window")|| placeSeat.equalsIgnoreCase("hallway")|| placeSeat.equalsIgnoreCase("middle")){
							System.out.println("Please choose a valid value");
						}
						break;
					default:
					break;
				}
			}else if (luggage<=23){
				System.out.println("M=227.500 with the benefit of a backpack of 10kg and another of 23kg and a choice of seat before check-in");
				System.out.println("¿What option do you want: M?");
				String fee=lector.nextLine().toUpperCase();
				switch (fee){
					case "m":
						individualFee[i]=feePrice*0.30;
						System.out.println("Please choose your seat");
						System.out.println("What part of the plane would you like to sit in?");
						System.out.println("Remember that the seat place of Window or Hallway has an additional cost");
						System.out.println("Window-Hallway-Middle");
						String placeSeat=lector.nextLine().toLowerCase();
						if (placeSeat.equals("window") || placeSeat.equals("hallway")){
							individualFee[i]=feePrice+12000;
						}  if(placeSeat.equalsIgnoreCase("window")|| placeSeat.equalsIgnoreCase("hallway")|| placeSeat.equalsIgnoreCase("middle")){
							System.out.println("Please choose a valid value");
						}
					break;
					default:
					break;
				}
	
			}
			additionalBag[i] = additionalBag(lector);
			double totalFee = feePrice + additionalBag[i];
			System.out.println("The final user price : " + (i+1) + " is " + totalFee);
			individualFee[i] = totalFee;
			accompaniedFee += totalFee;
		}
	return accompaniedFee;
	}
	
    /*
     * Method2: aloneFee
     *  @param lector is use for read the questions that I do for the user
     * @param feePrice helps like a constant for the method
     * @param fee is the request of the user for what fee he chose
     * @param seat is the request of the user if he want choose the seat before the check-in
     * @param placeSeat is the request of the user for where he is going to choose
     * @return aloneFee its the value of the total of the user 
     */
	

    public static double aloneFee(Scanner lector) {
        double feePrice = 175000.0;
        double aloneFee = 0.0;
        System.out.println("How much does your luggage weigh");
        int luggage = lector.nextInt();
        lector.nextLine();
		if (luggage<=3){
            System.out.println("Excellent,then I can show you these options");
            System.out.println("XS=175.000 with the benefit of a personal backpack");
            System.out.println("S=218.750 with the benefit of a backpack of 10kg");
            System.out.println("M=227.500 with the benefit of a backpack of 10kg and another of 23kg and a choice of seat before check-in");
            System.out.println("¿What option do you want: XS-S-M?");
            String fee=lector.nextLine().toUpperCase();
            switch (fee) {
                case "xs":
                    aloneFee=feePrice;
                    System.out.println("¿Do you want to choose your seat before the check-in for an additional value? Yes/No");
                    String seat=lector.nextLine().toLowerCase();
                    if (seat.equals("yes")){
                        aloneFee=aloneFee+50000.0;
                        System.out.println("Please choose your seat");
                    System.out.println("What part of the plane would you like to sit in?");
                    System.out.println("Remember that the seat place of Window or Hallway has an additional cost");
                    System.out.println("Window-Hallway-Middle");
                    String placeSeat=lector.nextLine().toLowerCase();
                    if (placeSeat.equals("window") || placeSeat.equals("hallway")){
                        aloneFee=aloneFee+15000.0;
                    } else if(placeSeat.equalsIgnoreCase("window")|| placeSeat.equalsIgnoreCase("hallway")|| placeSeat.equalsIgnoreCase("middle")){
                        System.out.println("Please choose a valid value");
                    }
                    } else if(seat.equals("no")){
                        System.out.println("Okey,you are a person without complications");
                    } else if (!seat.equals("yes") || !seat.equals("no")){
                        System.out.println("Please enter a value that appear in the options");
                    }
                    break;
                case "s":
                    aloneFee=feePrice*0.25;
                    System.out.println("Do you want to choose your seat before the check-in for an additional value");
                    seat=lector.nextLine().toLowerCase();
                    if (seat.equals("yes")){
                        aloneFee=aloneFee+50000.0;
                        System.out.println("Please choose your seat");
                        System.out.println("What part of the plane would you like to sit in?");
                        System.out.println("Remember that the seat place of Window or Hallway has an additional cost");
                        System.out.println("Window-Hallway-Middle");
                        String placeSeat=lector.nextLine().toLowerCase();
                        if (placeSeat.equals("Window") || placeSeat.equals("Hallway")){
                            aloneFee=aloneFee+15000.0;
                        } else if(placeSeat.equalsIgnoreCase("window")|| placeSeat.equalsIgnoreCase("hallway")|| placeSeat.equalsIgnoreCase("middle")){
                        System.out.println("Please choose a valid value");
                        }
                    } else if(seat.equals("no")){
                        System.out.println("Okey,you are a person without complications");
                    } else if (!seat.equals("yes") || !seat.equals("no")){
                        System.out.println("Please enter a value that appear in the options");
                    }
                    break; 
                case "m":
                    aloneFee=feePrice*0.30;
                    System.out.println("Please choose your seat");
                    System.out.println("What part of the plane would you like to sit in?");
                    System.out.println("Remember that the seat place of Window or Hallway has an additional cost");
                    System.out.println("Window-Hallway-Middle");
                    String placeSeat=lector.nextLine().toLowerCase();
                    if (placeSeat.equals("window") || placeSeat.equals("hallway")){
                        aloneFee=aloneFee+15000.0;
                    } else if(placeSeat.equalsIgnoreCase("window")|| placeSeat.equalsIgnoreCase("hallway")|| placeSeat.equalsIgnoreCase("middle")){
                        System.out.println("Please choose a valid value");
                    }


                    break;
                default:
                    break;
            }

        }else if (luggage<=10){
            System.out.println("Excellent,then I can show you these options");
            System.out.println("S=218.750 with the benefit of a backpack of 10kg");
            System.out.println("M=227.500 with the benefit of a backpack of 10kg and another of 23kg and a choice of seat before check-in");
            System.out.println("¿What option do you want: S-M?");
            String fee=lector.nextLine().toUpperCase();
            switch (fee) {
                case "s":
                    aloneFee=feePrice*0.25;
                    System.out.println("Do you want to choose your seat before the check-in for an additional value");
                    String seat=lector.nextLine().toLowerCase();
                    if (seat.equals("yes")){
                        aloneFee=aloneFee+50000.0;
                        System.out.println("Please choose your seat");
                        System.out.println("What part of the plane would you like to sit in?");
                        System.out.println("Remember that the seat place of Window or Hallway has an additional cost");
                        System.out.println("Window-Hallway-Middle");
                        String placeSeat=lector.nextLine().toLowerCase();
                    if (placeSeat.equals("window") || placeSeat.equals("hallway")){
                        aloneFee=aloneFee+15000.0;
                    } else if(placeSeat.equalsIgnoreCase("window")|| placeSeat.equalsIgnoreCase("hallway")|| placeSeat.equalsIgnoreCase("middle")){
                        System.out.println("Please choose a valid value");
                    }
                    } else if(seat.equals("no")){
                        System.out.println("Okey,you are a person without complications");
                    } else if (!seat.equals("yes") || !seat.equals("no")){
                        System.out.println("Please enter a value that appear in the options");
                    }
                    break; 
                case "m":
                    aloneFee=feePrice*0.30;
                    System.out.println("Please choose your seat");
                    System.out.println("What part of the plane would you like to sit in?");
                    System.out.println("Remember that the seat place of Window or Hallway has an additional cost");
                    System.out.println("Window-Hallway-Middle");
                    String placeSeat=lector.nextLine().toLowerCase();
                    if (placeSeat.equals("window") || placeSeat.equals("hallway")){
                        aloneFee=aloneFee+15000.0;
                    } else if(placeSeat.equalsIgnoreCase("window")|| placeSeat.equalsIgnoreCase("hallway")|| placeSeat.equalsIgnoreCase("middle")){
                        System.out.println("Please choose a valid value");
                    }
                    break;
                default:
                    break;
            }
        }else if (luggage<=23){
            System.out.println("M=227.500 with the benefit of a backpack of 10kg and another of 23kg and a choice of seat before check-in");
            System.out.println("¿What option do you want: M?");
            String fee=lector.nextLine().toUpperCase();

            switch (fee){
                case "m":
                    aloneFee=feePrice*0.30;
                    System.out.println("¿Do you want to choose your seat before the check-in?");
                    String seat=lector.nextLine().toLowerCase();
                    if (seat.equals("yes")){
                        System.out.println("What part of the plane would you like to sit in?");
                        System.out.println("Remember that the seat place of Window or Hallway has an additional cost");
                        System.out.println("Window-Hallway-Middle");
                        String placeSeat=lector.nextLine().toLowerCase();
                        if (placeSeat.equals("window") || placeSeat.equals("hallway")){
                        aloneFee=aloneFee+12000.0;
                        } else if(placeSeat.equalsIgnoreCase("window")|| placeSeat.equalsIgnoreCase("hallway")|| placeSeat.equalsIgnoreCase("middle")){
                        System.out.println("Please choose a valid value");
                    }
                    } 
                    break;
                default:
                    break;
            }

        }
        aloneFee = feePrice + additionalBag(lector);
        return aloneFee;
    }
    /*
     * Metho3: additionalBag
     * @param lector is use to scan the request of the user
     * @param bag is the request of the user about if he want an additional luggage
     * @param bag10 is the request of the user if he want an additional luggage of 10kg
     * @param bag23 is the request of the user if he want an additional luggage of 23kg
     * @return additionalBagFee is the result is the result of the sum of the variables bag10 and the bag23
     */

    public static double additionalBag(Scanner lector) {
        double additionalBagFee = 0.0;
        System.out.println("Do you want an additional luggage? Yes/No");
        String bag = lector.nextLine().toLowerCase();
            if (bag.equals("yes")) {
                for(int i=0;i<3;i++){
                    System.out.println("Do you want an extra luggage of 10kg? Yes/No (Max 3)");
                    String bag10 = lector.nextLine().toLowerCase();
                    if (bag10.equals("yes")) {
                    additionalBagFee += 50000;
                        if (bag10.equals("no")){
                            i=3;
                        }
                    }
                }
        }
        if (bag.equals("yes")) {
            for (int i=0;i<2;i++){
                System.out.println("Do you want an extra luggage of 23kg? Yes/No");
                String bag23 = lector.nextLine().toLowerCase();
                if (bag23.equals("yes")) {
                additionalBagFee += 100000;
                    if (bag23.equals("no")){
                        i=2;
                    }
                }
            }
        } else if (bag.equals("no")) {
            System.out.println("Understood, you are a person without troubles");
        } else {
            System.out.println("Please choose a valid value");
        }
        return additionalBagFee;
    }   
}    
