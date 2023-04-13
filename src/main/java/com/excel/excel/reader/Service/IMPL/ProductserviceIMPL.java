package com.excel.excel.reader.Service.IMPL;

import com.excel.excel.reader.DTO.ProductDto;
import com.excel.excel.reader.Entity.Product;
import com.excel.excel.reader.Repo.ProductRepository;
import com.excel.excel.reader.Service.Productservice;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
class ProductserviceIMPL implements Productservice {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<String> saveUsersFromExcelFile(MultipartFile file) throws IOException {
        Workbook workbook = new XSSFWorkbook(file.getInputStream());
        Sheet sheet = workbook.getSheetAt(0);
        List<String> ingredients = new ArrayList<>();
        List<String> missingPNumbers = new ArrayList<>();

        for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
            Row row = sheet.getRow(i);
            String pnumber = row.getCell(0).getStringCellValue();
            System.out.println();
            Optional<Product> productOptional = productRepository.findById(pnumber);
            if (productOptional.isPresent()) {
                String ingredient = productOptional.get().getIngredients();
                String[] ingredientList = ingredient.split(",\\s*");
                for (String ing : ingredientList) {
                    ingredients.add(ing);
                }
            } else {
                missingPNumbers.add(pnumber);
            }
        }

        workbook.close();

        if (!missingPNumbers.isEmpty()) {
            String missingPNumbersStr = String.join(", ", missingPNumbers);
            ingredients.clear();
            ingredients.add("Please add the Product(s): " + missingPNumbersStr);
        }

        return ingredients;
    }

    @Override
    public String addproducts(ProductDto productDto) {
        String pNumber = productDto.getPnumber();
        boolean exists = productRepository.existsById(pNumber);
        System.out.println("ssd" + exists);
        if (exists) {
            return "Error: P Number already exists";

        } else {
            Product product = new Product(
                    productDto.getId(),
                    productDto.getPnumber(),
                    productDto.getIngredients()
            );
            productRepository.save(product);
            return productDto.getPnumber() + " saved";
        }
    }



}

