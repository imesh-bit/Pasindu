package com.excel.excel.reader.Service;

import com.excel.excel.reader.DTO.ProductDto;
import com.excel.excel.reader.Entity.Product;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface Productservice {

    List<String> saveUsersFromExcelFile(MultipartFile file) throws IOException;


   public String addproducts(ProductDto productDto);

//    public boolean checkpnumber(ProductDto productDto);
}
