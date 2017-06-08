package com.ttms.serviceImpl;

import com.ttms.dao.SaleDAO;
import com.ttms.entity.Sale;
import com.ttms.entity.Sale_item;
import com.ttms.entity.Ticket;
import com.ttms.entity.User_sale;
import com.ttms.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hacker on 17-6-1.
 */
@Service("SaleServiceImpl")
public class SaleServiceImpl implements SaleService{

    @Autowired
    SaleDAO saleDAO;
    @Override
    public void insertSale(Sale sale) {
        saleDAO.insertSale(sale);
    }

    @Override
    public void updateSale(Sale sale) {
        saleDAO.updateSale(sale);
    }

    @Override
    public void selectSale() {
        saleDAO.selectSale();
    }

    @Override
    public int SearchSale(Ticket ticket) {
        return saleDAO.SearchSale(ticket);
    }

    @Override
    public void updateUser(Sale sale) {
        saleDAO.updateSale(sale);
    }

    @Override
    public void updateStatus(Sale sale) {
        saleDAO.updateStatus(sale);
    }

    @Override
    public void updateTicket(Sale sale) {
        saleDAO.updateTicket(sale);
    }

    @Override
    public List<Sale> SearchSalebyuser(int user_id) {
        return  saleDAO.SearchSalebyuser(user_id);
    }

    @Override
    public Sale_item Searchbysaleid(Sale sale) {
        return saleDAO.Searchbysaleid(sale);
    }

    @Override
    public List<Sale> selectSaleByUser_id(User_sale sale) {
        return saleDAO.selectSaleByUser_id(sale);
    }


}
