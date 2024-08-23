package ceing.ceing.service;

import ceing.ceing.domain.Address;
import ceing.ceing.domain.Brand;
import ceing.ceing.repository.BrandRepository;
import ceing.ceing.web.dto.BrandSaveDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class BrandService {

  private final BrandRepository brandRepository;

  public Long saveBrand(BrandSaveDto brandSaveDto) {
    Address address = new Address(brandSaveDto.getRoadNameAddress(), brandSaveDto.getZipCode());
    Brand brand = new Brand(brandSaveDto.getBrandName(), address);
    return brandRepository.save(brand);
  }

  public Brand findBrand(Long brandId){
    return brandRepository.findById(brandId).orElse(null);
  }

  public List<Brand> findBrands(){
    return brandRepository.findAll();
  }


}
