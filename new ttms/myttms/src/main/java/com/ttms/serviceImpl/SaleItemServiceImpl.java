package com.ttms.serviceImpl;

import com.ttms.dao.SaleitemDAO;
import com.ttms.entity.Sale;
import com.ttms.entity.Sale_item;
import com.ttms.entity.Ticket;
import com.ttms.service.SaleItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hacker on 17-6-1.
 */
@Service("saleItemServiceImpl")
public class SaleItemServiceImpl  implements SaleItemService{

    @Autowired
    SaleitemDAO saleitemDAO;
    @Override
    public void insertSaleItem(Sale_item sale_item) {

        saleitemDAO.insertSaleitem(sale_item);
    }

    @Override
    public List<Sale_item> selectSale_item() {
        return saleitemDAO.selectSale_item();
    }

    @Override
    public Sale_item SearchSaleItem(Ticket ticket) {
        return saleitemDAO.SearchSaleItem(ticket);
    }

    @Override
    public Sale selectSale_IDBySale_item_id(Sale_item sale_item) {
        return saleitemDAO.selectSale_IDBySale_item_id(sale_item);
    }


    @Override
    public Ticket Searchbysaleitemid(Sale_item saleItem) {
        return saleitemDAO.Searchbysaleitemid(saleItem);
    }
}
