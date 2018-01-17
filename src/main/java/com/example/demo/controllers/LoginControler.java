package com.example.demo.controllers;

import com.example.demo.Clients.Client;
import com.example.demo.Clients.Seller;
import com.example.demo.Clients.repo.ClientRepo;
import com.example.demo.Clients.repo.SellerRepo;
import com.example.demo.response.ResponsePOJO;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;

@RestController
public class LoginControler {
    @Autowired
    ClientRepo clientRepo;
    @Autowired
    SellerRepo sellerRepo;
    @RequestMapping( value = "/loginClient" , method = RequestMethod.POST)
    public ResponsePOJO LoginClient(@RequestParam String username,
                                     @RequestParam String password){

        List<Client> clientList= (List<Client>) clientRepo.findAll();




        for (int i=0;i<clientList.size();i++){
            if (clientList.get(i).getUsername().equals(username)&&clientList.get(i).getPassword().equals(password)){

                clientList.get(i);
                ResponsePOJO<Client> clientResponsePOJO=new ResponsePOJO<>();
                clientResponsePOJO.setStatus("200");
                clientResponsePOJO.setMassage("success");
                clientResponsePOJO.setObject(clientList.get(i));
                return clientResponsePOJO;
            }
        }
        ResponsePOJO<Client> clientResponsePOJO=new ResponsePOJO<>();
        clientResponsePOJO.setStatus("400");
        clientResponsePOJO.setMassage("wrong username or password");
        return clientResponsePOJO;
    }



    @RequestMapping( value = "/loginSeller" , method = RequestMethod.POST)
    public ResponsePOJO LoginSeller(@RequestParam String username,
                              @RequestParam String password){
        List<Seller> sellerList= (List<Seller>) sellerRepo.findAll();

        for (int i=0;i<sellerList.size();i++){
            if (sellerList.get(i).getUsername().equals(username)&&sellerList.get(i).getPassword().equals(password)){

                ResponsePOJO<Seller> clientResponsePOJO=new ResponsePOJO<>();
                clientResponsePOJO.setStatus("200");
                clientResponsePOJO.setMassage("success");
                clientResponsePOJO.setObject(sellerList.get(i));
                return clientResponsePOJO;
            }
        }
        ResponsePOJO<Seller> clientResponsePOJO=new ResponsePOJO<>();
        clientResponsePOJO.setStatus("400");
        clientResponsePOJO.setMassage("wrong username or password");
        return clientResponsePOJO;
    }
}
