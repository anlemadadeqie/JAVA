package com.ttms.service;
import java.util.*;
import com.ttms.entity.*;
/**
 * Created by hacker on 17-6-1.
 */
public interface SaleService {

    public void insertSale(Sale sale);
    public void updateSale(Sale sale);
    public void selectSale();
    public int SearchSale(Ticket ticket);
    public void updateUser(Sale sale);
    public void updateStatus(Sale sale);
    public void updateTicket(Sale sale);
    public List<Sale> SearchSalebyuser(int user_id);
    public Sale_item Searchbysaleid(Sale sale);
    public List<Sale> selectSaleByUser_id(User_sale sale);
}
