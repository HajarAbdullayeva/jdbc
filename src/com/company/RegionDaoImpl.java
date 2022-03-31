package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RegionDaoImpl implements RegionDao {

    private Connection c = null;
    private PreparedStatement p = null;
    private ResultSet rs = null;

    @Override
    public List<Region> getAllRegion() {

        List<Region> regions = new ArrayList<>();

        try {
            c = DbConnection.getConnection();
            p = c.prepareStatement(SqlConstants.SELECT_ALL_REGION);
            rs = p.executeQuery();

            while (rs.next()) {
                Region region = new Region();
                region.setId(rs.getLong("id"));
                region.setRegionName(rs.getString("regionName"));
                regions.add(region);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbConnection.closeConnection(c, p, rs);
        }
        return regions;
    }

    @Override
    public Region getRegionById(Long id) {

        try {
            c = DbConnection.getConnection();
            p = c.prepareStatement(SqlConstants.SELECT_REGION_BY_ID);
            p.setLong(1, id);
            rs = p.executeQuery();
            if (!rs.next()) {
                throw new RegionNotFoundException("region not found");
            }
            Region region = new Region();
            region.setId(rs.getLong("region_id"));
            region.setRegionName(rs.getString("region_name"));
            return region;
        } catch (RegionNotFoundException e) {
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbConnection.closeConnection(c, p, rs);
        }
        return null;
    }

    @Override
    public boolean addRegion(Region region) {
        try {
            c = DbConnection.getConnection();
            p = c.prepareStatement(SqlConstants.INSERT_REGION);
            p.setString(1, region.getRegionName());
            int result = p.executeUpdate();
            return result == 1;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbConnection.closeConnection(c, p, rs);
        }
        return false;
    }

    @Override
    public boolean deleteRegionByName(String regionName) {
        try {
            c = DbConnection.getConnection();
            p = c.prepareStatement(SqlConstants.DELETE_REGION_BY_NAME);
            p.setString(1, regionName);
            int result = p.executeUpdate();
            return result == 1;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbConnection.closeConnection(c, p, rs);
        }
        return false;
    }

    @Override
    public boolean deleteRegionById(Long id) {
        try {
            c = DbConnection.getConnection();
            p = c.prepareStatement(SqlConstants.DELETE_REGION_BY_ID);
            p.setLong(1, id);
            int result = p.executeUpdate();
            return result == 1;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbConnection.closeConnection(c, p, rs);
        }
        return false;
    }

    @Override
    public Region updateRegionById(Region region) {
        try {
            c = DbConnection.getConnection();
            p = c.prepareStatement(SqlConstants.UPDATE_REGION_BY_ID);
            p.setString(1, region.getRegionName());
            p.setLong(2, region.getId());
            int result = p.executeUpdate();
            if (result == 1) {
                return getRegionById(region.getId());
            }
        } catch (RegionNotFoundException e) {
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}