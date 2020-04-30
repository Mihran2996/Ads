package map.storage;

import map.model.AD;


import java.util.*;

public class adStorage {
    public List<AD> ads = new ArrayList<>();

    //
    public void printMyAlAds(String name, String phoneNumber) {
        for (int i = 0; i < ads.size(); i++) {
            if (name.equals(ads.get(i).getOuther().getName()) && phoneNumber.equals(ads.get(i).getOuther().getPhoneNumber())) {
                System.out.println(ads.get(i));
                System.out.println("------------------------------------------");
            } else {
                System.out.println("Incorrect value!");
            }
        }

    }

    public void printAllAds() {
        for (AD ad : ads) {
            System.out.println(ad);
            System.out.println("------------------------------------------");
        }
    }

    public void printAdByCategory(String category) {
        for (int i = 0; i < ads.size(); i++) {
            if (category.equals(ads.get(i).getCategory())) {
                System.out.println(ads.get(i));
                System.out.println("------------------------------------------");
            } else {
                System.out.println("Incorrect value!");
                break;
            }
        }
    }

    public void printAllAdsBySort() {
        Map<String, AD> ads1 = new TreeMap<>();
        for (int i = 0; i < ads.size(); i++) {
            ads1.put(ads.get(i).getTitle(), ads.get(i));
        }
        System.out.println(ads1);
        System.out.println("------------------------------------------");
        System.out.println();
//        for (AD ad : ads) {
//            System.out.println(ad);
//        }
    }

    public void printAllAdsByDateSorts() {
        Map<Date, AD> ads1 = new TreeMap<>();
        for (int i = 0; i < ads.size(); i++) {
            ads1.put(ads.get(i).getDate(), ads.get(i));
        }
        System.out.println(ads1);
        System.out.println("------------------------------------------");
        System.out.println();

//        DataComparator data=new DataComparator();
//        ads.sort(data);
//        for (AD ad : ads) {
//            System.out.println(ad);
//        }

    }

    public void deleteMyAllAds(String name, String phoneNumber) {
        for (int i = 0; i < ads.size(); i++) {
            if (name.equals(ads.get(i).getOuther().getName()) && phoneNumber.equals(ads.get(i).getOuther().getPhoneNumber())) {
                ads.remove(ads.get(i));
                System.out.println("Ad was deleted");
            } else {
                System.out.println("Incorect value!");
                break;
            }
        }
    }

    public void deleteByTitleAd(String title) {
        for (int i = 0; i < ads.size(); i++) {
            if (title.equals(ads.get(i).getTitle())) {
                ads.remove(ads.get(i));
                System.out.println("Ad was deleted");
            } else {
                System.out.println("Incorrect value!");
                break;
            }
        }
    }
}
