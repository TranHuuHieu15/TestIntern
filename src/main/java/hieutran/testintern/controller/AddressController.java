package hieutran.testintern.controller;

import hieutran.testintern.dto.AddressDTO;
import hieutran.testintern.dto.response.ResponseSuccess;
import hieutran.testintern.entity.Address;
import hieutran.testintern.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/address")
public class AddressController {

    private final AddressService addressService;

    @GetMapping("{addressId}")
    public ResponseSuccess<AddressDTO> getAddressById(@PathVariable("addressId") Long addressId) {
        AddressDTO address = addressService.getAddressById(addressId);
        return new ResponseSuccess<>(LocalDateTime.now(), HttpStatus.OK.value(), "Get address successfully", address);
    }

    @PostMapping
    public ResponseSuccess<AddressDTO> createAddress(@RequestBody AddressDTO addressDTO) {
        AddressDTO address = addressService.createAddress(addressDTO);
        return new ResponseSuccess<>(LocalDateTime.now(), HttpStatus.OK.value(), "Create address successfully", address);
    }

    @PutMapping("/{addressId}")
    public ResponseSuccess<AddressDTO> updateAddress(@PathVariable("addressId") Long addressId, @RequestBody AddressDTO addressDTO) {
        AddressDTO address = addressService.updateAddress(addressId, addressDTO);
        return new ResponseSuccess<>(LocalDateTime.now(), HttpStatus.OK.value(), "Update address successfully", address);
    }

    @DeleteMapping("/{addressId}")
    public ResponseSuccess<Void> deleteAddressById(@PathVariable("addressId") Long addressId) {
        addressService.deleteAddressById(addressId);
        return new ResponseSuccess<>(LocalDateTime.now(), HttpStatus.OK.value(), "Delete address successfully", null);
    }

    @GetMapping
    public ResponseSuccess<List<AddressDTO>> getAllAddresses() {
        List<AddressDTO> list = addressService.getAllAddresses();
        return new ResponseSuccess<>(LocalDateTime.now(), HttpStatus.OK.value(), "Get all addresses successfully", list);
    }
}
