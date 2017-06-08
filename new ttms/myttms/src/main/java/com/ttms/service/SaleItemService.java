package com.ttms.service;

import com.ttms.entity.*;
import com.ttms.entity.Sale_item;

import java.util.List;

/**
 * Created by hacker on 17-6-1.
 */
public interface  SaleItemService {
    public void insertSaleItem(Sale_item sale_item);
    public List<Sale_item> selectSale_item();
    public Sale_item SearchSaleItem(Ticket ticket);
    public Sale selectSale_IDBySale_item_id(Sale_item Sale_item);
    public Ticket Searchbysaleitemid(Sale_item sale_item);


}
