package hiber.service;

import hiber.dao.CarDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImp implements CarService {

    @Autowired
    CarDAO carDAO;
}
