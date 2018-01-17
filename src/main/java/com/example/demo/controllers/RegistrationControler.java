package com.example.demo.controllers;

import com.example.demo.Clients.Client;
import com.example.demo.Clients.Seller;
import com.example.demo.Clients.repo.ClientRepo;
import com.example.demo.Clients.repo.SellerRepo;
import com.example.demo.response.ResponsePOJO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RegistrationControler {

    @Autowired
    ClientRepo clientRepo;
    @Autowired
    SellerRepo sellerRepo;


    @RequestMapping( value = "/registration" , method = RequestMethod.POST)
    public ResponsePOJO<Client> registration(@RequestParam String username,
                                           @RequestParam String password,
                                           @RequestParam String phone,
                                           @RequestParam String email){

        Client client=new Client(username,password,phone,email);
        if(clientRepo.loadUserByUsername(username)==null) {

            clientRepo.save(client);
            ResponsePOJO<Client> clientResponsePOJO = new ResponsePOJO<>();
            try {
                clientResponsePOJO.setStatus("200");
                clientResponsePOJO.setMassage("success");
                clientResponsePOJO.setObject(client);
            } catch (Exception e) {
                clientResponsePOJO.setStatus("400");
                clientResponsePOJO.setMassage("warning");
            }

            return clientResponsePOJO;
        }
        else {
            ResponsePOJO<Client> clientResponsePOJO = new ResponsePOJO<>();
                clientResponsePOJO.setStatus("400");
                clientResponsePOJO.setMassage("something is wrong");
            return clientResponsePOJO;

        }
    }
    @RequestMapping( value = "/registrationSeller" , method = RequestMethod.POST)
    public String registrationSeller(@RequestParam String username,
                                             @RequestParam String password){

        Seller seller=new Seller(username,password);

        sellerRepo.save(seller);

        return "ok";
    }
}
