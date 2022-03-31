package com.company;

import java.util.List;

public interface RegionDao {
    List<Region> getAllRegion();

    Region getRegionById(Long id);

    boolean addRegion(Region region);

    boolean deleteRegionByName(String regionName);

    boolean deleteRegionById(Long id);

    Region updateRegionById(Region region);
}
