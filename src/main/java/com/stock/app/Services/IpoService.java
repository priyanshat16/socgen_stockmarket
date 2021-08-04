package com.stock.app.Services;

import java.util.List;

import com.stock.app.model.IPOEntity;


public interface IpoService {
 List<IPOEntity> getAllIpo();
 void addIpo(IPOEntity ipoentity);
}
