package hieutran.testintern.service.impl;

import hieutran.testintern.dto.AddressDTO;
import hieutran.testintern.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    @Override
    public AddressDTO getAddressById(Long id) {
        return null;
    }

    @Override
    public AddressDTO createAddress(AddressDTO addressDTO) {
        return null;
    }

    @Override
    public AddressDTO updateAddress(Long id, AddressDTO addressDTO) {
        return null;
    }

    @Override
    public void deleteAddressById(Long id) {

    }

    @Override
    public List<AddressDTO> getAllAddresses() {
        return List.of();
    }
}
