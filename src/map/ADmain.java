package map;


import map.en.Gender;
import map.model.AD;
import map.model.User;
import map.storage.UserStorage;
import map.storage.adStorage;
import java.util.Date;
import java.util.Scanner;


public class ADmain implements Comands {

    public static Scanner scanner = new Scanner(System.in);
    public static UserStorage userStorage = new UserStorage();
    public static map.storage.adStorage adStorage = new adStorage();
    public static boolean bool = false;
    public static boolean b;

    public static void main(String[] args) {

        boolean isRun = true;
        while (isRun) {
            comandsLogin();
            int comand;
            try {
                comand = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                comand = -1;
                System.out.println("Please input number!");
            }
            switch (comand) {
                case EXIT:
                    isRun = false;
                    System.out.println("Byby");
                    break;
                case LOGIN:
                    login();
                    Outer:
                    while (bool) {
                        comands();
                        int comand2;
                        try {
                            comand2 = Integer.parseInt(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            comand2 = -1;
                            System.out.println("please input number!");
                        }
                        switch (comand2) {
                            case LOGOUT:
                                bool = false;
                                break;
                            case ADD_NEW_AD:
                                b = true;
                                add();
                                break;
                            case PRINT_MY_ALL_ADS:
                                printMyAllAds();
                                break;
                            case PRINT_ALL_ADS:
                                printAllAds();
                                break;
                            case PRINT_AD_BY_CATEGORY:
                                prinAdtByCategory();
                                break;
                            case PRINT_ALL_ADS_BY_TITLE_SORT:
                                printAllAdsByTitleSort();
                                break;
                            case PRINT_ALL_ADS_BY_DATE_SORT:
                                printALLAdsByDateSort();
                                break;
                            case DELETE_MY_ALL_ADS:
                                deleteMyAllAds();
                                break;
                            case DELETE_AD_BY_TITLE:
                                deleteByTitleAd();
                                break;
                            default:
                                System.out.println("Wrong input!");
                        }
                        continue Outer;
                    }
                    break;
                case REGISTER:
                    register();
                    break;
                default:
                    System.out.println("Wrong comand!");
            }
        }
    }

    //
    private static void deleteByTitleAd() {
        if (adStorage.ads.isEmpty()) {
            System.out.println("Ads is empty! Please add Ad");
            return;
        }
        System.out.println("Please input Ad title for deleted");
        System.out.print("Title: ");
        String name = scanner.nextLine();
        adStorage.deleteByTitleAd(name);
    }

    private static void deleteMyAllAds() {
        if (adStorage.ads.isEmpty()) {
            System.out.println("Ads is empty! Please add Ad");
            return;
        }
        System.out.println("Please input user name/phoneNumberfor deleted all ads");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("PhoneNumber");
        String phoneNumber = scanner.nextLine();
        adStorage.deleteMyAllAds(name, phoneNumber);
    }

    private static void printALLAdsByDateSort() {
        if (adStorage.ads.isEmpty()) {
            System.out.println("Ads is empty! Please add Ad");
            return;
        }
        adStorage.printAllAdsByDateSorts();
    }

    private static void printAllAdsByTitleSort() {
        if (adStorage.ads.isEmpty()) {
            System.out.println("Ads is empty! Please add Ad");
            return;
        }
        adStorage.printAllAdsBySort();
    }

    private static void prinAdtByCategory() {
        if (adStorage.ads.isEmpty()) {
            System.out.println("Ads is empty! Please add Ad");
            return;
        }
        System.out.println("Please input category for print ad");
        System.out.print("Category: ");
        String category = scanner.nextLine();
        adStorage.printAdByCategory(category);
    }

    private static void printAllAds() {
        if (adStorage.ads.isEmpty()) {
            System.out.println("Ads is empty! Please add Ad");
        }
        adStorage.printAllAds();
    }

    private static void printMyAllAds() {
        if (adStorage.ads.isEmpty()) {
            System.out.println("Ads is empty! Please add Ad");
            return;
        }
        System.out.println("Pleas Input user name/phoneNumber for print ads");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("PhoneNumber: ");
        String phoneNumber = scanner.nextLine();
        adStorage.printMyAlAds(name, phoneNumber);


    }

    public static void add() {
        while (b) {
            System.out.println("Please input` (title,text,price,category)");
            String strData = scanner.nextLine();
            String[] split = strData.split(",");
            AD ad = new AD();
            User user = new User();

            try {
                ad.setTitle(split[0]);
                ad.setText(split[1]);
                ad.setPrice(Integer.parseInt(split[2]));
                ad.setDate(new Date());
                ad.setCategory(split[3]);
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("Incorrect value! try again" + e);
                add();
            }
            while (b) {
                try {
                    System.out.println("Please input outher");
                    System.out.println("Please input (name,surname,gender`(MALE or FEMALE),age,phoneNumber,passvord)");
                    String dataStr = scanner.nextLine();
                    String[] split1 = dataStr.split(",");
                    user.setName(split1[0]);
                    user.setSurname(split1[1]);
                    user.setGender(Gender.valueOf(split1[2]));
                    user.setAge(Integer.parseInt(split1[3]));
                    user.setPhoneNumber(split1[4]);
                    user.setPassword(split1[5]);
                } catch (IllegalArgumentException e) {
                    System.out.println("Incorrect value " + e);
                    add();
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Incorrect value! try again" + e);
                    add();
                }
                if (b) {
                    userStorage.users.put(user.getPhoneNumber(), user);
                    ad.setOuther(user);
                    adStorage.ads.add(ad);
                    System.out.println("Ad was added");
                    b = false;
                    break;
                }

            }
        }
        }

        private static void login () {
            if (userStorage.users.isEmpty()) {
                System.out.println("User is empty");
                register();
            }
            System.out.println("Please input phoneNumber/password");
            System.out.print("phoneNumber: ");
            String phoneNumber = scanner.nextLine();
            try {
                System.out.print("password: ");
                String password = scanner.nextLine();
                bool = userStorage.login(phoneNumber, password);
            } catch (NullPointerException e) {
                System.out.println("Incorrect value! Pleasy try again");
                login();
            }


        }

        private static void register () {
            System.out.println("Please input (name,surname,gender`(MALE or FEMALE),age,phoneNumber,passvord)");
            String dataStr = scanner.nextLine();
            String[] split = dataStr.split(",");
            User user = new User();
            try {
                user.setName(split[0]);
                user.setSurname(split[1]);
                try {
                    user.setGender(Gender.valueOf(split[2]));
                } catch (IllegalArgumentException e) {
                    System.out.println("Incorrect value " + e);
                    register();
                }
                user.setAge(Integer.parseInt(split[3]));
                user.setPhoneNumber(split[4]);
                user.setPassword(split[5]);
                userStorage.users.put(user.getPhoneNumber(), user);
                System.out.println("User was added");
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("incorrect value " + e);
                register();
            }
        }

        public static void comandsLogin () {
            System.out.println(EXIT + " For EXIT");
            System.out.println(LOGIN + " For LOGIN");
            System.out.println(REGISTER + " For REGISTR");
        }

        public static void comands () {
            System.out.println("Please input " + LOGOUT + " for exit");
            System.out.println("Please input " + ADD_NEW_AD + " for AD added");
            System.out.println("Please input " + PRINT_MY_ALL_ADS + " for print my all Ads");
            System.out.println("Please input " + PRINT_ALL_ADS + " for print all Ads");
            System.out.println("Please input " + PRINT_AD_BY_CATEGORY + " for search Ad by category");
            System.out.println("Please input " + PRINT_ALL_ADS_BY_TITLE_SORT + " for print all Ads by title sort");
            System.out.println("please input " + PRINT_ALL_ADS_BY_DATE_SORT + " for print all Ads by date sort");
            System.out.println("Please input " + DELETE_MY_ALL_ADS + " for deleted Ads by user");
            System.out.println("Please input " + DELETE_AD_BY_TITLE + " for deleted Ad by title");
        }
    }
