package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Product;

import java.util.HashSet;
import java.util.Set;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;
    private final OutsourcedPartRepository outsourcedPartRepository;

    public DatabaseLoader(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository = outsourcedPartRepository;
    }

    @Override
    public void run(String... strings) {
        if (!partRepository.findAll().iterator().hasNext() && !productRepository.findAll().iterator().hasNext()) {

            Set<OutsourcedPart> parts = new HashSet<>();

            OutsourcedPart wr = new OutsourcedPart();
            wr.setCompanyName("Water Tanks Inc.");
            wr.setName("Water Reservoir");
            wr.setInv(20);
            wr.setMinInv(10); // new field
            wr.setMaxInv(30); // new field
            wr.setPrice(15.00);
            wr.setId(1);
            if (!parts.add(wr)) {
                wr.setName(wr.getName() + " Multi-Pack");
            }

            OutsourcedPart cf = new OutsourcedPart();
            cf.setCompanyName("Coffee Filters Inc.");
            cf.setName("Reusable Coffee Filter");
            cf.setInv(20);
            cf.setMinInv(10); // new field
            cf.setMaxInv(30); // new field
            cf.setPrice(5.00);
            cf.setId(2);
            if (!parts.add(cf)) {
                cf.setName(cf.getName() + " Multi-Pack");
            }

            OutsourcedPart hr = new OutsourcedPart();
            hr.setCompanyName("HVAC Systems Inc.");
            hr.setName("Heating Rod");
            hr.setInv(20);
            hr.setMinInv(10); // new field
            hr.setMaxInv(30); // new field
            hr.setPrice(25.00);
            hr.setId(3);
            if (!parts.add(hr)) {
                hr.setName(hr.getName() + " Multi-Pack");
            }

            OutsourcedPart cp = new OutsourcedPart();
            cp.setCompanyName("Coffee Pots Inc.");
            cp.setName("Coffee Pot");
            cp.setInv(20);
            cp.setMinInv(10); // new field
            cp.setMaxInv(30); // new field
            cp.setPrice(10.00);
            cp.setId(4);
            if (!parts.add(cp)) {
                cp.setName(cp.getName() + " Multi-Pack");
            }

            OutsourcedPart mw = new OutsourcedPart();
            mw.setCompanyName("Electric Solutions Inc.");
            mw.setName("Machine Wiring");
            mw.setInv(20);
            mw.setMinInv(10); // new field
            mw.setMaxInv(30); // new field
            mw.setPrice(5.00);
            mw.setId(5);
            if (!parts.add(mw)) {
                mw.setName(mw.getName() + " Multi-Pack");
            }

            for (OutsourcedPart part : parts) {
                outsourcedPartRepository.save(part);
            }

            Product greenhouseMini = new Product("Greenhouse Mini", 50.00, 50);
            productRepository.save(greenhouseMini);

            Product greenhousePlus = new Product("Greenhouse Plus", 75.00, 50);
            productRepository.save(greenhousePlus);

            Product greenhouseMax = new Product("Greenhouse Max", 100.00, 50);
            productRepository.save(greenhouseMax);

            Product greenhousePrime = new Product("Greenhouse Prime", 125.00, 50);
            productRepository.save(greenhousePrime);

            Product greenhouseSignature = new Product("Greenhouse Signature", 150.00, 50);
            productRepository.save(greenhouseSignature);
        }
    }
}