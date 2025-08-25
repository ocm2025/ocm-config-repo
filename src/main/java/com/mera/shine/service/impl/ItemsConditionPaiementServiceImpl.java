package com.mera.shine.service.impl;

import com.mera.shine.dto.request.CreateItemsConditionPaiementRequestDto;
import com.mera.shine.dto.response.ItemsConditionPaiementDto;
import com.mera.shine.entity.ItemsConditionPaiement;
import com.mera.shine.mapper.ItemsConditionPaiementMapper;
import com.mera.shine.repository.ItemsConditionPaiementRepository;
import com.mera.shine.service.ItemsConditionPaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementation of the ItemsConditionPaiementService interface.
 */
@Service
@Transactional
public class ItemsConditionPaiementServiceImpl implements ItemsConditionPaiementService {

    private final ItemsConditionPaiementRepository itemsConditionPaiementRepository;
    private final ItemsConditionPaiementMapper itemsConditionPaiementMapper;

    @Autowired
    public ItemsConditionPaiementServiceImpl(ItemsConditionPaiementRepository itemsConditionPaiementRepository, 
                                            ItemsConditionPaiementMapper itemsConditionPaiementMapper) {
        this.itemsConditionPaiementRepository = itemsConditionPaiementRepository;
        this.itemsConditionPaiementMapper = itemsConditionPaiementMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ItemsConditionPaiementDto> findAll() {
        return itemsConditionPaiementRepository.findAll().stream()
                .map(itemsConditionPaiementMapper::toDto)
                .collect(Collectors.toList());
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<ItemsConditionPaiementDto> findById(Integer id) {
        return itemsConditionPaiementRepository.findById(id)
                .map(itemsConditionPaiementMapper::toDto);
    }

    @Override
    @Transactional
    public ItemsConditionPaiementDto create(CreateItemsConditionPaiementRequestDto createItemsConditionPaiementDto) {
        ItemsConditionPaiement itemsConditionPaiement = itemsConditionPaiementMapper.createDtoToEntity(createItemsConditionPaiementDto);
        itemsConditionPaiement = itemsConditionPaiementRepository.save(itemsConditionPaiement);
        return itemsConditionPaiementMapper.toDto(itemsConditionPaiement);
    }

    @Override
    @Transactional
    public ItemsConditionPaiementDto update(Integer id, ItemsConditionPaiementDto itemsConditionPaiementDto) {
        return itemsConditionPaiementRepository.findById(id)
                .map(existingItem -> {
                    ItemsConditionPaiement updatedItem = itemsConditionPaiementMapper.updateEntityFromDto(itemsConditionPaiementDto, existingItem);
                    updatedItem = itemsConditionPaiementRepository.save(updatedItem);
                    return itemsConditionPaiementMapper.toDto(updatedItem);
                })
                .orElseThrow(() -> new RuntimeException("ItemsConditionPaiement not found with id: " + id));
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        itemsConditionPaiementRepository.deleteById(id);
    }
}
