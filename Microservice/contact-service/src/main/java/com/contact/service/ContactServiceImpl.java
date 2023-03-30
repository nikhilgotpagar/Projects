package com.contact.service;

import com.contact.entity.Contact;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService {
    //fake list of contacts
    List<Contact> list = List.of(

            new Contact(1L, "NikhilG@gmail.com", "Nikhil",01L),
            new Contact(2L, "Amit@gmail.com", "Amit",01L),
            new Contact(3L, "Nick@gmail.com", "Nick",02L),
            new Contact(4L, "Sam@gmail.com", "Sam",03L),
            new Contact(5L, "Rick@gmail.com", "Rick",04L)
            );

    @Override
    public List<Contact> geContactsOfUser(Long userId) {
        return list.stream().filter(contact -> contact.getUserId().equals(userId)).collect(Collectors.toList());
    }




}

