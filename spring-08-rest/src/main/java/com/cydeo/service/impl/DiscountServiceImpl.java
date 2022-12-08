package com.cydeo.service.impl;

import com.cydeo.dto.DiscountDTO;
import com.cydeo.entity.Discount;
import com.cydeo.mapper.MapperUtil;
import com.cydeo.repository.DiscountRepository;
import com.cydeo.service.DiscountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiscountServiceImpl implements DiscountService {

    private final DiscountRepository discountRepository;
    private final MapperUtil mapperUtil;

    public DiscountServiceImpl(DiscountRepository discountRepository, MapperUtil mapperUtil) {
        this.discountRepository = discountRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<DiscountDTO> findAll() {
        List<Discount> discountList = discountRepository.findAll();
        return discountList.stream().map(discount -> mapperUtil.convert(discount, new DiscountDTO())).collect(Collectors.toList());
    }

    @Override
    public DiscountDTO findByName(String name) {
        Discount discount = discountRepository.findFirstByName(name);
        return mapperUtil.convert(discount, new DiscountDTO());
    }

    @Override
    public DiscountDTO create(DiscountDTO discountDTO) {
        discountRepository.save(mapperUtil.convert(discountDTO, new Discount()));
        return discountDTO;
    }

    @Override
    public DiscountDTO update(DiscountDTO discountDTO) {
        Discount discount = mapperUtil.convert(discountDTO, new Discount());
        discountRepository.save(discount);
        return discountDTO;
    }

}
