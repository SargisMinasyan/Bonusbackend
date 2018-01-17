package com.example.demo.controllers;

import com.example.demo.Clients.Bonus;
import com.example.demo.Clients.Client;
import com.example.demo.Clients.repo.ClientRepo;
import com.example.demo.response.ResponsePOJO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UpdateBonusControler {
    @Autowired
    ClientRepo clientRepo;

    @RequestMapping( value = "/update" , method = RequestMethod.POST)
    public String update(@RequestParam String username,
                                     @RequestParam String data,
                                     @RequestParam String amount){

        Client client=clientRepo.loadUserByUsername(username);
        Bonus bonus=new Bonus(data,amount);

        List<Bonus> bonuseslist=client.getBonuses();
        bonuseslist.add(bonus);
        client.setBonuses(bonuseslist);

        clientRepo.save(client);

        return String.valueOf(client.getBonuses());
    }
    @RequestMapping( value = "/getClientInfo" , method = RequestMethod.POST)
    public ResponsePOJO getClientInfo(@RequestParam String username){
        ResponsePOJO<Client> responsePOJO=new ResponsePOJO<>();
        Client client=clientRepo.loadUserByUsername(username);

        responsePOJO.setObject(client);
        responsePOJO.setMassage("success");
        responsePOJO.setStatus("200");


        return responsePOJO;
    }

    @RequestMapping( value = "/setClientNewInfo" , method = RequestMethod.POST)
    public ResponsePOJO setClientNewInfo(@RequestParam String username,@RequestParam String data,@RequestParam Integer amount){
        ResponsePOJO<Client> responsePOJO=new ResponsePOJO<>();

        try {
            Client client=clientRepo.loadUserByUsername(username);

            List<Bonus> list=client.getBonuses();
            list.add(new Bonus(data,amount.toString()));
            client.setBonuses(list);
            clientRepo.save(client);
            responsePOJO.setObject(client);
            responsePOJO.setMassage("success");
            responsePOJO.setStatus("200");
        }catch (Exception e){

            responsePOJO.setMassage("warning");
            responsePOJO.setStatus("400");
        }


        return responsePOJO;
    }

}
