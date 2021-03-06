package com.sqlite.northwindef.dao;

import com.sqldalmaker.DataStore;

import com.sqlite.northwindef.dto.Order;
import com.sqlite.northwindef.dto.OrderDetailsExtended;
import com.sqlite.northwindef.dto.OrderSubtotal;
import com.sqlite.northwindef.dto.QuarterlyOrdersByProduct;
import java.util.ArrayList;
import java.util.List;

// This code was generated by a tool. Don't modify it manually.
// http://sqldalmaker.sourceforge.net

public class OrdersDao {

    protected final DataStore ds;

    public OrdersDao(DataStore ds) {
        this.ds = ds;
    }

    /*
        (C)RUD: Orders
        Generated values are passed to DTO.
        Returns the number of affected rows or -1 on error.
     */
    public int createOrder(Order p) throws Exception {
        String sql = "insert into Orders (CustomerID, EmployeeID, OrderDate, RequiredDate, ShippedDate, Freight, ShipName, ShipAddress, ShipCity, ShipRegion, ShipPostalCode, ShipCountry) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String[] gen_col_nm = new String[]{"OrderID"};
        Object[] gen_values = new Object[gen_col_nm.length];
        int res = ds.insert(sql, gen_col_nm, gen_values, p.getCustomerID(), p.getEmployeeID(), p.getOrderDate(), p.getRequiredDate(), p.getShippedDate(), p.getFreight(), p.getShipName(), p.getShipAddress(), p.getShipCity(), p.getShipRegion(), p.getShipPostalCode(), p.getShipCountry());
        p.setOrderID(ds.castGeneratedValue(Integer.class, gen_values[0]));
        return res;
    }

    /*
        C(R)UD: Orders
     */
    public List<Order> readOrderList() throws Exception {
        String sql = "select * from Orders";
        final List<Order> res = new ArrayList<Order>();
        ds.queryAllRows(sql, new DataStore.RowHandler() {
            @Override
            public void handleRow(DataStore.RowData rd) throws Exception {
                Order obj = new Order();
                obj.setOrderID(rd.getValue(Integer.class, "OrderID"));  // t(OrderID) <- t(OrderID)
                obj.setCustomerID(rd.getValue(String.class, "CustomerID"));  // t(CustomerID) <- t(CustomerID)
                obj.setEmployeeID(rd.getValue(Integer.class, "EmployeeID"));  // t(EmployeeID) <- t(EmployeeID)
                obj.setOrderDate(rd.getValue(String.class, "OrderDate"));  // t(OrderDate) <- t(OrderDate)
                obj.setRequiredDate(rd.getValue(String.class, "RequiredDate"));  // t(RequiredDate) <- t(RequiredDate)
                obj.setShippedDate(rd.getValue(String.class, "ShippedDate"));  // t(ShippedDate) <- t(ShippedDate)
                obj.setFreight(rd.getValue(String.class, "Freight"));  // t(Freight) <- t(Freight)
                obj.setShipName(rd.getValue(String.class, "ShipName"));  // t(ShipName) <- t(ShipName)
                obj.setShipAddress(rd.getValue(String.class, "ShipAddress"));  // t(ShipAddress) <- t(ShipAddress)
                obj.setShipCity(rd.getValue(String.class, "ShipCity"));  // t(ShipCity) <- t(ShipCity)
                obj.setShipRegion(rd.getValue(String.class, "ShipRegion"));  // t(ShipRegion) <- t(ShipRegion)
                obj.setShipPostalCode(rd.getValue(String.class, "ShipPostalCode"));  // t(ShipPostalCode) <- t(ShipPostalCode)
                obj.setShipCountry(rd.getValue(String.class, "ShipCountry"));  // t(ShipCountry) <- t(ShipCountry)
                res.add(obj);
            }
        });
        return res;
    }

