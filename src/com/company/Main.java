package com.company;


import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RegionDao regionDao = new RegionDaoImpl();
        String regionName;
        long regionId;
        boolean result;
        Region region;
        System.out.println("1.get all region  2.get region by id  3.insert  4.delete by name  5.delete by id  6.update region  7.exit");
        int choice = scanner.nextInt();

        while (choice != 7) {
            switch (choice) {
                case 1 -> {
                    List<Region> regions = regionDao.getAllRegion();
                    regions.forEach(r -> {
                        System.out.println(r.getId() + "---" + r.getRegionName());
                        System.out.println();
                    });
                }
                case 2 -> {
                    System.out.println("please enter Id of region");
                    Long id = scanner.nextLong();
                    try {
                        region = regionDao.getRegionById(id);
                        System.out.println(region.getId() + "---" + region.getRegionName());
                    } catch (RegionNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 3 -> {
                    System.out.println("please enter region name");
                    regionName = scanner.next();
                    region = new Region();
                    region.setRegionName(regionName);
                    result = regionDao.addRegion(region);
                    if (result) {
                        System.out.println("successfully added new region");
                    } else {
                        System.out.println("added new region is failed");
                    }
                }
                case 4 -> {
                    System.out.println("please enter region name");
                    regionName = scanner.next();
                    result = regionDao.deleteRegionByName(regionName);
                    if (result) {
                        System.out.println("successfully deleted");
                    } else {
                        System.out.println("deleted region is failed");
                    }
                }
                case 5 -> {
                    System.out.println("please enter region id");
                    regionId = scanner.nextLong();
                    result = regionDao.deleteRegionById(regionId);
                    if (result) {
                        System.out.println("region successfully deleted");
                    } else {
                        System.out.println("deleted region is failed");
                    }
                }
                case 6 -> {
                    System.out.println("please enter region id");
                    regionId = scanner.nextLong();
                    System.out.println("please enter region name");
                    regionName = scanner.next();
                    region = new Region();
                    region.setId(regionId);
                    region.setRegionName(regionName);
                    region = regionDao.updateRegionById(region);
                    System.out.println(region.getId() + "---" + region.getRegionName());
                }
                default -> System.out.println("wrong choice");
            }
            System.out.println("1.get all region  2.get region by id  3.insert  4.delete by name  5.delete by id  6.update region  7.exit");
            choice = scanner.nextInt();
        }
    }
}
