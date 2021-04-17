package com.sqlite.northwindef.dao;

import com.sqldalmaker.DataStore;

import com.sqlite.northwindef.dto.Customer;
import com.sqlite.northwindef.dto.CustomersAndSuppliersByCity;
import java.util.ArrayList;
import java.util.List;

// This code was generated by a tool. Don't modify it manually.
// http://sqldalmaker.sourceforge.net

public class CustomersDao {

    protected final DataStore ds;

    public CustomersDao(DataStore ds) {
        this.ds = ds;
    }

    public int count() throws Exception {
        String sql = "select count(*) from Customers";
        return ds.query(int.class, sql);
    }

    public List<CustomersAndSuppliersByCity> getCustomersAndSuppliersByCity() throws Exception {
        String sql = "SELECT City, CompanyName, ContactName, \"Customers\" AS [Relationship]" +
        "\n FROM Customers" +
        "\n UNION SELECT City, CompanyName, ContactName, \"Suppliers\"" +
        "\n FROM Suppliers" +
        "\n ORDER BY City, CompanyName;";
        final List<CustomersAndSuppliersByCity> res = new ArrayList<CustomersAndSuppliersByCity>();
        ds.queryAllRows(sql, new DataStore.RowHandler() {
            @Override
            public void handleRow(DataStore.RowData rd) throws Exception {
                CustomersAndSuppliersByCity obj = new CustomersAndSuppliersByCity();
                obj.setCity(rd.getValue(String.class, "City"));  // q(City) <- q(City)
                obj.setCompanyName(rd.getValue(String.class, "CompanyName"));  // q(CompanyName) <- q(CompanyName)
                obj.setContactName(rd.getValue(String.class, "ContactName"));  // q(ContactName) <- q(ContactName)
                obj.setRelationship(rd.getValue(String.class, "Relationship"));  // q(Relationship) <- q(Relationship)
                res.add(obj);
            }
        });
        return res;
    }

    public List<Customer> find(String City, String CompanyName) throws Exception {
        String sql = "select * from customers where City=? and CompanyName=?";
        final List<Customer> res = new ArrayList<Customer>();
        ds.queryAllRows(sql, new DataStore.RowHandler() {
            @Override
            public void handleRow(DataStore.RowData rd) throws Exception {
                Customer obj = new Customer();
                obj.setCustomerID(rd.getValue(String.class, "CustomerID"));  // t(CustomerID) <- t(CustomerID) [INFO] SQL-shortcut
                obj.setCompanyName(rd.getValue(String.class, "CompanyName"));  // t(CompanyName) <- t(CompanyName)
                obj.setContactName(rd.getValue(String.class, "ContactName"));  // t(ContactName) <- t(ContactName)
                obj.setContactTitle(rd.getValue(String.class, "ContactTitle"));  // t(ContactTitle) <- t(ContactTitle)
                obj.setAddress(rd.getValue(String.class, "Address"));  // t(Address) <- t(Address)
                obj.setCity(rd.getValue(String.class, "City"));  // t(City) <- t(City)
                obj.setRegion(rd.getValue(String.class, "Region"));  // t(Region) <- t(Region)
                obj.setPostalCode(rd.getValue(String.class, "PostalCode"));  // t(PostalCode) <- t(PostalCode)
                obj.setCountry(rd.getValue(String.class, "Country"));  // t(Country) <- t(Country)
                obj.setPhone(rd.getValue(String.class, "Phone"));  // t(Phone) <- t(Phone)
                obj.setFax(rd.getValue(String.class, "Fax"));  // t(Fax) <- t(Fax)
                res.add(obj);
            }
        }, City, CompanyName);
        return res;
    }
}