    /*
        C(R)UD: Orders
     */
    public Order readOrder(Integer orderID) throws Exception {
        String sql = "select * from Orders where OrderID=?";
        DataStore.RowData rd = ds.queryRow(sql, orderID);
        Order obj = new Order();
        obj.setOrderID(rd.getValue(Integer.class, "OrderID"));  // t(OrderID) <- t(OrderID)
        obj.setCustomerID(rd.getValue(String.class, "CustomerID"));  // t(CustomerID) <- t(CustomerID)
        obj.setEmployeeID(rd.getValue(Integer.class, "EmployeeID"));  // t(EmployeeID) <- t(EmployeeID)
        obj.setOrderDate(rd.getValue(String.class, "OrderDate"));  // t(OrderDate) <- t(OrderDate)
        obj.setRequiredDate(rd.getValue(String.class, "RequiredDate"));  // t(RequiredDate) <- t(RequiredDate)
        obj.setShippedDate(rd.getValue(String.class, "ShippedDate"));  // t(ShippedDate) <- t(ShippedDate)
        obj.setFreight(rd.getValue(String.class, "Freight"));  // t(Freight) <- t(Freight)
        obj.setShipName(rd.getValue(String.class, "ShipName"));  // t(ShipName) <- t(ShipName)
        obj.setShipAddress(rd.getValue(String.class, "ShipAddress"));  // t(ShipAddress) <- t(ShipAddress)
        obj.setShipCity(rd.getValue(String.class, "ShipCity"));  // t(ShipCity) <- t(ShipCity)
        obj.setShipRegion(rd.getValue(String.class, "ShipRegion"));  // t(ShipRegion) <- t(ShipRegion)
        obj.setShipPostalCode(rd.getValue(String.class, "ShipPostalCode"));  // t(ShipPostalCode) <- t(ShipPostalCode)
        obj.setShipCountry(rd.getValue(String.class, "ShipCountry"));  // t(ShipCountry) <- t(ShipCountry)
        return obj;
    }

    /*
        CR(U)D: Orders
        Returns the number of affected rows or -1 on error.
     */
    public int updateOrder(Order p) throws Exception {
        String sql = "update Orders set CustomerID=?, EmployeeID=?, OrderDate=?, RequiredDate=?, ShippedDate=?, Freight=?, ShipName=?, ShipAddress=?, ShipCity=?, ShipRegion=?, ShipPostalCode=?, ShipCountry=? where OrderID=?";
        return ds.execDML(sql, p.getCustomerID(), p.getEmployeeID(), p.getOrderDate(), p.getRequiredDate(), p.getShippedDate(), p.getFreight(), p.getShipName(), p.getShipAddress(), p.getShipCity(), p.getShipRegion(), p.getShipPostalCode(), p.getShipCountry(), p.getOrderID());
    }

    /*
        CR(U)D: Orders
        Returns the number of affected rows or -1 on error.
     */
    public int updateOrder(String customerID, Integer employeeID, String orderDate, String requiredDate, String shippedDate, String freight, String shipName, String shipAddress, String shipCity, String shipRegion, String shipPostalCode, String shipCountry, Integer orderID) throws Exception {
        String sql = "update Orders set CustomerID=?, EmployeeID=?, OrderDate=?, RequiredDate=?, ShippedDate=?, Freight=?, ShipName=?, ShipAddress=?, ShipCity=?, ShipRegion=?, ShipPostalCode=?, ShipCountry=? where OrderID=?";
        return ds.execDML(sql, customerID, employeeID, orderDate, requiredDate, shippedDate, freight, shipName, shipAddress, shipCity, shipRegion, shipPostalCode, shipCountry, orderID);
    }

    /*
        CRU(D): Orders
        Returns the number of affected rows or -1 on error.
     */
    public int deleteOrder(Integer orderID) throws Exception {
        String sql = "delete from Orders where OrderID=?";
        return ds.execDML(sql, orderID);
    }

