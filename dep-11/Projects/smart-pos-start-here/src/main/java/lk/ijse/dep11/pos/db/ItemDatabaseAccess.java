package lk.ijse.dep11.pos.db;

import lk.ijse.dep11.pos.tm.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDatabaseAccess {

    private static final PreparedStatement GET_ALL_ITEMS;
    private static final PreparedStatement SAVE_ITEMS;
    private static final PreparedStatement UPDATE_ITEMS;
    private static final PreparedStatement DELETE_ITEMS;

    static {
        try{
            Connection connection = SingleConnectionDataSource.getInstance().getConnection();
            GET_ALL_ITEMS = connection.prepareStatement("SELECT * FROM Item");
            SAVE_ITEMS = connection.prepareStatement("INSERT INTO Item (item_code,description,qty_stock,unit_price) VALUES (?,?,?,?)");
            UPDATE_ITEMS = connection.prepareStatement("UPDATE item SET description=?,qty_stock=?,unit_price=? WHERE item_code=?");
            DELETE_ITEMS = connection.prepareStatement("DELETE FROM item WHERE item_code=?");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Item> itemList() throws SQLException {
        ResultSet resultSet = GET_ALL_ITEMS.executeQuery();
        List<Item> itemList = new ArrayList<>();
        while (resultSet.next()){
            Item item = new Item(resultSet.getString("item_code"), resultSet.getString("description"), resultSet.getInt("qty_stock"), resultSet.getBigDecimal("unit_price"));
            itemList.add(item);
        }
        return itemList;
    }

    public static void saveItems(Item item){
        try {
            SAVE_ITEMS.setString(1, item.getCode());
            SAVE_ITEMS.setString(2, item.getDescription());
            SAVE_ITEMS.setInt(3, item.getQty());
            SAVE_ITEMS.setBigDecimal(4, item.getUnitPrice());
            SAVE_ITEMS.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateItems(Item item) {
        try {
            UPDATE_ITEMS.setString(1, item.getDescription());
            UPDATE_ITEMS.setInt(2, item.getQty());
            UPDATE_ITEMS.setBigDecimal(3, item.getUnitPrice());
            UPDATE_ITEMS.setString(4, item.getCode());
            UPDATE_ITEMS.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteItems(String code){
        try {
            DELETE_ITEMS.setString(1,code);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
