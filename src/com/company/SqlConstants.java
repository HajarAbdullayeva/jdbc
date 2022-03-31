package com.company;

public interface SqlConstants {
    String SELECT_ALL_REGION = "select region_id as id, region_name as regionName from regions";

    String SELECT_REGION_BY_ID = "select * from regions r where r.region_id = ?";

    String INSERT_REGION = "insert into regions(region_name) values (?)";

    String DELETE_REGION_BY_NAME = "DELETE FROM REGIONS R WHERE R.REGION_NAME = ?";

    String DELETE_REGION_BY_ID = "DELETE FROM REGIONS R WHERE R.REGION_ID = ?";

    String UPDATE_REGION_BY_ID = "update regions r set r.region_name = ? where r.region_id = ?";
}