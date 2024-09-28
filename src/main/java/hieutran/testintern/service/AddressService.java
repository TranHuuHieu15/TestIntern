package hieutran.testintern.service;

import hieutran.testintern.dto.AddressDTO;

import java.util.List;

public interface AddressService {
    AddressDTO getAddressById(Long id);
    AddressDTO createAddress(AddressDTO addressDTO);
    AddressDTO updateAddress(Long id, AddressDTO addressDTO);
    void deleteAddressById(Long id);
    List<AddressDTO> getAllAddresses();
}
