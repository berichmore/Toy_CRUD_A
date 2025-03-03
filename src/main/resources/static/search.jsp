<%@ page import = "java.util.*" %>
<%@ page import = "java.sql.*" %>
<%@ page import = "java.io.*" %>
<%@ page import="com.nexacro.java.xapi.data.*" %>
<%@ page import="com.nexacro.java.xapi.tx.*" %>

<%@ page contentType="text/xml; charset=utf-8" %>

<%
    /****** Service API initialization ******/
    PlatformData pdata = new PlatformData();

    int nErrorCode = 0;
    String strErrorMsg = "START";

/******* JDBC Connection *******/
    Connection conn = null;
    Statement  stmt = null;
    ResultSet  rs   = null;
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=Sample","guest","guest");
    stmt = conn.createStatement();

    try {
        /******* SQL query *************/
        String SQL = "select * from sample_customers_list";
        rs = stmt.executeQuery(SQL);

        /********* Dataset Create ************/
        DataSet ds = new DataSet("customers");
        ds.addColumn("id",DataTypes.STRING, 4);
        ds.addColumn("name",DataTypes.STRING, 16);
        ds.addColumn("email", DataTypes.STRING, 32);
        ds.addColumn("phone", DataTypes.STRING, 16);
        ds.addColumn("comp_name", DataTypes.STRING, 32);
        ds.addColumn("department", DataTypes.STRING, 32);
        ds.addColumn("comp_phone", DataTypes.STRING, 16);
        ds.addColumn("comp_addr", DataTypes.STRING, 256);
        int row = 0;
        while(rs.next())
        {
            row = ds.newRow();
            ds.set(row, "id", rs.getString("id"));
            ds.set(row, "name", rs.getString("name"));
            ds.set(row, "email", rs.getString("email"));
            ds.set(row, "phone", rs.getString("phone"));
            ds.set(row, "comp_name", rs.getString("comp_name"));
            ds.set(row, "department", rs.getString("department"));
            ds.set(row, "comp_phone", rs.getString("comp_phone"));
            ds.set(row, "comp_addr", rs.getString("comp_addr"));
        }

        /********* Adding Dataset to PlatformData ************/
        pdata.addDataSet(ds);

        nErrorCode = 0;
        strErrorMsg = "SUCC";
    }
    catch(SQLException e) {
        nErrorCode = -1;
        strErrorMsg = e.getMessage();
    }

/******** JDBC Close *******/
    if ( stmt != null ) try { stmt.close(); } catch (Exception e) {}
    if ( conn != null ) try { conn.close(); } catch (Exception e) {}

    PlatformData senddata = new PlatformData();
    VariableList varList = senddata.getVariableList();
    varList.add("ErrorCode", nErrorCode);
    varList.add("ErrorMsg", strErrorMsg);

/******** XML data Create ******/
    HttpPlatformResponse res = new HttpPlatformResponse(response,
            PlatformType.CONTENT_TYPE_XML,"UTF-8");
    res.setData(pdata);
    res.sendData();
%>