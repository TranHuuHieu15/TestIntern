package hieutran.testintern.mapper;

import hieutran.testintern.dto.AddressDTO;
import hieutran.testintern.entity.Address;
import hieutran.testintern.entity.User;
import hieutran.testintern.exception.NotFoundException;
import hieutran.testintern.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class AddressMapper implements Function<Address, AddressDTO> {
    private final UserRepository userRepository;

    @Override
    public AddressDTO apply(Address address) {
        return AddressDTO.builder()
                .id(address.getId())
                .city(address.getCity())
                .street(address.getStreet())
                .country(address.getCountry())
                .active(address.isActive())
                .userId(address.getUser().getId())
                .build();
    }

    public Address applyToEntity(AddressDTO addressDTO) {
        User user = userRepository.findById(addressDTO.getUserId()).orElseThrow(() -> new NotFoundException("User not found with id: " + addressDTO.getUserId()));
        return Address.builder()
                .street(addressDTO.getStreet())
                .city(addressDTO.getCity())
                .country(addressDTO.getCountry())
                .active(addressDTO.isActive())
                .user(user)
                .build();
    }

}
