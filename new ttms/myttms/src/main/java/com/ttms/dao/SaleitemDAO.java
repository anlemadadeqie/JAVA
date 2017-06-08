package com.ttms.dao;

import com.ttms.entity.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hacker on 17-6-1.
 */

@Repository("SaleitemDAO")
public interface SaleitemDAO {
    public void insertSaleitem(Sale_item sale_item);
    public void deleteSaleitem(int Sale_item_id);
    public void updateSaleitem(Sale_item sale_item);

    public Sale selectSale_IDBySale_item_id(Sale_item Sale_item);
    public List<Sale_item> selectSale_itemByTicket_id(int ticket_id);
    public List<Sale_item> selectSale_itemBySale_ID(int Sale_id);
    public List<Sale_item> selectSale_item();
    public Sale_item SearchSaleItem(Ticket ticket);
    public Ticket Searchbysaleitemid(Sale_item saleItem);


}


