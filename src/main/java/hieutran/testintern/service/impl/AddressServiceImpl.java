package hieutran.testintern.service.impl;

import hieutran.testintern.dto.AddressDTO;
import hieutran.testintern.entity.Address;
import hieutran.testintern.entity.User;
import hieutran.testintern.exception.NotFoundException;
import hieutran.testintern.mapper.AddressMapper;
import hieutran.testintern.repository.AddressRepository;
import hieutran.testintern.repository.UserRepository;
import hieutran.testintern.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final UserRepository userRepository;
    private final AddressMapper addressMapper;

    @Override
    public AddressDTO getAddressById(Long id) {
        if (id == null) {
            try {
                throw new BadRequestException("Id is required!");
            } catch (BadRequestException e) {
                throw new RuntimeException(e);
            }
        }
        Address address = addressRepository.findById(id).orElseThrow(() -> new NotFoundException("Address not found with id: " + id));
        return addressMapper.apply(address);
    }

    @Override
    public AddressDTO createAddress(AddressDTO addressDTO) {
        Address address = addressMapper.applyToEntity(addressDTO);
        User user = userRepository.findById(addressDTO.getUserId()).orElseThrow(() -> new NotFoundException("User not found with id: " + addressDTO.getUserId()));
        Address savedAddress = addressRepository.save(address);
        return addressMapper.apply(savedAddress);
    }

    @Override
    public AddressDTO updateAddress(Long id, AddressDTO addressDTO) {
        getAddressById(id);
        User user = userRepository.findById(addressDTO.getUserId()).orElseThrow(() -> new NotFoundException("User not found with id: " + addressDTO.getUserId()));

        Address address = addressRepository.findById(id).orElseThrow(() -> new NotFoundException("Address not found with id: " + id));
        address.setCity(addressDTO.getCity());
        address.setCountry(addressDTO.getCountry());
        address.setStreet(addressDTO.getStreet());
        address.setActive(addressDTO.isActive());
        address.setUser(user);
        Address updatedAddress = addressRepository.save(address);
        return addressMapper.apply(updatedAddress);
    }

    @Override
    public void deleteAddressById(Long id) {
        getAddressById(id);
        Address address = addressRepository.findById(id).orElseThrow(() -> new NotFoundException("Address not found with id: " + id));
        addressRepository.delete(address);
    }

    @Override
    public List<AddressDTO> getAllAddresses() {
        List<AddressDTO> list = addressRepository.findAll().stream().map(addressMapper).toList();
        return list;
    }
}
