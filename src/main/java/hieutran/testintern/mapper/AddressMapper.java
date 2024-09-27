package hieutran.testintern.mapper;

import hieutran.testintern.dto.AddressDTO;
import hieutran.testintern.entity.Address;
import hieutran.testintern.entity.User;
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
                .is_active(address.is_active())
                .build();
    }

    public Address applyToEntity(AddressDTO addressDTO) {
        User user = userRepository.findById(addressDTO.getUserId()).orElse(null);
        return Address.builder()
                .city(addressDTO.getCity())
                .street(addressDTO.getStreet())
                .country(addressDTO.getCountry())
                .is_active(addressDTO.is_active())
                .user(user)
                .build();
    }

}