    public List<OrderSubtotal> getOrderSubtotals() throws Exception {
        String sql = "SELECT [OrderDetails].[OrderID], Sum(([UnitPrice]*[Quantity]*(1-[Discount])/100)*100) AS Subtotal" +
        "\n FROM [OrderDetails]" +
        "\n GROUP BY [OrderDetails].[OrderID];";
        final List<OrderSubtotal> res = new ArrayList<OrderSubtotal>();
        ds.queryAllRows(sql, new DataStore.RowHandler() {
            @Override
            public void handleRow(DataStore.RowData rd) throws Exception {
                OrderSubtotal obj = new OrderSubtotal();
                obj.setOrderID(rd.getValue(Integer.class, "OrderID"));  // q(OrderID) <- q(OrderID)
                obj.setSubtotal(rd.getValue(Double.class, "Subtotal"));  // q(Subtotal) <- q(Subtotal)
                res.add(obj);
            }
        });
        return res;
    }

    public List<QuarterlyOrdersByProduct> getQuarterlyOrdersByProduct(String d1, String d2) throws Exception {
        String sql = "SELECT Products.ProductName, Orders.CustomerID, strftime('%Y', [OrderDate]) AS OrderYear" +
        "\n FROM Products INNER JOIN (Orders INNER JOIN [OrderDetails] ON Orders.OrderID = [OrderDetails].OrderID) ON Products.ProductID = [OrderDetails].ProductID" +
        "\n WHERE (((Orders.OrderDate) Between ? And ?))" +
        "\n GROUP BY Products.ProductName, Orders.CustomerID, strftime('%Y', [OrderDate])";
        final List<QuarterlyOrdersByProduct> res = new ArrayList<QuarterlyOrdersByProduct>();
        ds.queryAllRows(sql, new DataStore.RowHandler() {
            @Override
            public void handleRow(DataStore.RowData rd) throws Exception {
                QuarterlyOrdersByProduct obj = new QuarterlyOrdersByProduct();
                obj.setProductName(rd.getValue(Object.class, "ProductName"));  // q(ProductName) <- q(ProductName)
                obj.setCustomerID(rd.getValue(Object.class, "CustomerID"));  // q(CustomerID) <- q(CustomerID)
                obj.setOrderYear(rd.getValue(Object.class, "OrderYear"));  // q(OrderYear) <- q(OrderYear)
                res.add(obj);
            }
        }, d1, d2);
        return res;
    }

    public List<OrderDetailsExtended> getOrderDetailsExtended() throws Exception {
        String sql = "SELECT DISTINCT" +
        "\n  [OrderDetails].OrderID," +
        "\n  [OrderDetails].ProductID," +
        "\n  Products.ProductName," +
        "\n  [OrderDetails].UnitPrice," +
        "\n  [OrderDetails].Quantity," +
        "\n  [OrderDetails].Discount," +
        "\n  ([OrderDetails].[UnitPrice]*[Quantity]*(1-[Discount])/100)*100 AS ExtendedPrice" +
        "\n FROM Products INNER JOIN [OrderDetails] ON Products.ProductID = [OrderDetails].ProductID" +
        "\n ORDER BY [OrderDetails].OrderID;";
        final List<OrderDetailsExtended> res = new ArrayList<OrderDetailsExtended>();
        ds.queryAllRows(sql, new DataStore.RowHandler() {
            @Override
            public void handleRow(DataStore.RowData rd) throws Exception {
                OrderDetailsExtended obj = new OrderDetailsExtended();
                obj.setOrderID(rd.getValue(Object.class, "OrderID"));  // q(OrderID) <- q(OrderID)
                obj.setProductID(rd.getValue(Object.class, "ProductID"));  // q(ProductID) <- q(ProductID)
                obj.setProductName(rd.getValue(Object.class, "ProductName"));  // q(ProductName) <- q(ProductName)
                obj.setUnitPrice(rd.getValue(Object.class, "UnitPrice"));  // q(UnitPrice) <- q(UnitPrice)
                obj.setQuantity(rd.getValue(Object.class, "Quantity"));  // q(Quantity) <- q(Quantity)
                obj.setDiscount(rd.getValue(Object.class, "Discount"));  // q(Discount) <- q(Discount)
                obj.setExtendedPrice(rd.getValue(Object.class, "ExtendedPrice"));  // q(ExtendedPrice) <- q(ExtendedPrice)
                res.add(obj);
            }
        });
        return res;
    }
}