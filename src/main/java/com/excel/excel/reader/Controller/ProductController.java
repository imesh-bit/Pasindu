package com.excel.excel.reader.Controller;

import com.excel.excel.reader.DTO.ProductDto;
import com.excel.excel.reader.Service.Productservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping
public class ProductController {

    @Autowired
    private Productservice productservice;

    @PostMapping("/users/upload")
    public ResponseEntity<?> uploadUsersFromExcelFile(@RequestParam("file") MultipartFile file) {
        try {
            List<String> pnumbers = productservice.saveUsersFromExcelFile(file);
            return ResponseEntity.ok().body(pnumbers);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Please Add the Product: " + e.getMessage());
        }
    }

    @PostMapping("/addproducts")
    public ResponseEntity<String> saveitem(@RequestBody ProductDto productDto) {
        String responseMessage = productservice.addproducts(productDto);
        if (responseMessage.startsWith("Error:")) {
            return ResponseEntity.badRequest().body(responseMessage); // Return error message in the response body with a 400 status code
        } else {
            return ResponseEntity.ok(responseMessage); // Return success message in the response body with a 200 status code
        }
    }

}